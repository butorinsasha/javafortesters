package com.javafortesters.chap16randomdata;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MathRandomTest {

    @Test
    public void mathRandomGeneratesRandomDoubleFrom0To1() {
        double rnd = Math.random();

        System.out.println(String.format("generated %f as random number", rnd));
        assertTrue(rnd>=0d && rnd<1.0);
    }

}
