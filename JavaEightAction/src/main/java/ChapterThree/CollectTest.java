package ChapterThree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollectTest {
    public static void main(String[] args) {
        ArrayList<Dish> menu = new ArrayList<>();
        //将结果转化为链表
        List<Dish> transactions = menu.stream().collect(Collectors.toList());

        //二者功能相同
        menu.stream().collect(Collectors.counting());
        menu.stream().count();


        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream()
                .collect(maxBy(dishCaloriesComparator));


        //Collectors类专门为汇总提供了一个工厂方法：Collectors.summingInt。它可接受一
        //个把对象映射为求和所需int的函数，并返回一个收集器；该收集器在传递给普通的collect方法后即执行我们需要的汇总操作
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        //但汇总不仅仅是求和；还有Collectors.averagingInt，连同对应的averagingLong和 averagingDouble可以计算数值的平均数：
        double avgCalories =
                menu.stream().collect(averagingInt(Dish::getCalories));

        //joining工厂方法返回的收集器会把对流中每一个对象应用toString方法得到的所有字符串连接成一个字符串
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        //请注意，joining在内部使用了StringBuilder来把生成的字符串逐个追加起来。此外还
        //要注意，如果Dish类有一个toString方法来返回菜肴的名称，那你无需用提取每一道菜名称的 函数来对原流做映射就能够得到相同的结果
//        String shortMenu = menu.stream().collect(joining());

        /**
         * 使用collect和reduce的去区别
         * 一个语义问题和一个实际问题。语义问题在于，reduce方法
         * 旨在把两个值结合起来生成一个新值，它是一个不可变的归约。与此相反，collect方法的设 计就是要改变容器，从而累积要输出的结果。
         * 以错误的语义使用reduce方法还会造成一个实际问题：这个归约过程不能并行工作，因为由多个线程并发修改同一个数据结构可能会破坏List本身。
         * 在这种情况下，如果你想要线程安全，就需要每 次分配一个新的List，而对象分配又会影响性能。这就是collect方法特别适合表达可变容器上的
         * 归约的原因，更关键的是它适合并行操作
         */

        //三者相同
        //函数式编程（特别是Java 8的Collections框架中加入的基于函数式风格原
        //理设计的新API）通常提供了多种方法来执行同一个操作尽可能为手头的问题探索不同的解决方案，但在通用的方案里面，始终选择
        //最专门化的一个,这里最专业化的是三。
        int a = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        int b = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        int c = menu.stream().mapToInt(Dish::getCalories).sum();
    }
}
