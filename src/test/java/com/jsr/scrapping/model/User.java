package com.jsr.scrapping.model;

public class User {

    private String id;
    private String pin;


    public User (String id, String pin)
    {
        this.id = id;
        this.pin = pin;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getPin() {
        return pin;
    }


    public void setPin(String pin) {
        this.pin = pin;
    }
}
