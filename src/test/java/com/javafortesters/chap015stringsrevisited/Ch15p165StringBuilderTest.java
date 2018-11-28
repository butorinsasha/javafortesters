package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Ch15p165StringBuilderTest {

    @Test
    public void stringbuilderIsOnlyAccesibleAsStringAfterToStringed() {
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("Hello There").replace(7, 11, "World").delete(5,7);
//                       012345678901
        assertThat(sbuilder.toString(), is("HelloWorld"));
    }

    @Test
    public void constructStringBuilderWithStartingStringValue() {
        StringBuilder sb = new StringBuilder("Hello");
        assertEquals("Hello", sb.toString());
    }

    @Test
    public void capacityIsTheSizeOfStringBuilder() {
        StringBuilder sb0 = new StringBuilder();
        assertThat(sb0.capacity(), is(16));

        sb0.append("1234567890123456");
        System.out.println(sb0.toString());
        System.out.println(sb0.capacity());

        sb0.append("7");
        System.out.println(sb0.toString());
        System.out.println(sb0.capacity());

        sb0.append("890123456789012345");
        System.out.println(sb0.toString());
        System.out.println(sb0.capacity());



        StringBuilder sb1 = new StringBuilder(512);
        assertThat(sb1.capacity(), is(512));
        assertThat(sb1.toString().length(), is(0));
    }

    @Test
    public void ensureCapacityToEnsureCapasityIsAtLeastEqualToTheSpecificMinimum() {
        StringBuilder sb = new StringBuilder();
        assertEquals("Default constructor allocates 16 Bytes", 16, sb.capacity());

        sb.ensureCapacity(32);
        System.out.println(sb.capacity());
        assertTrue("ensureCapacity(32) method", 32 <= sb.capacity());

        sb.append("12345678901234567890123456789012345");
        System.out.println(sb.toString());
        System.out.println(sb.capacity());

        sb.delete(10,sb.length());
        System.out.println(sb.toString());
        System.out.println(sb.capacity());

        assertTrue("ensureCapacity(32) method", 32 <= sb.capacity());

    }

    @Test
    public void trimToSizeSetsTheCapasityToTheMinimumNecessary() {
        StringBuilder sb = new StringBuilder();
        assertEquals("Default constructor allocates 16 Bytes", 16, sb.capacity());

        sb.ensureCapacity(32);
        System.out.println(sb.capacity());
        assertTrue("ensureCapacity(32) method", 32 <= sb.capacity());

        sb.append("12345678901234567890123456789012345");
        System.out.println(sb.toString());
        System.out.println(sb.capacity());

        sb.delete(10,sb.length());
        System.out.println(sb.toString());
        System.out.println(sb.capacity());

        sb.trimToSize();
        System.out.println(sb.toString());
        System.out.println(sb.capacity());
    }

    @Test
    public void stringBuilderResizesWhenAppendedMoreCharactersThenCurrentCapacity() {
        StringBuilder sb = new StringBuilder("Hello");
        int cap = sb.capacity();
        System.out.println(cap);

        for (int i = sb.length()+1; i < cap+1; i++) {
            sb.append(i%10);

            System.out.println(sb.toString());
            System.out.println(sb.capacity());

            assertEquals("Ensure the initial capacity remains", cap, sb.capacity());
        }

        sb.append("+");
        System.out.println(sb.toString());
        System.out.println(sb.capacity());
        assertTrue("Ensure the initial capacity increases", cap < sb.capacity());
    }

    @Test
    public void insertStringIntoStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.insert(0, "hello");
        sb.insert(5, "darling");
        sb.insert(5, " my ");
        System.out.println(sb.toString());
        assertEquals("hello my darling", sb.toString());
    }

    @Test
    public void reverseStringBuffer() {
        String str = "0123456789";
        StringBuilder sb = new StringBuilder(str);

        assertEquals("9876543210", sb.reverse().toString());
    }
}
