package com.hummingbird.cocoatouch.uikit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hummingbird.cocoatouch.foundation.NSIndexPath;
import com.hummingbird.objectivec.annotation.IBOutlet;
import com.hummingbird.objectivec.parser.IBOutletParser;


public class UITableView extends ListView
{
    public UITableViewDataSource dataSource = null;
    public UITableViewDelegate delegate = null;

    public void setDataSource(UITableViewDataSource dataSource)
    {
        this.dataSource = dataSource;
        reloadData();
    }
    public void setDelegate(UITableViewDelegate delegate)
    {
        this.delegate = delegate;
        addTouchItems();
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
        UITableViewCell cell = (UITableViewCell)inflater.inflate(id, this, false);
        IBOutletParser.parse(cell);
        return cell;
    }

    private void addTouchItems()
    {
        final UITableView tableView = this;
        this.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long arg3)
            {
                view.setSelected(true);
                delegate.tableViewDidSelectRowAtIndexPath(tableView,new NSIndexPath(0,index));
            }
        });
    }

    public UITableView(Context context)
    {
        super(context);
    }
    public UITableView(Context context, AttributeSet attrs){super(context, attrs);}
    public UITableView(Context context, AttributeSet attrs, int defStyleAttr){super(context, attrs, defStyleAttr);}
}