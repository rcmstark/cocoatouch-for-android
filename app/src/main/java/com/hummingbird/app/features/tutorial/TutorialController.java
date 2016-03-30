package com.hummingbird.app.features.tutorial;
import com.hummingbird.app.R;
import com.hummingbird.cocoatouch.uikit.UIButton;
import com.hummingbird.cocoatouch.uikit.UIPageControl;
import com.hummingbird.cocoatouch.uikit.UIScrollView;
import com.hummingbird.cocoatouch.uikit.UIScrollViewDelegate;
import com.hummingbird.cocoatouch.uikit.UIViewController;
import com.hummingbird.objectivec.annotation.IBAction;
import com.hummingbird.objectivec.annotation.IBOutlet;


public class TutorialController extends UIViewController implements UIScrollViewDelegate
{
    @IBOutlet(R.id.tutorial_scrollView)  UIScrollView scrollView;
    @IBOutlet(R.id.tutorial_button)      UIButton button;
    @IBOutlet(R.id.tutorial_pageControl) UIPageControl pageControl;

    //
    // Instance Methods
    //
    @Override public void viewDidLoad()
    {
        super.viewDidLoad();
        NSLog(__PRETTY_FUNCTION__());
        setScrollView();
        addViews();
    }
    @Override public void viewDidAppear(Boolean animated)
    {
        super.viewDidAppear(animated);
        NSLog(__PRETTY_FUNCTION__());
    }
    private void setScrollView()
    {
        this.scrollView.setDelegate(this);
        this.scrollView.setPagingEnabled(true);
    }
    private void addViews()
    {
        scrollView.addPage(this, R.layout.tutorial1);
        scrollView.addPage(this, R.layout.tutorial2);
        scrollView.addPage(this, R.layout.tutorial3);
        scrollView.setNeedsDisplay();
    }

    //
    // Actions
    //
    @IBAction(R.id.tutorial_button) public void dismiss(UIButton button)
    {
        this.navigationController.popViewController(false);
    }

    //
    // UIScrollViewDelegate
    //
    @Override
    public void scrollViewDidScroll(UIScrollView scrollView)
    {
        button.setHidden(scrollView.currentPage != 2);
        pageControl.setCurrentPage(scrollView.currentPage);
    }
}
