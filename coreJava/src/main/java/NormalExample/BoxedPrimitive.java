package NormalExample;

import java.util.Comparator;

public class BoxedPrimitive {

    static Integer i;

    public static void main(String[] args) {

        Comparator<Integer> naturalOrder1 = (i, j) -> i < j ? -1 : (i == j ? 0 : 1);
        System.out.println(naturalOrder1.compare(new Integer(42), new Integer(42)));

        Comparator<Integer> naturalOrder2 = (a, b) -> {
            int i = a;
            int j = b;
            return i < j ? -1 : (i == j ? 0 : 1);
        };
        System.out.println(naturalOrder2.compare(new Integer(42), new Integer(42)));

        if (i == 42) {
            System.out.println("fang");
        }
    }

}
