package com.hoangddt.duoihinhbatchu;

import android.content.Intent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class HuongDanActivity extends AppCompatActivity {

    private static final String TAG = "HuongDanActivity";
    Button mBack, mNext, mPrev;
    int []huongdan = new int[] {
            R.drawable.hd1,
            R.drawable.hd2,
            R.drawable.hd3,
            R.drawable.hd4,
            R.drawable.hd5
    };
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove name
        getSupportActionBar().hide();

        setContentView(R.layout.activity_huong_dan);


        mBack = (Button) findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Back");
                Intent intent = new Intent(HuongDanActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mNext = (Button) findViewById(R.id.next);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Next");
                RelativeLayout layout =(RelativeLayout)findViewById(R.id.huongdan);
                if(index < huongdan.length - 1){
                    index++;
                    layout.setBackground(ResourcesCompat.getDrawable(getResources(), huongdan[index], null) );
                }
            }
        });

        mPrev = (Button) findViewById(R.id.prev);
        mPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Prev");
                RelativeLayout layout =(RelativeLayout)findViewById(R.id.huongdan);
                if(index > 0){
                    index--;
                    layout.setBackground(ResourcesCompat.getDrawable(getResources(), huongdan[index], null) );
                }

            }
        });
    }
}
