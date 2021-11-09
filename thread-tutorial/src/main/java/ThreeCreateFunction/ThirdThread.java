package ThreeCreateFunction;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThirdThread  {

    public static void main(String[] args) {

        FutureTask<Integer> task = new FutureTask<Integer>(()->{
            int i = 0;
            for (; i < 20; i++) {

                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            return i;
        });


        for (int i = 0; i < 20; i++) {

            System.out.println(Thread.currentThread().getName() + "变量值i = " + i);

            if (10 == i) {

                new Thread(task, "Thread1").start();
                try {

                    //调用get方法会导致程序阻塞，必须等到子线程结束时才会得到返回值
                    System.out.println("线程返回值" + task.get());
                    System.out.println(task.isCancelled());
                    System.out.println(task.isDone());

                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
