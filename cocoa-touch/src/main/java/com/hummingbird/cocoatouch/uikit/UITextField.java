package com.hummingbird.cocoatouch.uikit;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


public class UITextField extends AppCompatEditText
{
    private UITextFieldDelegate delegate = null;
    private TextWatcher observer = null;
    private Drawable originalBackground;

    public void init()
    {
        this.originalBackground = getBackground();
    }
    public void setText(String text)
    {
        super.setText(text);
        setSelection(text.length());
    }
    public String text()
    {
        return getText().toString();
    }
    public void setDelegate(UITextFieldDelegate delegate)
    {
        this.delegate = delegate;
        if (this.delegate != null)
            addListeners();
        else
            removeListeners();
    }
    public void setPlaceholder(String placeholder)
    {
        this.setHint(placeholder);
    }
    public String placeholder()
    {
        return (String)this.getHint();
    }
    public void setHidden(boolean hidden)
    {
        this.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
    }
    public void becomeFirstResponder()
    {
        this.textFieldDidStartEditing();
        this.setFocusableInTouchMode(true);
        this.requestFocus();
        Activity activity = UIApplication.sharedApplication().activity();
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }
    public void resignFirstResponder()
    {
        this.textFieldDidFinishEditing();
        Activity activity = UIApplication.sharedApplication().activity();
        ((InputMethodManager)activity
                .getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(this.getWindowToken(), 0);
    }

    //
    // Method called when user press back button
    //
    @Override public boolean onKeyPreIme(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            textFieldDidFinishEditing();
        }
        return super.onKeyPreIme(keyCode, event);
    }

    //
    // Listeners
    //
    private void addListeners()
    {
        addTextListener();
        addKeyListener();
        addTouchListener();
        addFocusListener();
    }
    private void removeListeners()
    {
        removeTextChangedListener(observer);
        this.setOnKeyListener(null);
        this.setOnTouchListener(null);
        this.setOnFocusChangeListener(null);
    }
    private void addTextListener()
    {
        final UITextFieldDelegate delegate = this.delegate;
        final UITextField textField = this;
        this.observer = new TextWatcher()
        {
            @Override public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (delegate!= null)
                    delegate.textFieldShouldChange(textField,s,start,before,count);
            }
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                if (delegate != null)
                    delegate.textFieldBeforeChange(textField,s,start,count,after);
            }
            @Override public void afterTextChanged(Editable s)
            {
                if (delegate != null)
                    delegate.textFieldDidChange(textField);
            }
        };
        addTextChangedListener(observer);
    }
    private void addKeyListener()
    {
        final UITextField textField = this;
        this.setOnKeyListener(new OnKeyListener()
        {
            public boolean onKey(View view, int keyCode, KeyEvent event)
            {
                if (keyCode == KeyEvent.KEYCODE_ENTER)
                {
                    boolean shouldResign = true;
                    if (delegate != null)
                        shouldResign = delegate.textFieldShouldReturn(textField);
                    if (shouldResign)
                        resignFirstResponder();
                    return shouldResign;
                }
                return false;
            }
        });
    }
    private void addTouchListener()
    {
        this.setOnTouchListener(new OnTouchListener()
        {
            @Override public boolean onTouch(View v, MotionEvent event)
            {
                if(MotionEvent.ACTION_UP == event.getAction())
                {
                    becomeFirstResponder();
                }
                return true;
            }
        });
    }
    private void addFocusListener()
    {
        this.setOnFocusChangeListener(new OnFocusChangeListener()
        {
            @Override public void onFocusChange(View v, boolean hasFocus)
            {
                if(!hasFocus)
                    textFieldDidFinishEditing();
            }
        });
    }

    //
    // Style + Notificate Delegates
    //
    private void textFieldDidFinishEditing()
    {
        setCursorVisible(false);
        setBackgroundColor(Color.TRANSPARENT);
        if(delegate != null)
            delegate.textFieldDidEndEditing(this);
    }
    private void textFieldDidStartEditing()
    {
        setCursorVisible(true);
        setBackground(originalBackground);
        if (delegate != null)
            delegate.textFieldDidBeginEditing(this);
    }

    //Java Trash Code
    public UITextField(Context context) {super(context);init();};
    public UITextField(Context context, AttributeSet attrs) {super(context, attrs);init();}
    public UITextField(Context context, AttributeSet attrs, int defStyle) {super(context, attrs, defStyle);init();}
}
