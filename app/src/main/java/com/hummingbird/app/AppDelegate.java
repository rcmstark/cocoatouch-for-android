package com.hummingbird.app;
import android.content.Intent;
import com.hummingbird.app.features.share.Facebook;
import com.hummingbird.cocoatouch.foundation.NSDictionary;
import com.hummingbird.cocoatouch.uikit.UIApplication;
import com.hummingbird.cocoatouch.uikit.UIApplicationDelegate;
import com.hummingbird.cocoatouch.uikit.UIResponder;


public class AppDelegate extends UIResponder implements UIApplicationDelegate
{
    @Override public Boolean applicationDidFinishLaunchingWithOptions(UIApplication application, NSDictionary launchOptions)
    {
        return true;
    }
    @Override public void applicationDidBecomeActive(UIApplication application)
    {
        NSLog(__PRETTY_FUNCTION__());
    }
    @Override public void applicationDidBecomeActive(UIApplication application, int requestCode, int resultCode, Intent data)
    {
        Facebook.update(requestCode, resultCode, data);
    }
}
