package ChapterTwo.Four;

import ChapterTwo.One.Apple;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * java.util.function.Predicate<T>接口定义了一个名叫test的抽象方法，它接受泛型T对象，并返回一个boolean。
 */
public class PredicateTest {
    public static <T> String testInterfaceTest(T s, Predicate<T> flag) {

        return flag.test(s) ? "handsome" : "ugly";
    }

    public static void main(String[] args) {

        System.out.println(testInterfaceTest("fang", "fang"::equalsIgnoreCase));

        //使用negate方法来返回一个Predicate的非，比如苹果不是红的
        Predicate<Apple> redApple = apple -> "red".equalsIgnoreCase(apple.getColor());
        Predicate<Apple> notRedApple = Objects.requireNonNull(redApple).negate();

        //把两个Lambda用and方法组合起来，比如一个苹果既是红色又比较重
        Predicate<Apple> redAndHeavyApple = redApple.and(apple -> apple.getWeight() > 150);


    }
}
