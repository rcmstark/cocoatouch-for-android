package com.hummingbird.cocoatouch.uikit;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hummingbird.animations.NoneTransition;
import com.hummingbird.animations.PushTransition;
import com.hummingbird.cocoatouch.foundation.NSArray;
import com.hummingbird.cocoatouch.foundation.NSMutableArray;
import com.hummingbird.cocoatouch.messageui.MFComposeViewController;
import com.hummingbird.cocoatouch.uikit.helper.UIFragment;


public class UINavigationController extends AppCompatActivity
{
    private NSMutableArray<UIViewController> pushViewControllers = new NSMutableArray<>();
    private NSMutableArray<UIViewController> modalViewControllers = new NSMutableArray<>();

    //
    // Public Instance Methods
    //
    public void init() {}
    public int identifier()
    {
        return 0;
    }
    public int containerID()
    {
        return 0;
    }
    public void pushViewController(UIViewController viewController, Boolean animated)
    {
        UIViewController presentedViewController = lastViewController(this.pushViewControllers);
        viewController.navigationController = this;
        viewController.presentingViewController = presentedViewController;
        viewController.view.fragment().transition = animated?new PushTransition():new NoneTransition();
        if (presentedViewController != null)
            presentedViewController.presentedViewController = viewController;
        this.pushViewControllers.addObject(viewController);
        presentViewController(viewController, animated);
    }
    public void popViewController(Boolean animated)
    {
        if (this.pushViewControllers.count() == 1) return;

        UIViewController controllerToRemove = lastViewController(this.pushViewControllers);
        this.pushViewControllers.removeObject(controllerToRemove);

        UIViewController controllerToAppear = lastViewController(this.pushViewControllers);
        getFragmentManager().popBackStack();
    }
    public void popToRootViewController(Boolean animated)
    {
        int lastIndex = lastIndexOfArray(this.pushViewControllers);
        for (int i = lastIndex; i > 0; i--)
        {
            UIViewController controllerToRemove = this.pushViewControllers.objectAtIndex(i);
            this.pushViewControllers.removeObject(controllerToRemove);
        }
        UIViewController viewController = this.pushViewControllers.objectAtIndex(0);
        getFragmentManager().popBackStack(viewController.getClass().getName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    //
    // Protected Instance Methods
    //
    protected void presentModalViewController(UIViewController viewController, boolean animated)
    {
        UIViewController presentedViewController = lastViewController(this.modalViewControllers);
        if (presentedViewController == null)
            presentedViewController = lastViewController(this.pushViewControllers);

        viewController.navigationController = null;
        viewController.presentingViewController = presentedViewController;
        viewController.view.fragment().transition = UIModalTransition.transition(viewController.modalTransitionStyle,animated);
        presentedViewController.presentedViewController = viewController;
        this.modalViewControllers.addObject(viewController);
        presentViewController(viewController, animated);
    }
    protected void presentModalViewController(MFComposeViewController viewController, boolean animated)
    {
        this.startActivity(viewController.controller());
    }
    protected void dismissModalViewControllerAnimated(boolean animated)
    {
        UIViewController controllerToRemove = lastViewController(this.modalViewControllers);
        if (controllerToRemove == null) return;

        this.modalViewControllers.removeObject(controllerToRemove);

        UIViewController controllerToAppear = lastViewController(this.modalViewControllers);
        if (controllerToAppear == null)
            controllerToAppear = lastViewController(this.pushViewControllers);

        getFragmentManager().popBackStack();
    }


    //
    // Helpers
    //
    private void presentViewController(UIViewController viewController, Boolean animated)
    {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        UIFragment fragment = viewController.view.fragment();
        fragment.transition = animated?fragment.transition:new NoneTransition();
        fragmentTransaction
                .add(containerID(), fragment)
                .addToBackStack(viewController.getClass().getName())
                .commit();
    }
    private UIViewController lastViewController(NSArray<UIViewController> array)
    {
        int last_index = lastIndexOfArray(array);
        return last_index >= 0?array.objectAtIndex(last_index):null;
    }
    private int lastIndexOfArray(NSArray array)
    {
        return array.count()-1;
    }

    //
    // Android Methods
    //
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(this.identifier());
        init();
    }
    @Override
    public void onBackPressed()
    {
        if (this.modalViewControllers.count() > 0)
            dismissModalViewControllerAnimated(true);
        else if (this.pushViewControllers.count() > 1)
            popViewController(true);
        else
            super.onBackPressed();
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        UIApplication application = UIApplication.sharedApplication();
        UIApplicationDelegate delegate = application.delegate;
        if (delegate != null)
            delegate.applicationDidBecomeActive(application);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        UIApplication application = UIApplication.sharedApplication();
        UIApplicationDelegate delegate = application.delegate;
        if (delegate != null)
            delegate.applicationDidBecomeActive(application, requestCode, resultCode, data);
    }
}
