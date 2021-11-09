package ThreadSync;

/**
 * 线程释放同步监视器的情况
 * 1.同步方法和同步代码块执行结束
 * 2.同步方法和同步代码块执行过程中遇到break和return
 * 3.同步方法和同步代码块执行过程中遇到了未处理的error和exception
 * 4.执行过程中调用了wait方法
 * 线程不是放同步监视器的情况
 * 1.同步方法和同步代码块执行过程中程序调用sleep或yield
 * 2.同步方法执行过程中程序调用了suspend
 */

public class ThreeSyncFunction implements Runnable {

    private Double count;

    @Override
    //同步方法
    public synchronized void run() {
//        同步代码块
//        synchronized (count)

    }
}
