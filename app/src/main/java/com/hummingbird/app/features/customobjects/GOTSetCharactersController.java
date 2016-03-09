package com.hummingbird.app.features.customobjects;
import com.hummingbird.app.R;
import com.hummingbird.cocoatouch.foundation.NSMutableArray;
import com.hummingbird.cocoatouch.uikit.UIButton;
import com.hummingbird.cocoatouch.uikit.UIModalTransitionStyle;
import com.hummingbird.cocoatouch.uikit.UIViewController;
import com.hummingbird.objectivec.annotation.IBAction;

public class GOTSetCharactersController extends UIViewController
{
    @Override public void viewDidAppear(Boolean animated)
    {
        super.viewDidAppear(animated);
        NSLog(__PRETTY_FUNCTION__());
    }

    @IBAction(R.id.setcharacters) public void set(UIButton sender)
    {
        // Create Characters
        GOTCharacter jon = new GOTCharacter("Jon Snow", 25);
        GOTCharacter daenerys = new GOTCharacter("Daenerys Targaryen", 22);
        GOTCharacter arya = new GOTCharacter("Arya Stark", 14);
        GOTCharacter tyrion = new GOTCharacter("Tyrion Lannister", 28);
        GOTCharacter cersei = new GOTCharacter("Cersei Lannister", 32);

        //Set friends
        cersei.addFriend(tyrion);
        tyrion.addFriend(daenerys);
        tyrion.addFriend(cersei);
        jon.addFriend(arya);
        arya.addFriend(jon);
        daenerys.addFriend(tyrion);

        NSMutableArray<GOTCharacter> characters = new NSMutableArray<>();
        characters.addObject(jon);
        characters.addObject(daenerys);
        characters.addObject(arya);
        characters.addObject(tyrion);
        characters.addObject(cersei);

        GOTPresentCharactersController controller = (GOTPresentCharactersController)this.storyboard.instantiateViewControllerWithIdentifier(R.layout.gotpresentcharacterscontroller);
        controller.characters = characters;
        controller.modalTransitionStyle = UIModalTransitionStyle.CrossDissolve;
        this.presentViewController(controller, true);
    }
}
