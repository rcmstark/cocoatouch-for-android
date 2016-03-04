package com.hummingbird.cocoatouch.coregraphics;


public class CGPoint
{
    public float x;
    public float y;

    public static CGPoint Zero()
    {
        CGPoint point = new CGPoint();
        point.x = 0;
        point.y = 0;
        return point;
    }
}
