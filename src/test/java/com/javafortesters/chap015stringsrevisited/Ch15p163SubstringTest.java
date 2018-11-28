package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Ch15p163SubstringTest {

    @Test
    public void substringToGetSubsttringFromAString() {
        String digits = "0123456789";

        assertEquals("56789", digits.substring(5));

        assertEquals("lastIndex is not included", "56", digits.substring(5, 7));
        assertThat("lastIndex is not included", digits.substring(5, 7), is("56"));
    }

}
