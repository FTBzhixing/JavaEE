package com.ftb.async.CompletableFutureExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 基于runAsync系列方法实现无返回值的异步计算
 * 默认情况下，runAsync方法是使用整个JVM内唯一的ForkJoinPool.commonPool()线程池来执行异步任务的，方法允许我们使用自己制定的线程池来执行异步任务
 */
public class runAsyncTest {
    public static void main(String[] args) {
        // 1.1创建异步任务，并返回future
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {


            // 1.1.1休眠2s模拟任务计算
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("over");

        });

        // 1.2 同步等待异步任务执行结束
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
