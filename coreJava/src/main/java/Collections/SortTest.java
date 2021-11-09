package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(-5);
        arrayList.add(10);
        arrayList.add(1);
        System.out.println(arrayList);//[2, -5, 10, 1]
        Collections.reverse(arrayList);//[1, 10, -5, 2]
        Collections.sort(arrayList);//[-5, 1, 2, 10]
        Collections.shuffle(arrayList);//随机打散 [10, 1, 2, -5]

    }
}
