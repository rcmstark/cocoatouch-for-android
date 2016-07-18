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
    public void setHidden(boolean hidden)
    {
        this.setVisibility(hidden ? View.INVISIBLE : View.VISIBLE);
    }
    public void reloadData()
    {
        final UITableViewDataSource delegate = dataSource;
        final UITableView tableView = this;
        int numberOfElements = dataSource==null?0:dataSource.tableViewNumberOfRowsInSection(this,0);;
        String[] array = new String[numberOfElements];
        Context context = UIApplication.sharedApplication().context();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,0,array)
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
        Context context = UIApplication.sharedApplication().context();
        LayoutInflater inflater = LayoutInflater.from(context);
        UITableViewCell cell = (UITableViewCell)inflater.inflate(id, this, false);
        IBOutletParser.parse(cell);
        return cell;
    }

    //
    // Private Instance Methods
    //
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

    //
    // Java Trash
    //
    public UITableView(Context context) {super(context);}
    public UITableView(Context context, AttributeSet attrs){super(context, attrs);}
    public UITableView(Context context, AttributeSet attrs, int defStyleAttr){super(context, attrs, defStyleAttr);}
}