package com.javafortesters.domainentities;

public class AdminUser extends User{

    /*Overrides default superclass constructor*/
    public AdminUser() {
        this("adminuser", "adminpass");
    }

    /*Overrides parameterized superclass constructor*/
    public AdminUser(String username, String password) {
        super(username, password);
    }

    /*Overrides superclass User.getPermission() method*/

    /*
    * @Override (NOT JUnit annotation but java.lang one) tells the compiler to check that the getPermission method is really on the User object and is still the	same declaration.
    * This helps find any simple errors at compile time, rather than runtime.
    */
    @Override
    public String getPermission() {
        return "Elevated";
    }
}
