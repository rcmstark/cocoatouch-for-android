package com.hummingbird.cocoatouch.uikit;


import android.content.Context;

public class UIApplication extends UIResponder
{
    private static UIApplication application = null;
    private Context context;
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
    // Instance Methods
    //
    protected void setContext(Context context)
    {
        this.context = context;
    }
    public Context context()
    {
        return this.context;
    }
}
