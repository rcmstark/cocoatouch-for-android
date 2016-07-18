package com.hummingbird.cocoatouch.uikit;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;


public class UIImageView extends ImageView
{
    public void init() {}

    public void setHidden(boolean hidden)
    {
        this.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
    }

    public UIImageView(Context context) {super(context);init();}
    public UIImageView(Context context, AttributeSet attrs) {super(context, attrs);init();}
    public UIImageView(Context context, AttributeSet attrs, int defStyleAttr) {super(context, attrs, defStyleAttr);init();}
}
