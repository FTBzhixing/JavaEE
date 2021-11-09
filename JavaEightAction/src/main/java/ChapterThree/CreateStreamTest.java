package ChapterThree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class CreateStreamTest {
    public static void main(String[] args) {
        //由值创建流
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        //由数组创建流
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();

//        //由文件生成流
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"))) {

            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(""))).distinct().count();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //无限流，斐波那契数列
        //iterate方法接受一个初始值（在这里是0），还有一个依次应用在每个产生的新值上的Lambda（UnaryOperator<t>类型）
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1],t[0] + t[1]}) .limit(10) .map(t -> t[0]) .forEach(System.out::println);

        //generate不是依次对每个新生成的值应用函数的。它接受一个Supplier<T>类型的Lambda提供新的值
        Stream.generate(Math::random) .limit(5).forEach(System.out::println);

    }
}
