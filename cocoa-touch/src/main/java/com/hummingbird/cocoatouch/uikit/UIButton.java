package com.hummingbird.cocoatouch.uikit;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.hummingbird.cocoatouch.foundation.NSSelector;
import java.lang.reflect.Method;


public class UIButton extends Button
{
    public void init(){}

    public void setTitle(String title, UIControlState state)
    {
        this.setText(title);
    }
    public String titleForState(UIControlState state)
    {
        return this.getText().toString();
    }
    public void setHidden(Boolean hidden)
    {
        this.setVisibility(hidden?View.INVISIBLE:View.VISIBLE);
    }
    public void addTarget(final Object target, final NSSelector action, int event)
    {
        Method method = null;
        try
        {
            Class[] params = new Class[1];
            params[0] = this.getClass();
            method = target.getClass().getMethod(action.methodName, params);
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
            return;
        }
        addTarget(target, method, event);
    }

    public void addTarget(final Object target, final Method method, int event)
    {
        final UIButton button = this;
        this.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    method.invoke(target, button);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    //Java Trash Code
    public UIButton(Context context) {super(context);init();}
    public UIButton(Context context, AttributeSet attrs) {super(context, attrs);init();}
    public UIButton(Context context, AttributeSet attrs, int defStyleAttr) {super(context, attrs, defStyleAttr);init();}

}
