package com.hummingbird.cocoatouch.uikit;
import android.app.Fragment;
import com.hummingbird.cocoatouch.uikit.helper.UIFragment;


public class UIView extends UIResponder implements UIViewHierarchy
{

    private UIFragment fragment;


    //
    // Public Instance Methods
    //
    public Object viewWithTag(int tag)
    {
        return this.fragment.viewWithTag(tag);
    }

    //
    // Protected Instance Methods
    //
    protected  UIView()
    {
        this.fragment = new UIFragment();
    }
    protected UIView(UIViewController viewController, int identifier)
    {
        this.fragment = new UIFragment();
        this.fragment.identifier = identifier;
        this.fragment.viewController = viewController;
    }
    public UIFragment fragment()
    {
        return this.fragment;
    }
}
