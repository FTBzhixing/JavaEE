package ChapterEight.ImmutableDate.ControlDate;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class TemporalAdjusterTest {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        //下一个周末
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        //这个月月底
        LocalDate date3 = date2.with(lastDayOfMonth());


    }
}
