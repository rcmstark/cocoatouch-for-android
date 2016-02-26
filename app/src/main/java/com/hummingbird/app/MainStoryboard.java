package com.hummingbird.app;
import android.content.res.Resources;

import com.hummingbird.app.controllers.ViewController;
import com.hummingbird.cocoatouch.uikit.UIStoryboard;

/**
 * Created by rafaelcastro on 2/25/16.
 */

public class MainStoryboard extends UIStoryboard
{
    @Override
    public int initialViewControllerID()
    {
        return R.layout.viewcontroller;
    }

    @Override
    public Object viewControllerForIdentifier(int identifier)
    {
        switch (identifier)
        {
            case R.layout.viewcontroller:
                return new ViewController();
            default:
                throw new Resources.NotFoundException();
        }
    }
}
