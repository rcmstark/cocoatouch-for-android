package com.hummingbird.app.features.tableview;
import android.content.Context;
import android.util.AttributeSet;
import com.hummingbird.app.R;
import com.hummingbird.cocoatouch.uikit.UILabel;
import com.hummingbird.cocoatouch.uikit.UITableViewCell;
import com.hummingbird.objectivec.annotation.IBOutlet;


public class CustomCell extends UITableViewCell
{
    @IBOutlet(R.id.customcell_name) UILabel nameLabel;

    public void setName(String name)
    {
        this.nameLabel.setText(name);
    }

    //
    // Trash
    //
    public CustomCell(Context context) {super(context);}
    public CustomCell(Context context, AttributeSet attrs) {super(context, attrs);}
    public CustomCell(Context context, AttributeSet attrs, int defStyleAttr) {super(context, attrs, defStyleAttr);}
}
