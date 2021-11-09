package PatternExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegionTest {
    public static void main(String[] args) {
        //find方法只能制定开始下标。但是region可以指定一个范围。
        Pattern pattern = Pattern.compile("Java");
        String test = "123JavaJava";
        Matcher matcher = pattern.matcher(test);
        matcher.region(7, 11);
        // 返回7
        System.out.println(matcher.regionStart());
        // 返回11
        System.out.println(matcher.regionEnd());
        matcher.find();
        //返回 Java
        System.out.println(matcher.group());
    }
}
