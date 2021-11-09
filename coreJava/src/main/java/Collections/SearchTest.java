package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchTest {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(-5);
        arrayList.add(10);
        arrayList.add(1);

        System.out.println(Collections.max(arrayList));
        System.out.println(Collections.min(arrayList));
        Collections.replaceAll(arrayList,1,0);//把集合中的1都用0代替
        Collections.frequency(arrayList,-5);//判断集合中的-5的次数
        System.out.println(Collections.binarySearch(arrayList, 2));
    }
}
