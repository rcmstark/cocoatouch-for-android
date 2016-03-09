package com.hummingbird.app.features.share;
import com.hummingbird.cocoatouch.foundation.NSObject;
import com.hummingbird.cocoatouch.messageui.MFMessageComposeViewController;
import com.hummingbird.cocoatouch.uikit.UIViewController;


public class SMS extends NSObject
{
    public static void share(String text, UIViewController fromViewController)
    {
        MFMessageComposeViewController controller = new MFMessageComposeViewController();
        controller.setBody(text);
        fromViewController.presentViewController(controller, false);
    }
}
