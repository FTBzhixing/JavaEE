package FunctionStudy;

import java.util.function.BiFunction;

public class TestBiFunction {
    private static int testFunction(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);

    }

    public static void main(String[] args) {
        System.out.println(TestBiFunction.testFunction(1, 2, (a, b) -> a + b));
        System.out.println(TestBiFunction.testFunction(1, 2, (a, b) -> a - b));
        System.out.println(TestBiFunction.testFunction(1, 2, (a, b) -> a * b));
        System.out.println(TestBiFunction.testFunction(1, 2, (a, b) -> a / b));
    }
}
