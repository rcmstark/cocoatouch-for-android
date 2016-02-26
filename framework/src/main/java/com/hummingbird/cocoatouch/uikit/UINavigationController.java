package com.hummingbird.cocoatouch.uikit;

import android.content.Intent;

import com.hummingbird.cocoatouch.foundation.NSObject;

import java.util.ArrayList;


public class UINavigationController extends NSObject
{
    private static ArrayList<UINavigationController> navigationStack;

    private ArrayList<UIViewController> viewControllers = null;

    public static UINavigationController get(int identifier)
    {
        if (identifier == identifierNone()) return null;
        if (navigationStack == null) return null;
        return navigationStack.get(identifier);
    }
    public static int identifierNone()
    {
        return -1;
    }

    public UINavigationController(UIViewController viewController)
    {
        addViewControllerToStack(viewController);
        addNavigationToStack(this);
    }
    public int identifier()
    {
        return navigationStack==null?identifierNone():lastIndexArray(navigationStack);
    }
    public UIViewController lastViewController()
    {
        int last_index = lastIndexArray(this.viewControllers);
        return this.viewControllers.get(last_index);
    }
    public void pushViewController(UIViewController viewController, Boolean animated)
    {
        UIViewController currentViewController = this.lastViewController();
        Intent intent = new Intent(currentViewController, viewController.getClass());
        intent.putExtra("identifier", viewController.identifier());
        intent.putExtra("navigationControllerID", this.identifier());
        currentViewController.startActivity(intent);
    }
    public void popViewController(Boolean animated)
    {
        UIViewController currentViewController = lastViewController();
        removeViewControllerFromStack(currentViewController);
        currentViewController.dismissViewController(animated);
    }
    public void popToRootViewController(Boolean animated)
    {
        UIViewController currentViewController = lastViewController();
        UIViewController firstViewController = this.viewControllers.get(0);
        int last_index = lastIndexArray(this.viewControllers);
        for (int i = last_index; i > 0; i--)
        {
            this.viewControllers.remove(i);
        }
        Intent intent = new Intent(currentViewController,firstViewController.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        currentViewController.startActivity(intent);
    }

    //
    // HELPERS
    //
    private int lastIndexArray(ArrayList arrayList)
    {
        return arrayList.size()-1;
    }

    protected void removeViewControllerFromStack(UIViewController viewController)
    {
        this.viewControllers.remove(viewController);
    }
    protected void addViewControllerToStack(UIViewController viewController)
    {
        if (viewControllers == null)
            viewControllers = new ArrayList<UIViewController>();
        this.viewControllers.add(viewController);
    }
    protected void addNavigationToStack(UINavigationController navigationController)
    {
        if (navigationStack == null)
            navigationStack = new ArrayList<UINavigationController>();
        navigationStack.add(this);
    }
}
