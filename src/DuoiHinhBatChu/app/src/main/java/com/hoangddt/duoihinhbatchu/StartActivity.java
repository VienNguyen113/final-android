package com.hoangddt.duoihinhbatchu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hoangddt.duoihinhbatchu.activity.ListGameplayActivity;
import com.hoangddt.duoihinhbatchu.activity.MainActivity;

public class StartActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button mKhoiDong, mDemNguoc, mGheNong, mBack;

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

        setContentView(R.layout.activity_start);


        // Init and setting button
        mBack = (Button) findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do stuff here
                Log.d(TAG, "Khoi Dong called");
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mKhoiDong = (Button) findViewById(R.id.khoidong);
        mKhoiDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do stuff here
                Log.d(TAG, "Khoi Dong called");
                Intent intent = new Intent(StartActivity.this, ListGameplayActivity.class);
                startActivity(intent);
            }
        });

        mDemNguoc = (Button) findViewById(R.id.demnguoc);
        mDemNguoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Dem Nguoc called");
//                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
//                startActivity(intent);
            }
        });

        mGheNong = (Button) findViewById(R.id.ghenong);
        mGheNong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Ghe Nong called");
//                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
//                startActivity(intent);
            }
        });
    }
}
