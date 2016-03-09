package com.hummingbird.cocoatouch.uikit;
import android.content.Intent;

import com.hummingbird.cocoatouch.foundation.NSDictionary;

public interface UIApplicationDelegate
{
    public Boolean applicationDidFinishLaunchingWithOptions(UIApplication application, NSDictionary launchOptions);
    public void applicationDidBecomeActive(UIApplication application);
    public void applicationDidBecomeActive(UIApplication application, int requestCode, int resultCode, Intent data);
}
