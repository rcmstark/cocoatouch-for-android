package com.hummingbird.objectivec.parser;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
    private static void parse(final Method method, final UIViewHierarchy controller)
    {
        if(method.isAnnotationPresent(IBAction.class))
        {
            IBAction action = method.getAnnotation(IBAction.class);
            final Object button = controller.viewWithTag(action.value());
            if (button == null) return;

            if(Button.class.isAssignableFrom(button.getClass()))
            {
                parse((Button) button, method, controller);
            }
            else if(ImageButton.class.isAssignableFrom(button.getClass()))
            {
                parse((ImageButton)button, method, controller);
            }
        }
    }
    private static void parse(final Button button, final Method method, final UIViewHierarchy controller)
    {
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View view)
            {
                try
                {
                    method.invoke(controller, button);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    private static void parse(final ImageButton button, final Method method, final UIViewHierarchy controller)
    {
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View view)
            {
                try
                {
                    method.invoke(controller, button);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
