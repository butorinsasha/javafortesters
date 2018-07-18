package com.javafortesters.chap015stringsrevisited;

import com.javafortesters.chap015stringsrevisited.exceptions.InvalidPasswordException;
import com.javafortesters.chap015stringsrevisited.domainentities.User;
import org.junit.Test;

public class RegularExpressionsTest {

    @Test (expected = InvalidPasswordException.class)
    public void shortPasswordThrowsInvalidPasswordException() throws InvalidPasswordException {
        User usr0 = new User("user0", "sh0Rt");
    }

    @Test (expected = InvalidPasswordException.class)
    public void noDigitinPasswordThrowsInvalidPasswordException() throws InvalidPasswordException {
        User usr1 = new User("user1", "NoDigit");
    }

    @Test (expected = InvalidPasswordException.class)
    public void noCapitalinPasswordThrowsInvalidPasswordException() throws InvalidPasswordException {
        User usr2 = new User("user2", "n0capita");
    }

}
