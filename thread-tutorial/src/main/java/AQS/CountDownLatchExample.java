package AQS;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    // 请求的数量
    private static final int threadCount = 10;


    public static void main(String[] args) throws InterruptedException {
        Map map = new HashMap<Integer, Integer>();
        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            threadPool.execute(() -> {// Lambda 表达式的运用
                try {
                    test(threadnum, map);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();// 表示一个请求已经被完成
                }

            });
            map.put(threadnum, threadnum);
//            System.out.println("----------------------------" + map.get(threadnum));
        }
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("finish");
    }

    public synchronized static void test(int threadnum, Map map) throws InterruptedException {
//        Thread.sleep(1000);// 模拟请求的耗时操作
        System.out.println("threadnum:" + threadnum);
        System.out.println("----------------------------" + threadnum);
//        Thread.sleep(1000);// 模拟请求的耗时操作
    }
}
