package Atomic;

/**
 * 一.i++的原子性问题，i++的操作上分为三个步骤"读-改-写"
 * int i=10;
 * i=i++//10
 *
 * int temp=i;
 * i=i+1;
 * i=temp;
 *
 * 二.原子变量:jdk1.5后java.util.concurrent.atomic包下常用的原子变量
 * 它是如何实现原子性的呢
 * 1.它里面所有的字段都是带volatile的
 * 2.CAS算法保证数据的原子性，CAS算法是硬件对于并发操作共享数据的支持，CAS包含三个操作数
 * 内存值V，执行逻辑后一段时间后原先的内存值V，用A代替，更新值B，当且仅当V==A时，V==B时，才执行逻辑，否则，将不做任何操作。
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(ad).start();
        }
    }
}
