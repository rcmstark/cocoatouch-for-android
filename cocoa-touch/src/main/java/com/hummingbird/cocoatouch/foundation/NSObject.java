package com.hummingbird.cocoatouch.foundation;

import android.util.Log;

public class NSObject extends Object
{
    public void NSLog(String string)
    {
        Log.d("LOG", string);
    }

    public String __PRETTY_FUNCTION__()
    {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[3];
        final String s = e.getClassName();
        return s.substring(s.lastIndexOf('.') + 1, s.length()) + "." + e.getMethodName();
    }
}

