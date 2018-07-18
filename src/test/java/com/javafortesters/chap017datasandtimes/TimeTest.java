package com.javafortesters.chap017datasandtimes;

import com.javafortesters.chap017datesandtimes.domainentities.User;
import com.javafortesters.chap017datesandtimes.exceptions.InvalidPasswordException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TimeTest {

    @Test
    public void currentTimeMillisReturnsCurrentTimeInMilliSecondsFromTheEpoch(){
        long startTime = System.currentTimeMillis();

        for(int x=0; x < 10; x++){
            System.out.println("Current Time " +
                    System.currentTimeMillis());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total Time " + (endTime - startTime));
    }

    @Test
    public void nanoTimeReturnsCurrentsJavaVirtualMachineTimeInNanoSeconds(){
        long startTime = System.nanoTime();

        for(int x=0; x < 10; x++){
            System.out.println("Current Time " +
                    System.nanoTime());
        }

        long endTime = System.nanoTime();
        System.out.println("Total Time " + (endTime - startTime));
    }

    @Test
    public void userIdConsistsOfCharsOnly() throws InvalidPasswordException {
        User usr0 = new User();
        String regExNoDigits = "[^0-9]+";
        System.out.println(usr0.getId());

        assertTrue(usr0.getId().matches(regExNoDigits));
    }

}
