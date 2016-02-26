package com.hummingbird.objectivec.parser;

import com.hummingbird.cocoatouch.uikit.UIButton;
import com.hummingbird.cocoatouch.uikit.UIViewHierarchy;
import com.hummingbird.objectivec.annotation.IBAction;

import java.lang.reflect.Method;


public class IBActionParser
{
    public static void parse(UIViewHierarchy controller)
    {
        Method[] methods = controller.getClass().getDeclaredMethods();
        for (Method method: methods)
        {
            parse(method, controller);
        }
    }

    private static void parse(Method method, UIViewHierarchy controller)
    {
        if(method.isAnnotationPresent(IBAction.class))
        {
            IBAction action = method.getAnnotation(IBAction.class);
            UIButton button = (UIButton)controller.viewWithTag(action.value());
            button.addTarget(controller, method, 0);
        }
    }
}
