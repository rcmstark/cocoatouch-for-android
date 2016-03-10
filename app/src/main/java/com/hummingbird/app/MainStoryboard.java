package com.hummingbird.app;
import android.content.res.Resources;
import com.hummingbird.app.features.alerts.AlertController;
import com.hummingbird.app.features.customobjects.GOTPresentCharactersController;
import com.hummingbird.app.features.customobjects.GOTSetCharactersController;
import com.hummingbird.app.features.share.ShareController;
import com.hummingbird.app.features.tableview.TableController;
import com.hummingbird.app.features.transition.NextViewController;
import com.hummingbird.app.features.transition.TransitionController;
import com.hummingbird.app.features.tutorial.TutorialController;
import com.hummingbird.cocoatouch.uikit.UIApplicationDelegate;
import com.hummingbird.cocoatouch.uikit.UIStoryboard;
import com.hummingbird.cocoatouch.uikit.UIViewController;


public class MainStoryboard extends UIStoryboard
{

    @Override public UIApplicationDelegate applicationDelegate()
    {
        return new AppDelegate();
    }
    @Override public int containerID()
    {
        return R.id.container;
    }
    @Override public int storyBoardID()
    {
        return R.layout.mainstoryboard;
    }
    @Override public int initialViewControllerID()
    {
        return R.layout.maincontroller;
    }
    @Override public UIViewController viewControllerForIdentifier(int identifier)
    {
        switch (identifier)
        {
            case R.layout.maincontroller:
                return new MainController();
            case R.layout.tutorialcontroller:
                return new TutorialController();
            case R.layout.tutorial1:
            case R.layout.tutorial2:
            case R.layout.tutorial3:
                return new UIViewController();
            case R.layout.transitioncontroller:
                return new TransitionController();
            case R.layout.nextviewcontroller:
                return new NextViewController();
            case R.layout.tablecontroller:
                return new TableController();
            case R.layout.gotsetcharacterscontroller:
                return new GOTSetCharactersController();
            case R.layout.gotpresentcharacterscontroller:
                return new GOTPresentCharactersController();
            case R.layout.viewcontroller:
                return new UIViewController();
            case R.layout.sharecontroller:
                return new ShareController();
            case R.layout.alertcontroller:
                return new AlertController();
            default:
                throw new Resources.NotFoundException();
        }
    }
}
