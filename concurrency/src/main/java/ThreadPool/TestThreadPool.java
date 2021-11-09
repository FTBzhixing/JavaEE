package ThreadPool;

import java.util.concurrent.*;

/**
 * 线程池的体系结构:
 * java.util.concurrent.Executor:负责线程的使用和调度的根接口
 *      ExecutorService 子接口:线程池的主要接口
 *          ThreadPoolExecutor 实现类
 *          ScheduledExecutorService 子接口：负责线程的调度
 *              ScheduledThreadPoolExecutor 继承了ThreadPoolExecutor又实现了ScheduledExecutorService
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        ThreadPoolDemo demo = new ThreadPoolDemo();
        for (int i = 0; i < 10; i++) {
            pool.submit(demo);
        }

        Future<Integer> future = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum += i;
                }
                return sum;
            }
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}

class ThreadPoolDemo implements Runnable{
    private int i=0;
    @Override
    public void run() {
        while (i<=100){
            System.out.println(Thread.currentThread().getName()+" : "+i++);
        }
    }
}
