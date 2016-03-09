package com.hummingbird.cocoatouch.uikit;


import android.app.FragmentTransaction;

import com.hummingbird.animations.NoneTransition;
import com.hummingbird.animations.PushTransition;
import com.hummingbird.cocoatouch.messageui.MFComposeViewController;
import com.hummingbird.cocoatouch.uikit.helper.UIFragment;

public class UIViewController extends UIResponder implements UIViewHierarchy
{
    public UINavigationController navigationController;
    public UIStoryboard storyboard;
    public UIView view;
    public UIViewController presentingViewController;
    public UIViewController presentedViewController;
    public UIModalTransitionStyle modalTransitionStyle = UIModalTransitionStyle.CoverVertical;


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

    //
    // Protected Instance Methods
    //
    protected void setIdentifier(int identifier)
    {
        this.view = new UIView(this, identifier);
    }

    public void viewDidLoad() {}
    public void viewWillAppear(Boolean animated) {}
    public void viewDidAppear(Boolean animated) {}
    public void viewWillDisappear(Boolean animated) {}
    public void viewDidDisappear(Boolean aniamted){}
}
