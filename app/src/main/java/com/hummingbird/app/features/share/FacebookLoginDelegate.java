package com.hummingbird.app.features.share;
import com.facebook.FacebookException;


public interface FacebookLoginDelegate
{
    public void facebookLoginDidReturnSuccess(String access_token);
    public void facebookLoginDidReturnError(FacebookException exception);
    public void facebookLoginDidCancel();
}
