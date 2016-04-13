package com.vanistudio.homer.Model;

import java.util.ArrayList;

/**
 * Created by thuynh6 on 4/11/2016.
 */
public class Homer_Estate {
    private String price;
    private float size;
    private int bedroom;
    private int bathroom;
    private String id;
    private String description;
    private Homer_Address adrress;
    private Homer_Location location;
    private Homer_User seller;
    private Homer_Status status;
    private ArrayList<Homer_Image> images;
    private ArrayList<Homer_Comment> comments;
    private ArrayList<Homer_Report> reports;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Homer_Address getAdrress() {
        return adrress;
    }

    public void setAdrress(Homer_Address adrress) {
        this.adrress = adrress;
    }

    public Homer_Location getLocation() {
        return location;
    }

    public void setLocation(Homer_Location location) {
        this.location = location;
    }

    public Homer_User getSeller() {
        return seller;
    }

    public void setSeller(Homer_User seller) {
        this.seller = seller;
    }

    public Homer_Status getStatus() {
        return status;
    }

    public void setStatus(Homer_Status status) {
        this.status = status;
    }

    public ArrayList<Homer_Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Homer_Image> images) {
        this.images = images;
    }

    public ArrayList<Homer_Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Homer_Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Homer_Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Homer_Report> reports) {
        this.reports = reports;
    }
}
