package CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁，在完成某些运算时，只有其他所有线程的运算全部完成，当前运算才继续执行
 * CountDownLatc类似于一个倒计时，每次有个线程完成时，都递减1，当所有线程都结束时，才会去执行主线程的操作
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        LatchDemo latchDemo = new LatchDemo(countDownLatch);

        for (int i = 0; i < 5; i++) {
            new Thread(latchDemo).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("complete");


    }
}
