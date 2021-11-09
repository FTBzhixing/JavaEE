import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] ary = str.split(","); // 预期大于 3，结果是 3
        System.out.println(ary.length);

        List list = new ArrayList<String>();
        list.add("String");
        list.add("num");
        ArrayList arrayList = (ArrayList) list.subList(0, 1);
        System.out.println(arrayList);
        HashMap<Object, Object> map = new HashMap<>();
        map.entrySet();
    }
}
