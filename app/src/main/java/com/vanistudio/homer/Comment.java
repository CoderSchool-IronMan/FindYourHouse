package com.vanistudio.homer;

/**
 * Created by User on 4/21/2016.
 */
public class Comment {
    private String mName;
    private String mDate;
    private String mComment;

    public Comment(String mName, String mDate, String mComment) {
        this.mName = mName;
        this.mDate = mDate;
        this.mComment = mComment;
    }

    public String getmName() {
        return mName;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmComment() {
        return mComment;
    }
}

