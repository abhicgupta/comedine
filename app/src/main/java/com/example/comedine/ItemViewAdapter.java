package com.example.comedine;

/**
 * Created by abhinavgupta on 20/12/14.
 */
import android.app.Activity;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ItemViewAdapter extends ArrayAdapter<ItemRow> {
    private final Activity context;
    private final ArrayList<ItemRow> itemRow;

    static class ViewHolder {
        public TextView item_name;
        public TextView item_price;
    }

    public ItemViewAdapter(Activity context, int layoutResourceId, ArrayList<ItemRow> itemRow) {
        super(context, layoutResourceId, itemRow);
        this.context = context;
        this.itemRow = itemRow;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            /*
              Ab: This could have been written as inflater.inflate(R.layout.menu_item, null) too.
                  But that would not allow us to set the height of the item
             */
            rowView = inflater.inflate(R.layout.menu_item, parent, false);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.item_name = (TextView) rowView.findViewById(R.id.item_name);
            viewHolder.item_price = (TextView) rowView.findViewById(R.id.item_price);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();

        ItemRow item = itemRow.get(position);
        holder.item_name.setText(item.getName());
        holder.item_price.setText(item.getPrice());

        return rowView;
    }
}