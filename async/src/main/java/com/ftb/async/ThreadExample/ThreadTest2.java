package com.ftb.async.ThreadExample;

import com.ftb.async.Utils.TaskUtil;

import java.time.Duration;
import java.time.Instant;

public class ThreadTest2 {

    public static void main(String[] args) {
        Instant inst1 = Instant.now();
        TaskUtil.taskA();
        TaskUtil.taskB();
        Instant inst2 = Instant.now();
        System.out.println("Difference in seconds : " + Duration.between(inst1, inst2).getSeconds());
    }
}
