package ChapterEight.ImmutableDate;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class LocalDateTest {
    public static void main(String[] args) {
        //你最先碰到的可能是LocalDate类。该类的实例是一个不
        //可变对象，它只提供了简单的日期，并不含当天的时间信息。另外，它也不附带任何与时区相关的信息
        LocalDate date = LocalDate.of(2014, 3, 18);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear());
        System.out.println(LocalDate.now());
        System.out.println("----------------");
        //TemporalField是一个接口，它定 义了如何访问temporal对象某个字段的值。ChronoField枚举实现了这一接口
        System.out.println(date.get(ChronoField.YEAR));
        System.out.println(date.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));

        System.out.println(LocalDate.parse("2014-03-18"));

    }
}
