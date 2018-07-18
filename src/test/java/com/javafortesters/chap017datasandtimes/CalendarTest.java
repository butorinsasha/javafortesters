package com.javafortesters.chap017datasandtimes;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalendarTest {

    @Test
    public void calendarGetTime() {
        Calendar cal = Calendar.getInstance();
        long nowTime = System.currentTimeMillis();
        assertEquals(cal.getTime().getTime(), nowTime); // could be late
        System.out.println(nowTime);
        System.out.println(cal.getTime().getTime());
    }

    @Test
    public void calendarToString() {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.toString());
    }

    @Test
    public void gregorianCalendarInstance() {
        Calendar cal = new GregorianCalendar();
        long nowTime = System.currentTimeMillis();
        assertEquals(cal.getTime().getTime(), System.currentTimeMillis(), 5); // could be late
        System.out.println(nowTime);
        System.out.println(cal.getTime().getTime());
    }

}
