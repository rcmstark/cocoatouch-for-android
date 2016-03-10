package com.hummingbird.cocoatouch.foundation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class NSArray<NSObject> implements Iterable<NSObject>
{
    protected ArrayList<NSObject> array = new ArrayList<>();


//    public static NSArray arrayWithObjects(NSObject ...objects)
//    {
//        NSArray result = new NSArray<>();
//        List<NSObject> list = Arrays.asList(objects);
//        result.array = new ArrayList<>(list);
//        return result;
//    }
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
