package javastudy.effectiveJava.Chapter4_ClassAndInterface.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class SetWithInheritance {

    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("boom","pow","kaboom"));

        System.out.println(s.getAddCount());//6
    }

}

class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;// 3->4->5->6
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();//3
        return super.addAll(c);//Set(super)의 addAll은 add를 호출함 -> Set의 add는 override되어 override된 버전인 본인의 add가 호출됨
    }

    public int getAddCount() {
        return addCount;
    }
}