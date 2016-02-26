# CocoaTouch for Android

If you are here, I will assume:

  - You are an iOS Developer
  - You like CocoaTouch
  - You need to code Android but you don't want to learn it
  - You want to replicate your iOS code to Android


### 1. Why you should use it?

In Android, Activity is the equivalent to UIViewController and it normally look like:

```sh
public class MainActivity extends AppCompatActivity 
{
    Button button; // Equivalent to iOS UIButton
    ListView tableview; //Equivalent to iOS UITableView
    
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Link XML to variables
        this.button = this.findViewById(R.id.button);
        this.listView = this.findViewById(R.id.tableview);
    }
}
```

Using this libraty, it becomes:

```sh
public class MainActivity extends UIViewController 
{
    @IBOutlet(R.id.button)    UIButton button;
    @IBOutlet(R.id.tableview) UITableView;
    
    @Override
    public void viewDidLoad()
    {
        super.viewDidLoad();
        NSLog(__PRETTY_FUNCTION__());
    }
}
```

Nice right? But it becomes better. To add a new ViewController in the stack:

```sh
public void presentTutorial()
{
    Intent intent = new Intent(this, TutorialController.class);
    this.startActivity(intent);
}
```

```sh
public void presentTutorial()
{
    int identifier = R.layout.tutorialcontroller;
    UIViewController controller = this.storyboard.instantiateViewControllerWithIdentifier(identifier);
    this.navigationController.pushViewController(controller, true);
}
```

So you code now as you do in iOS

### 2. Limitations

I created some structures such as UIViewContorller, UIButton, UITableView, UILabel... that I needed to create my app. But there are a lot of to do yet. iOS have a bunch of other elements that needs to be code. Maybe I'm here looking for contributors. 

//TODO

Use composition instead of inheritance to simulate Android structures. Inheritance is bad because:
- UIViewComtroller can be AppCompatActivity or FragmentActivity.
- UIScrollView can be ViewerPager, ScrollView, HorizontalScrollView, VerticalScrollView.
- it can not simulate all cases with inheritance.


### 3. Installation

Use Gradle:

```sh
compile 'com.hummingbird:cocoa-touch:0.0.1'
```

### 4. Configure Project

2.1 - Create a class MainStoryboard

```sh
public class MainStoryboard extends UIStoryboard
```

2.2 - Go to AndroidManifest and make it the fist launch Activity
```sh
        <activity android:name=".MainStoryboard">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity> 
```
2.3 - Overide methods in MainStoryboard, declaring the initial UIViewController id and and mapping layout ids with classes

```sh
public class MainStoryboard extends UIStoryboard
{
    @Override
    public int initialViewControllerID()
    {
        return R.layout.viewcontroller;
    }
    @Override
    public Object viewControllerForIdentifier(int identifier)
    {
        switch (identifier)
        {
            case R.layout.viewcontroller:
                return new ViewController();
            default:
                throw new Resources.NotFoundException();
        }
    }
}
```

### 5. Add new UIViewControllers to your project:

- Right click in the folder you want to add it
- Select New-> Activity -> Empty Activity
    - Activity Name: Add your ViewController's name. Example: TutorialController
    - Layout Name: This is part of your XML id. Example: If you put the name "tutorialcontroller", you id will be R.layout.tutorialcontroller
    - Click in Finish
- Make your Activity inherit UIViewController
- Go to MainStoryboard
    - Find the method viewControllerForIdentifier
    - Add the case R.laytout.YOUR_LAYOUT_NAME: return new YOUR_CLASS_NAME();
    
Using my Example, I would be:

File: TutorialController.java
```sh
public class TutorialController : UIViewController
```

File: tutorialcontroller.xml

Android Studio create it in the folder res->laytout. You can edit your canvas and work with pure XML (I miss you XCODE interfacebuilder...)

File: MainStoryboard.java
```sh
public class MainStoryboard extends UIStoryboard
{
    @Override
    public int initialViewControllerID()
    {
        return R.layout.viewcontroller;
    }
    @Override
    public Object viewControllerForIdentifier(int identifier)
    {
        switch (identifier)
        {
            case R.layout.viewcontroller:
                return new ViewController();
            case R.layout.tutorialcontroller:
                return new TutorialController();
            default:
                throw new Resources.NotFoundException();
        }
    }
}
```

I recomend you create new UIViewController this way, because AndroidStudio add this new class to AndroidManifest automatically, as you can see:

File: AndroidManifest.xml
```sh
<activity android:name=".controllers.TutorialController"/>
```

### 6. Enjoy

You can contact me here or just send me an email: rafael.castro@hummingbird.com.br

### 7. License

Apache-2.0

