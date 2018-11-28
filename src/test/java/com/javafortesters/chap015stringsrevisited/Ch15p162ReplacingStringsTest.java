package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Ch15p162ReplacingStringsTest {

    @Test
    public void replaceToReplaceAllMatchingSubstringsWithNewSubstring() {
        String hello = "Hello fella fella fella";
        assertThat( hello.replace("fella", "World"), is("Hello World World World"));
    }

    @Test
    public void replaceAllToReplaceAllSubstringsMatchingRegExWithNewSubstring() {
        String hello = "Hello **lla fell* fella";

        assertThat( hello.replaceAll("\\w\\wll.", "World"), is("World **lla World World"));
    }

    @Test
    public void replaceFirstToReplaceFirstSubstringMatchingRegExWithNewSubstring() {
        String hello = "Hello fella fella fella";
        assertThat( hello.replaceFirst(".ell.", "World"), is("World fella fella fella"));
    }

}
