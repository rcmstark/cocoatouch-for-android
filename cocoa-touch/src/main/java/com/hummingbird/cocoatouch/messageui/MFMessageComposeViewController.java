package com.hummingbird.cocoatouch.messageui;
import android.content.Intent;


public class MFMessageComposeViewController extends MFComposeViewController
{
    public MFMessageComposeViewController()
    {
        this.intent = new Intent(Intent.ACTION_VIEW);
        this.intent.setType("vnd.android-dir/mms-sms");
    }
    public void setBody(String body)
    {
        this.intent.putExtra("sms_body",body);
    }
}
