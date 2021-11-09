package com.ftb.async.CompletableFutureExample;

import com.ftb.async.Utils.ThreadPoolUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

public class CompleteTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        ThreadPoolExecutor POOL_EXECUTOR = ThreadPoolUtil.getExecutor();

        // 2.开启线程计算任务结果，并设置
        POOL_EXECUTOR.execute(() -> {

            // 2.1休眠3s，模拟任务计算
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 2.2设置计算结果到future
            System.out.println("----" + Thread.currentThread().getName() + " set future result----");
            future.complete("hello,jiaduo");

        });

        // 3.等待计算结果
        System.out.println("---main thread wait future result---");
        System.out.println(future.get());
        System.out.println("---main thread got future result---");

        ThreadPoolUtil.closeThreadPool(POOL_EXECUTOR);
    }
}
