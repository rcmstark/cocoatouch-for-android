package com.hummingbird.animations;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.graphics.Point;


public class CrossDissolveTransition implements Transition
{
    public Animator animator(Fragment fragment, Point size, boolean enter)
    {
        Animator animator = null;
        if(enter)
        {
            animator = ObjectAnimator.ofFloat(fragment, "alpha", 0, 1);
        }
        else
        {
            animator = ObjectAnimator.ofFloat(fragment, "alpha", 1, 0);
        }
        animator.setDuration(500);
        return animator;
    }
}
