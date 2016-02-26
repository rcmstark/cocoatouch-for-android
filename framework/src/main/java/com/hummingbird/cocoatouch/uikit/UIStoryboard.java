package com.hummingbird.cocoatouch.uikit;


public class UIStoryboard extends UIViewController
{
    private static UIStoryboard mainStoryboard;

    public static UIStoryboard get(Class cls)
    {
        return mainStoryboard;
    }

    public int initialViewControllerID()
    {
        return -1;
    }

    public Object viewControllerForIdentifier(int identifier)
    {
        return null;
    }

    public final UIViewController instantiateViewControllerWithIdentifier(int identifier)
    {
        UIViewController viewController = (UIViewController)this.viewControllerForIdentifier(identifier);
        viewController.setIdentifier(identifier);
        viewController.setStoryboard(this);
        return viewController;
    }

    //
    // Trick Part
    //
    @Override
    public final void init()
    {
        super.init();
        mainStoryboard = this;
        this.storyboard = this;
        this.navigationController = new UINavigationController(this);
    }

    @Override
    public final void viewDidAppear(Boolean animated)
    {
        super.viewDidAppear(animated);
        int initalViewControllerID = this.initialViewControllerID();
        UIViewController viewController = this.instantiateViewControllerWithIdentifier(initalViewControllerID);
        this.navigationController.pushViewController(viewController, false);
    }

    @Override
    public final void viewDidLoad() {super.viewDidLoad();}
    @Override
    public final void viewWillAppear(Boolean animated){super.viewWillAppear(animated);}
    @Override
    public final void viewWillDisappear(Boolean animated){super.viewWillDisappear(animated);}
    @Override
    public final void viewDidDisappear(Boolean animated){super.viewDidDisappear(animated);}
}
