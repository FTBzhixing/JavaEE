import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCAlternate {
    private int number = 1;

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private void loopA(int totalLoop) {
        lock.lock();
        try {
            if (number != 1) {
                condition1.await();
            }

            System.out.println(Thread.currentThread().getName() + "\t" + totalLoop);
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void loopB(int totalLoop) {
        lock.lock();
        try {
            if (number != 2) {
                condition2.await();
            }

            System.out.println(Thread.currentThread().getName() + "\t" + totalLoop);
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void loopC(int totalLoop) {
        lock.lock();
        try {
            if (number != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + totalLoop);

            number = 3;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        number = 1;

    }

    public static void main(String[] args) {
        ABCAlternate ad = new ABCAlternate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    ad.loopA(i);

                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 20; i++) {
                    ad.loopB(i);

                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 20; i++) {
                    ad.loopC(i);
                    System.out.println("----------------------");
                }
            }
        }, "C").start();
    }
}
