package com.hummingbird.app.features.share;
import android.content.Intent;
import android.net.Uri;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.hummingbird.cocoatouch.foundation.NSObject;
import com.hummingbird.cocoatouch.uikit.UIApplication;
import com.hummingbird.cocoatouch.uikit.UIViewController;
import java.util.Arrays;


public class Facebook extends NSObject
{
    private static Facebook facebook;
    private CallbackManager callbackManager;
    private LoginManager loginManager;
    public FacebookLoginDelegate delegate;


    public static Facebook sharedInstance()
    {
        if (facebook == null)
        {
            facebook = new Facebook();
            FacebookSdk.sdkInitialize(UIApplication.sharedApplication().context());
        }
        return facebook;
    }
    public static void share(String link, UIViewController fromViewController)
    {
        Facebook.sharedInstance();
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse(link))
                .setContentTitle("CocoaTouch for Android")
                .build();
        ShareDialog.show(fromViewController.view.fragment(), content);
    }
    public static void login(FacebookLoginDelegate delegate, String... permissions)
    {
        Facebook.sharedInstance().delegate = delegate;
        Facebook.sharedInstance().loginWithPermissions(permissions);
    }
    public static void update(int requestCode, int resultCode, Intent data)
    {
        Facebook.sharedInstance().set(requestCode, resultCode, data);
    }

    //
    // Private instance methods
    //
    private void loginWithPermissions(String... permissions)
    {
        callbackManager = CallbackManager.Factory.create();
        loginManager = LoginManager.getInstance();
        loginManager.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>()
                {
                    @Override
                    public void onSuccess(LoginResult loginResult)
                    {
                        String facebook_token = AccessToken.getCurrentAccessToken().getToken();
                        delegate.facebookLoginDidReturnSuccess(facebook_token);
                    }

                    @Override
                    public void onCancel()
                    {
                        delegate.facebookLoginDidCancel();
                    }

                    @Override
                    public void onError(FacebookException exception)
                    {
                        delegate.facebookLoginDidReturnError(exception);
                    }
                });
        loginManager.logInWithReadPermissions(UIApplication.sharedApplication().activity(), Arrays.asList(permissions));
    }
    private void set(int requestCode, int resultCode, Intent data)
    {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}

