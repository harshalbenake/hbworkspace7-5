package com.harshalbenake.calenderdates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.harshalbenake.calenderdates.adapter.CalenderListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview=(ListView)findViewById(R.id.listview);
        CalenderListAdapter arrayAdapter = new CalenderListAdapter(MainActivity.this);
        listview.setAdapter(arrayAdapter);
    }
}
