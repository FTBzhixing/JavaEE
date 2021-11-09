package com.ftb.async.CompletableFutureExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenCombine {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = ThenCompose.doSomethingOne("123")
                .thenCombine(ThenCompose.doSomethingTwo("456"), (one, two) -> {
            return one + " " + two;
        });
        System.out.println(result.get());
    }
}
