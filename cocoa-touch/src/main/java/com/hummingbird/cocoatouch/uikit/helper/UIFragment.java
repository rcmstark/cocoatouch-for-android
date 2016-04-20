package com.hummingbird.cocoatouch.uikit.helper;
import android.animation.Animator;
import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.hummingbird.animations.NoneTransition;
import com.hummingbird.animations.Transition;
import com.hummingbird.cocoatouch.uikit.UIApplication;
import com.hummingbird.cocoatouch.uikit.UIViewController;
import com.hummingbird.cocoatouch.uikit.UIViewHierarchy;
import com.hummingbird.objectivec.parser.IBActionParser;
import com.hummingbird.objectivec.parser.IBOutletParser;


public class UIFragment extends Fragment implements UIViewHierarchy
{

    public int identifier = 0;
    public UIViewController viewController = new UIViewController();
    public Transition transition = new NoneTransition();
    public boolean animated = false;
    private View container;


    @Override public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        if (this.identifier == 0)
            return new View(UIApplication.sharedApplication().context());

        this.container = inflater.inflate(this.identifier, container, false);
        IBOutletParser.parse(this.viewController);
        IBActionParser.parse(this.viewController);
        this.viewController.viewDidLoad();

        // This code is used to unable to touch UIViewController after a transition
        // Fix the problem to call action in the behind UIViewController
        this.container.setOnTouchListener(new View.OnTouchListener()
        {
            @Override public boolean onTouch(View view, MotionEvent event)
            {
                return true;
            }
        });
        return this.container;
    }
    @Override public Animator onCreateAnimator(int transit, boolean enter, int nextAnim)
    {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return this.transition.animator(this, size, enter);
    }
    public Object viewWithTag(int id)
    {
        return this.container.findViewById(id);
    }
    public void setHidden(boolean hidden)
    {
        this.container.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
    }
    public void setUserInteractionEnabled(final boolean enabled)
    {
        this.container.setEnabled(enabled);
    }

    @Override public void onStart()
    {
        super.onStart();

        //
        // Should not notify controllers when app goes to background
        //
        if(!UIApplication.sharedApplication().isNotificationsEnabled())
            return;


        if (this.viewController.presentingViewController() != null)
            this.viewController.presentingViewController().viewWillDisappear(animated);
        this.viewController.viewWillAppear(animated);
    }
    @Override public void onResume()
    {
        super.onResume();

        //
        // Should not notify controllers when app goes to background
        //
        if(!UIApplication.sharedApplication().isNotificationsEnabled())
            return;


        if (this.viewController.presentingViewController() != null)
        {
            this.viewController.presentingViewController().viewDidDisappear(animated);
            this.viewController.presentingViewController().view.setUserInteractionEnabled(false);
        }
        this.viewController.viewDidAppear(animated);
    }
    @Override public void onPause()
    {
        super.onPause();

        //
        // Should not notify controllers when app goes to background
        //
        if(!UIApplication.sharedApplication().isNotificationsEnabled())
                return;


        if (this.viewController.presentingViewController() != null)
            this.viewController.presentingViewController().viewWillAppear(animated);
        this.viewController.viewWillDisappear(animated);
    }
    @Override public void onStop()
    {
        super.onStop();

        //
        // Should not notify controllers when app goes to background
        //
        if(!UIApplication.sharedApplication().isNotificationsEnabled())
            return;


        if (this.viewController.presentingViewController() != null)
        {
            this.viewController.presentingViewController().viewDidAppear(animated);
            this.viewController.presentingViewController().view.setUserInteractionEnabled(true);
        }
        this.viewController.viewDidDisappear(animated);
    }
}
