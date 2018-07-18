package com.javafortesters.chap007basicsofjavarevisited.users;

public class User {

    public User() {
        count++;
    }

    public User(String name) {
        this();
        this.name = name;
    }

    public static int count;
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
