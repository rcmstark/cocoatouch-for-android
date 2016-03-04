package com.hummingbird.cocoatouch.uikit.helper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.hummingbird.cocoatouch.coregraphics.CGPoint;
import com.hummingbird.cocoatouch.coregraphics.CGRect;
import com.hummingbird.cocoatouch.coregraphics.CGSize;
import com.hummingbird.cocoatouch.uikit.UIFragmentController;
import com.hummingbird.cocoatouch.uikit.UIScrollView;
import com.hummingbird.cocoatouch.uikit.UIScrollViewDelegate;

import java.util.ArrayList;


public class ScrollViewPager extends ViewPager
{
    public CGRect frame = CGRect.Zero();
    public CGPoint contentOffset = CGPoint.Zero();
    public CGSize  contentSize = CGSize.Zero();
    public int currentPage = 0;

    private PagerAdapter adapter;
    private ArrayList subviews_ids = new ArrayList();
    private ArrayList fragmentsControllers = new ArrayList();
    private UIScrollViewDelegate delegate;

    public ScrollViewPager(Context context) {super(context);}
    public ScrollViewPager(Context context, AttributeSet attrs) {super(context, attrs);}

    public void setNeedsDisplay() {
        this.setAdapter(adapter);
    }

    public void setDelegate(final UIScrollViewDelegate delegate) {
        this.delegate = delegate;
        final UIScrollView scrollView = (UIScrollView) this;
        this.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                scrollView.contentOffset.x = positionOffsetPixels;
                delegate.scrollViewDidScroll(scrollView);
            }

            @Override
            public void onPageSelected(int position) {
                scrollView.currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
    });
    }
    public void addPage(FragmentActivity activity, int layout_id, UIFragmentController controller)
    {
        this.subviews_ids.add(layout_id);
        this.fragmentsControllers.add(controller);

        adapter = new FragmentPagerAdapter(activity.getSupportFragmentManager())
        {
            @Override
            public int getCount()
            {
                return fragmentsControllers.size();
            }

            @Override
            public Fragment getItem(int position)
            {
                UIFragmentController fragmentController = (UIFragmentController)fragmentsControllers.get(position);
                fragmentController.setStoryboardID((int)subviews_ids.get(position));
                return fragmentController;
            }
        };
    }
    public void scrollToPage(int page)
    {
        this.setCurrentItem(page, true);
    }
}