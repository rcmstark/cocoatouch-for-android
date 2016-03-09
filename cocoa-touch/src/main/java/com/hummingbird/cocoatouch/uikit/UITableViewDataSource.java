package com.hummingbird.cocoatouch.uikit;
import android.content.Context;

import com.hummingbird.cocoatouch.foundation.NSIndexPath;

public interface  UITableViewDataSource
{
    public int tableViewNumberOfRowsInSection(UITableView tableView, int section);
    public UITableViewCell tableViewCellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath);
}
