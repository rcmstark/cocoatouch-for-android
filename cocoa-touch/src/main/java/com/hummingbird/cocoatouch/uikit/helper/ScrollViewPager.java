package com.hummingbird.cocoatouch.uikit.helper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.hummingbird.cocoatouch.uikit.UIFragmentController;

import java.util.ArrayList;


public class ScrollViewPager extends ViewPager
{
    private PagerAdapter adapter;
    private ArrayList subviews_ids = new ArrayList();
    private ArrayList fragmentsControllers = new ArrayList();

    public ScrollViewPager(Context context) {super(context);}
    public ScrollViewPager(Context context, AttributeSet attrs) {super(context, attrs);}

    public void setNeedsDisplay()
    {
        this.setAdapter(adapter);
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
}