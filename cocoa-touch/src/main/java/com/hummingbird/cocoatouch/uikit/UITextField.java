package com.hummingbird.cocoatouch.uikit;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;


public class UITextField extends EditText
{
    private UITextFieldDelegate delegate = null;
    private TextWatcher observer = null;


    public void init() {}

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
            addListener();
        else
            removeListener();
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
        this.setFocusableInTouchMode(true);
        this.requestFocus();
        Activity activity = UIApplication.sharedApplication().activity();
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }
    public void resignFirstResponder()
    {
        Activity activity = UIApplication.sharedApplication().activity();
        ((InputMethodManager)activity
                .getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(this.getWindowToken(), 0);
    }

    //
    //Helpers
    //
    private void addListener()
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
    private void removeListener()
    {
        removeTextChangedListener(observer);
    }

    //Java Trash Code
    public UITextField(Context context) {super(context);init();};
    public UITextField(Context context, AttributeSet attrs) {super(context, attrs);init();}
    public UITextField(Context context, AttributeSet attrs, int defStyle) {super(context, attrs, defStyle);init();}
}
