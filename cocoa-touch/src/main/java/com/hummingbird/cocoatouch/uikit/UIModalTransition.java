package com.hummingbird.cocoatouch.uikit;
import com.hummingbird.animations.CoverVerticalTransition;
import com.hummingbird.animations.CrossDissolveTransition;
import com.hummingbird.animations.NoneTransition;
import com.hummingbird.animations.Transition;


public class UIModalTransition
{
    protected static Transition transition(UIModalTransitionStyle style, Boolean animated)
    {
        if (!animated)
            return new NoneTransition();

        switch (style)
        {
            case CoverVertical:
                return new CoverVerticalTransition();
            case CrossDissolve:
                return new CrossDissolveTransition();
            default:
                return new NoneTransition();
        }
    }
}
