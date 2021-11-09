package ChapterTwo.Three;

import ChapterTwo.One.Apple;
import ChapterTwo.Two.ApplePredicate;

import java.util.ArrayList;
import java.util.List;


public class Filter {

    public static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
        ArrayList<T> result = new ArrayList<>();
        for (T e : inventory) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        //匿名类实现
        ArrayList<Apple> inventory = new ArrayList<>();
        List<Apple> list1 = ChapterTwo.Two.Filter.filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equalsIgnoreCase(apple.getColor());
            }
        });

        //Lambda表达式实现
        List<Apple> list2 = ChapterTwo.Two.Filter.filterApples(inventory, (apple) -> "red".equalsIgnoreCase(apple.getColor()));

        //Lambda泛型实现
        List<Apple> list3 = Filter.filter(inventory, (apple) -> "red".equalsIgnoreCase(apple.getColor()));

        ArrayList<Integer> numbers = new ArrayList<>();
        List<Integer> list4 = Filter.filter(numbers, (i) -> i % 2 == 0);

    }
}
