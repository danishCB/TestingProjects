package com.example.emp.expandablelistviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.emp.expandablelistviewexample.adapter.ExpListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ExpandableListView) findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);


        /**
         * Select Only One Item at a time
         */
        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

                int len = listAdapter.getGroupCount();

                for (int i = 0; i < len; i++) {
                    if (i != groupPosition) {
                        listView.collapseGroup(i);
                    }
                }

            }
        });
    }


    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Windows11");
        listDataHeader.add("AndroidQ");
        listDataHeader.add("MAC10");

        List<String> windows = new ArrayList<>();
        windows.add("Windows 8");
        windows.add("Windows 9");
        windows.add("Windows 10");

        List<String> android = new ArrayList<>();
        android.add("Android 4");
        android.add("Android 5");
        android.add("Android 6");

        List<String> mac = new ArrayList<>();
        mac.add("Mac 8");
        mac.add("Mac 9");
        mac.add("Mac 10");

        listHash.put(listDataHeader.get(0),windows);
        listHash.put(listDataHeader.get(1),android);
        listHash.put(listDataHeader.get(2),mac);

    }
}
