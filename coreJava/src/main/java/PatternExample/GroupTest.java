package PatternExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupTest {
    //组是用括号划分的正则表达式，可以根据组的编号来引用这个组。组号为0表示整个表达式，组号为1表示被第一对括号括起的组，
    // 依次类推，例如A(B(C))D，组0是ABCD，组1是BC，组2是C。
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(java)");
        Matcher matcher = pattern.matcher("12java自由java之路");

        int groupCount = matcher.groupCount();
        System.out.println(groupCount);
        groupCount = matcher.groupCount();
        System.out.println(groupCount);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group();
            System.out.println("start:end:group-->" + start + ":" + end + ":" + group);
        }
    }
}
