package ThreadFunction;

public class Sleep {

    public static void main(String[] args) throws InterruptedException {

            System.out.println(System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis());

    }
}
