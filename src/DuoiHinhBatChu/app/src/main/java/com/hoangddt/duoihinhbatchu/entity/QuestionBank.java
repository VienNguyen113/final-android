package com.hoangddt.duoihinhbatchu.entity;

import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class QuestionBank extends RealmObject {
    @PrimaryKey
    private String id;
    private RealmList<Question> easyQuestions;
    private RealmList<Question> mediumQuestions;
    private RealmList<Question> hardQuestions;

    public QuestionBank() {
        this.id = UUID.randomUUID().toString();
        this.easyQuestions = new RealmList<>();
        this.mediumQuestions = new RealmList<>();
        this.hardQuestions = new RealmList<>();
    }

    public String getId() {
        return id;
    }

    public RealmList<Question> getEasyQuestions() {
        return easyQuestions;
    }

    public void setEasyQuestions(RealmList<Question> easyQuestions) {
        this.easyQuestions = easyQuestions;
    }

    public RealmList<Question> getMediumQuestions() {
        return mediumQuestions;
    }

    public void setMediumQuestions(RealmList<Question> mediumQuestions) {
        this.mediumQuestions = mediumQuestions;
    }

    public RealmList<Question> getHardQuestions() {
        return hardQuestions;
    }

    public void setHardQuestions(RealmList<Question> hardQuestions) {
        this.hardQuestions = hardQuestions;
    }
}