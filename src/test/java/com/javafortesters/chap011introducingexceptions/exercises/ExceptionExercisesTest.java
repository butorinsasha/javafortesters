//
package com.javafortesters.chap011introducingexceptions.exercises;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExceptionExercisesTest {


    @Test
    public void fixNullPointException() {
        Integer age = 18;
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

//    @Test
//    public void catchArithmeticException() {
//        Integer age = null;
//        String ageAsString;
//
//        try {
//            ageAsString = age.toString();
//        } catch(ArithmeticException e) {
//            age = 18;
//            ageAsString = age.toString();
//        }
//        String yourAge = "You are " + ageAsString + " years old";
//        assertEquals("You are 18 years old", yourAge);
//    }

//    @Test
//    public void throwNullPointerExceptionInCatch() {
//        Integer age = null;
//        String ageAsString;
//
//        try {
//            ageAsString = age.toString();
//        } catch(NullPointerException e) {
//            ageAsString = age.toString();
//        }
//        String yourAge = "You are " + ageAsString + " years old";
//        assertEquals("You are 18 years old", yourAge);
//    }

//    @Test
//    public void catchNoSuchMethodException() {
//        Integer age = 18;
//        String ageAsString;
//
//        try {
//            ageAsString = age.toString();
//        } catch(NoSuchMethodException e) { //Error:(67, 11) java: exception java.lang.NoSuchMethodException is never thrown in body of corresponding try statement
//            age = 18;
//            ageAsString = age.toString();
//        }
//        String yourAge = "You are " + ageAsString + " years old";
//        assertEquals("You are 18 years old", yourAge);
//    }

    @Test
    public void useExceptionAsAnObject() {
        Integer age = null;
        String ageAsString;

        try {
            ageAsString = age.toString();
        } catch (NullPointerException e) {
            age = 18;
            ageAsString = age.toString();

//            System.out.println("getMessage() - " + e.getMessage());
//            System.out.println("getStackTrace() - " + e.getStackTrace());
//            System.out.println("e.printStackTrace()");
//            e.printStackTrace();

            String eMsg = e.getMessage();
            System.out.println(eMsg);

//            StackTraceElement[] stkTrArray = e.getStackTrace();
//            for(int i=0; i<stkTrArray.length; i++){
//                System.out.println(i + " " + stkTrArray[i]);
//
//                System.out.println(stkTrArray[i].getFileName());
//                System.out.println(stkTrArray[i].getLineNumber());
//                System.out.println(stkTrArray[i].getClassName());
//
//                System.out.print("\n");
//            }

        }
    }

}
