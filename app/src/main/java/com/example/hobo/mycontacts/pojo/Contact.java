package com.example.hobo.mycontacts.pojo;

/**
 * Created by Caleb on 7/4/2017.
 */

public class Contact {

    private int id;
    private int photo;
    private String name;
    private String phone;
    private String email;
    private int likes;

    public Contact() {
    }

    public Contact(int photo, String name, String phone, String email, int likes) {
        this.photo = photo;
        this.name  = name;
        this.phone = phone;
        this.email = email;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
