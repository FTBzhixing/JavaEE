package ThreadNotify;

public class FirstCondition {
//wait(),notify(),notifyAll()必须和synchronized配合使用
//这里表示在加了同步监视器的方法内，若满足某条件，则将当前线程置于等待状态，然后取唤醒其他线程
//notify是唤醒在此对象的监视器上等待的单个线程。 如果有任何线程正在等待该对象，则选择其中一个线程被唤醒，且是随机的，notifyAll是唤醒所有线程
    public synchronized void test(){
        try{
            if(false){
                wait();
            }else {
                notify();
                notifyAll();
            }

        }catch (Exception e){

        }
    }
}
