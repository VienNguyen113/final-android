package com.hoangddt.duoihinhbatchu;

import android.content.Intent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class GuideActivity extends AppCompatActivity {

    private static final String TAG = "GuideActivity";
    Button mBack, mNext, mPrev;
    int []guide = new int[] {
            R.drawable.guide1,
            R.drawable.guide2,
            R.drawable.guide3,
            R.drawable.guide4,
            R.drawable.guide5
    };
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove name
        getSupportActionBar().hide();

        setContentView(R.layout.activity_guide);


        mBack = (Button) findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Back");
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mNext = (Button) findViewById(R.id.next);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Next");
                RelativeLayout layout =(RelativeLayout)findViewById(R.id.guide);
                if(index < guide.length - 1){
                    index++;
                    layout.setBackground(ResourcesCompat.getDrawable(getResources(), guide[index], null) );
                }
            }
        });

        mPrev = (Button) findViewById(R.id.music);
        mPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Prev");
                RelativeLayout layout =(RelativeLayout)findViewById(R.id.guide);
                if(index > 0){
                    index--;
                    layout.setBackground(ResourcesCompat.getDrawable(getResources(), guide[index], null) );
                }

            }
        });
    }
}
