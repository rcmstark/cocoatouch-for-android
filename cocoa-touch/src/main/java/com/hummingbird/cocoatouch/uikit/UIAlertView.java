package com.hummingbird.cocoatouch.uikit;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import com.hummingbird.cocoatouch.foundation.NSObject;


public class UIAlertView extends NSObject
{
    String title = null;
    String message = null;
    UIAlertViewDelegate delegate = null;

    public UIAlertView initWithTitle(String title)
    {
        this.title = title;
        return this;
    }
    public UIAlertView delegate(UIAlertViewDelegate delegate)
    {
        this.delegate = delegate;
        return this;
    }
    public UIAlertView message(String message)
    {
        this.message = message;
        return this;
    }

    public void show()
    {
        Context context = UIApplication.sharedApplication().context();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override public void onClick(DialogInterface dialogInterface, int i)
            {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
