package ChapterTwo.Six;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Constructor {
    public static void main(String[] args) {
        Supplier<Cat> t = Cat::new;
        t.get();

        Function<Integer,Dog> c=Dog::new;
        Dog apply = c.apply(1);

        BiFunction<Integer,Integer,Horse> h =Horse::new;
        Horse horse = h.apply(10, 20);

    }
}
