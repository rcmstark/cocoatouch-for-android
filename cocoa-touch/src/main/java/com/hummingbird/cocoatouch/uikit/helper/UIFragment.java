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
    private ViewGroup container;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        this.container = (ViewGroup)inflater.inflate(this.identifier, container, false);
        IBOutletParser.parse(this.viewController);
        IBActionParser.parse(this.viewController);
        this.viewController.viewDidLoad();
        return this.container;
    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim)
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

    @Override
    // ViewWillAppear
    public void onStart()
    {
        super.onStart();
        if (this.viewController.presentingViewController != null)
            this.viewController.presentingViewController.viewWillDisappear(animated);
        this.viewController.viewWillAppear(animated);
    }

    @Override
    //ViewDidAppear
    public void onResume() {
        super.onResume();
        if (this.viewController.presentingViewController != null)
            this.viewController.presentingViewController.viewDidDisappear(animated);
        this.viewController.viewDidAppear(animated);
    }

    @Override
    //ViewWillDisappear
    public void onPause()
    {
        super.onPause();
        if (this.viewController.presentingViewController != null)
            this.viewController.presentingViewController.viewWillAppear(animated);
        this.viewController.viewWillDisappear(animated);
    }

    @Override
    //ViewDidDisappear
    public void onStop()
    {
        super.onStop();
        if (this.viewController.presentingViewController != null)
            this.viewController.presentingViewController.viewDidAppear(animated);
        this.viewController.viewDidDisappear(animated);
    }
}
