package com.javafortesters.chap008selectionsanddecisions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SelectionsAndDecisionsTest {

    @Test
    public void moreTernary() {
        String url = "www.eviltester.com";

        url = url.startsWith("http") ? url : addHttp(url);

        assertTrue(url.startsWith("http://"));
        assertEquals("http://www.eviltester.com", url);
    }

    private String addHttp(String url) {
        return "http://" + url;
    }

    @Test
    public void catOrCatsTernary1() {
        int numberOfCats = 3;
        String catS = "cat";
        catS = numberOfCats != 1 ? "cats" : "cat";
        assertEquals("cats", catS);
    }

    @Test
    public void catOrCatsTernary2() {
        int numberOfCats = 3;
        System.out.println(catOrCats(numberOfCats));
        assertEquals("3 == cats", "cats", catOrCats(numberOfCats));

        numberOfCats = 1;
        System.out.println(catOrCats(numberOfCats));
        assertEquals("1 == cat", "cat", catOrCats(numberOfCats));

    }

    private String catOrCats(int numberOfCats) {
        return numberOfCats != 1 ? "cats" : "cat";
    }

    @Test
    public void ifAddHttp() {
        String url = "www.seleniumsimplified.com";

        if (!url.startsWith("http")) {
            url = addHttp(url);
        }

        assertTrue(url.startsWith("http://"));
        System.out.println(url);
        assertEquals("http://www.seleniumsimplified.com", url);
    }

    @Test
    public void assertTrueIfTrue1() {
        boolean truthy = true;

        if (truthy == true) assertTrue(truthy);
    }

    @Test
    public void assertTrueIfTrue2() {
        boolean truthy = true;
        if (truthy) {
            assertTrue(truthy);
            assertFalse(!truthy);
        }
    }

    @Test
    public void ifElseAddHttp() {
        String url = "www.seleniumsimplified.com";
        if (url.startsWith("http")) {
             // Do nothing. The url is fine
        } else {
            url = addHttp(url);
        }

        assertTrue(url.startsWith("http://"));
        assertEquals("http://www.seleniumsimplified.com", url);
    }


    @Test
    public void assertTrueElseAssertFals1() {
        boolean truthy = false;

        if  (truthy == true)
            assertTrue(truthy);
        else
            assertFalse(truthy);
    }

    @Test
    public void assertTrueElseAssertFalse2() {
        boolean truthy = true;

        if (truthy) {
            assertTrue(truthy);
            assertFalse(!truthy);
        } else {
            assertFalse(truthy);
        }
    }


    @Test
    public void ifElseNestedAddHttp() {
        String url = "seleniumsimplified.com";

        if (url.startsWith("http")) {
            // Do nothing. The url is fine
        } else {
            if (!url.startsWith("www")) {
                url = "www." + url;
            }
            url = addHttp(url);
        }

        assertTrue(url.startsWith("http://"));
        assertEquals("http://www.seleniumsimplified.com", url);
    }

    @Test
    public void switchExample() {
        System.out.println(likelyGenderIs("sir"));
        assertEquals("M", likelyGenderIs("sir"));

        System.out.println(likelyGenderIs("mr"));
        assertEquals("M", likelyGenderIs("mr"));

        System.out.println(likelyGenderIs("master"));
        assertEquals("M", likelyGenderIs("master"));

        System.out.println(likelyGenderIs("miss"));
        assertEquals("F", likelyGenderIs("miss"));

        System.out.println(likelyGenderIs("mrs"));
        assertEquals("F", likelyGenderIs("mrs"));
    }

    private String likelyGenderIs(String title) {
        String likelygGender;

        switch(title.toLowerCase()) {
            case "sir":
            case "mr":
            case "master":
                likelygGender = "M";
                break;
            default:
                likelygGender = "F";
                break;
        }

        return likelygGender;
    }

    private String countryFullNameIs(String ctr) {
        String countryFullName;

        switch (ctr.toLowerCase()) {
            case "uk":
                countryFullName = "United Kingdom";
                break;
            case "us":
            case "usa":
                countryFullName = "United States";
                break;
            case "fr":
                countryFullName = "France";
                break;
            case "se":
                countryFullName = "Sweden";
                break;
            default:
                countryFullName = "Rest Of World";
                break;
        }

        return countryFullName;
    }

    @Test
    public void countyShortCodeConvertedToFullNameCorrectly() {
        String countryShortCode = "uSa";
        System.out.println(countryFullNameIs(countryShortCode));
        assertEquals("United States", countryFullNameIs(countryShortCode));
    }

    private String intToText1(int x) {
        String txt;

        switch(x) {
            case 1:
                txt = "One";
                break;
            case 2:
                txt = "Two";
                break;
            case 3:
                txt = "Three";
                break;
            case 4:
                txt = "Four";
                break;
            default:
                if (x > 4) {
                    txt = "Too big";
                } else {
                    txt  = "Too small";
                }
                break;
        }
        return txt;
    }


    private String intToText2(int x) {

        switch(x) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            default:
                if (x > 4) {
                    return "Too big";
                } else {
                    return "Too small";
                }
        }
    }

    @Test
    public void intConvertedToTextCorrectly() {
        int a = 5;
        assertEquals("Too big", intToText2(a));
    }

}

