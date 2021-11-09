package Lock;

/**
 * 使用wait notify关键字时要记住两个点
 * 1.wait是阻塞线程并释放锁资源的，当它再次被唤醒时，会从当前位置继续执行。所以在写逻辑时一定要注意
 * 2.wait存在虚假唤醒的情况。比如在有两个生产者和两个消费者时，假设product为0，生产者生产一个product后，唤醒其他所有进程，被两个消费者线程分别抢到锁
 * 那他们都会接着wait执行下去，使得product会变成负数
 * 在object类的方法介绍里有介绍，一定要把wait放在while循环里去执行
 */
public class Clerk {
    private int product = 0;

    public synchronized void get() {
        while (product >= 1) {
            System.out.println("产品已满!");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + ++product);
        this.notifyAll();

    }

    public synchronized void sale() {
        while (product <= 0) {
            System.out.println("缺货！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + --product);
        this.notify();

    }
}
