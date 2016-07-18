package com.hummingbird.cocoatouch.uikit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;


public class UILabel extends TextView
{
    public void init(){};

    public String text()
    {
        return getText().toString();
    }
    public void setHidden(boolean hidden)
    {
        this.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
    }

    public UILabel(Context context) {super(context);init();}
    public UILabel(Context context, AttributeSet attrs){super(context, attrs);init();}
    public UILabel(Context context, AttributeSet attrs, int defStyle) {super(context, attrs, defStyle);init();}
}