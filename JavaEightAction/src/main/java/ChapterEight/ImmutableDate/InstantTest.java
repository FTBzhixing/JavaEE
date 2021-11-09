package ChapterEight.ImmutableDate;

import java.time.Duration;
import java.time.Instant;

/**
 * java.time.Instant类对时间建模的方 式，基本上它是以Unix元年时间
 * （传统的设定为UTC时区1970年1月1日午夜时分）开始所经历的 秒数进行计算
 */
public class InstantTest {
    public static void main(String[] args) {
        Instant.ofEpochSecond(3);
        Instant.ofEpochSecond(3, 0);
        Instant.ofEpochSecond(2, 1_000_000_000);
        Instant.ofEpochSecond(4, -1_000_000_000);

        Instant inst1 = Instant.now();
        System.out.println("Inst1 : " + inst1);
        Instant inst2 = inst1.plus(Duration.ofSeconds(10));
        System.out.println("Inst2 : " + inst2);

        System.out.println("Difference in milliseconds : " + Duration.between(inst1, inst2).toMillis());

        System.out.println("Difference in seconds : " + Duration.between(inst1, inst2).getSeconds());
    }
}
