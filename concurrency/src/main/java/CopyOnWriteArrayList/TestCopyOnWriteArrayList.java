package CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(threadDemo).start();
        }
    }
}
