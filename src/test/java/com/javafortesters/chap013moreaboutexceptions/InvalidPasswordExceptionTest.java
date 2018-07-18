package com.javafortesters.chap013moreaboutexceptions;

import com.javafortesters.chap013moreaboutexceptions.domainentities.User;
import com.javafortesters.chap013moreaboutexceptions.exceptions.InvalidPasswordException;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class InvalidPasswordExceptionTest {

    private User usr;
    private InvalidPasswordException ex;

    @Test(expected = InvalidPasswordException.class)
    public void invalidPasswordExceptionIsThrownOnSetPassword() throws InvalidPasswordException {
        usr = new User();
        usr.setPassword("short");
    }

    @Test
    public void invalidPasswordExceptionIsThrownInTheParamConstructor() {
        try {
            usr = new User("username", "short");
            fail("An InvalidPasswordException should have been thrown");
        } catch (InvalidPasswordException e) {
            ex = e;
        } finally {
            assertNotNull(ex);
        }
    }

    @Test
    public void invalidPasswordExceptionIsNotThrownInTheDefaultConstructor() {
        try {
            usr = new User();
        } catch (InvalidPasswordException e) {
            ex = e;
            fail("An InvalidPasswordException should have NOT been thrown");
        } finally {
            assertTrue(ex == null);
        }
    }

    @Test
    public void exceptionMessageContainsText() {
        try {
            usr = new User("username", "short");
            fail("An InvalidPasswordException should have been thrown");
        } catch (InvalidPasswordException e) {
            assertTrue(e.getMessage().contains("Password must be"));
        }

    }
}