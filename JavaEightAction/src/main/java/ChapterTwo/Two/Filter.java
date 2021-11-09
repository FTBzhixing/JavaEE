package ChapterTwo.Two;

import ChapterTwo.One.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为参数化
 */
public class Filter {
    public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p){
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
