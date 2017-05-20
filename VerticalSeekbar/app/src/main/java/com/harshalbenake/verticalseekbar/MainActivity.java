package com.harshalbenake.verticalseekbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;

import com.harshalbenake.verticalseekbar.views.CustomVerticalSeekbar;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomVerticalSeekbar customVerticalSeekbar=(CustomVerticalSeekbar)findViewById(R.id.customverticalseekbar);
        customVerticalSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean userAction) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
