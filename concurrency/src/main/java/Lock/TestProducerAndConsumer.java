package Lock;

public class TestProducerAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(producer,"A").start();
        new Thread(consumer,"B").start();
    }
}
