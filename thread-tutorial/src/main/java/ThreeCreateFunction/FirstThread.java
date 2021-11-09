package ThreeCreateFunction;

public class FirstThread extends Thread {

    private int i;

    @Override
    public void run() {
        for (; i < 20; i++) {
            System.out.println(getName() + " " + getId() + " " + getState() + " " + getThreadGroup() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {

            System.out.println(Thread.currentThread().getName() + " " + i);
            if (10 == i) {

                new FirstThread().start();
                new FirstThread().start();
            }
        }
    }
}
