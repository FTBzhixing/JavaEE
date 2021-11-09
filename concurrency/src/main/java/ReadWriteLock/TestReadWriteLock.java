package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {
    private int number = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " : " + number);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void set(int number){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());
            this.number=number;
        }finally {
            lock.writeLock().unlock();
        }
    }
}
