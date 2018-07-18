package com.javafortesters.chap16randomdata;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaUtilRandomTest {

    @Test
    public void canGeneradeRandomInt() {
        /*Creates a new pseudo randomom number generator*/
        Random generate = new Random();
        for (int x = 0; x < 1000; x++) {

            /*Returns the next pseudorandomom, uniformly distributed int value from this randomom number generator's sequence.*/
            int randomInt = generate.nextInt();

            System.out.println(randomInt);
            assertTrue(randomInt >= Integer.MIN_VALUE && randomInt < Integer.MAX_VALUE);
        }
    }

    @Test
    public void generateRandomBoolean() {
        Random generate = new Random();
        boolean randomBoolean;
        int countTrue = 0;
        int countFalse = 0;

        for (int i = 0; i < 1000; i++) {
            randomBoolean = generate.nextBoolean();
            if (randomBoolean)
                countTrue++;
            else
                countFalse++;
        }
        System.out.println("countTrue=" + countTrue + ":" + countFalse + "=countFalse");
        assertEquals(1000, countTrue + countFalse);
    }

    @Test
    public void generateRandomLong() {
        Random generate = new Random();
        long randomLong = 0;
        for (int i = 0; i < 1000; i++) {
            randomLong = generate.nextLong();
            System.out.println(randomLong);
            assertTrue(randomLong >= Long.MIN_VALUE && randomLong < Long.MAX_VALUE);
        }
    }

    @Test
    public void generateRandomFloat() {
        Random generate = new Random();
        float randomFloat = 0.0f;
        for (int i = 0; i < 1000; i++) {
            randomFloat = generate.nextFloat();
            System.out.println(randomFloat);
            assertTrue(randomFloat>=0.0f && randomFloat<1.0f);
        }
    }

    @Test
    public void generateRandomDouble() {
        Random generate = new Random();
        double randomDouble = 0.0;
        for (int i = 0; i < 1000; i++) {
            randomDouble = generate.nextDouble();
            System.out.println(randomDouble);
            assertTrue(randomDouble>=0.0 && randomDouble<1.0);
        }
    }

    @Test
    public void generateRandomByte() {
        Random generate = new Random();
        int len = 10;
        byte[] randomBytes = new byte[len];

        System.out.println(len);

        System.out.println(new String(randomBytes));
        for (byte b : randomBytes) {
            System.out.print(Integer.toHexString(b & 0x000000ff) + " ");
        }

        System.out.print("\n");

        generate.nextBytes(randomBytes);

        for (byte b : randomBytes) {
            System.out.print(Integer.toHexString(b & 0x000000ff) + " ");
        }

        System.out.print("\n");

        for (byte b : randomBytes) {
            System.out.print(Integer.toHexString(b) + " ");
        }

        System.out.print("\n");

        assertEquals(len, randomBytes.length);
        for (byte b : randomBytes) {
            assertTrue(b >= Byte.MIN_VALUE && b < Byte.MAX_VALUE);
        }
    }

    @Test
    public void generateRandomIntGivenRange() {
        Random generate = new Random();
        int min = 15;
        int max = 20;
        int randomIntRange;
        for (int i=0; i<100; i++) {
            randomIntRange = min + generate.nextInt(max-min+1);
            System.out.print(randomIntRange + ",");
            assertTrue(randomIntRange >= min && randomIntRange <= max);
        }
    }

    @Test
    public void generateRandomGaussian() {
        Random generate = new Random();
        double random;

        /*Initials*/
        int n = 1000;
        double a = -4.0;
        double b = +4.0;
        double h = 0.5;
        int k = (int) ((b-a)/h);

        /*Generating boarders*/
        double[] boarders = new double[k+1];
        boarders[0] = a;
        for (int i = 1; i < k+1; i++) {
            boarders[i] = boarders[i-1]+h;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(String.format( "%1$d [%2$.2f; %3$.2f)", i, boarders[i], boarders[i+1] ) );
        }

        /*Generating random vaues and counting*/
        int[] counts = new int[k];
        for (int i = 0; i < n; i++) {
            random = generate.nextGaussian();
//            random = (b-a) * generate.nextFloat() + a;
            for (int j = 0; j < k; j++) {
                if ( random >= boarders[j] && random < boarders[j+1] ) {
                    counts[j]++;
                }
            }
        }

        /*Print counts*/
        for (int i = 0; i < k; i++) {
            System.out.println(i + " " + counts[i]);
        }

        /*Culculate integered percents of counts*/
        int [] pInt = new int[k];
        for (int i = 0; i < k; i++) {
            pInt[i] = (int) ((float) counts[i]/n*100);
        }

        for (int i = 0; i < k; i++) {
            System.out.println(i + " " + pInt[i]);
        }

        /*Plot graph*/
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < pInt[i]; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

    }

    @Test
    public void generateRandomWithSeed() {
        Random generate = new Random(1234567L);

        int randomInt0 = generate.nextInt();
        long randomLong0 = generate.nextLong();
        double randomDouble0 = generate.nextDouble();
        double randomGaussian0 = generate.nextGaussian();
        float randomFloat0 = generate.nextFloat();
        boolean randomBoolean0 = generate.nextBoolean();

        System.out.println(randomInt0);
        System.out.println(randomLong0);
        System.out.println(randomLong0);
        System.out.println(randomDouble0);
        System.out.println(randomGaussian0);
        System.out.println(randomFloat0);
        System.out.println(randomBoolean0);


        assertEquals(1042961893, randomInt0);
        assertEquals(-6749250865724111202L, randomLong0);

        generate = new Random(1234567L);

        int randomInt1 = generate.nextInt();
        long randomLong1 = generate.nextLong();
        double randomDouble1 = generate.nextDouble();
        double randomGaussian1 = generate.nextGaussian();
        float randomFloat1 = generate.nextFloat();
        boolean randomBoolean1 = generate.nextBoolean();

        System.out.println(randomInt1);
        System.out.println(randomLong1);
        System.out.println(randomDouble1);
        System.out.println(randomGaussian1);
        System.out.println(randomFloat1);
        System.out.println(randomBoolean1);

        assertEquals(randomInt0, randomInt1);
        assertEquals(randomLong0, randomLong1);
        assertEquals(randomDouble0, randomDouble1, 0.0);
        assertEquals(randomGaussian0, randomGaussian1, 0.0);
        assertEquals(randomFloat0, randomFloat1 , 0.0);
        assertEquals(randomBoolean0, randomBoolean1);

    }

    @Test
    public void generateRandomStrings() {

        System.out.println(" ".getBytes()[0]);
        System.out.println("A".getBytes()[0]);
        System.out.println("Z".getBytes()[0]);

        char c = 'A'+1;
        byte b = 'A'+1;
        System.out.println(c + " " + b);
        assertEquals(c, b);

        List<Character> validCharactersList= new ArrayList<>();
        char ch = 'A';
        while (ch <= 'Z') {
            validCharactersList.add(ch);
            ch++;
        }
        validCharactersList.add(' ');
        System.out.println(validCharactersList);

        Character[] validCharactersArray = new Character[validCharactersList.size()];
        validCharactersList.toArray(validCharactersArray);

        char[] validCharArray = new char[validCharactersArray.length];
        for (int i=0; i<validCharactersArray.length; i++) {
            validCharArray[i] = validCharactersArray[i];
        }

        String validString = new String(validCharArray);
        System.out.println("[" + validString + "]");

        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ ", validString);

        Random generate = new Random();
        int stringLengh = 100;
        String randomStr;
        StringBuilder randomStrBuilder = new StringBuilder();

        for (int i=0; i<stringLengh; i++) {
            int randomIndex = generate.nextInt(validString.length());
            char randomChar = validString.charAt(randomIndex);
            randomStrBuilder.append(randomChar);
        }
        randomStr = randomStrBuilder.toString();

        System.out.println(randomStr);
    }
}