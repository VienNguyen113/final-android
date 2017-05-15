package com.hoangddt.duoihinhbatchu.entity;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Question extends RealmObject {
    @PrimaryKey
    public String id;
    public String imageName;
    public String answerKey;
    public boolean isPlayed = false;
    public String userAnswerKey = null;

    public Question() {
        this.id = UUID.randomUUID().toString();
    }

    public Question(String imageName, String answerKey) {
        this.id = UUID.randomUUID().toString();
        this.imageName = imageName;
        this.answerKey = answerKey;
    }

    public String getId() {
        return id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(String answerKey) {
        this.answerKey = answerKey;
    }

    public boolean isPlayed() {
        return isPlayed;
    }

    public void setPlayed(boolean played) {
        isPlayed = played;
    }

    public String getUserAnswerKey() {
        return userAnswerKey;
    }

    public void setUserAnswerKey(String userAnswerKey) {
        this.userAnswerKey = userAnswerKey;
    }
}
