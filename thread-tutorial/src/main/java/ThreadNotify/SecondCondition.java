package ThreadNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 和firstCondition的实现是一样的
 */
public class SecondCondition {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();

    public void test() {
        //加锁
        lock.lock();
        try {

            if (false) {
                cond.wait();
            } else {
                cond.signal();
                cond.signalAll();
            }

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}
