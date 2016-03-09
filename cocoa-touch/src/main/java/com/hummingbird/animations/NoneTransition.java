package com.hummingbird.animations;
import android.animation.Animator;
import android.app.Fragment;
import android.graphics.Point;


public class NoneTransition implements Transition
{
    public Animator animator(Fragment fragment, Point size, boolean enter)
    {
        return null;
    }
}
