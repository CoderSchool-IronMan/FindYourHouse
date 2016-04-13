package com.vanistudio.homer.Model;

/**
 * Created by thuynh6 on 4/11/2016.
 */
public class Homer_Status {
    private String status; //on-sale, sold, deleted
    private String date; //date when status changes

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
