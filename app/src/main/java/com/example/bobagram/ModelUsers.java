package com.example.bobagram;

public class ModelUsers {
    String name;
    float total_amount;

    public ModelUsers() {
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getTotAmt() {
        return total_amount;
    }

    public void setTotAmt(float total_amount) {
        this.total_amount = total_amount;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ModelUsers(String name, String email, String image, String uid, float total_amount) {
        this.name = name;
        this.email = email;
        this.image = image;
        this.uid = uid;
        this.total_amount = total_amount;
    }

    String email;

    String image;

    String uid;
}
