package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class SplitStringTest {

    @Test
    public void splitToSplitStringBySpecifiedDelimeter() {
        String csv = "0,1 2.3;4,5,6,7,8,9";
        String[] results = csv.split("[,\\s\\.;]");
        String[] expecteds = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        assertThat(results.length, is(10));
        assertArrayEquals(expecteds, results);
    }

}
