package com.my.company;

import org.apache.commons.lang3.time.DateUtils;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class MyDateUtilititySamples {
    public static void main(String[] args) {

        // Adding or subtracting number of days from current date

        // Using apache commons library
        Date dateBefore30Days_javautildate_1 = DateUtils.addDays(new Date(),-30);
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
}
