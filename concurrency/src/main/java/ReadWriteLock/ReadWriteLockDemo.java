package ReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        TestReadWriteLock rw = new TestReadWriteLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                rw.set((int)(Math.random()*101));
            }
        },"Write").start();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rw.get();
                }
            },"Read").start();
        }
    }
}
