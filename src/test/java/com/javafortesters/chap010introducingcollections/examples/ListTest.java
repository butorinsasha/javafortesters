package com.javafortesters.chap010introducingcollections.examples;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListTest {

    @Test
    public void getElementAtAnIndex() {
        List<String> days = new ArrayList<String>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");

        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
    }

    @Test
    public void removeAnElementAtAnArray() {
        List<String> days = new ArrayList<>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");

        days.remove(1);
        days.remove("Monday");

        assertEquals(2, days.size());
        assertEquals("Wednesday", days.get(0));
        assertEquals("Thursday", days.get(1));
    }

    @Test
    public void addAnElementAtASpecificIndex() {
        List<String> days = new ArrayList<>();
        String[] expectedDaysArray = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        days.add("Tuesday");
        days.add("Thursday");
        days.add("Saturday");

        days.add(0, "Monday");
        days.add(2, "Wednesday");
        days.add(4, "Friday");
        days.add(6, "Sunday");

        int i = 0;
        for (String day : days) {
            System.out.println(i + " " + days.get(i));
            i++;
        }
        assertTrue(7 == days.size());
        assertTrue(7 == days.size());
        for (i=0; i<days.size(); i++) {
            assertEquals(expectedDaysArray[i], days.get(i));
        }
    }

    @Test
    public void addAllElementsInACollectionAtASpecificIndex() {
        List<String> days = new ArrayList<>();
        List<String>  missingDays = new ArrayList<>();

        String[] expectedDaysArray = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        days.add("Monday");
        days.add("Friday");

        missingDays.add("Tuesday");
        missingDays.add("Wednesday");
        missingDays.add("Thursday");

        days.addAll(1, missingDays);

        assertEquals(5, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
        assertEquals("Thursday", days.get(3));
        assertEquals("Friday", days.get(4));
    }

    @Test
    public void indexOfFindIndexOfElement() {
        System.out.println("\nindexOfFindIndexOfElement()");

        List<String> days = new ArrayList<>();
        List<String>  missingDays = new ArrayList<>();


        days.add("Mondays");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Drinkday");
        days.add("Drinkday");
        days.add("Drinkday");

        for (String day : days) {
            System.out.println("Index of " + day + " is " + days.indexOf(day));
        }

        assertEquals(4, days.indexOf("Drinkday"));
        assertEquals(6, days.lastIndexOf("Drinkday"));
    }

    @Test
    public void setElementAtIndex() {
        System.out.println("\nsetElementAtIndex()");
        List<String> days = new ArrayList<>();

        days.add("Monday");
        days.add("Thursday");
        days.add("Wednesday");

        days.set(1, "Tuesday");

        assertEquals("Tuesday", days.get(1));
    }

    @Test
    public void subListToCreateAPortionOfList() {
        System.out.println("\nsubListToCreateAPortionOfList()");

        String[] expectedDaysArray = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        List<String> daysList = new ArrayList<>();
        daysList.add("Monday");
        daysList.add("Tuesday");
        daysList.add("Wednesday");
        daysList.add("Thursday");
        daysList.add("Friday");
        daysList.add("Saturday");
        daysList.add("Sunday");


         /*subList*/
        List<String> workdaysList = daysList.subList(0,5);

        System.out.print("\n");
        for (int i=0; i<workdaysList.size(); i++ ) {
            System.out.println(i + " " + workdaysList.get(i));
        }

        assertEquals(5, workdaysList.size());

        for (int i=0; i<5; i++) {
            assertEquals(expectedDaysArray[i], workdaysList.get(i));
        }


        /*Compare to Arrays.copyOf() and Arrays.copyOfRaunge*/

        String[] daysArray = new String[7];
        daysList.toArray(daysArray);

        String[] workdaysArray = Arrays.copyOf(daysArray, 5);
        String[] weekendDaysArray = Arrays.copyOfRange(daysArray, 5, 7);

        System.out.print("\n");
        for (int i=0; i<workdaysArray.length; i++ ) {
            System.out.println(i + " " + workdaysArray[i]);
        }

        System.out.print("\n");
        for (int i=0; i<weekendDaysArray.length; i++ ) {
            System.out.println(i + " " + weekendDaysArray[i]);
        }
    }

}
