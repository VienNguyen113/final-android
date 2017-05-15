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
        String[] easyQuestionImages = context.getResources().getStringArray(R.array.easy_questions_images);
        String[] easyKeyAnswers = context.getResources().getStringArray(R.array.easy_questions_key_answers);
        String[] mediumQuestionImages = context.getResources().getStringArray(R.array.medium_questions_images);
        String[] mediumKeyAnswers = context.getResources().getStringArray(R.array.medium_questions_key_answers);
        String[] hardQuestionImages = context.getResources().getStringArray(R.array.hard_questions_images);
        String[] hardKeyAnswers = context.getResources().getStringArray(R.array.hard_questions_key_answers);

        QuestionBank questionBank = new QuestionBank();
        for (int i = 0; i < easyQuestionImages.length; i++) {
            questionBank.getEasyQuestions().add(new Question(easyQuestionImages[i], easyKeyAnswers[i]));
        }
        for (int i = 0; i < mediumQuestionImages.length; i++) {
            questionBank.getMediumQuestions().add(new Question(mediumQuestionImages[i], mediumKeyAnswers[i]));
        }
        for (int i = 0; i < hardQuestionImages.length; i++) {
            questionBank.getHardQuestions().add(new Question(hardQuestionImages[i], hardKeyAnswers[i]));
        }

        // add to database
        Realm realm = RealmHelper.getInstance(context).getRealm();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(questionBank);
        realm.commitTransaction();
    }
}
