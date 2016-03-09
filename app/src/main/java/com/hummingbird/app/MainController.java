package com.hummingbird.app;
import com.hummingbird.cocoatouch.uikit.UIButton;
import com.hummingbird.cocoatouch.uikit.UIViewController;
import com.hummingbird.objectivec.annotation.IBAction;


public class MainController extends UIViewController
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
    @IBAction(R.id.main_tutorial) public void presentTutorialController(UIButton sender)
    {
        presentViewController(R.layout.tutorialcontroller);
    }
    @IBAction(R.id.main_transition) public void presentTransitionController(UIButton sender)
    {
        presentViewController(R.layout.transitioncontroller);
    }
    @IBAction(R.id.main_tableview) public void presentTableController(UIButton sender)
    {
        presentViewController(R.layout.tablecontroller);
    }
    @IBAction(R.id.main_customobjects) public void presentGOTSetCharactersController(UIButton sender)
    {
        presentViewController(R.layout.gotsetcharacterscontroller);
    }
    @IBAction(R.id.main_share) public void presentShareController(UIButton sender)
    {
        presentViewController(R.layout.sharecontroller);
    }
    @IBAction(R.id.main_alert) public void presentAlertController(UIButton sender)
    {
        presentViewController(R.layout.alertcontroller);
    }

    //
    // Helpers
    //
    private void presentViewController(int identifier)
    {
        UIViewController controller = this.storyboard.instantiateViewControllerWithIdentifier(identifier);
        this.navigationController.pushViewController(controller, true);
    }
}
