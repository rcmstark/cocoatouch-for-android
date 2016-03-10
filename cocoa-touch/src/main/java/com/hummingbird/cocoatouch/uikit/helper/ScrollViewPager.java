package com.hummingbird.cocoatouch.uikit.helper;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hummingbird.cocoatouch.coregraphics.CGPoint;
import com.hummingbird.cocoatouch.coregraphics.CGRect;
import com.hummingbird.cocoatouch.coregraphics.CGSize;
import com.hummingbird.cocoatouch.foundation.NSMutableArray;
import com.hummingbird.cocoatouch.foundation.NSNumber;
import com.hummingbird.cocoatouch.uikit.UIApplication;
import com.hummingbird.cocoatouch.uikit.UIScrollView;
import com.hummingbird.cocoatouch.uikit.UIScrollViewDelegate;
import com.hummingbird.cocoatouch.uikit.UIViewController;


public class ScrollViewPager extends ViewPager
{
    public CGRect frame = CGRect.Zero();
    public CGPoint contentOffset = CGPoint.Zero();
    public CGSize  contentSize = CGSize.Zero();
    public int currentPage = 0;

    private PagerAdapter adapter;
    private NSMutableArray<NSNumber> subviews_ids = new NSMutableArray<>();
    private NSMutableArray<UIViewController> controllers = new NSMutableArray<>();
    private UIScrollViewDelegate delegate;


    public void setNeedsDisplay()
    {
        this.setAdapter(adapter);
    }
    public void setDelegate(final UIScrollViewDelegate delegate)
    {
        this.delegate = delegate;
        final UIScrollView scrollView = (UIScrollView) this;
        this.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
                scrollView.contentOffset.x = positionOffsetPixels;
                delegate.scrollViewDidScroll(scrollView);
            }

            @Override
            public void onPageSelected(int position)
            {
                scrollView.currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
    });
    }
    public void addPage(UIViewController fromViewController, int layout_id)
    {

        UIViewController controller = fromViewController.storyboard.instantiateViewControllerWithIdentifier(layout_id);
//        fromViewController.addChildViewController(controller);

        this.controllers.addObject(controller);
        this.subviews_ids.addObject(new NSNumber(layout_id));

        adapter = new PagerAdapter()
        {
            @Override
            public Object instantiateItem(ViewGroup collection, int index)
            {
                Context context = UIApplication.sharedApplication().context();
                LayoutInflater inflater = LayoutInflater.from(context);
                UIViewController controller = controllers.objectAtIndex(index);
                View view = controller.view.fragment().onCreateView(inflater, collection, null);
                collection.addView(view);
                return view;
            }

            @Override
            public int getCount()
            {
                return subviews_ids.count();
            }

            @Override
            public boolean isViewFromObject(View view, Object object)
            {
                return view==object;
            }

            @Override
            public void destroyItem(ViewGroup collection, int position, Object view)
            {
                collection.removeView((View) view);
            }
        };
    }
    public void scrollToPage(int page)
    {
        this.setCurrentItem(page, true);
    }

    //
    // Java Trash
    //
    public ScrollViewPager(Context context) {super(context);}
    public ScrollViewPager(Context context, AttributeSet attrs) {super(context, attrs);}
}