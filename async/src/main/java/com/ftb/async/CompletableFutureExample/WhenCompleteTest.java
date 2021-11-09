package com.ftb.async.CompletableFutureExample;


import com.ftb.async.Utils.ThreadPoolUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * 这里代码3挂起了main函数所在线程，是因为具体执行异步任务的是ForkJoin的commonPool线程池，其中线程都是Deamon线程，
 * 所以，当唯一的用户线程main线程退出后整个JVM进程就退出了，会导致异步任务得不到执行
 * 所以，由此看来，在使用CompletableFuture系列方法的时候，不能使用它的默认线程池！！！！！！！！！！！！！！！！！
 */
public class WhenCompleteTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolExecutor executor = ThreadPoolUtil.getExecutor();
        // 1.创建一个CompletableFuture对象
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

            // 1.1模拟异步任务执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 1.2返回计算结果
            return "hello";
        },executor);

        // 2.添加回调函数
        future.whenComplete((t, u) -> {

            // 2.1如果没有异常，打印异步任务结果
            if (null == u) {
                System.out.println(t + " world");
            } else {
                // 2.2打印异常信息
                System.out.println(u.getLocalizedMessage());

            }
        });

        // 3.挂起当前线程，等待异步任务执行完毕
//        Thread.currentThread().join();
        ThreadPoolUtil.closeThreadPool(executor);
    }
}
