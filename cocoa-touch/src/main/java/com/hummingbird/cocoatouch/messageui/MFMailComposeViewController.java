package com.hummingbird.cocoatouch.messageui;
import android.content.Intent;


public class MFMailComposeViewController extends MFComposeViewController
{
    public MFMailComposeViewController()
    {
        this.intent = new Intent(Intent.ACTION_SEND);
        this.intent.setType("message/rfc822");
    }
    public Intent controller()
    {
        return Intent.createChooser(this.intent, "Send mail...");
    }
    public void setSubject(String subject)
    {
        this.intent.putExtra(Intent.EXTRA_SUBJECT, subject);
    }
    public void setMessageBody(String body, Boolean isHTML)
    {
        this.intent.putExtra(Intent.EXTRA_TEXT, body);
    }
}
