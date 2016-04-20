package com.hummingbird.cocoatouch.uikit;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;


public class UITextField extends EditText
{
    private UITextFieldDelegate delegate = null;

    public UITextField(Context context) {super(context);}
    public UITextField(Context context, AttributeSet attrs) {super(context, attrs);}
    public UITextField(Context context, AttributeSet attrs, int defStyle) {super(context, attrs, defStyle);}

    public String text()
    {
        return getText().toString();
    }
    public void setDelegate(UITextFieldDelegate delegate)
    {
        this.delegate = delegate;
        addListener();
    }
    public void setPlaceholder(String placeholder)
    {
        this.setHint(placeholder);
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
        addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                delegate.textFieldShouldChange(textField,s,start,before,count);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                delegate.textFieldBeforeChange(textField,s,start,count,after);
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                delegate.textFieldDidChange(textField);
            }
        });
    }
}
