package com.hummingbird.app.features.transition;

import com.hummingbird.app.R;
import com.hummingbird.cocoatouch.uikit.UILabel;
import com.hummingbird.cocoatouch.uikit.UIViewController;
import com.hummingbird.objectivec.annotation.IBOutlet;


public class NextViewController extends UIViewController
{

    @IBOutlet(R.id.nextviewcontroller_label) UILabel label;
    public String animationName;

    @Override public void viewDidLoad()
    {
        super.viewDidLoad();
        NSLog(__PRETTY_FUNCTION__());
        this.label.setText(animationName);
    }
    @Override public void viewDidAppear(Boolean animated)
    {
        super.viewDidAppear(animated);
        NSLog(__PRETTY_FUNCTION__());
    }
}
