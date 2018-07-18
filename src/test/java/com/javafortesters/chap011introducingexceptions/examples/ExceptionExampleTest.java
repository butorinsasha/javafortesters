package com.javafortesters.chap011introducingexceptions.examples;

import com.javafortesters.chap013moreaboutexceptions.exceptions.InvalidPasswordException;
import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExceptionExampleTest {

    @Test (expected = NullPointerException.class)
    public void throwNullPointException() {
        Integer age = null;
//        Integer age = 18;
        String ageAsString = age.toString();
        String yourAge = "You are " + ageAsString + " years old";
        assertEquals("You are 18 years old", yourAge);
    }

    @Test
    public void catchNullPointerException() {
        Integer age = null;
        String ageAsString;

        try {
            ageAsString = age.toString();
        } catch(NullPointerException e) {
            age = 18;
            ageAsString = age.toString();
        }
        String yourAge = "You are " + ageAsString + " years old";
        assertEquals("You are 18 years old", yourAge);
    }

    @Test
    public void catchMoreThanOneException() {
        Integer age = 18;
        String ageAsString;

        try {
            ageAsString = age.toString();
        } catch(NullPointerException e) {
            age = 18;
            ageAsString = age.toString();
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument: " + e.getMessage());
        }
    }

    @Test(expected = NullPointerException.class) // If a NullPointerException is thrown then the method will pass.
    public void nullPointerExceptionExpected() {
        Integer age = null;
        age.toString();
    }

    @Test
    public void passwordMustBeGreaterThan5Chars()  {
        User user0 = new User("username0", "qwerty");
    }

    @Test(expected = IllegalArgumentException.class)
    public void exampleTryCatchFinally()  {
        String pswd = null;

        try {
            System.out.println("1. try {}: Generate NullPointerException");
            System.out.println(pswd.length());
        } catch(NullPointerException e) {
            System.out.println("2. catch {}: Handle NullPointerException and generate unhandled IllegalArgumentException");
            pswd = "qwe";
            User usr0 = new User("username0", pswd);
        } finally {
            System.out.println("3. finally {}: Run code in finally section");
        }
    }

    @Test
    public void exampleTryCatchFinally1() {
        String pswd = null;

        try {
            System.out.println("1. try {}: Generate NullPointerException");
            System.out.println(pswd.length());
        } catch (NullPointerException e1) {
            try {
                System.out.println("2. catch {}: Handle NullPointerException and generate inner handled InvalidPasswordException");
                pswd = "qwe";
                User usr0 = new User("username0", pswd);
            } catch (IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        } finally {
            System.out.println("3. finally {}: Run code in finally section");
            System.out.println(pswd.length());
        }
    }
}
