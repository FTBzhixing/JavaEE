package com.ftb.async.ThreadExample;

import com.ftb.async.Utils.TaskUtil;

import java.time.Duration;
import java.time.Instant;

/**
 * 异步执行，比ThreadTest2顺序执行快了2s
 */
public class ThreadTest3 {

    public static void main(String[] args) {
        Instant inst1 = Instant.now();
        Thread thread = new Thread(TaskUtil::taskA, "threadA");
        thread.start();
        TaskUtil.taskB();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant inst2 = Instant.now();
        System.out.println("Difference in seconds : " + Duration.between(inst1, inst2).getSeconds());
    }
}
