package com.hummingbird.cocoatouch.uikit;
import com.hummingbird.cocoatouch.foundation.NSMutableArray;
import com.hummingbird.cocoatouch.messageui.MFComposeViewController;


public class UIViewController extends UIResponder implements UIViewHierarchy
{
    public UINavigationController navigationController;
    public UIStoryboard storyboard;
    public UIView view;
    public UIModalTransitionStyle modalTransitionStyle = UIModalTransitionStyle.CoverVertical;
    private NSMutableArray<UIViewController>childViewControllers = new NSMutableArray<>();
    private UIViewController parentViewController;
    private UIViewController presentingViewController;
    private UIViewController presentedViewController;

    //
    // Public Instance Methods
    //
    public Object viewWithTag(int tag)
    {
        return this.view.viewWithTag(tag);
    }
    public void presentViewController(UIViewController viewController, boolean animated)
    {
        this.navigationController.presentModalViewController(viewController, animated);
    }
    public void presentViewController(MFComposeViewController composer, Boolean animated)
    {
        this.navigationController.presentModalViewController(composer, animated);
    }
    public void dismissViewControllerAnimated(Boolean animated)
    {
        this.navigationController.dismissModalViewControllerAnimated(animated);
    }
    public void addChildViewController(UIViewController viewController)
    {
        viewController.setParentViewController(this);
        this.childViewControllers.addObject(viewController);
    }
    public void removeFromParentViewController()
    {
        this.parentViewController.childViewControllers.removeObject(this);
    }

    //
    // Get Methods
    //
    public UIViewController parentViewController()
    {
        return this.parentViewController;
    }
    public UIViewController presentingViewController()
    {
        return this.presentingViewController;
    }
    public UIViewController presentedViewController()
    {
        return this.presentedViewController;
    }

    //
    // Protected Instance Methods
    //
    protected void setIdentifier(int identifier)
    {
        this.view = new UIView(this, identifier);
    }
    protected void setParentViewController(UIViewController parentViewController)
    {
        this.parentViewController = parentViewController;
    }
    protected void setPresentingViewController(UIViewController presentingViewController)
    {
        this.presentingViewController = presentingViewController;
    }
    protected void setPresentedViewController(UIViewController presentedViewController)
    {
        this.presentedViewController = presentedViewController;
    }

    //
    // Life Cycle Notificaitons
    //
    public void viewDidLoad()
    {
        for (UIViewController viewController : this.childViewControllers)
            viewController.viewDidLoad();
    }
    public void viewWillAppear(Boolean animated)
    {
        for (UIViewController viewController : this.childViewControllers)
            viewController.viewWillAppear(animated);
    }
    public void viewDidAppear(Boolean animated)
    {
        for (UIViewController viewController : this.childViewControllers)
            viewController.viewDidAppear(animated);
    }
    public void viewWillDisappear(Boolean animated)
    {
        for (UIViewController viewController : this.childViewControllers)
            viewController.viewWillDisappear(animated);
    }
    public void viewDidDisappear(Boolean animated)
    {
        for (UIViewController viewController : this.childViewControllers)
            viewController.viewWillDisappear(animated);
    }
}
