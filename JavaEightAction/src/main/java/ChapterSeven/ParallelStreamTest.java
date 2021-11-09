package ChapterSeven;

import java.util.stream.Stream;

/**
 * 并行流内部使用了默认的ForkJoinPool（7.2节会进一步讲到分支/合并框架），它默认的
 * 线程数量就是你的处理器数量，这个值是由Runtime.getRuntime().availableProcessors()得到的。 但 是你可以通过系统 属性 java.util.concurrent.ForkJoinPool.common. parallelism来改变线程池大小，如下所示：
 * System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","12"); 这是一个全局设置，因此它将影响代码中所有的并行流。反过来说，目前还无法专为某个
 * 并行流指定这个值。一般而言，让ForkJoinPool的大小等于处理器数量是个不错的默认值， 除非你有很好的理由，否则我们强烈建议你不要修改它。
 */
public class ParallelStreamTest {

    public static void main(String[] args) {
        //将顺序流转换为并行流
        Long reduce = Stream.iterate(1L, i -> i + 1).limit(10).parallel().reduce(0L, Long::sum);

        //顺序流和并行流相互转化
        Stream<Long> parallel = Stream.iterate(1L, i -> i + 1).parallel();
        Stream<Long> sequential = parallel.sequential();

    }
}
