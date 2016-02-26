package com.hummingbird.objectivec.parser;

import com.hummingbird.cocoatouch.foundation.NSObject;
import com.hummingbird.cocoatouch.uikit.UIViewHierarchy;
import com.hummingbird.objectivec.annotation.IBOutlet;

import java.lang.reflect.Field;


public class IBOutletParser extends NSObject
{
    public static void parse(UIViewHierarchy view)
    {
        Field[] fields = view.getClass().getDeclaredFields();
        for (Field field : fields)
        {
            parse(field, view);
        }
    }

    private static void parse(Field field, UIViewHierarchy view)
    {
        field.setAccessible(true);
        if(field.isAnnotationPresent(IBOutlet.class))
        {
            IBOutlet outlet = field.getAnnotation(IBOutlet.class);
            try
            {
                field.set(view,view.viewWithTag(outlet.value()));
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
    }
}

