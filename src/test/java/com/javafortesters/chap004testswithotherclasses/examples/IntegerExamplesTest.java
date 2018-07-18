package com.javafortesters.chap004testswithotherclasses.examples;

//import java.lang.*; // Not necessary to import java.lang package. It is pre-imported by default.
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntegerExamplesTest {
    @Test
    public void integerExploration() {
//        Integer four = new Integer(4);  // Integer is deprecated in java 1.9
//        System.out.println(four.value); // Can't get because value is 'private final int value; in java.lang.Integer
//        System.out.println("printing: four.intValue() = " + four.intValue()); // This works
        Integer four = 4;

//        Integer five = new Integer("5"); // Integer is deprecated in java 1.9
        Integer five = 5; // autoboxing (available from Java 1.5): automatically converts integer to Integer while assigning

        Integer six = 6; // autoboxing (available from Java 1.5): automatically converts integer to Integer while assigning

        assertEquals("intValue return int 4", 4, four.intValue());
        assertEquals("intValue return int 5", 5, five.intValue());
        assertEquals("autoboxing assignment for 6", 6, six.intValue());
    }

    @Test
    public void intToHexConvertingExploration() {

        Integer eleven = 11;
        Integer ten = 10;
        Integer three = 3;
        Integer twentyOne = 21;

        int iEleven = eleven;
        int iTen = ten;
        int iThree = three;
        int iTwentyOne = twentyOne;

        assertEquals("11 (dec) is b (hex)", "b", Integer.toHexString(eleven));
        assertEquals("10 (dec) is a (hex)", "a", Integer.toHexString(ten));
        assertEquals("3 (dec) is 3 (hex)", "3", Integer.toHexString(three));
        assertEquals("21 (dec) is 15 (hex)", "15", Integer.toHexString(twentyOne));

        assertEquals("11 (dec) is b (hex)", "b", Integer.toHexString(iEleven));
        assertEquals("10 (dec) is a (hex)", "a", Integer.toHexString(iTen));
        assertEquals("3 (dec) is 3 (hex)", "3", Integer.toHexString(iThree));
        assertEquals("21 (dec) is 15 (hex)", "15", Integer.toHexString(iTwentyOne));
    }

    @Test
    public void confirmMaxAndMinIntegerSizes() {
        assertEquals("Integer.MIN_VALUE == -2147483648", Integer.MIN_VALUE, -2147483648);
        assertEquals("Integer.MAX_VALUE == 2147483647", Integer.MAX_VALUE, 2147483647);
    }

    @Test
    public void confirmIntegerIsNotInteger() {
        assertEquals(4, 4);
        assertTrue(4==4);

        Integer firstFour = new Integer(4);
        Integer secondFour = new Integer(4);

        assertEquals(firstFour, secondFour);        // PASSED
//        assertTrue(firstFour == secondFour);        // FAILED Comparing links to objects, not int values of those
        assertTrue(firstFour.equals(secondFour));   // PASSED Compares int value of two not null objects
        assertTrue("Hello" == "Hello");             // PASSED !!!
        assertTrue("Hello".equals("Hello"));        // PASSED
    }

}