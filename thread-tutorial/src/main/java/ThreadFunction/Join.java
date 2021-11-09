package ThreadFunction;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Join {

    public static void main(String[] args) {

        FutureTask<Integer> task = new FutureTask<Integer>(() -> {

            int i = 0;
            for (; i < 20; i++) {

                System.out.println(Thread.currentThread().getName() + " " + i);
            }

            return i;
        });


        for (int i = 0; i < 20; i++) {

            System.out.println(Thread.currentThread() + " " + i);

            if (10 == i) {

                Thread thread = new Thread(task, "Thread1");
                thread.start();

                try {
                    thread.join();
                    //调用get方法会导致程序阻塞，必须等到子线程结束时才会得到返回值
                    System.out.println("线程返回值" + task.get());

                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
