package com.javafortesters.chap015stringsrevisited;

import com.javafortesters.chap015stringsrevisited.domainentities.User;
import com.javafortesters.chap015stringsrevisited.exceptions.InvalidPasswordException;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class RegularExprationsTest {

    @Test (expected = InvalidPasswordException.class)
    public void invalidPasswordExceptionIsThrownInTheParamConstructor() throws InvalidPasswordException {
        User usr0= new User("user0", "sh0Rt");
        User usr1 = new User("user1", "NoDigit");
        User usr2 = new User("user2", "nOcap1tal");
    }
}
