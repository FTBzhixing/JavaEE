package ReflectExample;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Class<? extends Set<String>> c1 = null;
        try {
            c1 = (Class<? extends Set<String>>) Class.forName("java.util.Set<>");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        Constructor<? extends Set<String>> cons = null;
        try {
            cons = c1.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Set<String> s= null;
        try{
            s = cons.newInstance();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        s.add("fang");
        s.forEach(System.out::println);

        BigInteger bigInteger = new BigInteger("123");
    }
}
