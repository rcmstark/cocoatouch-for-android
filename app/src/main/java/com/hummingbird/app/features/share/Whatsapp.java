package com.hummingbird.app.features.share;
import com.hummingbird.cocoatouch.foundation.NSObject;
import com.hummingbird.cocoatouch.messageui.MFWhatsappComposeViewController;
import com.hummingbird.cocoatouch.uikit.UIAlertView;
import com.hummingbird.cocoatouch.uikit.UIAlertViewDelegate;
import com.hummingbird.cocoatouch.uikit.UIViewController;


public class Whatsapp extends NSObject
{
    public static void share(String text, UIViewController fromViewController)
    {
        MFWhatsappComposeViewController controller = new MFWhatsappComposeViewController();
        controller.setBody(text);

        try
        {
            fromViewController.presentViewController(controller, false);
        }
        catch (Exception e)
        {
            UIAlertView alertView = new UIAlertView().initWithTitle("Error")
                                                     .delegate(null)
                                                     .message("You don't have whatsapp app installed");
            alertView.show();
        }
    }
}

