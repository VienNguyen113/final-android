package com.hoangddt.duoihinhbatchu.database;

import android.content.Context;

import com.hoangddt.duoihinhbatchu.entity.Question;
import com.hoangddt.duoihinhbatchu.entity.QuestionBank;

import io.realm.Realm;

public class RealmHelper {
    private static RealmHelper instance;
    private Context context;
    private Realm realm;

    private RealmHelper(Context c) {
        this.context = c;
        this.realm = Realm.getDefaultInstance();
    }

    public static RealmHelper getInstance(Context c) {
        if (instance == null) {
            instance = new RealmHelper(c);
        }
        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    public void addQuestion(Question q) {
        QuestionBank questionBank = realm.where(QuestionBank.class).findFirst();
        realm.beginTransaction();
        questionBank.getQuestions().add(q);
        realm.commitTransaction();
    }

    public Question getQuestion(String questionId) {
        return realm.where(Question.class).equalTo("id", questionId).findFirst();
    }

    public QuestionBank getQuestionBank() {
        return realm.where(QuestionBank.class).findFirst();
    }
}