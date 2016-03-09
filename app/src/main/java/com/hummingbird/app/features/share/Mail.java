package com.hummingbird.app.features.share;
import android.widget.Toast;
import com.hummingbird.cocoatouch.foundation.NSObject;
import com.hummingbird.cocoatouch.messageui.MFMailComposeViewController;
import com.hummingbird.cocoatouch.uikit.UIAlertView;
import com.hummingbird.cocoatouch.uikit.UIViewController;


public class Mail extends NSObject
{
    public static void share(String text, String subject, UIViewController fromViewController)
    {
        MFMailComposeViewController mailComposer = new MFMailComposeViewController();
        mailComposer.setSubject(subject);
        mailComposer.setMessageBody(text, false);
        try
        {
            fromViewController.presentViewController(mailComposer, false);
        }
        catch (Exception e)
        {
            UIAlertView alertView = new UIAlertView().initWithTitle("Error")
                                                     .delegate(null)
                                                     .message("You don't have an email app installed");
            alertView.show();
        }
    }
}
