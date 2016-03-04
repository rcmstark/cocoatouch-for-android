package com.hummingbird.cocoatouch.coregraphics;


public class CGSize
{
    public float width;
    public float height;

    public static CGSize Zero()
    {
        CGSize size = new CGSize();
        size.width = 0;
        size.height = 0;
        return size;
    }
}
