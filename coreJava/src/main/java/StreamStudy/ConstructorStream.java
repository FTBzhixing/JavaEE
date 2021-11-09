package StreamStudy;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConstructorStream {
    public static void main(String[] args) {

        Stream<String> a = Stream.of("a", "b", "c");

        String[] strings = {"a", "b", "c"};
        Stream<String> b = Stream.of(strings);
        Stream<String> c = Arrays.stream(strings);

        IntStream d = IntStream.of(1, 2, 3);
        IntStream e = IntStream.range(1, 3);
        a.forEach(System.out::println);

//        a.collect(Collectors.toCollection(new HashSet<>()))
    }
}
