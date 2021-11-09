package test;

public class BigDog extends AbstractDog implements Dog{

    @Override
    public void eat(){
        System.out.println("BigDog eat");
    }

    @Override
    public void wolf() {

    }
    public static void main(String[] args) {
        BigDog bigDog = new BigDog();
        bigDog.eat();
    }
}
