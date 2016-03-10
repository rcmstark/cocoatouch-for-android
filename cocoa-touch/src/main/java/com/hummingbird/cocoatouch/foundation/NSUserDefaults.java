package com.hummingbird.cocoatouch.foundation;
import android.content.Context;
import android.content.SharedPreferences;
import com.hummingbird.cocoatouch.uikit.UIApplication;


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
    // Private Methods
    //
    private Context context()
    {
        return UIApplication.sharedApplication().context();
    }
    private SharedPreferences preferences(String key)
    {
        return context().getSharedPreferences(key, Context.MODE_PRIVATE);
    }
    private SharedPreferences.Editor editor(String key)
    {
        return preferences(key).edit();
    }

    //
    // Public Setters
    //
    public void setObject(String string, String key)
    {
        SharedPreferences.Editor editor = editor(key);
        editor.putString(key, string);
        editor.apply();
    }
    public void setBool(Boolean bool, String key)
    {
        SharedPreferences.Editor editor = editor(key);
        editor.putBoolean(key, bool);
        editor.apply();
    }

    //
    // Public Delete
    //
    public void removeObjectForKey(String key)
    {
        SharedPreferences.Editor editor = editor(key);
        editor.remove(key);
        editor.apply();
    }

    //
    // Public Getters
    //
    public String stringForKey(String key)
    {
        return preferences(key).getString(key, null);
    }
    public Boolean boolForKey(String key)
    {
        return preferences(key).getBoolean(key, false);
    }
}
