package com.javafortesters.chap009arraysandforloopiteration;

import com.javafortesters.domainentities.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ForLoopTest {


//    User[] users = new User[] {new User(), new User(), new User()};

    /*Initialize array of String workdays*/

    private User[] users = new User[100];
    private String[] workdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    @Before
    public void initializeArrayOfUsers() {
        for (int i=0; i<users.length; i++) {
            users[i] = new User( "user" + i, "password" + i);
        }
    }

    @Test
    public void forEachLoop() {
        String days = "";

        for (String workday : workdays) {
            days = days + "|" + workday;
        }

        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday", days);
    }

    @Test
    public void forILoop() {
        String days = "";

        for (int i=0; i<5; i++) {
            days = days + "|" + workdays[i];
        }

        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday", days);
    }


    @Test
    public void forLoopUsingIndexFixedCondition() {
        String days = "";

        int i=0;
        for (; ;) {
            days = days + "|" + i + "-" + workdays[i];
            i++;
            if (i>=5) break;
        }

        assertEquals("|0-Monday|1-Tuesday|2-Wednesday|3-Thursday|4-Friday", days);
    }

    @Test
    public void checkArrayOfUsersIsCreated() {
        assertNotNull("There is an `users` array variable and it is not Null", users);
        assertEquals("Array length is claimed to be 100", 100, users.length);

        /*Check every element of `users` array is not Null*/
        for (int i=0; i<100; i++) {
            assertNotNull(users[i]);
        }
    }

    @Test
    public void iterateOverArrayOfUsersForI() {
//        User[] users = new User[3];
        for (int i=0; i<users.length; i++) {

//            users[i] = new User( "user" + Integer.toString(i), "password" + Integer.toString(i));
            System.out.println(users[i].getUsername() + " " + users[i].getPassword());
            assertEquals("user"+i, users[i].getUsername());
            assertEquals("password"+i, users[i].getPassword());
        }
    }

    @Test
    public void iterateOverArrayOfUserForIn() {
        for (User usr : users) {
            System.out.println(usr.getUsername());
        }
    }
}
