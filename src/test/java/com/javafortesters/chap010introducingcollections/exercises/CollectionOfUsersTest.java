package com.javafortesters.chap010introducingcollections.exercises;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CollectionOfUsersTest {

    private Collection<User> usersCollection0 = new ArrayList<User>();
    private Collection<User> usersCollection1 = new ArrayList<>();

    private User user00 = new User("username00", "password00");
    private User user01 = new User("username01", "password01");

    private User user10 = new User("username10", "password10");
    private User user11 = new User("username11", "password11");


//    @Before
    public void addUserToCollectionOfUsers(Collection col, User usr) {
        col.add(usr);
    }

    @Test
    public void collectionsOfUsersCreated() {

        assertTrue(usersCollection0.size() == 0);
        assertTrue(usersCollection0.isEmpty() == true);

        assertTrue(usersCollection1.size() == 0);
        assertTrue(usersCollection1.isEmpty() == true);

    }

    @Test
    public void firstCollectionsOfUsersIsFilledWithUsers() {
        addUserToCollectionOfUsers(usersCollection0, user00);
        addUserToCollectionOfUsers(usersCollection0, user01);

        assertNotNull(usersCollection0);

        assertEquals(2, usersCollection0.size());
        assertTrue(usersCollection0.size() == 2);

        assertTrue(usersCollection0.isEmpty() == false);

        assertTrue(usersCollection0.contains(user00));
        assertTrue(usersCollection0.contains(user01));
    }

    @Test
    public void secondCollectionsOfUsersIsFilledWithUsers() {
        addUserToCollectionOfUsers(usersCollection1, user10);
        addUserToCollectionOfUsers(usersCollection1, user11);

        assertNotNull(usersCollection1);

        assertEquals(2, usersCollection1.size());
        assertTrue(usersCollection1.size() == 2);

        assertTrue(usersCollection1.isEmpty() == false);

        assertTrue(usersCollection1.contains(user10));
        assertTrue(usersCollection1.contains(user11));
    }

    @Test
    public void secondCollectionAddedToFirstCollection() {
        addUserToCollectionOfUsers(usersCollection0, user00);
        addUserToCollectionOfUsers(usersCollection0, user01);
        addUserToCollectionOfUsers(usersCollection1, user10);
        addUserToCollectionOfUsers(usersCollection1, user11);

        usersCollection0.addAll(usersCollection1);

        System.out.println("usersCollection0");
        for (User usr : usersCollection0) {
            System.out.println(usr.getUsername() + " " + usr.getPassword());
        }

        System.out.print("\n");

        System.out.println("usersCollection1");
        for (User usr : usersCollection1) {
            System.out.println(usr.getUsername() + " " + usr.getPassword());
        }

        assertTrue(usersCollection0.containsAll(usersCollection1));
    }

    @Test
    public void removeAllUsersFromSecondCollection() {
        secondCollectionAddedToFirstCollection(); // DO NOT DO LIKE THIS. Tests must be independent from each other
        usersCollection1.removeAll(usersCollection1);
        assertTrue(usersCollection1.isEmpty());
    }

    @Test
    public void clearFirstCollection() {
        secondCollectionAddedToFirstCollection();
        usersCollection1.removeAll(usersCollection1);
        usersCollection0.clear();
        assertTrue(usersCollection1.isEmpty());
        assertTrue(usersCollection0.isEmpty());

    }
}
