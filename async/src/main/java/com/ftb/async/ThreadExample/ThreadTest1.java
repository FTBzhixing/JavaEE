package com.ftb.async.ThreadExample;

import com.ftb.async.Utils.TaskUtil;

/**
 * 多线程调用写在方法里是异步得，方法调用顺序并不会影响线程得执行
 */
public class ThreadTest1 {

    public static void main(String[] args) throws InterruptedException {
        TaskUtil.threadTest1taskA();
        TaskUtil.threadTest1taskB();
        //这里打印顺序为A taskB B taskA，main线程和taskA，taskB线程是异步得

        System.out.println("A");
        Thread.sleep(3000);
        System.out.println("B");
    }
}
