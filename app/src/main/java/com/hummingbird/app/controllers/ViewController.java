package com.hummingbird.app.controllers;
import com.hummingbird.cocoatouch.uikit.UIViewController;


public class ViewController extends UIViewController
{
    @Override
    public void viewDidLoad()
    {
        NSLog(__PRETTY_FUNCTION__());
        NSLog("Hello Android");
    }
}
