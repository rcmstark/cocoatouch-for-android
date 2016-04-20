package com.hummingbird.cocoatouch.uikit;
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
    public void setHidden(boolean hidden)
    {
        this.fragment.setHidden(hidden);
    }
    public void setUserInteractionEnabled(boolean enabled)
    {
        this.fragment.setUserInteractionEnabled(enabled);
    }

    //
    // Protected Instance Methods
    //
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
