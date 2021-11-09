package PatternExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppendTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Java");
        Matcher matcher = pattern.matcher("Java1234");

//返回true
        System.out.println(matcher.find());
        StringBuffer sb = new StringBuffer();

        matcher.appendReplacement(sb, "Python");
//输出Python
        System.out.println(sb);

        matcher.appendTail(sb);
//输出Python1234
        System.out.println(sb);
    }
}
