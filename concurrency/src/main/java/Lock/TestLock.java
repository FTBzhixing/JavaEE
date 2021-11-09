package Lock;

/**
 * 一.用于解决多线程安全问题的方式
 * sychronized:隐式锁
 * 1.同步代码块
 * 2.同步方法
 *
 * jdk1.5以后
 * 3.同步锁Lock
 * 注意：是一个显示锁，需要通过lock()方法上锁，必须通过unlock()方法释放锁
 * 为了保证unlock方法一定会执行，应该把它放在finally里，但是就算如此也不是一定会执行
 * 而sychronized锁的释放是jvm底层实现的
 */
public class TestLock {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(threadDemo).start();
        }
    }
}
