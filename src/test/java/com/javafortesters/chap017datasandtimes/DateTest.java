package com.javafortesters.chap017datasandtimes;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DateTest {

    @Test
    public void dateClassParamConstuctor() throws InterruptedException {
        Date date1 = new Date();
//        Thread.sleep(1000); // wait 1000 milliseconds = 1 second
        Date date2 = new Date(System.currentTimeMillis());
        System.out.println(date1);
        System.out.println(date2.toString());
        assertThat(date1, is(date2));
    }

    @Test
    public void oneWeekFromNow() {

        Date nowDate = new Date();
        System.out.println(nowDate.toString());

        long nowTime = nowDate.getTime();
        System.out.println(nowTime);

        long oneWeekFromNowTime = nowTime + (1000 * 60 * 60 * 24 * 7);
        System.out.println(oneWeekFromNowTime);

        Date oneWeekFromNowDate = new Date(oneWeekFromNowTime);
        System.out.println(oneWeekFromNowDate);

        assertEquals(7, ( (oneWeekFromNowDate.getTime() - nowDate.getTime()) / (24 * 60 * 60 * 1000) ) );
    }

    @Test
    public void setTimeToDateAfterConstructingIt() throws InterruptedException {
        Date date1 = new Date();
        Thread.sleep(2000);
        Date date2 = new Date();
        System.out.println(date1.compareTo(date2));
        assertTrue(date1.compareTo(date2) < 0);

        date2.setTime(date1.getTime());

        assertTrue(date1.equals(date2));
        assertThat(date1.compareTo(date2), is(0));
    }

    @Test
    public void maxAndMinDate() {
        Date nowDate = new Date();
        Date minDate = new Date(Long.MIN_VALUE);
        Date maxDate = new Date(Long.MAX_VALUE);

        System.out.println(nowDate);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(minDate);
        System.out.println(maxDate);
    }
}
