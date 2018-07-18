package com.javafortesters.chap005testwithourownclasses.domainobject.example;

import com.javafortesters.domainobject.TestAppEnv;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAppEnvironmentTest {
    @Test
    public void canGetUrlStatically() {
        assertEquals("Returns Hard Coded URL", "http://192.123.0.3:67", TestAppEnv.getUrl());
        assertTrue("Does one string == to anther", "http://192.123.0.3:67".equals(TestAppEnv.getUrl())); // This is correct String comparison PASSED
        assertTrue("Does one string == to anther", "http://192.123.0.3:67"==TestAppEnv.getUrl());        // This is not correct String comparison but PASSED

        /*
        * public - the field can be accessed by any code that imports the TestAppEnv class
        * static - TestAppEnv does not need to be instantiated with new before usage
        * final - the variable can not change once a value has been assigned
        * String - declares the variable as a String object
        * DOMAIN, PORT - by convention constants are written in uppercase, with multiple words
        * delimited by _ underscore
        */
        assertEquals("Compare domain", "192.123.0.3", TestAppEnv.DOMAIN);
        assertEquals("Compare port", "67", TestAppEnv.PORT);

    }
}
