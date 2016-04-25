package com.vanistudio.homer.Model;

/**
 * Created by thuynh6 on 4/11/2016.
 */
public class Homer_Comment {
    private Homer_User user; //who posted comment
    private String date; //date when comment is posted
    private String content; //comment content
    private int score; //from 1 to 5
    private String id;

    public Homer_User getUser() {
        return user;
    }

    public void setUser(Homer_User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
