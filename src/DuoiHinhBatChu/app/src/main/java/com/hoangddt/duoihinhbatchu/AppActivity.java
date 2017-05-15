package com.hoangddt.duoihinhbatchu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by hoangddt on 07/05/2017.
 */
public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        // this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // remove name
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
    }
}
