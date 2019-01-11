/**
 * Created by yujingchen on 11/14/17.
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ForwardingSet<E> implements Set<E> {
    private final Set<E> s;

    public ForwardingSet(Set<E> s){ this.s = s; }
    @Override public boolean equals(Object o){ return s.equals(o);  }
    @Override public int hashCode() { return s.hashCode(); }
    @Override public String  toString() { return s.toString(); }
    @Override public int size() {return s.size();}
    @Override public boolean isEmpty() {return s.isEmpty();}
    @Override public boolean contains(Object o) {return s.contains(o);}
    @Override public Iterator<E> iterator() {return s.iterator();}
    @Override public Object[] toArray() {return new Object[0];}
    @Override public <T> T[] toArray(T[] a) {return s.toArray(a);}
    public boolean add(E e) { return s.add(e); }
    public boolean remove(Object o){ return s.remove(o); }
    @Override public boolean containsAll(Collection<?> c) {return s.contains(c);}
    @Override public boolean addAll(Collection<? extends E> c) {return s.addAll(c);}
    @Override public boolean retainAll(Collection<?> c) {return s.retainAll(c);}
    @Override public boolean removeAll(Collection<?> c) {return s.removeAll(c);}
    public boolean isIn(Object o){return isIn(o);}
    @Override public void clear() {s.clear();}
}
