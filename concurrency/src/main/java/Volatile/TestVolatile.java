package Volatile;

/**
 * volatile关键字：当多个线程进行操作共享数据时，可以保证内存种的数据可见。即把自己线程中缓存的数据时时刻刻
 * 刷新到主存中。这种频繁刷新当然会影响执行效率，且加了volatile的字段无法进行jvm底层的重排序，但是它比sychonized互斥锁的效率要高的多。
 * 但是它不具备互斥性，且不能保证变量的原子性，
 */
public class TestVolatile {

    public static void main(String[] args) {

        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        while (true) {

            if (td.isFlag()) {
                System.out.println("------------------");
                break;
            }
        }
    }
}
