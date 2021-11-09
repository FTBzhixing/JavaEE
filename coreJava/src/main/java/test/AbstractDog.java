package test;

public class AbstractDog {
    void eat(){
        System.out.println("AbstractDog eat");
    }

    public static void main(String[] args) {
        AbstractDog abstractDog = new AbstractDog();
        abstractDog.eat();
    }
}
