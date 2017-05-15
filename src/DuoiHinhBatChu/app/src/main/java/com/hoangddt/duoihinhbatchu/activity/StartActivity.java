package com.hoangddt.duoihinhbatchu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hoangddt.duoihinhbatchu.R;
import com.hoangddt.duoihinhbatchu.entity.QuestionType;

public class StartActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static String QUESTION_TYPE_KEY = "QUESTION_TYPE_KEY";

    Button btnEasyQuestion, btnMediumQuestion, btnHardQuestion, btnBack;

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
        btnBack = (Button) findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do stuff here
                Log.d(TAG, "Khoi Dong called");
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnEasyQuestion = (Button) findViewById(R.id.khoidong);
        btnEasyQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do stuff here
                Log.d(TAG, "Khoi Dong called");
                Intent intent = new Intent(StartActivity.this, ListGameplayActivity.class);
                intent.putExtra(QUESTION_TYPE_KEY, QuestionType.EASY);
                startActivity(intent);
            }
        });

        btnMediumQuestion = (Button) findViewById(R.id.demnguoc);
        btnMediumQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Dem Nguoc called");
                Intent intent = new Intent(StartActivity.this, ListGameplayActivity.class);
                intent.putExtra(QUESTION_TYPE_KEY, QuestionType.MEDIUM);
                startActivity(intent);
            }
        });

        btnHardQuestion = (Button) findViewById(R.id.ghenong);
        btnHardQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stuff here
                Log.d(TAG, "Ghe Nong called");
                Intent intent = new Intent(StartActivity.this, ListGameplayActivity.class);
                intent.putExtra(QUESTION_TYPE_KEY, QuestionType.HARD);
                startActivity(intent);
            }
        });
    }
}
