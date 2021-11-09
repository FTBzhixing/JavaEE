package ThreeCreateFunction;

public class SecondThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {

            //当线程类实现Runnable接口时，想要获取当前线程的状态只能调用Thread.currentThread()
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {

            System.out.println(Thread.currentThread().getName() + " " + i);

            if(10==i){

                SecondThread st = new SecondThread();
                //通过new Thread(target,name)创建
                new Thread(st,"Thread1").start();
                new Thread(st,"Thread2").start();

            }
        }
    }
}
