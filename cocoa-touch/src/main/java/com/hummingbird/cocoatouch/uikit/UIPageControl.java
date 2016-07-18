package com.hummingbird.cocoatouch.uikit;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import com.hummingbird.cocoatouch.R;


public class UIPageControl extends LinearLayout
{

    //Attribute values
    private int    _currentPage;
    private int    _numberOfPages;
    private int    _currentPageIndicatorTintColor;
    private int    _pageIndicatorTintColor;

    //Fixes values
    private float  _indicatorSize = 30.0f;
    private float  _indicatorDistance = 20.0f;



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
        if (pageIndex == _currentPage) return;
        _currentPage = pageIndex;
        updateUI();
    }
    public void setNumberOfPages(int numberOfPages)
    {
        if (numberOfPages == _numberOfPages) return;
        _numberOfPages = numberOfPages;
        updateUI();
    }
    public void setPageIndicatorTintColor(int color)
    {
        if (color == _pageIndicatorTintColor) return;
        _pageIndicatorTintColor = color;
        updateUI();
    }
    public void setCurrentPageIndicatorTintColor(int color)
    {
        if (color == _currentPageIndicatorTintColor) return;
        _currentPageIndicatorTintColor = color;
        updateUI();
    }
    public void setHidden(boolean hidden)
    {
        this.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
    }

    //
    // Private Instance Methods
    //
    private void init(Context context, AttributeSet attrs)
    {
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);
        fetchAttributes(context, attrs);
        updateUI();
    }
    private void fetchAttributes(Context context, AttributeSet attrs)
    {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.UIPageControl, 0, 0);
        _currentPageIndicatorTintColor = a.getColor(R.styleable.UIPageControl_currentPageIndicatorTintColor, Color.WHITE);
        _pageIndicatorTintColor = a.getColor(R.styleable.UIPageControl_pageIndicatorTintColor, Color.GRAY);
        _currentPage = a.getInteger(R.styleable.UIPageControl_currentPage, 0);
        _numberOfPages = a.getInteger(R.styleable.UIPageControl_numberOfPages, 3);
        a.recycle();
    }
    private void updateUI()
    {
        removeAllViews();
        for (int i = 0; i < _numberOfPages; i++)
        {
            View view = new View(getContext());
            setIndicatorBackground(view, i == _currentPage);
            LayoutParams lp = new LinearLayout.LayoutParams((int) _indicatorSize, (int) _indicatorSize);
            int margin = (int)(_indicatorDistance / 2);
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
        invalidate();
        requestLayout();
    }
    private void setIndicatorBackground(View view, boolean isCurrent)
    {
        ShapeDrawable drawableDefault = new ShapeDrawable();
        drawableDefault.setShape(new OvalShape());
        drawableDefault.getPaint().setColor(isCurrent? _currentPageIndicatorTintColor : _pageIndicatorTintColor);

        if (Build.VERSION.SDK_INT < 16)
            view.setBackgroundDrawable(drawableDefault);
        else
            view.setBackground(drawableDefault);
    }
}
