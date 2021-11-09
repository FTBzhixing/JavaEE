package com.ftb.async.Utils;

public class TaskUtil {

    public static void threadTest1taskA(){
        Thread taskA = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("taskA");
        });
        taskA.start();
    }

    public static void threadTest1taskB(){
        Thread taskB = new Thread(() -> {
            System.out.println("taskB");
        });
        taskB.start();
    }
    public static void taskA() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("taskA");
    }

    public static void taskB() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("taskB");
    }
}
