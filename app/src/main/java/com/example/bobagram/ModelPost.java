package com.example.bobagram;

public class ModelPost {
    public ModelPost() {
    }

    String ptime, pcomments;
    String title;
    String description;
    String drink;
    String price;
    String rating;
    String udp;
    String uemail;
    String uid;
    String uimage;

    String uname, plike;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() { return rating; }

    public void setRating(String rating) { this.rating = rating; }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public String getDrink() { return drink; }

    public void setDrink(String drink) { this.drink = drink; }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUdp() {
        return udp;
    }

    public void setUdp(String udp) {
        this.udp = udp;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUimage() {
        return uimage;
    }

    public void setUimage(String uimage) {
        this.uimage = uimage;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPlike() {
        return plike;
    }

    public void setPlike(String plike) {
        this.plike = plike;
    }

    String pid;

    public String getPcomments() {
        return pcomments;
    }

    public void setPcomments(String pcomments) {
        this.pcomments = pcomments;
    }

    public ModelPost(String description, String pid, String ptime, String pcomments, String title, String udp, String uemail, String uid, String uimage, String uname, String plike, String rating, String price, String drink) {
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.drink = drink;
        this.pid = pid;
        this.ptime = ptime;
        this.pcomments = pcomments;
        this.title = title;
        this.udp = udp;
        this.uemail = uemail;
        this.uid = uid;
        this.uimage = uimage;
        this.uname = uname;
        this.plike = plike;
    }
}