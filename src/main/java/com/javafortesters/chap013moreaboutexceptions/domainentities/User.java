package com.javafortesters.chap013moreaboutexceptions.domainentities;

import com.javafortesters.chap013moreaboutexceptions.exceptions.InvalidPasswordException;

public class User {

    private String username;
    private String password;

    /*Default constructor ver. 1.0*/
//    public User() {
//        username = "username";
//        password = "password";
//    }

    /*Default constructor ver. 2.0*/
    public User() throws InvalidPasswordException {
        this("guest", "qwerty");
    }




    /*Parameterized constructor ver. 1.0  */
//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }

    /*Parameterized constructor ver. 2.0*/
//    public User(String username, String password) {
//        this.username = username;
//        setPassword(password);
//    }

    /*Parameterized constructor ver. 3.0*/
    public User(String username, String password) throws InvalidPasswordException {
        this.username = username;
        setPassword(password);
    }



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    /*setPassword() method ver. 1.0*/
//    public void setPassword(String password) {
//        this.password = password;
//    }

    /*setPassword() method ver. 2.0 unchecked IllegalArgumentException*/
//    public void setPassword(String password) {
//        if (password.length() < 6) {
//            throw new IllegalArgumentException("Password must be at least 6 chars length");
//        }
//        this.password = password;
//    }

    /*setPassword() method ver. 3.0 custom checked InvalidPasswordException*/
    public void setPassword(String password) throws InvalidPasswordException {
        if (password.length() < 6) {
            throw new InvalidPasswordException("Password must be at least 6 chars long");
        }
        this.password = password;
    }

    public String getPermission() {
        return "Normal";
    }
}
