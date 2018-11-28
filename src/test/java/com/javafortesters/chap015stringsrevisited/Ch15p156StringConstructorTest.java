package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
//import static org.hamcrest.core.IsNot.not;


public class Ch15p156StringConstructorTest {
    String str; // null

    @Test
    public void nullString() {
        String str1 = null;
        assertNull(str1);
    }

    @Test
    public void canConstructZeroLengthButNotNullStringWithNoArguments() {
        str = new String(); // zero-length but not null

        assertNotNull("Zero-length string supposed to be not null", str);
        assertThat("Zero-length string supposed to be not null", str, is(not(nullValue())));

        assertEquals("Zero-length string has zero length", 0, str.length());
        assertThat("Zero-length string has zero length", str.length(), is(0));
    }

    @Test
    public void canConstructStringFromString() {
        String strToConstructFrom = "abc";
        str = new String(strToConstructFrom);
        assertThat(str, is("abc"));
    }

    @Test
    public void canConstructStringFromCharArray() {
        char [] chars = new char[]  {
                                        '\u0026',
                                        // '\u0027',  The compiler actually sees this: '''
                                        '\'',
                                        0x0027,
                                        050,
                                        41,
                                        0x002a
                                    };
        // '\u0027' = ''' https://stackoverflow.com/questions/13693312/java-assign-unicode-apostrophe-to-char
        /*
         * Error:(41, 35) java: empty character literal
         * Error:(41, 42) java: unclosed character literal
         * Error:(46, 1) java: class, interface, or enum expected
         */

        str = new String(chars);
        assertThat(str, is("&\'\'()*"));
    }

    @Test
    public void canConstructStringFromByteArray() {
        byte[] bytes = new byte[]   {
                                        '\u0026',
                                        /*'\u0027',*/
                                        '\'',
                                        0x0027,
                                        050,
                                        41,
                                        0x002a
                                    };
        // '\u0027' = ''' https://stackoverflow.com/questions/13693312/java-assign-unicode-apostrophe-to-char
        /*
        * Error:(41, 35) java: empty character literal
        * Error:(41, 42) java: unclosed character literal
        * Error:(46, 1) java: class, interface, or enum expected
        */

        str = new String(bytes);
        assertThat(str, is("&\'\'()*"));

    }

    @Test
    public void canConstructStringFromStringBuilder() {
        StringBuilder strBuilder = new StringBuilder("abc");
        String str = new String(strBuilder);
        assertThat(str, is("abc"));
    }

    @Test
    public void canCnstructStringFromStringBuffer() {
        StringBuffer strBuffer = new StringBuffer("abc");
        String str = new String(strBuffer);
        assertThat(str, is("abc"));
    }
}
