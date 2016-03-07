package com.hummingbird.cocoatouch.foundation;


public class NSString extends NSObject
{
    String string;

    public static String FromClass(Class cls)
    {
        return cls.getName();
    }
    public NSString(String string)
    {
        this.string = string;
    }

    public String text()
    {
        return this.string;
    }

    public boolean isEqual(NSString string)
    {
        return this.string == string.text();
    }
}
