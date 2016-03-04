package com.hummingbird.cocoatouch.uikit;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;

import com.hummingbird.objectivec.parser.IBOutletParser;


public class UIView extends RelativeLayout implements UIViewHierarchy
{
    private UIViewController controller =  null;

    public UIView(Context context, UIViewController viewController)
    {
        super(context);
        this.controller = viewController;
    }

    public Object viewWithTag(int id)
    {
        return findViewById(id);
    }

    public void setHidden(Boolean hidden)
    {
        this.setVisibility(hidden?View.INVISIBLE:View.VISIBLE);
    }

    public void endEditing(Boolean end)
    {
        InputMethodManager inputManager = (InputMethodManager) this.controller.getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = this.controller.getCurrentFocus();
        if (view != null)
        {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public UIView(Context context){super(context);}
    public UIView(Context context, AttributeSet attrs) {super(context, attrs);}
    public UIView(Context context, AttributeSet attrs, int defStyleAttr){super(context, attrs, defStyleAttr);}
}