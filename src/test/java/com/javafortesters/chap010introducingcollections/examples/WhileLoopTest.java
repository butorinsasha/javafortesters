package com.javafortesters.chap010introducingcollections.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WhileLoopTest {

    String[] someDays = {"Tuesday", "Thursday", "Wednesday", "Monday", "Saturday", "Sunday", "Friday"};

    List<String> days = Arrays.asList(someDays);

    @Test
    public void forEachLoopExample() {
        int forEachCount=0;
        for (String day : days) {
            if (day.equals("Monday")) {
                break;
            }
            forEachCount++;
        }

        assertEquals("Monday is at position 3", 3, forEachCount);
    }

    @Test
    public void forLoopExample() {
        int forCount;

        for (forCount=0; forCount<days.size(); forCount++) {
            if (days.get(forCount).equals("Monday")) {
                break;
            }
        }
        assertEquals("Monday is at position 3", 3, forCount);
    }

    @Test
    public void whileLoopExample() {
        int whileCount = 0;
        while (!days.get(whileCount).equals("Monday")) {
            whileCount++;
        }
        assertEquals("Monday is at position 3", 3, whileCount);
    }

    @Test
    public void doWhileLoopExample() {
        int doWhileCount = -1;
        do {
            doWhileCount++;
        } while (!days.get(doWhileCount).equals("Monday"));
        assertEquals("Monday is at position 3", 3, doWhileCount);
    }

}
