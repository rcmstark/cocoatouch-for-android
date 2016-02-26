package com.hummingbird.cocoatouch.uikit;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;


public class UILabel extends TextView
{
    public String text()
    {
        return getText().toString();
    }

    public UILabel(Context context) {super(context);}
    public UILabel(Context context, AttributeSet attrs){super(context, attrs);}
    public UILabel(Context context, AttributeSet attrs, int defStyle) {super(context, attrs, defStyle);}
}