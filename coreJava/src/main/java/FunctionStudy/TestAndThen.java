package FunctionStudy;

import java.util.function.Function;

/**
 * 理解了compose()方法，对于这个方法来说就比较容易理解了，跟compose()恰恰相反，也就是先执行当前函数，然后再执行andThen()方法传参的函数，
 */
public class TestAndThen {
    public static int testFunction(int i, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(i);
    }

    public static void main(String[] args) {
        System.out.println(testFunction(2, i -> i * 2 + 1, j -> j * j));
    }
}
