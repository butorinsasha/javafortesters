package com.javafortesters.chap009arraysandforloopiteration;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArraysTest {

    @Test
    public void simpleArrayExample() {
        String[] numbers0123 = {"zero", "one", "two", "three"};
        for (String numberText : numbers0123) {
            System.out.println(numberText);
        }

        assertEquals("zero", numbers0123[0]);
        assertEquals("three", numbers0123[3]);
    }

    @Test
    public void arrayDeclarationExplored() {
        /*Decalre an array of fixed values*/
        int[] integers = new int[10];
        int []moreInts = new int[10];
        int evenMore[] = new int[10];

        boolean[] booleans = new boolean[10];

        double[] doubles = new double[10];

        char[] chars = new char[10];


//        int x;
//        System.out.println(x);

        for (int i=0; i<chars.length; i++) {
            System.out.println(Character.toString(chars[i]));
        }

        /*Initialize created array like this wont work*/
        // integers = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
         integers = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};



        /*Declare and create an Array with Actual Values*/
        int[] ints1to10 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        /*Declare an empty array = zero-length array*/
        int[] zeroLength = {};
        int[] moreZeroLength = new int[0];

       // ints1to10 = new int[10];
//        for (int i = 0; i < ints1to10.length; i++) {
//            ints1to10[i] = 10-i;
//            System.out.println(ints1to10[i]);
//        }

        /*Declare an Array for later initialization*/
        int[] uninitializedArray;
        uninitializedArray = new int[10];
        uninitializedArray = new int[] {100, 200, 300};
    }


    @Test
    public void createArrayOfUsers() {
        User[] users = new User[3];
    }
}
