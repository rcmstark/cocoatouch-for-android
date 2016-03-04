package com.hummingbird.cocoatouch.uikit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.hummingbird.cocoatouch.foundation.NSSelector;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class UIButton extends Button
{
    public UIButton(Context context) {super(context);}
    public UIButton(Context context, AttributeSet attrs) {super(context, attrs);}
    public UIButton(Context context, AttributeSet attrs, int defStyleAttr) {super(context, attrs, defStyleAttr);}

    public void setTitle(String title, int state)
    {
        this.setText(title);
    }
    public String titleForState(int state)
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
                catch (IllegalAccessException | InvocationTargetException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

}
