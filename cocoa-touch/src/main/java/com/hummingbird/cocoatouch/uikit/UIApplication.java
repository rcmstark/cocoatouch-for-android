package com.hummingbird.cocoatouch.uikit;
import android.app.Activity;
import android.content.Context;


public class UIApplication extends UIResponder
{

    private static UIApplication application = null;
    private Context context = null;
    private boolean isViewControllerNotificationEnabled = true;
    public UIApplicationDelegate delegate;


    //
    // Class Methods
    //
    public static UIApplication sharedApplication()
    {
        if (application == null)
            application = new UIApplication();
        return application;
    }

    //
    // Public Instance Methods
    //
    public Context context()
    {
        return this.context;
    }
    public Activity activity()
    {
        return (Activity)this.context;
    }
    public boolean isNotificationsEnabled()
    {
        return this.isViewControllerNotificationEnabled;
    }

    //
    // Protected Instance Methods
    //
    protected void setContext(Context context)
    {
        this.context = context;
    }
    protected void setNotificationsEnabled(boolean enabled)
    {
        this.isViewControllerNotificationEnabled = enabled;
    }
}
