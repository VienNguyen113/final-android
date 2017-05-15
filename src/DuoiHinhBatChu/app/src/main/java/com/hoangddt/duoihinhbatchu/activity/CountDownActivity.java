package com.hoangddt.duoihinhbatchu.activity;


import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hoangddt.duoihinhbatchu.R;

public class CountDownActivity extends Activity {

    private TextView tvDay, tvHour, tvMinute, tvSecond, tvEvent;
    private LinearLayout linearLayout1, linearLayout2;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_coutdown);

        initUI();
        countDownStart(30);
    }

    @SuppressLint("SimpleDateFormat")
    private void initUI() {
        linearLayout1 = (LinearLayout) findViewById(R.id.ll1);
        linearLayout2 = (LinearLayout) findViewById(R.id.ll2);
        tvDay = (TextView) findViewById(R.id.txtTimerDay);
        tvHour = (TextView) findViewById(R.id.txtTimerHour);
        tvMinute = (TextView) findViewById(R.id.txtTimerMinute);
        tvSecond = (TextView) findViewById(R.id.txtTimerSecond);
        tvEvent = (TextView) findViewById(R.id.tvevent);
    }

    // //////////////COUNT DOWN START/////////////////////////
    public void countDownStart(long seconds) {
        final long miliSecconds = seconds * 1000;
        handler = new Handler();
        runnable = new Runnable() {
            long miniSecs = miliSecconds;
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    if (miniSecs > 0) {

                        long days = miniSecs / (24 * 60 * 60 * 1000);
                        miniSecs -= days * (24 * 60 * 60 * 1000);
                        long hours = miniSecs / (60 * 60 * 1000);
                        miniSecs -= hours * (60 * 60 * 1000);
                        long minutes = miniSecs / (60 * 1000);
                        miniSecs -= minutes * (60 * 1000);
                        long seconds = miniSecs / 1000;
                        tvDay.setText("" + String.format("%02d", days));
                        tvHour.setText("" + String.format("%02d", hours));
                        tvMinute.setText("" + String.format("%02d", minutes));
                        tvSecond.setText("" + String.format("%02d", seconds));
                    } else {
                        linearLayout1.setVisibility(View.VISIBLE);
                        linearLayout2.setVisibility(View.GONE);
                        tvEvent.setText("Android Event Start");
                        handler.removeCallbacks(runnable);
                        // handler.removeMessages(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }

    // //////////////COUNT DOWN END/////////////////////////
}