package com.harshalbenake.horizontallistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.harshalbenake.horizontallistview.views.CustomHorizontalListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomHorizontalListView customhorizontallistview=(CustomHorizontalListView)findViewById(R.id.customhorizontallistview);
        String itemArray[]={"1","2","3","4","5","6","7","8","9","10"};
        customhorizontallistview.setListItems(itemArray);
    }
}
