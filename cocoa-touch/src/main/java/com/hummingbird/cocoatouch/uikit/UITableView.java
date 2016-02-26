package com.hummingbird.cocoatouch.uikit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hummingbird.cocoatouch.foundation.NSIndexPath;


public class UITableView extends ListView
{
    public UITableViewDataSource dataSource = null;

    public void setDataSource(UITableViewDataSource dataSource)
    {
        this.dataSource = dataSource;
        reloadData();
    }
    public void reloadData()
    {
        final UITableViewDataSource delegate = dataSource;
        final UITableView tableView = this;

        int numberOfElements;
        try
        {
            numberOfElements = dataSource.tableViewNumberOfRowsInSection(this,0);
        }
        catch (NullPointerException name)
        {
            return;
        }

        String[] array = new String[numberOfElements];
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(dataSource.context(),0,array)
        {
            @Override
            public View getView(int index, View convertView, ViewGroup parent)
            {
                return delegate.tableViewCellForRowAtIndexPath(tableView, new NSIndexPath(0,index));
            }
        };
        this.setAdapter(adapter);
    }
    public UITableViewCell dequeueReusableCellWithIdentifierForIndexPath(int id, NSIndexPath indexPath)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        return (UITableViewCell)inflater.inflate(id, this, false);
    }

    public UITableView(Context context)
    {
        super(context);
    }
    public UITableView(Context context, AttributeSet attrs){super(context, attrs);}
    public UITableView(Context context, AttributeSet attrs, int defStyleAttr){super(context, attrs, defStyleAttr);}
}