package com.hummingbird.cocoatouch.uikit;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

public class UIImage extends Drawable
{

    public static UIImage imageWithName(@DrawableRes int imageName)
    {
        return (UIImage) UIApplication.sharedApplication().context().getResources().getDrawable(imageName);
    }

    //Java Trash code
    @Override public void draw(Canvas canvas) {}
    @Override public void setAlpha(int alpha) {}
    @Override public void setColorFilter(ColorFilter colorFilter) {}
    @Override public int getOpacity() {return 0;}
}
