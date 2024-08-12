package com.my.company;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class MyDateUtilititySamples {
    public static void main(String[] args) throws ParseException {

        add_or_subtract_number_of_days_from_current_date();

        currentDateToString();

        stringToJavaUtilDate();
    }

    private static void add_or_subtract_number_of_days_from_current_date() {
        // Adding or subtracting number of days from current date

        // Using apache commons library
        Date dateBefore30Days_javautildate_1 = DateUtils.addDays(new Date(), -30);
        System.out.println("dateBefore30Days_javautildate_1: " + dateBefore30Days_javautildate_1);

        // Using java.time.LocalDate
        // Notice that this doesn't include time
        LocalDate dateBefore30Days_localdate_2 = LocalDate.now(ZoneId.of("Europe/Paris")).minusDays(30);
        System.out.println("dateBefore30Days_localdate_2: " + dateBefore30Days_localdate_2);

        Date dateBefore30Days_javautildate_2 = Date.from(                     // Convert from modern java.time class to troublesome old legacy class.  DO NOT DO THIS unless you must, to inter operate with old code not yet updated for java.time.
                dateBefore30Days_localdate_2                          // `LocalDate` class represents a date-only, without time-of-day and without time zone nor offset-from-UTC.
                        .atStartOfDay(                       // Let java.time determine the first moment of the day on that date in that zone. Never assume the day starts at 00:00:00.
                                ZoneId.of("America/Montreal")  // Specify time zone using proper name in `continent/region` format, never 3-4 letter pseudo-zones such as “PST”, “CST”, “IST”.
                        )                                    // Produce a `ZonedDateTime` object.
                        .toInstant()                         // Extract an `Instant` object, a moment always in UTC.
        );
        System.out.println("dateBefore30Days_javautildate_2: " + dateBefore30Days_javautildate_2);

        // Using java.time.Instant
        // Notice that this includes time
        Instant now = Instant.now(); //current date
        Instant before = now.minus(Duration.ofDays(30));
        Date dateBefore = Date.from(before);
        System.out.println("dateBefore: " + dateBefore);
    }

    // before java8 style
    private static void currentDateToString() {
        String expectedDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(new Date());
        System.out.println("expectedDate: " + expectedDate);
    }

    // java8 style
    private String getCurrentLocalDateTimeStamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a"));
    }

    private static void stringToJavaUtilDate() throws ParseException {

        String dateInStringFormat = "2024-08-06 12:16:04 PM";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a", Locale.ENGLISH);
        Date date = formatter.parse(dateInStringFormat);
        System.out.println("date: " + date);

        String dateInStringFormat2 = "2024-08-06";
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date2 = formatter2.parse(dateInStringFormat2);
        System.out.println("date2: " + date2);
    }
}
