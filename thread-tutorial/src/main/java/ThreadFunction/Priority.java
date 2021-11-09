package ThreadFunction;

import java.util.concurrent.FutureTask;

public class Priority {

    public static void main(String[] args) {
//priority是线程的优先级，可以设置成1-10的数字，但是不推荐设置数字，因为不同的系统环境对优先级的支持级别可能不一样，建议设置成静态参数
        Thread.currentThread().setPriority(Thread.NORM_PRIORITY);

        FutureTask<Integer> task = new FutureTask<Integer>(() -> {
            int i = 0;
            for (; i < 5; i++) {

                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            return i;
        });

        for (int i = 0; i < 30; i++) {

            System.out.println(Thread.currentThread().getName() + "变量值i = " + i);

            if (10 == i) {

                Thread low = new Thread(task, "Thread1");
                low.start();
                System.out.println("开始的优先级" + "low="+low.getPriority());
                low.setPriority(Thread.MIN_PRIORITY);
                System.out.println(Thread.currentThread().getName() + " " + i);

            }

            if (20 == i) {

                Thread high = new Thread(task, "Thread2");
                high.start();
                System.out.println("开始的优先级" + "high="+high.getPriority());
                high.setPriority(Thread.MAX_PRIORITY);
                System.out.println(Thread.currentThread().getName() + " " + i);

            }
        }
    }
}
