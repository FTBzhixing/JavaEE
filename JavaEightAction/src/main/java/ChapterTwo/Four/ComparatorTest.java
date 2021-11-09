package ChapterTwo.Four;

import ChapterTwo.One.Apple;

import java.util.ArrayList;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public class ComparatorTest {
    public static void main(String[] args) {
        Comparator<Apple> comparing = comparing(Apple::getWeight);
        ArrayList<Apple> inventory = new ArrayList<>();
        //逆序
        inventory.sort(comparing.reversed());

        //比较器链
        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));

    }
}
