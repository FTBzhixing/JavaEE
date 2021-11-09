package com.ftb.async.AsyncAnnotationExample;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.CompletableFuture;

@EnableAsync
public class AsyncTest {

    @Async
    public  CompletableFuture<String> doSomething() {
        // 1.创建future
        CompletableFuture<String> result = new CompletableFuture<String>();
        // 2.模拟任务执行
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "doSomething");
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.complete("done");

        // 3.返回结果
        return result;

    }


}
