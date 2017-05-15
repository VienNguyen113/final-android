package com.hoangddt.duoihinhbatchu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hoangddt.duoihinhbatchu.R;
import com.hoangddt.duoihinhbatchu.adapter.ListGamePlayAdapter;
import com.hoangddt.duoihinhbatchu.database.RealmHelper;
import com.hoangddt.duoihinhbatchu.entity.Question;

import java.util.List;

/*
*
* */
public class ListGameplayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_gameplay);

        // create temp data
        List<Question> questionList = RealmHelper.getInstance(this).getQuestionBank().getQuestions();

        RecyclerView rvListGameplay = (RecyclerView) findViewById(R.id.rvListGameplay);
        rvListGameplay.setAdapter(new ListGamePlayAdapter(questionList, this));
        rvListGameplay.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
