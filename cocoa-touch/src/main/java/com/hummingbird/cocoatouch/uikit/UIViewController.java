package com.hummingbird.cocoatouch.uikit;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import com.hummingbird.cocoatouch.messageui.MFComposeViewController;
import com.hummingbird.objectivec.parser.IBActionParser;
import com.hummingbird.objectivec.parser.IBOutletParser;


public class UIViewController extends AppCompatActivity implements UIViewHierarchy
{

    public UINavigationController navigationController;
    public UIStoryboard storyboard;
    private int identifier;


    public void init()
    {
        this.storyboard = UIStoryboard.get(this.getClass());
    }
    public int identifier()
    {
        return this.identifier;
    }
    public Object viewWithTag(int id)
    {
        return this.findViewById(id);
    }
    public String __PRETTY_FUNCTION__()
    {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[3];
        final String s = e.getClassName();
        return s.substring(s.lastIndexOf('.') + 1, s.length()) + "." + e.getMethodName();
    }
    public void NSLog(String message)
    {
        Log.d("LOG:", message);
    }
    public Context context()
    {
        return this;
    }
    public void dismissViewController(Boolean animated)
    {
        this.finish();
    }

    protected void setIdentifier(int identifier)
    {
        this.identifier = identifier;
    }
    protected void setNavigationController(UINavigationController navigationController)
    {
        this.navigationController = navigationController;
    }
    protected void setStoryboard(UIStoryboard storyboard)
    {
        this.storyboard = storyboard;
    }
    public void presentViewController(MFComposeViewController composer, Boolean animated)
    {
        this.startActivity(composer.controller());
    }

    @Override
    // ViewDidLoad
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Initial Values
        init();
        this.identifier = this.storyboard.initialViewControllerID();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            this.identifier = bundle.getInt("identifier", this.identifier);
            int navigationController_id = bundle.getInt("navigationControllerID", UINavigationController.identifierNone());
            UINavigationController navigationController = UINavigationController.get(navigationController_id);
            setNavigationController(navigationController);
            this.navigationController.addViewControllerToStack(this);
        }
        setContentView(this.identifier);
        IBOutletParser.parse(this);
        IBActionParser.parse(this);
        viewDidLoad();
    }

    public UIView view()
    {
        return (UIView)((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
    }

    @Override
    public void onBackPressed()
    {
        this.navigationController.removeViewControllerFromStack(this);
        super.onBackPressed();
    }

    @Override
    // ViewWillAppear
    protected void onStart()
    {
        super.onStart();
        viewWillAppear(true);
    }

    @Override
    //ViewDidAppear
    protected void onResume()
    {
        super.onResume();
        viewDidAppear(true);
    }

    @Override
    //ViewWillDisappear
    protected void onPause()
    {
        super.onPause();
        viewWillDisappear(true);
    }

    @Override
    //ViewDidDisappear
    protected void onStop()
    {
        super.onStop();
        viewDidDisappear(true);
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        UIApplication application = UIApplication.sharedApplication();
        UIApplicationDelegate delegate = application.delegate;
        if (delegate != null)
            delegate.applicationDidBecomeActive(application);
    }

    //Inplemanted in child
    public void IBOutlet(){}
    public void viewDidLoad() {}
    public void viewWillAppear(Boolean animated) {}
    public void viewDidAppear(Boolean animated) {}
    public void viewWillDisappear(Boolean animated) {}
    public void viewDidDisappear(Boolean aniamted){}
}
