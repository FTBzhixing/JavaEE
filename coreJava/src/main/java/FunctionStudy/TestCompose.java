package FunctionStudy;

import java.util.function.Function;

/**
 * Compose:接收一个function类型的函数作为参数
 * 实际意思是对于输入参数，首先会执行compose参数中的函数，即j -> j * j，再将这个结果作为参数拿去执行apply参数中的函数i -> i * 2 + 1
 */
public class TestCompose {
    public static int testFunction(int i, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(i);
    }

    public static void main(String[] args) {
        System.out.println(testFunction(2, i -> i * 2 + 1, j -> j * j));
    }
}
