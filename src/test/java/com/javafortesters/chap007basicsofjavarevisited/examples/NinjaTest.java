package com.javafortesters.chap007basicsofjavarevisited.examples;

import com.javafortesters.chap007basicsofjavarevisited.admins.Admin;
import com.javafortesters.chap007basicsofjavarevisited.users.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NinjaTest {

    @Test
    public void adminChangeUserName() {
//        User user1 = new User();
//        user1 = null;
//        user1 = new User("Donatello");
        System.out.println(Admin.count);
        Admin admin1 = new Admin("Splinter", 10);
        System.out.println(Admin.count);
        Admin admin2 = new Admin("Shredder", 11);
        System.out.println(Admin.count);

//        System.out.println(user1.getName());
//        System.out.println(User.count);
        System.out.println(admin1.getName());
        System.out.println(admin2.getName());
        User user1 = admin1.createUser("Leonardo");
        User user2 = admin1.createUser("Raphael");
        System.out.println(user1.getName());
        admin1.changeUserName(user1, "Donatello");
        System.out.println(user1.getName());
        assertEquals("Name should be changed to Donatello", "Donatello", user1.getName());
        admin1.deleteUser(user1);
//        user1 = null;
//        user1 = user2;
        System.out.println(user1.getName());
//        assertEquals("Name should be changed to Donatello", "Donatello", user1.getName());
    }

    @Test
    public void adminCanDeleteUser() {
        Admin admin0 = new Admin("Master", 10);
        User user0 = admin0.createUser("Slave");
        user0 = admin0.deleteUser(user0);
        System.out.println(user0);
    }
}