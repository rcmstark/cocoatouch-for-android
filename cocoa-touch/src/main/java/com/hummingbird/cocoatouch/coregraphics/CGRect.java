package com.hummingbird.cocoatouch.coregraphics;


public class CGRect
{
    public CGPoint origin;
    public CGSize size;

    public static CGRect Zero()
    {
        CGRect frame = new CGRect();
        frame.origin = CGPoint.Zero();
        frame.size = CGSize.Zero();
        return frame;
    }
}
