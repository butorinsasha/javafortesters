package com.javafortesters.chap017datesandtimes.domainentities;

import com.javafortesters.chap017datesandtimes.exceptions.InvalidPasswordException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class User {

    private String username;
    private String password;
    private String id;

    /*Default constructor ver. 1.0*/
//    public User() {
//        username = "username";
//        password = "password";
//    }

    /*Default constructor ver. 2.0*/
    public User() throws InvalidPasswordException {
        this("guest", "qw3rtY");
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
        setStrId();
    }



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {return id;}

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
//    public void setPassword(String password) throws InvalidPasswordException {
//        if (password.length() < 6) {
//            throw new InvalidPasswordException("Password must be at least 6 chars long");
//        }
//        this.password = password;
//    }

    /*setPassword() method ver. 4.0 RegEx check*/
    public void setPassword(String password) throws InvalidPasswordException {
        if  (
                !((password.length() >= 6) &&
                password.matches(".*[0-9]+.*") &&
                password.matches(".*[A-Z]+.*"))
            )
        {
            throw new InvalidPasswordException("Password must consist of at least one capital, at least one digit and be at least 6 chars long ");
        }
        this.password = password;
    }

    public void setTimeId() {
        long longTimeId = System.currentTimeMillis();
        String strTimeId = String.valueOf(longTimeId);
        id = strTimeId;
    }

    public void setStrId() {
        long longTimeId = System.currentTimeMillis();
        System.out.println(longTimeId);
        String strId = String.valueOf(longTimeId);
        String strSet = "OIZEASbTBg";
//                       0123456789

        for (int d = 0; d <= 9; d++) {
            strId = strId.replace(String.valueOf(d), String.valueOf(strSet.charAt(d)));
        }

        id = strId;
    }


    public String getPermission() {
        return "Normal";
    }
}
