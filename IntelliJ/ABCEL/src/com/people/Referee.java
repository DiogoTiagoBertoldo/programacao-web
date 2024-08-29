package com.people;

public class Referee extends Person {

    private String password;

    public Referee(String name, String email, String password) {
        super(name, email);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
