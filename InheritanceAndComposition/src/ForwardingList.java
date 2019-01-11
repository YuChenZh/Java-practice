/**
 * Created by yujingchen on 11/14/17.
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.List;

public class ForwardingList<E> implements List<E>{
        private final List<E> s;

    public ForwardingList(List<E> s){ this.s = s; }
    @Override public boolean equals(Object o){ return s.equals(o);  }
    @Override public int hashCode() { return s.hashCode(); }
    @Override public String  toString() { return s.toString(); }
    @Override public int size() {return s.size();}
    @Override
    public  void add(int index, E element) {
        s.add(index, element);
    }
    @Override public  E get(int index) {
        return s.get(index);
    }
    @Override
    public  E remove(int index) {
        return s.remove(index);
    }
    @Override
    public  int indexOf(Object element) {
        return s.indexOf(element);
    }
    @Override
    public  int lastIndexOf(Object element) {
        return s.lastIndexOf(element);
    }
    @Override
    public  boolean addAll(int index, Collection<? extends E> elements) {
        return s.addAll(index, elements);
    }
    @Override
    public  ListIterator<E> listIterator() {
        return s.listIterator();
    }
    @Override
    public  ListIterator<E> listIterator(int index) {
        return s.listIterator(index);
    }
    @Override
    public  E set(int index, E element) {
        return s.set(index, element);
    }
    @Override
    public  List<E> subList(int fromIndex, int toIndex) {
        return s.subList(fromIndex, toIndex);
    }
    @Override public boolean isEmpty() {return s.isEmpty();}
    @Override public boolean contains(Object o) {return s.contains(o);}
    @Override public Iterator<E> iterator() {return s.iterator();}
    @Override public Object[] toArray() {return new Object[0];}
    @Override public <T> T[] toArray(T[] a) {return s.toArray(a);}
    public boolean add(E e) { return s.add(e); }
    public boolean remove(Object o){ return s.remove(o); }
    @Override public boolean containsAll(Collection<?> c) {return s.containsAll(c);}
    @Override public boolean addAll(Collection<? extends E> c) {return s.addAll(c);}
    @Override public boolean retainAll(Collection<?> c) {return s.retainAll(c);}
    @Override public boolean removeAll(Collection<?> c) {return s.removeAll(c);}
    @Override public void clear() {s.clear();}
}
