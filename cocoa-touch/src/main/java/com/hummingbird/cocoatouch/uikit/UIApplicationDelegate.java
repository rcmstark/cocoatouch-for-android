package com.hummingbird.cocoatouch.uikit;
import com.hummingbird.cocoatouch.foundation.NSDictionary;

public interface UIApplicationDelegate
{
    public Boolean applicationDidFinishLaunchingWithOptions(UIApplication application, NSDictionary launchOptions);
    public void applicationDidBecomeActive(UIApplication application);
}
