package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ComparingStringTest {

    @Test
    public void compareToReturnsZeroIfStringsAreEquals() {
        String str = "Hello";
        assertThat(str.compareToIgnoreCase("Hello"), is(0));
    }

    @Test
    public void compareToIgnoreCaseReturnsReturnsNegativeIfComparingStringIsSmaller() {
        String str = "Hello";
        assertThat(str.compareTo("hello") < 0, is(true)); // "Hello" < "hello"
        assertTrue(str.compareTo("hello") < 0);
        System.out.println(str.compareTo("hello")); // -32
        System.out.println("ASCII code for 'H' = " + Integer.toHexString((byte) 'H'));
        System.out.println("ASCII code for 'h' = " + Integer.toHexString((byte) 'h'));

        assertThat(str.compareTo("Helloo") < 0, is(true));
        assertTrue(str.compareTo("Helloo") < 0);
        System.out.println(str.compareTo("Helloo"));

        assertThat(str.compareTo("Hemlo") < 0, is(true));
        assertTrue(str.compareTo("Hemlo") < 0);
        System.out.println(str.compareTo("Hemlo"));
    }

    @Test
    public void compareToReturnsReturnsPositiveIfComparingStringIsLarger() {
        String str = "Hello";
        assertThat(str.compareTo("Hel") > 0, is(true));
        assertTrue(str.compareTo("H") > 0);
        System.out.println(str.compareTo("H"));

        assertThat(str.compareTo("Helln") > 0, is(true));
        assertTrue(str.compareTo("Helln") > 0);
        System.out.println(str.compareTo("Helln"));

        assertThat(str.compareTo("HeLlo") > 0, is(true)); //"Hello" > "HeLlo"
        assertTrue(str.compareTo("HeLlo") > 0);
        System.out.println(str.compareTo("HeLlo"));
        System.out.println("ASCII code for 'L' = " + Integer.toHexString((byte) 'L'));
        System.out.println("ASCII code for 'l' = " + Integer.toHexString((byte) 'l'));

        for (int i = 0; i < 5; i++) {
            assertTrue("Hello".toCharArray()[i] >= "HeLlo".toCharArray()[i]);
        }
    }

    @Test
    public void compareToIgnoreCaseComparesStringsIgnoreingCases() {
        String str = "Hello";
        assertThat(str.compareToIgnoreCase("Hello"), is(0));
        assertThat(str.compareToIgnoreCase("hello"), is(0));
        assertThat(str.compareToIgnoreCase("helLo"), is(0));
    }


    @Test
    public void containsChecksIfStringConsistOfAnotherString() {
        String str = "abracadabra";
        assertThat(str.contains("abra"), is(true));
        assertThat(str.contains("abracadabra"), is(true));
    }

    @Test
    public void equalsEqualsForCharSequenceIntefaceImpelemntedClasses() {
        String str = "AbrAcAdAbrA";
        assertThat(str.contentEquals("AbrAcAdAbrA"), is(true));
        assertThat(str.equals("AbrAcAdAbrA"), is(true));
        assertThat(str.equalsIgnoreCase("abracadabra"), is(true));
    }

    @Test
    public void regionMatchesIsAComplicatedMethodToCheckEqualityOfStingPortions() {
        String str = "Hello fella";
//                    01234567890
        assertThat(str.regionMatches(true, 6, "fez", 0, 2), is(true));
    }


    @Test
    public void regionMatchesIsAComplicatedMethodToCheckEqualityOfStingPortions1() {
        String str = "Hello fella";
//                    01234567890
        assertThat(str.contains("la"), is(true));
        assertThat(str.regionMatches(true, 9, "young lady", 6, 2), is(true));
//                                             0123456789
    }

    @Test
    public void indexOfReturnsStartPossitionOfSubstring() {
        String str = "Hello my fella elf";
        //            012345678901234567
        assertThat(str.indexOf("el", 0), is(1));
    }


    public static List<Integer> findAllOccurrences(String str, String substr) {
        List<Integer> actualsList = new ArrayList<>();

        /*Simple implementation*/
//        actualsList.add(2);
//        actualsList.add(3);
//        actualsList.add(8);
//        actualsList.add(10);

        /*Real implementaton*/
        int searchFrom = 0;
        while (     (str.indexOf(substr, searchFrom) >= 0) &&
                    (str.indexOf(substr, searchFrom) < str.length())    )
        {
            actualsList.add(str.indexOf(substr, searchFrom));
            searchFrom = str.indexOf(substr, searchFrom) + 1;
        }
            return actualsList;
    }

    @Test
    public void findAllOcccurencesFindsAllSubstringLocationsInTheGivenString() {
        String str = "abracadabra";
        //            01234567890

//        int[] expectedsArray = {2, 3, 8, 9};
//        String substr = "l";

//        int[] expectedsArray = {1, 7};
//        String substr = "e";

        int[] expectedsArray = {0, 7};
        String substr = "abra";

        /*Generating expectedsList data from expectedsArray*/
        List<Integer> expectedsList = new ArrayList<>();
        for (int i=0; i<expectedsArray.length; i++) {
            expectedsList.add(expectedsArray[i]);
        }

        /*Checking the expectedsList data is generated correctly*/
        for (int i=0; i<expectedsList.size(); i++) {
            assertThat(expectedsList.get(i) , is(expectedsArray[i]));
        }

        /*Main testing*/
        for (int i=0; i<findAllOccurrences(str, substr).size(); i++) {
            assertThat(findAllOccurrences(str, substr).get(i), is(expectedsList.get(i)));
            System.out.println(findAllOccurrences(str, substr).get(i) + "==" + expectedsList.get(i));
        }
    }

}
