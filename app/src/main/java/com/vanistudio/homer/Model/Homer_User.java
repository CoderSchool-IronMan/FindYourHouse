package com.vanistudio.homer.Model;

import java.util.ArrayList;

/**
 * Created by thuynh6 on 4/11/2016.
 */
public class Homer_User {
    private String name;
    private String email;
    private String phone;
    private String status; //active or disable
    //private ArrayList<Homer_Rating> ratings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
