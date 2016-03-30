package com.hummingbird.cocoatouch.uikit;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;


public class UIPageControl extends LinearLayout
{

    private static int DEFAULT_NUMBER_OF_VIEW = 3;
    private static float DEFAULT_INDICATOR_SIZE = 30.0f;
    private static float DEFAULT_INDICATOR_DISTANCE = 20.0f;

    private int mCurrentPage = 0;
    private int mNumberOfPages = DEFAULT_NUMBER_OF_VIEW;
    private float mIndicatorSize = DEFAULT_INDICATOR_SIZE;
    private float mIndicatorDistance = DEFAULT_INDICATOR_DISTANCE;
    private int mColorCurrent = Color.WHITE;
    private int mColorNormal = Color.GRAY;


    //
    // Inherit
    //
    public UIPageControl(Context context) {super(context);}
    public UIPageControl(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }
    public UIPageControl(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    //
    // Public Instace Methods
    //
    public void setCurrentPage(int pageIndex)
    {
        if (pageIndex == mCurrentPage) return;
        mCurrentPage = pageIndex;
        updateUI();
    }
    public void setNumberOfPages(int numberOfPages)
    {
        if (numberOfPages == mNumberOfPages) return;
        mNumberOfPages = numberOfPages;
        updateUI();
    }
    public void setPageIndicatorTintColor(int color)
    {
        if (color == mColorNormal) return;
        mColorNormal = color;
        updateUI();
    }
    public void setCurrentPageIndicatorTintColor(int color)
    {
        if (color == mColorCurrent) return;
        mColorCurrent = color;
        updateUI();
    }

    //
    // Private Instance Methods
    //
    private void init(Context context, AttributeSet attrs)
    {
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);
        updateUI();
    }
    private void updateUI()
    {
        removeAllViews();
        for (int i = 0; i < mNumberOfPages; i++)
        {
            View view = new View(getContext());
            setIndicatorBackground(view, i == mCurrentPage);
            LayoutParams lp = new LinearLayout.LayoutParams((int)mIndicatorSize, (int)mIndicatorSize);
            int margin = (int)(mIndicatorDistance / 2);
            if (getOrientation() == LinearLayout.HORIZONTAL)
            {
                lp.leftMargin = margin;
                lp.rightMargin = margin;
            }
            else
            {
                lp.topMargin = margin;
                lp.bottomMargin = margin;
            }
            addView(view, lp);
        }
        requestLayout();
        invalidate();
    }
    private void setIndicatorBackground(View view, boolean isCurrent)
    {
        ShapeDrawable drawableDefault = new ShapeDrawable();
        drawableDefault.setShape(new OvalShape());
        drawableDefault.getPaint().setColor(isCurrent?mColorCurrent:mColorNormal);

        if (Build.VERSION.SDK_INT < 16)
            view.setBackgroundDrawable(drawableDefault);
        else
            view.setBackground(drawableDefault);
    }
}
