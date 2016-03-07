package com.hummingbird.cocoatouch.foundation;
import java.util.HashMap;


public class NSDictionary extends NSObject
{
    private HashMap<String, NSObject> dictionaty = new HashMap<String, NSObject>();

    //
    // Class Methods
    //
    public static NSDictionary dictionatyWithObjects(NSArray<NSObject> objects, NSArray<String> keys)
    {
        NSDictionary result = new NSDictionary();
        for (int i = 0; i < objects.count(); i++)
        {
            result.dictionaty.put(keys.objectAtIndex(i), objects.objectAtIndex(i));
        }
        return result;
    }
    public static NSDictionary dictionaryWithObject(NSObject object, String key)
    {
        NSDictionary result = new NSDictionary();
        result.dictionaty.put(key, object);
        return result;
    }
}
