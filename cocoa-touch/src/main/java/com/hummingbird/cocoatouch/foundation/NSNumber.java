package com.hummingbird.cocoatouch.foundation;

public class NSNumber extends NSObject
{
    int number;

    public NSNumber(int number)
    {
        this.number = number;
    }

    public int integerValue()
    {
        return this.number;
    }
}
