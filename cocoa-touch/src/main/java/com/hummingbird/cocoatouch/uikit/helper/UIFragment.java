package com.hummingbird.cocoatouch.uikit.helper;
import android.animation.Animator;
import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hummingbird.animations.Transition;
import com.hummingbird.cocoatouch.uikit.UIApplication;
import com.hummingbird.cocoatouch.uikit.UIViewController;
import com.hummingbird.cocoatouch.uikit.UIViewHierarchy;
import com.hummingbird.objectivec.parser.IBActionParser;
import com.hummingbird.objectivec.parser.IBOutletParser;


public class UIFragment extends Fragment implements UIViewHierarchy
{

    public int identifier;
    public UIViewController viewController;
    public Transition transition;
    public boolean animated;
    private View container;


    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        this.container = inflater.inflate(this.identifier, container, false);
        IBOutletParser.parse(this.viewController);
        IBActionParser.parse(this.viewController);
        this.viewController.viewDidLoad();
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
        this.container.setVisibility(hidden?View.INVISIBLE:View.VISIBLE);
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
            this.viewController.presentingViewController().viewDidDisappear(animated);
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
            this.viewController.presentingViewController().viewDidAppear(animated);
        this.viewController.viewDidDisappear(animated);
    }
}
