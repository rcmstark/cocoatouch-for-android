package com.hummingbird.cocoatouch.uikit;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import com.hummingbird.cocoatouch.foundation.NSObject;


public class UIActionSheet extends NSObject
{
    String title = null;
    String[] otherButtonTitlers = null;
    UIActionSheetDelegate delegate = null;
    String cancelButtonTitle = null;
    String destructiveButtonTitle = null;

    public UIActionSheet initWithTitle(String title)
    {
        this.title = title;
        return this;
    }

    public UIActionSheet delegate(UIActionSheetDelegate delegate)
    {
        this.delegate = delegate;
        return this;
    }

    public UIActionSheet cancelButtonTitle(String title)
    {
        this.cancelButtonTitle = title;
        return this;
    }

    public UIActionSheet destructiveButtonTitle(String title)
    {
        this.destructiveButtonTitle = title;
        return this;
    }

    public UIActionSheet otherButtonTitles(String[] array)
    {
        this.otherButtonTitlers = array;
        return this;
    }

    public void show()
    {
        final UIActionSheet actionSheet = this;
        final UIActionSheetDelegate delegate = this.delegate;
        Context context = UIApplication.sharedApplication().context();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(this.title);
        builder.setItems(this.otherButtonTitlers, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                if(delegate != null)
                    delegate.actionSheetClickedButtonAtIndex(actionSheet, index);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

