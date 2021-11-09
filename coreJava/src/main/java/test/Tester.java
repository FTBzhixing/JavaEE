package test;

import java.util.concurrent.ThreadLocalRandom;

public class Tester {
    static <T> T[] toArray(T... args) {
        return args;
    }

    public static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(b, c);
            case 2:
                return toArray(a, c);
        }
        throw new AssertionError();
    }

    public static void main(String[] args) {
        String[] strings = pickTwo("fang", "teng", "bo");

    }
}
