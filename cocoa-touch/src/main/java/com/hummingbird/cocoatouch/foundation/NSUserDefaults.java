package com.hummingbird.cocoatouch.foundation;

import android.content.Context;
import android.content.SharedPreferences;

import com.hummingbird.cocoatouch.uikit.UIApplication;
import com.hummingbird.cocoatouch.uikit.UIViewController;


public class NSUserDefaults
{

    private static NSUserDefaults nsUserDefault = null;

    //
    // Class Methods
    //
    public static NSUserDefaults standartUserDefaults()
    {
        if (nsUserDefault == null)
            nsUserDefault = new NSUserDefaults();
        return nsUserDefault;
    }

    //
    // Instance Methods
    //
    private Context context()
    {
        return UIApplication.sharedApplication().context();
    }

    //
    // Setters
    //
    public void setObject(String string, String key)
    {
        SharedPreferences preferences = context().getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, string);
        editor.apply();
    }
    public void setBool(Boolean bool, String key)
    {
        SharedPreferences preferences = context().getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, bool);
        editor.apply();
    }

    //
    // Getters
    //
    public String stringForKey(String key)
    {
        SharedPreferences preferences = context().getSharedPreferences(key, Context.MODE_PRIVATE);
        return preferences.getString(key,null);
    }
    public Boolean boolForKey(String key)
    {
        SharedPreferences preferences = context().getSharedPreferences(key, Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }
}
