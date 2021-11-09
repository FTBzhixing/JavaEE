package ThreadLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lock对锁操控的灵活性比sync高的多，在此列出的是最基础的用法，更多的用法去看javadoc8
 */
public class FirstLock {

    private final ReentrantLock lock = new ReentrantLock();

    public void run() {

        lock.lock();
        try {
            //需要保证线程安全的代码

        } catch (Exception e) {

        } finally {
            // 通常在finally里设置是否要释放锁
            lock.unlock();
        }
    }
}
