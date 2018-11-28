package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Ch15p155ConvertingToFromStringTest {

    @Test
    public void aStringLiteralIsAnObject() {
        assertThat("hello".length(), is(5));
    }

    @Test
    public void stringsAreImmutableSoJavaCanReuseSameTextValuedStringsObjects() {
        String str1 = new String("abc");
        String str2 = new String("abc");

        assertEquals(str1, str2);
        assertEquals("abc", "abc");

        assertThat(str1, is(str2));
        assertThat("abc", is("abc"));

//        assertTrue(str1 == str2); // fail
        assertTrue("abc" == "abc");

//        assertSame(str1, str2); // fail
        assertSame("abc", "abc");

    }

    @Test
    public void stringConcatMethodConcatenatesStringsOnly() {
        String str1 = "abra";
        String str2 = str1.concat("cadabra"); // param of concat(@NotNull String str) ONLY String
        assertEquals("abracadabra", str2);
        assertThat(str2, is("abracadabra"));
    }

    @Test
    public void canConvertToStringInDifferentWays() {
        String intConcatConvert = "" + 1;
        assertThat(intConcatConvert, is("1"));

        String integerIntConvert = Integer.toString(2);
        assertThat(integerIntConvert, is("2"));

        String integerStringConvert = String.valueOf(3); // = Integer.toString(3)
        assertThat(integerStringConvert, is("3"));

    }

    @Test
    public void parseIntegerAndValueOf() {
        int i1 = Integer.parseInt("+12"); // public static int parseInt(@NotNull String s) throws NumberFormatException

        Integer i2 = Integer.valueOf("12");  // public static Integer valueOf(@NotNull String s) throws NumberFormatException | new Integer(Integer.parseInt(s))

//        System.out.println(i1.getClass()); // Error:(64, 30) java: int cannot be dereferenced
        System.out.println(i2.getClass());

//        assertEquals(i1, i2); // Ambiguous method call
        assertEquals(i1, (int) i2);
        assertTrue(i1 == i2);
    }

    @Test
    public void canConvertFromStringToCharArray() {
        char[] cArray = {'a', '3'};
        System.out.println("a3".toCharArray());
        assertThat("a3".toCharArray(), is(cArray));
    }

    @Test
    public void canConvertFromCharArrayToString() {
        char[] chArr = {'a', '3', '/', '\\'};
        String str1 = String.valueOf(chArr);
        assertThat(str1, is("a3/\\"));
    }

    @Test
    public void canConvertFromStringToByteArray() {
        String str = "a3/\\";

//        char[] chArr= str.toCharArray();

        byte[] bArr = str.getBytes();
        System.out.println(bArr);
        byte[] expectedBytes = {'a', '3', '/', '\\'}; // can create byte[] array this way

        for (int i=0; i<bArr.length; i++) {
            System.out.print(str.charAt(i) + " = ");
            System.out.print(bArr[i] + " = ");
            System.out.print(Integer.toHexString(bArr[i]) + " = ");
            System.out.println(String.format("%8s", Integer.toBinaryString(bArr[i])));
        }

        assertArrayEquals(expectedBytes, bArr);
    }


    @Test
    public void toConvertStringToIntegerStringMustConsistsOfDecimalNumbers() /*throws NumberFormatException*/ {
        String[] validStrings = {"-0023","-023", "-24", "-4", "0", "4", "24", "023", "0023", "+0", "+4", "+24", "+023", "+0023"};
        int[] expectedIntegers = {-23, -23, -24, -4, 0, 4, 24, 23, 23, 0, 4, 24, 23, 23};

        for (int i=0; i<validStrings.length; i++)
            try {
//                System.out.println(Integer.parseInt(validStrings[i]));
                assertThat(Integer.parseInt(validStrings[i]), is(expectedIntegers[i]));
            } catch (NumberFormatException e) {
//                System.out.println("NumberFormatException for \"" + validStrings[i] + "\" is caught but should NOT have!");
                fail("NumberFormatException for \"" + validStrings[i] + "\" is caught but should NOT have!");
            }
    }

    @Test
    public void toConvertStringToIntegerStringMustNotConsistsOfAnySymbolsButDecimalDigits() throws NumberFormatException {
            String[] invalidStrings = {"ab", "3.0", "$&%"};

            for (int i=0; i<invalidStrings.length; i++)
            try {
                Integer.parseInt(invalidStrings[i]);
//                System.out.println("NumberFormatException for \"" + invalidStrings[i] + "\" is NOT caught. But should have");
                fail("NumberFormatException for \"" + invalidStrings[i] + "\" is NOT caught. But should have");
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException for \"" + invalidStrings[i] + "\" is caught as been supposed");
                assertNotNull("NumberFormatException for \"" + invalidStrings[i] + "\" is caught as been supposed", e);
            }
    }

    @Test
    public void canConvertFromStringToByteArrayBySpecifyingEncoding() /*throws UnsupportedEncodingException */{
        String str = "&\'\'()*";
        byte[] expectedBytesASCII = {38, 39, 39, 40, 41, 42};
        byte[] expectedBytesUTF8 = {38, 39, 39, 40, 41, 42};

        try {
            byte[] bytesASCII = str.getBytes("ASCII");
            byte[] bytesUTF8 = str.getBytes("UTF8");
            assertArrayEquals(expectedBytesASCII, bytesASCII);
            assertArrayEquals(expectedBytesUTF8, bytesUTF8);
        } catch (UnsupportedEncodingException e) {
            fail("UnsupportedEncodingException is caught: " + e.getMessage());
        }
    }
}
