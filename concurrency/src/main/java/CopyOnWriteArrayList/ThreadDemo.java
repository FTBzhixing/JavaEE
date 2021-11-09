package CopyOnWriteArrayList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadDemo implements Runnable {
    //之前使用线程安全容器的方法，这种方法存在并发修改异常的问题
//    private static List<String> list= Collections.synchronizedList(new ArrayList<String>());

    //当写入时，底层会复制出一个新的链表，再进行写入，所以就不会存在并发修改异常问题，但是这种操作不适合添加操作过多的情况，适合迭代操作多的情况
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            list.add("AA");
        }
    }
}
