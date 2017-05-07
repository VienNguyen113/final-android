package com.hoangddt.duoihinhbatchu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button mGuide, mSetting, mInfo, mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        //Remove title bar
        // this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // remove name
        getSupportActionBar().hide();

        setContentView(R.layout.activity_app);


        // Init and setting button
        mGuide = (Button) findViewById(R.id.huong_dan);
        mGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do stuff here
                Log.d(TAG, "Huong Dan called");
            }
        });

        mInfo = (Button) findViewById(R.id.thong_tin);
        mInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Info called");
            }
        });

        mSetting = (Button) findViewById(R.id.cai_dat);
        mSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Setting called");
            }
        });

        mStart = (Button) findViewById(R.id.bat_dau);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Start called");
            }
        });
    }
}
