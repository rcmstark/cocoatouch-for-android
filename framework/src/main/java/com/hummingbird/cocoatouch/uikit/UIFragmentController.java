package com.hummingbird.cocoatouch.uikit;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hummingbird.objectivec.parser.IBActionParser;
import com.hummingbird.objectivec.parser.IBOutletParser;

public class UIFragmentController extends Fragment implements UIViewHierarchy
{
    int storyboard_id;
    ViewGroup view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        this.view = (ViewGroup)inflater.inflate(this.storyboard_id, container, false);
        IBOutletParser.parse(this);
        IBActionParser.parse(this);
        viewDidLoad();
        return this.view;
    }

    public void setStoryboardID(int storyboard_id)
    {
        this.storyboard_id = storyboard_id;
    }
    public Object viewWithTag(int id)
    {
        return this.view.findViewById(id);
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
        return getActivity().getApplicationContext();
    }

    @Override
    // ViewWillAppear
    public void onStart()
    {
        super.onStart();
        viewWillAppear(true);
    }

    @Override
    //ViewDidAppear
    public void onResume()
    {
        super.onResume();
        viewDidAppear(true);
    }

    @Override
    //ViewWillDisappear
    public void onPause()
    {
        super.onPause();
        viewWillDisappear(true);
    }

    @Override
    //ViewDidDisappear
    public void onStop()
    {
        super.onStop();
        viewDidDisappear(true);
    }

    //Inplemanted in child
    public void viewDidLoad() {}
    public void viewWillAppear(Boolean animated) {}
    public void viewDidAppear(Boolean animated) {}
    public void viewWillDisappear(Boolean animated) {}
    public void viewDidDisappear(Boolean aniamted){}
}