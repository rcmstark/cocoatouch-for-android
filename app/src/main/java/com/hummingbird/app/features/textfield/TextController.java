package com.hummingbird.app.features.textfield;
import com.hummingbird.app.R;
import com.hummingbird.cocoatouch.uikit.UIButton;
import com.hummingbird.cocoatouch.uikit.UITextField;
import com.hummingbird.cocoatouch.uikit.UIViewController;
import com.hummingbird.objectivec.annotation.IBAction;
import com.hummingbird.objectivec.annotation.IBOutlet;


public class TextController extends UIViewController
{
    @IBOutlet(R.id.textField1) UITextField textField1;
    @IBOutlet(R.id.textField2) UITextField textField2;


    @Override public void viewDidLoad()
    {
        super.viewDidLoad();
        textField1.setPlaceholder("Random TextField1");
        textField1.setText("");

        textField2.setPlaceholder("Random TextField2");
        textField2.setText("");
        textField2.becomeFirstResponder();
    }

    //
    // Actions
    //
    @IBAction(R.id.text_bfr) public void becomeFirstResponder(UIButton sender)
    {
        textField1.becomeFirstResponder();
    }
    @IBAction(R.id.text_rfr) public void resignFirstResponder(UIButton sender)
    {
        textField1.resignFirstResponder();
    }
}
