package com.javafortesters.domainentities;

public class User {

    private String username;
    private String password;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(username, user.username) &&
//                Objects.equals(password, user.password);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(username, password);
//    }

    /*Default constructor ver. 1.0*/
//    public User() {
//        username = "username";
//        password = "password";
//    }

    /*Default constructor ver. 2.0*/
    public User() {
        this("guest", "qwerty");
    }


    /*Parameterized constructor ver. 1.0  */
//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }

    /*Parameterized constructor ver. 2.0*/
    public User(String username, String password) {
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

    /*setPassword() method ver. 3.0 custom checked InvalidPasswordException*/
//        public void setPassword(String password) {
//        if (password.length() < 6) {
//            throw new IllegalArgumentException("Password must be at least 6 chars length");
//        }
//        this.password = password;
//    }


    public void setPassword(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException ("Password must be at least 6 chars length");
        }
        this.password = password;
    }

    public String getPermission() {
        return "Normal";
    }


}
