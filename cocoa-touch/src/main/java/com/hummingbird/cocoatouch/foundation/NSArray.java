package com.hummingbird.cocoatouch.foundation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class NSArray<NSObject> implements Iterable<NSObject>
{
    protected ArrayList<NSObject> array = new ArrayList<NSObject>();


    public int count()
    {
        return this.array.size();
    }
    public NSObject objectAtIndex(int index)
    {
        return this.array.get(index);
    }
    public Iterator<NSObject> iterator()
    {
        return this.array.iterator();
    }
}
