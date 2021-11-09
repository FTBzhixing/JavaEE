package ChapterThree;

import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 使用reduce进行归约有一个装箱成本，Stream API还提供了原始类 型流特化，专门支持处理数值流的方法
 * IntStream、DoubleStream和LongStream，分别将流中的元素特化为int、long和double，从而避免了暗含的装箱成本
 */
public class ShuZhiStream {
    public static void main(String[] args) {
        //映射到数值流
        ArrayList<Dish> menu = new ArrayList<>();
        int sum = menu.stream().mapToInt(Dish::getCalories).sum();

        //转换回对象流
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> integerStream = intStream.boxed();

        //默认值OptionalInt
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories) .max();

        //数值范围,这里我们用了rangeClosed方法来生成1到100之间的所有数字,range是不包含结束值的
        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);

        //
    }
}
