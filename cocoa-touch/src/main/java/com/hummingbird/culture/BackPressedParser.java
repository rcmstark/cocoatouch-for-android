package com.hummingbird.culture;
import com.hummingbird.objectivec.annotation.IBAction;
import java.lang.reflect.Method;


public class BackPressedParser
{
    public static Method onBackPressedMethod(Object controller)
    {
        if (controller == null)
            return null;

        Method[] methods = controller.getClass().getDeclaredMethods();
        for (Method method: methods)
        {
            if (isTheRightMethod(method, controller))
                return method;
        }
        return null;
    }
    private static boolean isTheRightMethod(final Method method, final Object controller)
    {
        if(method.isAnnotationPresent(IBAction.class))
        {
            IBAction action = method.getAnnotation(IBAction.class);
            return action.value() == DefaultActions.onBackPressed;
        }
        return false;
    }
}
