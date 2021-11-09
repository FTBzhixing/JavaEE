package Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo implements Runnable{
    private AtomicInteger serialNumber=new AtomicInteger();

    public int getSerialNumber() {
        //i++
        return serialNumber.getAndIncrement();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getSerialNumber());
    }


}
