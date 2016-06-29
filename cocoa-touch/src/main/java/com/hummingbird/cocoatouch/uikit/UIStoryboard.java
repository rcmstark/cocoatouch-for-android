package com.hummingbird.cocoatouch.uikit;
import android.support.annotation.LayoutRes;


public class UIStoryboard extends UINavigationController
{
    public int storyBoardID()
    {
        return 0;
    }
    public int initialViewControllerID()
    {
        return 0;
    }
    public UIViewController viewControllerForIdentifier(int identifier)
    {
        return null;
    }
    public UIApplicationDelegate applicationDelegate()
    {
        return null;
    }
    public final UIViewController instantiateViewControllerWithIdentifier(@LayoutRes int identifier)
    {
        UIViewController viewController = this.viewControllerForIdentifier(identifier);
        viewController.setIdentifier(identifier);
        viewController.storyboard = this;
        return viewController;
    }

    //
    // Custom Implementation
    //
    @Override public int identifier()
    {
        return this.storyBoardID();
    }
    @Override public void init()
    {
        super.init();

        UIApplication application = UIApplication.sharedApplication();
        application.setContext(this);
        application.delegate = this.applicationDelegate();
        application.delegate.applicationDidBecomeActive(application);

        UIViewController viewController = instantiateViewControllerWithIdentifier(initialViewControllerID());
        this.pushViewController(viewController, false);
    }
}
