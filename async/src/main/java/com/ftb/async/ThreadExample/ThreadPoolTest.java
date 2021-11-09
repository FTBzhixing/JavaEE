package com.ftb.async.ThreadExample;

import com.ftb.async.Utils.TaskUtil;
import com.ftb.async.Utils.ThreadPoolUtil;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {

    //线程池默认的ThreadFactory创建的线程是用户线程，这些线程存在于线程池中，线程池里的核心线程  是会一直存在的，如果没有任务
    //就会阻塞，而只要当前线程中有用户线程，由于守护线程的存在，程序就不会退出，所以使用线程池时必须要关闭。
    public static void main(String[] args) {
        Instant inst1 = Instant.now();
        ThreadPoolExecutor POOL_EXECUTOR = ThreadPoolUtil.getExecutor();
        POOL_EXECUTOR.execute(TaskUtil::taskA);
        POOL_EXECUTOR.execute(TaskUtil::taskB);
        Instant inst2 = Instant.now();
        System.out.println("Difference in seconds : " + Duration.between(inst1, inst2).getSeconds());
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadPoolUtil.closeThreadPool(POOL_EXECUTOR);
    }
}
