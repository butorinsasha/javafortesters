package com.javafortesters.chap003myfirsttest.examples.naming;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NameClassTest {
    @Test
    public void whenClassHasTestAtEndThenTestisRun() {
        // this test will run from maven so it needs to pass
        assertTrue("whenClassHasTestAtEndThenTestisRun", true);
    }
}
