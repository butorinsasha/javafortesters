package com.javafortesters.chap010introducingcollections.exercises;

import com.javafortesters.domainentities.User;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapOfUsersTest {

    @Test
    public void testUserMap() {
        Map<String, User> usersMap = new HashMap<>();
        assertNotNull(usersMap);

        User user0 = new User("username0", "password0");
        User user1 = new User("username1", "password1");
        assertNotNull(user0);
        assertNotNull(user1);

        usersMap.put("key", user0);
        usersMap.put("key", user1);
        assertEquals(1, usersMap.size());
        assertTrue(usersMap.containsValue(user1));
        assertFalse(usersMap.containsValue(user0));
    }

}
