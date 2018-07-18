package com.javafortesters.chap006domainentities;

import com.javafortesters.chap013moreaboutexceptions.exceptions.InvalidPasswordException;
import org.junit.Test;
import com.javafortesters.domainentities.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void canConstructANewUser() throws InvalidPasswordException {
        User user0 = new User();
    }

    @Test
    public void userHasDefaultUserNameAndPassword1() throws InvalidPasswordException {
        User user1 = new User();

        assertEquals("default username expected",
                "guest",
                user1.getUsername() );

        assertEquals("default password expected",
                "qwerty",
                user1.getPassword() );

    }

//    @Test
//    public void userHasDefaultUserNameAndPassword2() {
//        User user2 = new User();
//        user2.username = "bob";
//        user2.password = "qwerty";
//
//        assertEquals("default username expected", "bob", user2.username );
//        assertEquals("default password expected", "qwerty", user2.password );
//    }

    @Test
    public void CanConstructWithUsernameAndPassword() throws InvalidPasswordException {
        User user3 = new User("admin", "pA55w0rD");

        System.out.println(user3.getUsername() + "\n" + user3.getPassword());

        assertEquals("given username expected", "admin", "admin" );
        assertTrue("given username expected", "admin".equals(user3.getUsername()) );

        assertEquals("given password expected", "pA55w0rD", "pA55w0rD" );
        assertTrue("given password expected", "pA55w0rD".equals(user3.getPassword()) );
    }

    @Test
    public void canSetPasswordAfterConstructed() throws InvalidPasswordException {
        User user4 = new User();

        user4.setPassword("PaZZwor6");

        assertEquals("setter password expected", "PaZZwor6", user4.getPassword() );
    }
}
