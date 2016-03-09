package com.hummingbird.app.features.tableview;
import com.hummingbird.app.R;
import com.hummingbird.cocoatouch.foundation.NSIndexPath;
import com.hummingbird.cocoatouch.foundation.NSMutableArray;
import com.hummingbird.cocoatouch.uikit.UITableView;
import com.hummingbird.cocoatouch.uikit.UITableViewCell;
import com.hummingbird.cocoatouch.uikit.UITableViewDataSource;
import com.hummingbird.cocoatouch.uikit.UIViewController;
import com.hummingbird.objectivec.annotation.IBOutlet;


public class TableController extends UIViewController implements UITableViewDataSource
{

    @IBOutlet(R.id.tableview) UITableView tableView;
    private NSMutableArray<String> tableData;


    @Override public void viewDidLoad()
    {
        super.viewDidLoad();
        NSLog(__PRETTY_FUNCTION__());
        this.tableData = new NSMutableArray<String>();
        this.tableData.addObject("Daenerys Targaryen");
        this.tableData.addObject("Jon Snow");
        this.tableData.addObject("Arya Stark");
        this.tableData.addObject("Tyrion Lannister");
        this.tableData.addObject("Cersei Lannister");
        this.tableView.setDataSource(this);
    }
    @Override public void viewDidAppear(Boolean animated)
    {
        super.viewDidAppear(animated);
        NSLog(__PRETTY_FUNCTION__());
    }

    //
    // UITableViewDataSource
    //
    @Override public int tableViewNumberOfRowsInSection(UITableView tableView, int section)
    {
        return this.tableData.count();
    }
    @Override public UITableViewCell tableViewCellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath)
    {
        CustomCell cell = (CustomCell)tableView.dequeueReusableCellWithIdentifierForIndexPath(R.layout.tablecustomcell, indexPath);
        cell.setName(this.tableData.objectAtIndex(indexPath.row));
        return cell;
    }
}
