package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Ch15p163RemovingWhitespaceTest {

    @Test
    public void trimRemovesLeadingAnsTrailingWhiteSpacesFromString() {
        String padded = "    trim me    ";
        assertThat(padded.length(), is(15));

        String trimmed = padded.trim();
        assertThat(trimmed.length(), is(7));
        assertThat(trimmed, is("trim me"));
    }

}
