package Collections;

import java.util.*;

public class ControlTest {
    public static void main(String[] args) {
        Collections.synchronizedList(new ArrayList<>());
        Collections.synchronizedMap(new HashMap<>());
        Collections.synchronizedSet(new HashSet<>());

        //创建一个空的，不可变的List对象
        List<Object> objects = Collections.emptyList();
        //创建一个只要一个元素的，且不可变的Set对象
        Set<String> fang = Collections.singleton("fang");
        //返回普通的Map对象对应的不可变版本
        Map<Object, Object> objectObjectMap = Collections.unmodifiableMap(new HashMap<>());
    }
}
