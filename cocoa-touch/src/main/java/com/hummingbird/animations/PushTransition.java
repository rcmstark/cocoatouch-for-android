package com.hummingbird.animations;


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.graphics.Point;

public class PushTransition implements Transition
{
    public Animator animator(Fragment fragment, Point size, boolean enter)
    {
        Animator animator = null;
        if(enter)
        {
            animator = ObjectAnimator.ofFloat(fragment, "translationX", (float) size.x, 0);
        }
        else
        {
            animator = ObjectAnimator.ofFloat(fragment, "translationX", 0, (float) size.x);
        }
        animator.setDuration(300);
        return animator;
    }
}
