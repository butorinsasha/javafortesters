package com.javafortesters.chap003myfirsttest.examples.naming;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class NameClass {
    @Test
    public void whenClassNameHasNoTestInItThenItIsNotRun() {
        // this test has the name "NameClass" with no "Test" apended to the end of the name so it will not run from command line 'mvn test'
        // failing test
        assertTrue("Failed test", true);
    }
}
