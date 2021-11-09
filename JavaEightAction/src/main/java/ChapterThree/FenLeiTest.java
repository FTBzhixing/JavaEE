package ChapterThree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class FenLeiTest {
    public static void main(String[] args) {

        ArrayList<Dish> menu = new ArrayList<>();

        Map<String, List<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType));

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400)
                return CaloricLevel.DIET;
            else if (dish.getCalories() <= 700)
                return CaloricLevel.NORMAL;
            else
                return CaloricLevel.FAT;
        }));

        //多级分组
        Map<String, Map<CaloricLevel, List<Dish>>> collect1 = menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() <= 400)
                return CaloricLevel.DIET;
            else if (dish.getCalories() <= 700)
                return CaloricLevel.NORMAL;
            else
                return CaloricLevel.FAT;
        })));

        //传递给第一个groupingBy的第二个收集器可以是任何类型，而不一定是另一个groupingBy
        //普通的单参数groupingBy(f)（其中f是分类函数）实际上是groupingBy(f,toList())的简便写法。
        Map<String, Long> collect2 = menu.stream().collect(groupingBy(Dish::getType, counting()));

        Map<String, Integer> collect3 = menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));

        Map<String, Set<CaloricLevel>> collect4 = menu.stream().collect(
                groupingBy(Dish::getType, mapping(
                        dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        },
                        toSet())));

        //分区器的好处在于保留了分区函数返回true或false的两套流元素列表。
        Map<Boolean, Map<String, List<Dish>>> collect5 = menu.stream().collect(
                partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
    }
}
