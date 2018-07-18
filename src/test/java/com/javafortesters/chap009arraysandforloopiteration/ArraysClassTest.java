package com.javafortesters.chap009arraysandforloopiteration;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArraysClassTest {
    String[] workdays = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    @Test
    public void copyOfCopiesAndResizeArray() {
        String[] weekDays;
        weekDays = Arrays.copyOf(workdays, 7);

        assertEquals(null, weekDays[5]);
        assertEquals(null, weekDays[6]);

        weekDays[5] = "Saturday";
        weekDays[6] = "Sunday";

    }

    @Test
    public void copyOfToCopyAndTruncateAnArray() {
        String[] weekDays;
        weekDays = Arrays.copyOf(workdays, 3);
        assertEquals(3, weekDays.length);
        assertEquals("Monday", weekDays[0]);
        assertEquals("Tuesday", weekDays[1]);
        assertEquals("Wednesday", weekDays[2]);
    }

    @Test
    public void copyOfRangeToCopyASubsetOfAnArray1() {
        String[] weekDays = Arrays.copyOfRange(workdays, 2, 5);

        assertEquals(3, weekDays.length);
        assertEquals("Wednesday", weekDays[0]);
        assertEquals("Thursday", weekDays[1]);
        assertEquals("Friday", weekDays[2]);

        assertEquals(weekDays[0], workdays[2]);
        assertEquals(weekDays[1], workdays[3]);
        assertEquals(weekDays[2], workdays[4]);
    }

    @Test
    public void copyOfRangeToCopyASubsetOfAnArray2() {
        String[] weekDays = Arrays.copyOfRange(workdays, 2, 7);

        assertEquals(5, weekDays.length);
        assertEquals("Wednesday", weekDays[0]);
        assertEquals("Thursday", weekDays[1]);
        assertEquals("Friday", weekDays[2]);

        assertEquals(null, weekDays[3]);
        assertEquals(null, weekDays[4]);
    }

    @Test
    public void fillToPopulateAnArrayWithData() {
        int[] tenItems = new int[] {0, 0, 0, 0, 0, 1, 1, 1, 1, 1};

        // fill cells 5-9 with `1`
        Arrays.fill(tenItems, 5, 10, 2);

        // 0-4 cells are remained untouched;
        for (int i=0; i<5; i++) {
            assertEquals(0, tenItems[i]);
        }

        // 5-9 cells are now equal 2
        for (int i=5; i<tenItems.length; i++) {
            assertEquals(2, tenItems[i]);
        }
    }

    @Test
    public void sortToQuickSortAnArray() {
        int[] outOfOrder;
        outOfOrder = new int[6];
        outOfOrder = new int[] {2, 4, 3, 1, 5, 0};

        Arrays.sort(outOfOrder);

        for (int i=0; i<outOfOrder.length; i++) {
            System.out.println(i + "=" + outOfOrder[i]);
            assertEquals(i, outOfOrder[i]);
        }
    }

    @Test
    public void sortWorkdays() {
        String[] workdaySortingExpected = {"friday", "monday", "thursday", "tuesday", "wednesday"};

        for (int i=0; i<workdays.length; i++) {
            workdays[i] = workdays[i].toLowerCase();
        }

        Arrays.sort(workdays);

        for (int i=0; i<workdays.length; i++) {
            System.out.println(workdaySortingExpected[i] + "=" + workdays[i]);
        }

        assertArrayEquals(workdaySortingExpected, workdays);

    }

}
