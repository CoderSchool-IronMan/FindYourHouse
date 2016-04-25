package com.vanistudio.homer.Model;

/**
 * Created by thuynh6 on 4/11/2016.
 */
public class Homer_Rating {
    private String username; //who gives rating
    private int score; //from 1 to 5
    private String date;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
