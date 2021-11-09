package com.ftb.async.CompletableFutureExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 基于thenCompose实现当一个CompletableFuture执行完毕后，执行另外一个CompletableFuture
 */
public class ThenCompose {
    // 1.异步任务，返回future
    public static CompletableFuture<String> doSomethingOne(String s) {
        // 1.1创建异步任务
        return CompletableFuture.supplyAsync(() -> {

            // 1.1.1休眠1s，模拟任务计算
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 1.1.2 解密，并返回结果
            return s;
        });

    }

    // 2.开启异步任务，返回future
    public static CompletableFuture<String> doSomethingTwo(String s) {
        return CompletableFuture.supplyAsync(() -> {

            // 2.1 休眠3s，模拟计算
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 2.2 查询公司信息，转换为str，并返回
            return s + " World";

        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = doSomethingOne("Hello").thenCompose(ThenCompose::doSomethingTwo);
        System.out.println(result.get());
    }
}
