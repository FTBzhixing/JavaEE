package ChapterEight.ImmutableDate;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DurationTest {
    public static void main(String[] args) {
        Duration threeMinutes = Duration.ofMinutes(4);
        System.out.println(threeMinutes);
        Duration threeMinutes1 = Duration.of(3, ChronoUnit.MINUTES);
        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);


    }
}
