package com.hummingbird.cocoatouch.foundation;

import android.content.Context;
import android.content.SharedPreferences;

import com.hummingbird.cocoatouch.uikit.UIViewController;


public class NSUserDefaults
{
    private static NSUserDefaults nsUserDefault = null;

    public NSUserDefaults standartUserDefaults()
    {
        if (nsUserDefault == null)
            nsUserDefault = new NSUserDefaults();
        return nsUserDefault;
    }

    //
    // Setters
    //
    public void set(String string, String key, UIViewController viewController)
    {
        SharedPreferences preferences = viewController.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, string);
        editor.apply();
    }
    public void set(Boolean bool, String key, UIViewController viewController)
    {
        SharedPreferences preferences = viewController.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, bool);
        editor.apply();
    }

    //
    // Getters
    //
    public String string(String key, UIViewController viewController)
    {
        SharedPreferences preferences = viewController.getSharedPreferences(key, Context.MODE_PRIVATE);
        return preferences.getString(key,"");
    }
    public Boolean bool(String key, UIViewController viewController)
    {
        SharedPreferences preferences = viewController.getSharedPreferences(key, Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }
}
