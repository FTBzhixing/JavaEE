package ChapterTwo.Four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * java.util.function.Function<T, R>接口定义了一个叫作apply的方法，它接受一个
 * 泛型T的对象，并返回一个泛型R的对象。如果你需要定义一个Lambda，将输入对象的信息映射 到输出，就可以使用这个接口（比如提取苹果的重量，或把字符串映射为它的长度）
 */
public class FunctionTest {
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        ArrayList<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        map(Arrays.asList("java", "cobol", "cpp"), String::length).forEach(System.out::println);
    }
}
