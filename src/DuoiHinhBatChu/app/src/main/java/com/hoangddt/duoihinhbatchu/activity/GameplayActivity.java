package com.hoangddt.duoihinhbatchu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.hoangddt.duoihinhbatchu.R;
import com.hoangddt.duoihinhbatchu.database.RealmHelper;
import com.hoangddt.duoihinhbatchu.entity.Question;
import com.hoangddt.duoihinhbatchu.util.FileUtils;

public class GameplayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        getSupportActionBar().hide();

        // Retrieve views
        ImageView imvQuestion = (ImageView) findViewById(R.id.imvQuestion);
        final EditText edtAnswer = (EditText) findViewById(R.id.edtAnswer);
        Button btnCheck = (Button) findViewById(R.id.btnCheck);

        final String quesiontId = getIntent().getStringExtra(ListGameplayActivity.BUNDLE_KEY_QUESTION_ID);
        final Question question = RealmHelper.getInstance(this).getQuestion(quesiontId);

        imvQuestion.setImageDrawable(FileUtils.getInstance(this).getDrawable(question.getImageName()));
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answerKey = edtAnswer.getText().toString().trim().replaceAll(" ","").toLowerCase();
                if (question.getAnswerKey().equals(answerKey)) {
                    Toast.makeText(getApplicationContext(), "DUNG ROI", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "SAI ROI", Toast.LENGTH_SHORT).show();
                }

                // update question
                RealmHelper.getInstance(getApplication()).updateQuestionStatus(quesiontId, answerKey);
            }
        });

    }
}
