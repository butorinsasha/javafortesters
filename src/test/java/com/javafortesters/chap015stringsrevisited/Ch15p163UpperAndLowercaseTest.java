package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Ch15p163UpperAndLowercaseTest {

    @Test
    public void toUppercaseConvertStringToUppercase() {
        String text = "In the lower 3rd";
        assertThat(text.toUpperCase(), is("IN THE LOWER 3RD"));
    }

    @Test
    public void toLowercaseConvertStringToLowercase() {
        String text = "In the lower 3rd";
        assertThat(text.toLowerCase(), is("in the lower 3rd"));

    }

}
