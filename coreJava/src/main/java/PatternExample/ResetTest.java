package PatternExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResetTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Java");
        String test = "Java";
        Matcher matcher = pattern.matcher(test);

        matcher.find();
        //返回Java
        System.out.println(matcher.group());
        //从起始位置重新匹配
        matcher.reset();

        matcher.find();
        //返回Java
        System.out.println(matcher.group());

        //返回false
        //相当于matcher = pattern.matcher("Python");
        matcher.reset("Python");
        System.out.println(matcher.find());
    }
}
