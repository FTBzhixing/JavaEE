package com.ftb.async.CompletableFutureExample;

import com.ftb.async.Utils.ThreadPoolUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 基于supplyAsync系列方法实现有返回值的异步计算
 * 默认情况下，supplyAsync方法是使用整个JVM内唯一的ForkJoinPool.commonPool()线程池来执行异步任务的，方法允许我们使用自己制定的线程池来执行异步任务
 */
public class SupplyAsyncTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = ThreadPoolUtil.getExecutor();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "AAA";
        }, executor);
        future.complete("BBB");

        System.out.println(future.get());
        ThreadPoolUtil.closeThreadPool(executor);
    }
}
