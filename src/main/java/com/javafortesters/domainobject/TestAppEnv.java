package com.javafortesters.domainobject;

public class TestAppEnv {
    public static final String DOMAIN = "192.123.0.3";
    public static final String PORT = "67";

    /*
    * public this method is accessible to any class that imports TestAppEnv
    * static this method can be used and called, without instantiating a TestAppEnv object
    * String this method returns a string, to the calling code
    */
    public static String getUrl() {
//  public static int getUrl() {
        return "http://" + DOMAIN + ":" + PORT;
//      return null;

    }
}
