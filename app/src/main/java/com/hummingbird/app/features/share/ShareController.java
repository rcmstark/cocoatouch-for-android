package com.hummingbird.app.features.share;
import com.facebook.FacebookException;
import com.hummingbird.app.R;
import com.hummingbird.cocoatouch.uikit.UIAlertView;
import com.hummingbird.cocoatouch.uikit.UIButton;
import com.hummingbird.cocoatouch.uikit.UIViewController;
import com.hummingbird.culture.DefaultActions;
import com.hummingbird.objectivec.annotation.IBAction;


public class ShareController extends UIViewController implements FacebookLoginDelegate
{

    private static String link = "https://github.com/rcmcastro/cocoatouch-for-android";


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
    // Share Actions
    //
    @IBAction(DefaultActions.onBackPressed) public void back(UIButton sender)
    {
        this.navigationController.popViewController(true);
    }
    @IBAction(R.id.share_sms) public void shareSMS(UIButton sender)
    {
        SMS.share(link, this);
    }
    @IBAction(R.id.share_email) public void shareEmail(UIButton sender)
    {
        Mail.share(link, "CocoaTouch for Android!", this);
    }
    @IBAction(R.id.share_whatsapp) public void shareWhatsapp(UIButton sender)
    {
        Whatsapp.share(link, this);
    }
    @IBAction(R.id.share_facebook) public void shareFacebook(UIButton sender)
    {
        Facebook.share(link, "CocoaTouch for Android!", this);
    }

    //
    // Login Actions
    //
    @IBAction(R.id.login_facebook) public void loginFacebook(UIButton sender)
    {
        Facebook.login(this, "public_profile", "email");
    }

    //
    // FacebookLoginMethods
    //
    @Override public void facebookLoginDidReturnSuccess(String access_token)
    {
        UIAlertView alertView = new UIAlertView().initWithTitle("Login With Success").message("accessToken: " + access_token);
        alertView.show();
    }
    @Override public void facebookLoginDidReturnError(FacebookException exception)
    {
        UIAlertView alertView = new UIAlertView().initWithTitle("Login Error").message("errorMessage: " + exception.toString());
        alertView.show();
    }
    @Override public void facebookLoginDidCancel() {}
}
