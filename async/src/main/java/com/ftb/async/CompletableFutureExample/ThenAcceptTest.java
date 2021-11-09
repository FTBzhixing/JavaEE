package com.ftb.async.CompletableFutureExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 基于thenAccept实现异步任务A，执行完毕后，激活异步任务B执行，这种方式激活的异步任务B是可以拿到任务A的执行结果的：
 */
public class ThenAcceptTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.创建异步任务，并返回future
        CompletableFuture<String> oneFuture = CompletableFuture.supplyAsync(() -> {

            // 1.1休眠2s，模拟任务计算
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 1.2返回计算结果
            return "hello";
        });
        // 2.在future上施加事件，当future计算完成后回调该事件，并返回新future
        CompletableFuture<Void> twoFuture = oneFuture.thenAccept(t -> {

            // 2.1.1对oneFuture返回的结果进行加工
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("---after oneFuture over doSomething---" + t);
        });

        // 3.同步等待twoFuture对应的任务完成，返回结果固定为null
        System.out.println(twoFuture.get());
    }
}
