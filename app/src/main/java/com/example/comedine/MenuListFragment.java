package com.example.comedine;

import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by abhinavgupta on 15/12/14.
 */
public class MenuListFragment extends ListFragment{

    static MenuListFragment newInstance(int num) {
        MenuListFragment m = new MenuListFragment();

        Bundle args = new Bundle();
        ArrayList<ItemRow> itemRow = new ArrayList<ItemRow>();
        itemRow.add(new ItemRow("EX1" + num, "10" + num));
        itemRow.add(new ItemRow("EX2" + num, "20" + num));
        args.putParcelableArrayList("item", itemRow);
        m.setArguments(args);

        return m;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle b = getArguments();
        ArrayList<ItemRow> itemRow = b.getParcelableArrayList("item");
        /*ArrayList<ItemRow> itemRow = new ArrayList<ItemRow>();

        itemRow.add(new ItemRow("EX1", "10"));
        itemRow.add(new ItemRow("EX2", "20"));*/
        /*String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "X1", "X2", "X3", "X4","X5","X6","X7","X8","X9","X10","X11","X12","X13"
                ,"X14","X15","X16"};
        String [] prices = new String[] {
          "1","2","3",
                "4","5","6","7","8",
                "9","10", "11","12","13","14","15","16","17","18","19","20","21","22","23",
                "24","25","26"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),itemRow);
        */
        ItemViewAdapter adapter = new ItemViewAdapter(getActivity(), R.layout.menu_item, itemRow);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // do something with the data
    }

}
