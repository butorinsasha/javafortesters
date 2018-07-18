package com.javafortesters.chap003myfirsttest.examples.naming;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NameTestClass {
    @Test
    public void whenClassHasTestInMiddleThenTestIsNotRun() {
        // this will not run from command line 'mvn test'
        assertTrue("whenClassHasTestInMiddleThenTestIsNotRun", true);
    }
}
