package FunctionStudy;

import java.util.function.Function;

/**
 * apply:将给定的参数应用到这个函数上,传入的参数类型为T返回类型为R
 */
public class TestApply {
    public static String testFunction(int i, Function<Integer, String> function) {
        if (2 == i) {
            return function.apply(i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(testFunction(2, i -> "fang"));
    }
}
