package com.hoangddt.duoihinhbatchu.util;

import android.content.Context;

import com.hoangddt.duoihinhbatchu.R;
import com.hoangddt.duoihinhbatchu.database.RealmHelper;
import com.hoangddt.duoihinhbatchu.entity.Question;
import com.hoangddt.duoihinhbatchu.entity.QuestionBank;

import io.realm.Realm;

public class DataUtils {
    private static DataUtils instance;
    private Context context;

    private DataUtils(Context c) {
        this.context = c;
    }

    public static DataUtils getInstance(Context c) {
        if (instance == null) {
            instance = new DataUtils(c);
        }
        return instance;
    }

    public void generateDataAtFirstRun() {
        String[] imageNames = context.getResources().getStringArray(R.array.list_image_questions);
        String[] keyAnswers = context.getResources().getStringArray(R.array.list_key_answer);

        QuestionBank questionBank = new QuestionBank();
        for (int i = 0; i < imageNames.length; i++) {
            questionBank.getQuestions().add(new Question(imageNames[i], keyAnswers[i]));
        }

        // add to database
        Realm realm = RealmHelper.getInstance(context).getRealm();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(questionBank);
        realm.commitTransaction();
    }
}
