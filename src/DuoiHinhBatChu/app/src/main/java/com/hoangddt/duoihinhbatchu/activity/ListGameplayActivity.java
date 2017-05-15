package com.hoangddt.duoihinhbatchu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hoangddt.duoihinhbatchu.R;
import com.hoangddt.duoihinhbatchu.adapter.ListGamePlayAdapter;
import com.hoangddt.duoihinhbatchu.database.RealmHelper;
import com.hoangddt.duoihinhbatchu.entity.Question;
import com.hoangddt.duoihinhbatchu.util.AutofitRecyclerView;
import com.hoangddt.duoihinhbatchu.util.MarginDecoration;
import com.hoangddt.duoihinhbatchu.util.RecyclerItemClickListener;

import java.util.List;

/*
*
* */
public class ListGameplayActivity extends AppCompatActivity {

    public static String BUNDLE_KEY_QUESTION_ID = "QUESTION_ID";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_gameplay);

        // create temp data
        final List<Question> questionList = RealmHelper.getInstance(this).getQuestionBank().getQuestions();

        AutofitRecyclerView rvListGameplay = (AutofitRecyclerView) findViewById(R.id.rvListGameplay);
        rvListGameplay.addItemDecoration(new MarginDecoration(this));
        rvListGameplay.setHasFixedSize(true);
        rvListGameplay.setAdapter(new ListGamePlayAdapter(questionList, this));

        rvListGameplay.addOnItemTouchListener(new RecyclerItemClickListener(this, rvListGameplay, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(ListGameplayActivity.this, GameplayActivity.class);
                intent.putExtra(BUNDLE_KEY_QUESTION_ID, questionList.get(position).getId());
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
}
