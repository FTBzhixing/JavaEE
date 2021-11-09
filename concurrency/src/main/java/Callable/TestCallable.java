package Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        FutureTask<Integer> task = new FutureTask<>(threadDemo);
        new Thread(task).start();
        try {
            /**
             * 当 new Thread(task).start()在运行的时候，get方法不会执行，所以futuretask也是可以用于闭锁的
             */
            Integer num = task.get();
            System.out.println(num);
            System.out.println("----------------------------");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
