package com.hummingbird.cocoatouch.foundation;
import java.util.ArrayList;


public class NSArray<NSObject>
{
    protected ArrayList<NSObject> array = new ArrayList<NSObject>();


    public int length()
    {
        return this.array.size();
    }
    public NSObject objectAtIndex(int index)
    {
        return this.array.get(index);
    }
}
