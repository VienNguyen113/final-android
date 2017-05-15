package com.hoangddt.duoihinhbatchu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hoangddt.duoihinhbatchu.R;
import com.hoangddt.duoihinhbatchu.StartActivity;
import com.hoangddt.duoihinhbatchu.database.RealmHelper;
import com.hoangddt.duoihinhbatchu.util.DataUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button mGuide, mSetting, mInfo, mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init data at first run
        if (RealmHelper.getInstance(this).getQuestionBank() == null || !(RealmHelper.getInstance(this).getQuestionBank().getQuestions().size() > 0)) {
            DataUtils.getInstance(this).generateDataAtFirstRun();
        }

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
                Log.d(TAG, "Guide called");
                Intent intent = new Intent(MainActivity.this, GuideActivity.class);
                startActivity(intent);
            }
        });

        mInfo = (Button) findViewById(R.id.thong_tin);
        mInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Info called");
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        mSetting = (Button) findViewById(R.id.cai_dat);
        mSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Setting called");
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        mStart = (Button) findViewById(R.id.bat_dau);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Start called");
                Intent intent = new Intent(MainActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
    }
}
