package com.javafortesters.chap015stringsrevisited;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Ch15p164FormatStringTest {

    @Test
    public void formatString() {
        String txt = "%s %1$s snake! it's almost %d %3$s %1$s";
        assertThat  (
                        String.format(txt, "long", 10, "meters"),
                        is("long long snake! it's almost 10 meters long")
                    );
    }

}
