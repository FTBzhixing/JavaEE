package PatternExample;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PatternTest {
    public static void main(String[] args) {
        //Pattern类用于创建一个正则表达式，也可以说是创建一个匹配模式，可以通过两个静态方法创建
        Pattern pattern = Pattern.compile("Java");
        Pattern cobol = Pattern.compile("cobol", Pattern.CASE_INSENSITIVE);//第二个参数flag为匹配模式，Pattern.CASE_INSENSITIVE表示忽略大小写

        //根据匹配模式拆分输入序列
        //当limit值大于所能返回的字符串的最多个数或者为负数，返回的字符串个数将不受限制，
        //但结尾可能包含空串，而当limit=0时与split(CharSequence input)等价，但结尾的空串会被丢弃。
        String s1="123Java456Java789Java";
        Arrays.stream(pattern.split(s1)).forEach(System.out::println);

        //Matcher类提供了对正则表达式的分组支持,以及对正则表达式的多次匹配支持
        String s4="Java";
        String s2="Java123";
        String s3="Java1234";
        Matcher matcher = pattern.matcher(s2);
        Matcher matcher1 = pattern.matcher(s4);
        // matches方法需要整个字符串都匹配正则才返回true
        System.out.println(matcher1.matches());

        // lookingAt需要字符串是以正则模式开头，才返回true
        System.out.println(matcher.lookingAt());

        //find可以对任意位置字符串匹配,其中start为起始查找索引值，只要有匹配到的就返回true
        matcher.reset();
        System.out.println(matcher.find());
    }


}
