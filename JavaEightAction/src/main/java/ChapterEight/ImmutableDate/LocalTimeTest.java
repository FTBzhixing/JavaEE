package ChapterEight.ImmutableDate;

import java.time.LocalTime;

public class LocalTimeTest {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(13, 25, 20);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());

        System.out.println(LocalTime.parse("13:45:20"));
    }
}
