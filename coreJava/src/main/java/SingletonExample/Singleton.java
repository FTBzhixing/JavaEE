package SingletonExample;

public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton(){};

    public static Singleton getInstance(){

        return instance;

    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
