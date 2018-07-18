package com.javafortesters.chap007basicsofjavarevisited.admins;

import com.javafortesters.chap007basicsofjavarevisited.users.User;

public class Admin {

    public Admin (String name, int accessLevel) {
        this.name = name;
        this.accessLevel = accessLevel;
        count++;
    }

    public static int count;
    private String name;
    private int accessLevel;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    protected int getAccessLevel() {
        return accessLevel;
    }

    public User createUser(String name) {
        return new User(name);
    }

    public User deleteUser(User user) {
       // System.out.println(user.getName() + " is about to be nulled")
        user=null;
        return user; // You cant delete an object this way. "user" is just a copy of reference variable being transmitted trough argument to method parameter on method call
       // System.out.println("You cant delete an object like this. \"user\" is just a copy af reference variable being transmitted method parameter on method call");
    }

    public void changeUserName(User user, String newName) {
        user.setName(newName);
    }
}
