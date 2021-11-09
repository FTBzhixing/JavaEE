package FunctionStudy;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class TestBinaryOperator {
    private static int testFunction(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);

    }

    private static String getShort(String a, String b, Comparator<String> comparator){
        return BinaryOperator.minBy(comparator).apply(a,b);
    }

    private static String getLong(String a, String b, Comparator<String> comparator){
        return BinaryOperator.maxBy(comparator).apply(a,b);
    }

    public static void main(String[] args) {
        System.out.println(TestBinaryOperator.testFunction(1, 2, (a, b) -> a + b));
        System.out.println(TestBinaryOperator.testFunction(1, 2, (a, b) -> a - b));
        System.out.println(TestBinaryOperator.testFunction(1, 2, (a, b) -> a * b));
        System.out.println(TestBinaryOperator.testFunction(1, 2, (a, b) -> a / b));

        System.out.println(TestBinaryOperator.getShort("Java","Cobol",(a,b)->a.length()-b.length()));
        System.out.println(TestBinaryOperator.getLong("Java","Cobol",(a,b)->a.length()-b.length()));

    }
}
