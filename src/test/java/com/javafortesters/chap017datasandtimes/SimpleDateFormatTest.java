package com.javafortesters.chap017datasandtimes;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleDateFormatTest {

    @Test
    public void simpleDateFormatExample() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date(0L);
        String datePattern = "yyyy-MM-dd";
        sdf.applyPattern(datePattern);
        assertThat(sdf.format(date), is("1970-01-01"));
        System.out.println(String.format(
                "|\"%s\" |  \"%s\"|",
                datePattern,
                sdf.format(date)));



        datePattern = "MMM/dd/yyy";
        sdf.applyPattern(datePattern);
        System.out.println(String.format(
                                            "|\"%s\" |  \"%s\"|",
                                            datePattern,
                                            sdf.format(date)));


    }

    @Test
    public void importantDateFormatPatterns() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d HH:mm:ss.SSS");
        Date date = sdf.parse("2013-1-15 23:39:54.123");

        String[][] formatElement = {
                {"y", "year"},
                {"yy", "year"},
                {"yyy", "year"},
                {"yyyy", "year"},
                {"yyyyy", "year"},
                {"M", "Month"},
                {"MM", "Month"},
                {"MMM", "Month"},
                {"MMMM", "Month"},
                {"d", "Day in Month"},
                {"dd", "Day in Month"},
                {"ddd", "Day in Month"},
                {"h", "Hour in AM/PM Time"},
                {"hh", "Hour in AM/PM Time"},
                {"hhh", "Hour in AM/PM Time"},
                {"H", "Hour in 24 Hr Time"},
                {"HHH", "Hour in 24 Hr Time"},
                {"m", "Minute in Time"},
                {"mm", "Minute in Time"},
                {"mmm", "Minute in Time"},
                {"s", "Second in Minute"},
                {"ss", "Second in Minute"},
                {"sss", "Second in Minute"},
                {"S", "Milllisecond"},
                {"E", "Week Day Name"},
                {"EEEE", "Week Day Name"},
                {"a", "AM/PM"},
        };

        System.out.println("| Element      | Description          | Output       |");
        System.out.println("| ------------ | -------------------- | ------------ |");

        for(String []details : formatElement) {

            sdf.applyPattern(details[0]);
            System.out.println(
                    String.format("| %12s | %20s | %12s |",
                            "\"" + details[0] + "\"",
                            "\"" + details[1] + "\"",
                            "\"" + sdf.format(date) + "\""));
        }
    }

    @Test
    public void unusualDateFormatPatterns() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = sdf.parse("2013-1-15 23:39:54.123");

        String[][] formatElement = {
                {"w", "Week in the year"},
                {"www", "Week in the year"},

                {"W", "Week in the month"},
                {"WW", "Week in the month"},
                {"WWW", "Week in the month"},

                {"D", "Day in the year"},

                {"F", "Day of week in the month"},
                {"FF", "Day of week in the month"},
                {"FFF", "Day of week in the month"},

                {"u", "Day number in the week"},
                {"uu", "Day number in the week"},

                {"k", "Hour in the day (1-24)"},
                {"kkk", "Hour in the day (1-24)"},

                {"H", "Hour in the am/pm (0-11)"},
                {"HHH", "Hour in the am/pm (0-11)"},

                {"z", "General Time Zone"},

                {"Z", "RTC 822 Time Zone"},

                {"X", "ISO 8601 Time Zone"},
        };

        System.out.println("| Element      | Description                | Output       |");
        System.out.println("| ------------ | -------------------------- | ------------ |");

        for(String []details : formatElement) {

            sdf.applyPattern(details[0]);
            System.out.println(
                    String.format("| %12s | %26s | %12s |",
                            "\"" + details[0] + "\"",
                            "\"" + details[1] + "\"",
                            "\"" + sdf.format(date) + "\""));
        }
    }

    @Test
    public void convertsDateToLong() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date1 = sdf.parse("1970-01-01 03:00:00.000");
        System.out.println(date1.getTime());

        Date date2 = new Date(0L);
        System.out.println(date2);
        System.out.println(date2.getTime());

        Date date3 = new Date(-84000000L);
        System.out.println(sdf.format(date3));
        System.out.println(date3.getTime());

        Date dateMin = new Date(Long.MIN_VALUE);
        Date dateMax = new Date(Long.MAX_VALUE);
        System.out.println(sdf.format(dateMin));
        System.out.println(sdf.format(dateMax));
    }
}
