package com.hummingbird.cocoatouch.foundation;


public class NSMutableArray<NSObject> extends NSArray<NSObject>
{
    public void addObject(NSObject object)
    {
        this.array.add(object);
    }
    public void insertObject(NSObject object, int index)
    {
        this.array.add(index, object);
    }
    public void removeObjectAtIndex(int index)
    {
        this.array.remove(index);
    }
    public void removeAllObjects()
    {
        this.array.removeAll(array);
    }
}
