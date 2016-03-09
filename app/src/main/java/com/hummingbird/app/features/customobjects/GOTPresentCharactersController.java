package com.hummingbird.app.features.customobjects;
import com.hummingbird.app.R;
import com.hummingbird.cocoatouch.foundation.NSArray;
import com.hummingbird.cocoatouch.uikit.UIAlertView;
import com.hummingbird.cocoatouch.uikit.UIButton;
import com.hummingbird.cocoatouch.uikit.UILabel;
import com.hummingbird.cocoatouch.uikit.UIViewController;
import com.hummingbird.objectivec.annotation.IBAction;
import com.hummingbird.objectivec.annotation.IBOutlet;


public class GOTPresentCharactersController extends UIViewController
{

    @IBOutlet(R.id.presentCharacters) UILabel label;
    public NSArray<GOTCharacter> characters;
    private GOTCharacter oldest;
    private GOTCharacter friendly;
    private String names = "";


    @Override public void viewDidLoad()
    {
        super.viewDidLoad();

        this.friendly = characters.objectAtIndex(0);
        this.oldest = characters.objectAtIndex(0);
        for (GOTCharacter character : characters)
        {
            this.names = this.names + character.name + ", ";

            // Print characters name
            NSLog("GoT Character: " + character.name);

            // Search characters with more friends
            if (character.friends.count() >this.friendly.friends.count())
                this.friendly = character;

            // Search oldest character
            if (character.age > this.oldest.age)
                this.oldest = character;
        }
        //
        // Remove last ", "
        //
        this.names = this.names.substring(0, this.names.length() - 2);
        this.label.setText(this.names);
    }

    //
    // Actions
    //
    @IBAction(R.id.present_oldest) public void presentOldest(UIButton sender)
    {
        String message = oldest.name + " is the oldest character";
        showAlert(message);
    }
    @IBAction(R.id.present_friendly) public void presentFriendlier(UIButton sender)
    {
        String message = friendly.name + " has more friends";
        showAlert(message);
    }

    //
    // Helpers
    //
    private void showAlert(String message)
    {
        UIAlertView alertView = new UIAlertView().initWithTitle("GoT")
                                                 .delegate(null)
                                                 .message(message);
        alertView.show();
    }
}
