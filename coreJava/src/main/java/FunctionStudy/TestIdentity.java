package FunctionStudy;

import java.util.function.Function;

public class TestIdentity {
    public static Function<Object, Object> testFunction(int i, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return Function.identity();
    }

}
