package com.hoangddt.duoihinhbatchu;

import android.content.Intent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class SettingActivity extends AppCompatActivity {

    private static final String TAG = "SettingActivity";
    Button mBack, mMusic, mEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove name
        getSupportActionBar().hide();
        setContentView(R.layout.activity_setting);

        mBack = (Button) findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Back");
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mMusic = (Button) findViewById(R.id.music);
        mMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Music");
            }
        });

        mEffect = (Button) findViewById(R.id.effect);
        mEffect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Effect");
            }
        });
    }
}
