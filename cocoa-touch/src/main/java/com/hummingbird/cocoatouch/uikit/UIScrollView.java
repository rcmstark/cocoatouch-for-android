package com.hummingbird.cocoatouch.uikit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.hummingbird.cocoatouch.uikit.helper.ScrollViewPager;


public class UIScrollView extends ScrollViewPager
{
    public UIScrollView(Context context) {super(context);}
    public UIScrollView(Context context, AttributeSet attrs) {super(context, attrs);}

    public void setPagingEnabled(boolean enabled)
    {
        //TODO
        //Remove ScrollViewPager inheritance and use composition
    }
    public void setHidden(boolean hidden)
    {
        this.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
    }
}