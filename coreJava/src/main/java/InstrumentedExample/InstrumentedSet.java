package InstrumentedExample;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class InstrumentedSet<E> extends ForwardingSet<E> {

    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    public int getAddCount() {
        return addCount;
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    //可以用于接受set集合将其直接转为我们自定义的InstrumentedSet以便处理。
    public static void test(Set<String> strings) {
        InstrumentedSet<String> set = new InstrumentedSet<>(strings);
    }

    public static void main(String[] args) {
        TreeSet<Object> treeSet = new TreeSet<>();
        HashSet<Object> hashSet = new HashSet<>();

        Set instrumentedSet = new InstrumentedSet<>(treeSet);
        Set instrumentedSet1 = new InstrumentedSet<>(hashSet);


    }
}
