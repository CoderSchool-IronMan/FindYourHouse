package com.vanistudio.homer.Model;

/**
 * Created by thuynh6 on 4/11/2016.
 */
public class Homer_Report {
    private Homer_User user; //who reported
    private String date; //date when report
    private String content; //report content

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
}
