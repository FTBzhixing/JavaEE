package ForkJoinPool;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoinPool {
    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 10000000000L);

//        Long sum = pool.invoke(task);
        long reduce = LongStream.rangeClosed(0L, 10000000000L).parallel().reduce(0L, Long::sum);
        System.out.println(reduce);
        Instant end = Instant.now();
        System.out.println("time=" + Duration.between(start, end));
    }
}
