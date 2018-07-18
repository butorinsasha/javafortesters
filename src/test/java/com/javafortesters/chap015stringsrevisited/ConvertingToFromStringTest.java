package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConvertingToFromStringTest {

    @Test
    public void aStringLitegalIsAnObject() {
        assertThat("hello".length(), is(5));
    }

    @Test
    public void stringsAreImmutableSoJavaCanReuseSameTextValuedStringsObjects() {
        String str1 = new String("abc");
        String str2 = new String("abc");
        assertEquals(str1, str2);
        assertThat(str1, is(str2));
    }

    @Test
    public void stringConcatMethodConcatenatesStringsOnly() {
        String str1 = "abra";
        String str2 = str1.concat("cadabra"); // param of concate(@NotNull String.str) ONLY String
        assertEquals("abracadabra", str2);
        assertThat(str2, is("abracadabra"));
    }

    @Test
    public void canConvertToStringInDifferentWays() {
        String intConcatConvert = "" + 1;
        assertThat(intConcatConvert, is("1"));

        String integerIntConvert = Integer.toString(2);
        assertThat(integerIntConvert, is("2"));

        String integerStringConvert = String.valueOf(3);
        assertThat(integerStringConvert, is("3"));
    }
    @Test
    public void canConvertFromStringToCharArray() {
        char[] cArray = {'a', '3'};
        assertThat("a3".toCharArray(), is(cArray));
    }

    @Test
    public void canConvertFromCharArrayToString() {
        char[] chArr = {'a', '3', '/', '\\'};
        String str = String.valueOf(chArr);
        assertThat(str, is("a3/\\"));
    }

    @Test
    public void canConvertFromStringToByteArray() {
        String str = "a3/\\";

//        char[] chArr= str.toCharArray();

        byte[] bArr = str.getBytes();
        byte[] expectedBytes = {'a', '3', '/', '\\'}; // can create byte[] array this way

        for (int i=0; i<bArr.length; i++) {
//            System.out.print(chArr[i] + " = ");
            System.out.print(str.charAt(i) + " = ");
            System.out.print(Integer.toHexString(bArr[i]) + " = ");
            System.out.println(String.format("%8s", Integer.toBinaryString(bArr[i])));
        }

        assertArrayEquals(expectedBytes, bArr);
    }


    @Test
    public void toConverStringToIntegerStringMustConsistsOfDecimalNumbers() /*throws NumberFormatException*/ {
        String[] positiveStrings = {"-0023","-023", "-24", "-4", "0", "4", "24", "023", "0023", "+0", "+4", "+24", "+023", "+0023"};
        int[] expectedIntegers = {-23, -23, -24, -4, 0, 4, 24, 23, 23, 0, 4, 24, 23, 23};

        for (int i=0; i<positiveStrings.length; i++)
            try {
//                System.out.println(Integer.parseInt(positiveStrings[i]));
                assertThat(Integer.parseInt(positiveStrings[i]), is(expectedIntegers[i]));
            } catch (NumberFormatException e) {
//                System.out.println("NumberFormatException for \"" + positiveStrings[i] + "\" is caught but should NOT have!");
                fail("NumberFormatException for \"" + positiveStrings[i] + "\" is caught but should NOT have!");
            }
    }

    @Test
    public void toConvertStringToIntegerStringMustNotConsistsOfAnySymbolsButDecimalDigits() throws NumberFormatException {
            String[] negativeStrings = {"ab", "3.0", "$&%"};

            for (int i=0; i<negativeStrings.length; i++)
            try {
                Integer.parseInt(negativeStrings[i]);
//                System.out.println("NumberFormatException for \"" + negativeStrings[i] + "\" is NOT caught. But should have");
                fail("NumberFormatException for \"" + negativeStrings[i] + "\" is NOT caught. But should have");
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException for \"" + negativeStrings[i] + "\" is caught as been supposed");
                assertNotNull("NumberFormatException for \"" + negativeStrings[i] + "\" is caught as been supposed", e);
            }
    }

    @Test
    public void canConvertFromStringToByteArrayBySpecifyingEncoding() /*throws UnsupportedEncodingException */{
        String str = "&\'\'()*";
        byte[] expectedBytes = {38, 39, 39, 40, 41, 42};

        try {
            byte[] bytes = str.getBytes("ascii");
            assertArrayEquals(expectedBytes, bytes);
        } catch (UnsupportedEncodingException e) {
            fail("UnsupportedEncodingException is caught: " + e.getMessage());
        }
    }
}
