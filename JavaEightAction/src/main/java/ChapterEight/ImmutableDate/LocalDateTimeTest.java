package ChapterEight.ImmutableDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("2014-03-18");
        LocalTime time = LocalTime.parse("13:45:20");
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        System.out.println(dt3);
        //通过它们各自的atTime或者atDate方法，向LocalDate传递一个时间对象，或者向
        //LocalTime传递一个日期对象的方式，你可以创建一个LocalDateTime对象。你也可以使用 toLocalDate
        //或者toLocalTime方法，从LocalDateTime中提取LocalDate或者LocalTime 组件
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
    }
}
