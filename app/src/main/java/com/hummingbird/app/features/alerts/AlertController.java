package com.hummingbird.app.features.alerts;
import com.hummingbird.app.R;
import com.hummingbird.app.features.customobjects.GOTCharacter;
import com.hummingbird.cocoatouch.uikit.UIActionSheet;
import com.hummingbird.cocoatouch.uikit.UIActionSheetDelegate;
import com.hummingbird.cocoatouch.uikit.UIAlertView;
import com.hummingbird.cocoatouch.uikit.UIButton;
import com.hummingbird.cocoatouch.uikit.UIViewController;
import com.hummingbird.culture.DefaultActions;
import com.hummingbird.objectivec.annotation.IBAction;


public class AlertController extends UIViewController implements UIActionSheetDelegate
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
    @IBAction(R.id.uialertview) public void presentAlerView(UIButton sender)
    {
        UIAlertView alertView = new UIAlertView().initWithTitle("Hey buddy")
                                                 .delegate(null)
                                                 .message("Winter is comming");
        alertView.show();
    }
    @IBAction(R.id.uiactionsheet) public void presentActionSheet(UIButton sender)
    {
        UIActionSheet actionSheet = new UIActionSheet().initWithTitle("Characters")
                                                       .delegate(this)
                                                       .otherButtonTitles(GOTCharacter.allCharacters());
        actionSheet.show();
    }

    //
    // ActionSheetDelegate
    //
    @Override public void actionSheetClickedButtonAtIndex(UIActionSheet actionSheet, int buttonIndex)
    {
        NSLog("Character selected: " + GOTCharacter.allCharacters()[buttonIndex]);
    }
}
