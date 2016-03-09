package com.hummingbird.animations;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.graphics.Point;


public class CoverVerticalTransition implements Transition
{
    public Animator animator(Fragment fragment, Point size, boolean enter)
    {
        Animator animator = null;
        if(enter)
        {
            animator = ObjectAnimator.ofFloat(fragment, "translationY", (float) size.y, 0);
        }
        else
        {
            animator = ObjectAnimator.ofFloat(fragment, "translationY", 0, (float) size.y);
        }
        animator.setDuration(500);
        return animator;
    }
}
