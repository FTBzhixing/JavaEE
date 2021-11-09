package ChapterThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamTest {
    public static void main(String[] args) {
        //和迭代器类似，流只能遍历一次。遍历完之后，这个流已经被消费掉了。
        //可以从原始数据源那里再获得一个新的流来重新遍历一遍，就像迭代器一样（这里假设它是集合之类的可重复的源，如果是I/O通道就没戏了）
        List<String> list = Arrays.asList("fang", "teng", "bo");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);

        ArrayList<Dish> menu = new ArrayList<>();

        //用谓词筛选
        List<Dish> collect = menu.stream().filter(Dish::isVegetarian).collect(toList());

        //流还支持一个叫作distinct的方法，它会返回一个元素各异（根据流所生成元素的
        //hashCode和equals方法实现）的流。例如，以下代码会筛选出列表中所有的偶数，并确保没有重复。
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 3, 2, 1);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::print);

        //截短流
        menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(toList());

        //跳过元素
        menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());

        //映射
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        words.stream().map(String::length).collect(toList());

        //flatMap扁平化映射
//        String[] arrayOfWords = {"Goodbye", "World"};
//        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);


        //flatMap扁平化映射
        //前两种演示了单纯使用map无法实现打散字符串数据到单个字符的功能
        List<String[]> collect1 = words.stream()
                .map(word -> word.split("")).distinct()
                .collect(toList());

        List<Stream<String>> collect2 = words.stream()
                .map(word -> word.split("")).map(Arrays::stream).distinct()
                .collect(toList());


        //使用flatMap方法的效果是，各个数组并不是分别映射成一个流，而是映射成流的内容。所
        //有使用map(Arrays::stream)时生成的单个流都被合并起来，即扁平化为一个流
        List<String> collect3 = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(toList());

        //检查谓词是否至少匹配一个元素
        boolean flag = menu.stream().anyMatch(Dish::isVegetarian);

        //检查谓词是否匹配所有元素,但它会看看流中的元素是否都能匹配给定的谓词
        boolean b = menu.stream().allMatch(d -> d.getCalories() < 1000);

        //和allMatch相对的是noneMatch。它可以确保流中没有任何元素与给定的谓词匹配
        boolean isHealthy = menu.stream().noneMatch(d -> d.getCalories() >= 1000);

        //findAny方法将返回当前流中的任意元素。它可以与其他流操作结合使用。
        Optional<Dish> any = menu.stream().filter(Dish::isVegetarian).findAny();

        //查找第一个元素
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = someNumbers.stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0).findFirst();


    }
}
