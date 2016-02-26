package com.hummingbird.cocoatouch.uikit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;


public class UIActivityIndicatorView extends ProgressBar
{
    public UIActivityIndicatorView(Context context)
    {
        super(context);
        stopAnimating();
    }

    public UIActivityIndicatorView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        stopAnimating();
    }

    public UIActivityIndicatorView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        stopAnimating();
    }

    public void stopAnimating(){
        setVisibility(View.INVISIBLE);
    }
    public void startAnimating(){
        setVisibility(View.VISIBLE);
    }
}