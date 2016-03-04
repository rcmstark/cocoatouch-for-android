package com.hummingbird.cocoatouch.messageui;
import android.content.Intent;


public class MFWhatsappComposeViewController extends MFComposeViewController
{
    public MFWhatsappComposeViewController()
    {
        this.intent = new Intent();
        this.intent.setAction(Intent.ACTION_SEND);
        this.intent.setType("text/plain");
        this.intent.setPackage("com.whatsapp");
    }
    public void setBody(String body)
    {
        this.intent.putExtra(Intent.EXTRA_TEXT, body);
    }
}
