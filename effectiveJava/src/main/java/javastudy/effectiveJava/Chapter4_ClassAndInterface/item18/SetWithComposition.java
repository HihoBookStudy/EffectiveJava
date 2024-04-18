package javastudy.effectiveJava.Chapter4_ClassAndInterface.item18;

import java.util.*;

public class SetWithComposition {

    public static void main(String[] args) {
        InstrumentSet<String> s = new InstrumentSet<>(new HashSet<>());
        s.addAll(List.of("boom", "pow", "kaboom"));
        System.out.println(s.getAddCount());//3
    }

}


class InstrumentSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);//본인의 add 메소드(addCount와 관련있음) 가 아닌 ForwardingSet의 addAll메소드를 호출함(addCount와 관련없음)
    }

    public int getAddCount() {
        return this.addCount;
    }
}

class ForwardingSet<E> implements Set<E> {
    private final Set<E> s;

    public ForwardingSet(Set<E> s) {
        this.s = s;
    }

    public void clear() {
        s.clear();
    }

    public boolean contains(Object o) {
        return s.contains(o);
    }

    public boolean isEmpty() {
        return s.isEmpty();
    }

    public int size() {
        return s.size();
    }

    public Iterator<E> iterator() {
        return s.iterator();
    }

    public boolean add(E e) {
        return s.add(e);
    }

    public boolean remove(Object o) {
        return s.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return s.containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        return s.addAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return s.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return s.retainAll(c);
    }

    public Object[] toArray() {
        return s.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return s.toArray(a);
    }

    @Override
    public boolean equals(Object o) {
        return s.equals(o);
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public String toString() {
        return s.toString();
    }
}
