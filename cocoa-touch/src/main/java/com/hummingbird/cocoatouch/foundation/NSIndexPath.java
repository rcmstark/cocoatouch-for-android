package com.hummingbird.cocoatouch.foundation;

public class NSIndexPath
{
    public int row = 0;
    public int section = 0;

    public NSIndexPath(int section, int row)
    {
        this.section = section;
        this.row = row;
    }
}
