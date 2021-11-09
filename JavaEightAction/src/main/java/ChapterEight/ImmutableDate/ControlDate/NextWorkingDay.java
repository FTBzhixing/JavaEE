package ChapterEight.ImmutableDate.ControlDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextWorkingDay implements TemporalAdjuster {

    //第一种方式
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int dayToAdd=1;
        if(dow==DayOfWeek.FRIDAY)dayToAdd=3;
        else if(dow==DayOfWeek.SATURDAY)dayToAdd=2;
        return temporal.plus(dayToAdd, ChronoUnit.DAYS);
    }

    public static void main(String[] args) {
        //第二种方式
        LocalDate date = LocalDate.of(2018, 8, 1);
        date = date.with(temporal -> { DayOfWeek dow =
                DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK)); int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3; else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2; return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
        System.out.println(date);

        //第三种方式
        date = date.with(temporal -> { DayOfWeek dow =
                DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK)); int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3; else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2; return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
    }
}
