package PatternExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupTest2 {
    public static void main(String[] args) {
        Pattern pattern1 = Pattern.compile("(?<p1>java)(python)");
        Matcher matcher1 = pattern1.matcher("java自由java之路javapython自由之路python");

        // 输出false，因为要满足整个字符串匹配正则才输出true
        System.out.println(matcher1.matches());
        // 输出false，因为要满足字符串以正则模式开头才输出true
        System.out.println(matcher1.lookingAt());

        // 输出分组数量：2
        // 加上默认分组其实有三个分组：javapython、java、python,
        // 打印的时候javapython这个默认分组是不打印的，但是匹配的时候是会被用到的
        int count = matcher1.groupCount();
        System.out.println("分组数量:" + count);

        while (matcher1.find()) {
            System.out.println("find str...");
            for (int i = 0; i <= count; i++) {
                int start = matcher1.start(i);
                int end = matcher1.end(i);
                String group = matcher1.group(i);
                System.out.println("start:end:group-->" + start + ":" + end + ":" + group);
            }
            // 通过分组名称来获取分组的值
            System.out.println("xxx-->" + matcher1.group("p1"));
        }
    }
}
