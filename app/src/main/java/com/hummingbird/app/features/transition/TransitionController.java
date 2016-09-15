package com.hummingbird.app.features.transition;
import com.hummingbird.app.R;
import com.hummingbird.cocoatouch.uikit.UIButton;
import com.hummingbird.cocoatouch.uikit.UIModalTransitionStyle;
import com.hummingbird.cocoatouch.uikit.UIViewController;
import com.hummingbird.culture.DefaultActions;
import com.hummingbird.objectivec.annotation.IBAction;


public class TransitionController extends UIViewController
{

    @Override public void viewDidLoad()
    {
        super.viewDidLoad();
        NSLog(__PRETTY_FUNCTION__());
    }
    @Override public void viewDidAppear(Boolean animated)
    {
        super.viewDidAppear(animated);
        NSLog(__PRETTY_FUNCTION__());
    }

    //
    // Actions
    //
    @IBAction(DefaultActions.onBackPressed) public void back(UIButton sender)
    {
        this.navigationController.popViewController(true);
    }
    @IBAction(R.id.crossdissolve) public void transitionCrossDissolve(UIButton sender)
    {
        NextViewController controller = (NextViewController)this.storyboard.instantiateViewControllerWithIdentifier(R.layout.nextviewcontroller);
        controller.modalTransitionStyle = UIModalTransitionStyle.CrossDissolve;
        controller.animationName = "Cross Dissolve";
        this.presentViewController(controller, true);
    }
    @IBAction(R.id.coververtical) public void transitionCoverVertical(UIButton sender)
    {
        NextViewController controller = (NextViewController)this.storyboard.instantiateViewControllerWithIdentifier(R.layout.nextviewcontroller);
        controller.modalTransitionStyle = UIModalTransitionStyle.CoverVertical;
        controller.animationName = "Cover Vertical";
        this.presentViewController(controller, true);
    }
    @IBAction(R.id.push) public void trasitionPushAnimated(UIButton sender)
    {
        NextViewController controller = (NextViewController)this.storyboard.instantiateViewControllerWithIdentifier(R.layout.nextviewcontroller);
        controller.animationName = "Push";
        this.navigationController.pushViewController(controller, true);
    }
    @IBAction(R.id.noAnimation) public void trasitionPushNoAnimated(UIButton sender)
    {
        NextViewController controller = (NextViewController)this.storyboard.instantiateViewControllerWithIdentifier(R.layout.nextviewcontroller);
        controller.animationName = "No Animation";
        this.navigationController.pushViewController(controller, false);
    }
}
