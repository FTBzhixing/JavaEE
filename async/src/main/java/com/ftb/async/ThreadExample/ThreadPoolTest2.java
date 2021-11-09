package com.ftb.async.ThreadExample;

import com.ftb.async.Utils.TaskUtil;
import com.ftb.async.Utils.ThreadPoolUtil;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

//new NamedThreadFactory
//get方法确实可以在main函数所在线程获取到异步任务的执行结果，但是main线程必须以阻塞的代价来获取结果，在异步任务执行完毕前，main函数所在线程就不能做其他事情了
public class ThreadPoolTest2 {

    public static void main(String[] args) {
        ThreadPoolExecutor POOL_EXECUTOR = ThreadPoolUtil.getExecutor();
        Future<?> result = POOL_EXECUTOR.submit(TaskUtil::taskA);
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("end");
        ThreadPoolUtil.closeThreadPool(POOL_EXECUTOR);
    }
}
