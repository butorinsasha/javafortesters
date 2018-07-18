package com.javafortesters.chap010introducingcollections.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SetTest {

    @Test
    public void testUserSet() {
        Set<User> usersSet = new HashSet<>();

        /*Create a User*/
        User user0 = new User("username0", "password0");
        System.out.println(user0);
        assertNotNull(user0);

        /*Add the User to the Set*/
        usersSet.add(user0);
        assertEquals(1, usersSet.size());
        assertTrue(usersSet.contains(user0));

        /*A Set: Does not allow storing duplicates, so adding a duplicate is ignored.*/
        /*Add the User to the Set again*/
        usersSet.add(user0);
        assertEquals(1, usersSet.size());
        assertTrue(usersSet.contains(user0));


        /*
        * For Set: ordering is not guaranteed.
        * So if you iterate through a set it may not bring back the elements in the order you expect.
        */
        User user1 = new User("username1", "password1");
        User user2 = new User("username2", "password2");
        usersSet.add(user1);
        usersSet.add(user2);

        User[] expectedUsersArray = {user0, user1, user2};
        int i=0;
        for (User usr : usersSet) {
            System.out.println(i + " " + usr.getUsername());
            i++;
        }

        i=0;
        for (User usr : usersSet) {
            assertTrue(usersSet.contains(expectedUsersArray[i]));
            i++;
        }

    }
}
