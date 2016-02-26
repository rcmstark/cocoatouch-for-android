package com.hummingbird.cocoatouch.messageui;

import android.content.Intent;

import com.hummingbird.cocoatouch.foundation.NSObject;

public class MFComposeViewController extends NSObject
{
    Intent intent;

    public Intent controller()
    {
        return this.intent;
    }
}
