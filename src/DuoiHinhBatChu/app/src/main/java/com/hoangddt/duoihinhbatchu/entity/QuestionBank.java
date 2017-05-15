package com.hoangddt.duoihinhbatchu.entity;

import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class QuestionBank extends RealmObject {
    @PrimaryKey
    public String id;
    public RealmList<Question> questions;

    public QuestionBank() {
        this.id = UUID.randomUUID().toString();
        this.questions = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public RealmList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(RealmList<Question> questions) {
        this.questions = questions;
    }
}
