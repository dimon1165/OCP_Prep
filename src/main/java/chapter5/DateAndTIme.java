package chapter5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;


//UTC - standard time, use same as GMT(Greenwich Mean Time)+00:00
// ALL DONT HAVE CONSTRUCTORS
// ALL is immutable
public class DateAndTIme {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(LocalDate.now());     // 2019-07-18
        System.out.println(LocalDateTime.now()); // 2019-07-18T09:53:26.698
        System.out.println(ZonedDateTime.now()); // 2019-07-18T09:53:26.699+03:00[Europe/Kiev]

        System.out.println(LocalDate.of(2015, Month.JUNE, 30));
        System.out.println(LocalTime.of(14, 30, 33, 888));
        System.out.println(LocalDateTime.of(2015, Month.JANUARY, 10, 14, 33, 39, 888));

        ZoneId zoneId = ZoneId.of("US/Eastern");
        // prohibited to path Month.JUNE there -> accepts only month as int.
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2015, 1, 20, 6, 15, 30, 200, zoneId);
        System.out.println(zonedDateTime);

        System.out.println(ZoneId.systemDefault());
        ZoneId.getAvailableZoneIds().stream().filter(x -> x.startsWith("EU") && x.contains("KIEV")).findFirst().ifPresent(System.out::println);

        LocalDate localDateStart = LocalDate.of(2014, Month.JANUARY, 20);
        LocalDate localDateEnd = LocalDate.of(2014, Month.JANUARY, 25);
        System.out.println(localDateStart.plusDays(2));
        System.out.println(localDateStart.plusWeeks(1));
        System.out.println(localDateStart.plusMonths(1));
        System.out.println(localDateStart.plusYears(1));
        localDateStart = localDateStart.minusDays(1);
        System.out.println(localDateStart);
        System.out.println(localDateStart.toEpochDay());

        //PERIODS - only for large amount of time -> years, month, days
        Period between = Period.between(localDateStart, localDateEnd);
        System.out.println(between.getDays());
        Period period = Period.ofMonths(1);
        System.out.println(period.getDays());
        System.out.println(localDateStart.plus(period));
        LocalTime localTime = LocalTime.of(20, 45);
//        localTime.plus(period); UnsupportedType. It is not allowed to add period of days to time.

        //DURATIONS -> for small -> hours, minutes, seconds
        System.out.println(Duration.ofDays(1)); //PT24H
        System.out.println(Duration.ofHours(1)); //PT1H
        System.out.println(Duration.ofMinutes(1)); //1PT1M

        //INSTANT is time represented in GMT
        Instant start = Instant.now();
        Thread.sleep(1000);
        Instant finish = Instant.now();
        Duration duration = Duration.between(start, finish);
        System.out.println(duration.toMillis());

        ZoneId zoneIdInstant = ZoneId.of("US/Eastern");
        LocalDateTime localDateTime = LocalDateTime.of(localDateEnd, localTime);
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(localDateTime, zoneIdInstant);
        Instant instant = zonedDateTime1.toInstant();
        System.out.println(zonedDateTime1);
        System.out.println(instant);

        //L11n I18N
        Locale locale = Locale.getDefault();
        System.out.println(locale);
        Locale.Builder builder = new Locale.Builder()
                .setRegion("US")
                .setLanguage("en");
        System.out.println(builder.build());

        Locale france = new Locale("fr", "FR");
        ResourceBundle bundle = ResourceBundle.getBundle("Zoo_en", france);
        System.out.println(bundle.getString("hello"));

        LocalDateTime localDateTime1 = LocalDateTime.of(localDateEnd,localTime);
        System.out.println(localDateTime1.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));


    }
}