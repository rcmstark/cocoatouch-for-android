package com.hummingbird.cocoatouch.foundation;
import android.os.Handler;
import java.lang.reflect.Method;

public class NSTimer extends NSObject
{
    private boolean repeats;
    private boolean invalidate;
    private Object target;
    private long timeInterval;
    private NSSelector selector;
    private Object userInfo;

    public void invalidate()
    {
        this.invalidate = true;
        this.repeats = false;
    }
    public static NSTimer scheduledTimer(final long timeInterval, final Object target, final NSSelector selector, final Object userInfo, final Boolean repeats)
    {
        final NSTimer timer = new NSTimer();
        timer.repeats = repeats;
        timer.target = target;
        timer.selector = selector;
        timer.userInfo = userInfo;
        timer.timeInterval = timeInterval;
        timer.invalidate = false;
        execute(timer);
        return timer;
    }
    private static void execute(final NSTimer timer)
    {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override public void run() {
                try
                {
                    if (timer == null ||timer.invalidate)
                        return;

                    Method method = null;
                    if (timer.userInfo == null)
                    {
                        method = timer.target.getClass().getDeclaredMethod(timer.selector.methodName);
                        method.invoke(timer.target);
                    }
                    else
                    {
                        Class[] params = new Class[1];
                        params[0] = timer.userInfo.getClass();
                        method = timer.target.getClass().getMethod(timer.selector.methodName, params);
                        method.invoke(timer.target, timer.userInfo);
                    }
                    if (timer.repeats)
                        execute(timer);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, timer.timeInterval);
    }
}
