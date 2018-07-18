package com.javafortesters.chap012introducinginheritance.exercises;

import com.javafortesters.domainentities.EnvUser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnvironmentUserTest {

    private EnvUser enuser = new EnvUser();

    @Test
    public void enviromentUserHasUserMethods() {
        assertEquals("guest", enuser.getUsername());
        assertEquals("qwerty", enuser.getPassword());
    }

    @Test
    public void enviromentUserHasGetUrlMethod() {
        assertEquals("http://192.123.0.3:67", enuser.getUrl());
    }

}
