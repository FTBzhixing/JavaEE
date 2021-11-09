package ThreadNotify;

import java.util.concurrent.ArrayBlockingQueue;

public class ThirdCondition extends Thread {
    private ArrayBlockingQueue<String> bq;

    public ThirdCondition(ArrayBlockingQueue<String> bq) {

        this.bq = bq;
    }

    public void run() {

        String[] strArr = {"java", "C++", "Cobol"};
        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + "生产者准备生产集合元素");
            try {
                Thread.sleep(1000);
                bq.put(strArr[i % 3]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "生产完成" + bq);
        }
    }
}

class Consumer extends Thread {

    private ArrayBlockingQueue<String> bq;

    public Consumer(ArrayBlockingQueue<String> bq) {
        this.bq = bq;
    }

    public void run() {

        while (true) {
            System.out.println(getName() + "消费者准备消费集合元素");

            try {
                Thread.sleep(200);
                bq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "消费完成" + bq);
        }

    }

    public static void main(String[] args) {

        ArrayBlockingQueue bq = new ArrayBlockingQueue<String>(1);
        new ThirdCondition(bq).start();
        new ThirdCondition(bq).start();
        new ThirdCondition(bq).start();
        new Consumer(bq).start();

    }
}
