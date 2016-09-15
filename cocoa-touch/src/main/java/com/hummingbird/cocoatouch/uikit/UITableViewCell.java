package com.hummingbird.cocoatouch.uikit;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;


public class UITableViewCell extends RelativeLayout implements UIViewHierarchy
{
    @Override
    public Object viewWithTag(int tag)
    {
        return this.findViewById(tag);
    }

    public UITableViewCell(Context context)
    {
        super(context);
        init();
    }

    public UITableViewCell(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public UITableViewCell(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init()
    {
        RelativeLayout.LayoutParams layout_description = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,44);
        this.setLayoutParams(layout_description);
    }
}
