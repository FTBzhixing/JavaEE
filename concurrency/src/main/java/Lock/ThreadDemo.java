package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo implements Runnable {
    private int ticket = 100;
    //    private AtomicInteger ticket = new AtomicInteger(100);
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "    " + --ticket);
                }else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
