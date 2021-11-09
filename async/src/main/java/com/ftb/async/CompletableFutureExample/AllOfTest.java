package com.ftb.async.CompletableFutureExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AllOfTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.创建future列表
        List<CompletableFuture<String>> futureList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            futureList.add(ThenCompose.doSomethingOne(String.valueOf(i)));
        }

        // 2.转换多个future为一个
        CompletableFuture<Void> result = CompletableFuture
                .allOf(futureList.toArray(new CompletableFuture[futureList.size()]));

        // 3.等待所有future都完成
        System.out.println(result.get());
    }
}
