import java.util.Collection;
import java.util.Iterator;


/**
 * Created by yujingchen on 11/18/17.
 */
public class ForwardingCollection<E> implements Collection<E> {
    private final Collection<E> s;

    public ForwardingCollection(Collection<E> s){ this.s = s; }

    @Override public boolean equals(Object o){ return s.equals(o);  }
    @Override public int hashCode() { return s.hashCode(); }
    @Override public String  toString() { return s.toString(); }
    @Override public int size() {return s.size();}
    @Override
    public  Object[] toArray() {
        return s.toArray();
    }

    @Override
    public <T>  T[] toArray(T[] array) {
        return s.toArray(array);
    }

    @Override
    public  boolean removeAll(Collection<?> collection) {
        return s.removeAll(collection);
    }
    @Override
    public  boolean retainAll(Collection<?> collection) {
        return s.retainAll(collection);
    }
    @Override
    public Iterator<E> iterator() {
        return s.iterator();
    }
    @Override
    public  boolean add(E element) {
        return s.add(element);
    }
    @Override
    public  boolean remove(Object object) {
        return s.remove(object);
    }
    @Override
    public  void clear() {
        s.clear();
    }
    @Override
    public  boolean contains(Object object) {
        return s.contains(object);
    }
    @Override
    public  boolean isEmpty() {
        return s.isEmpty();
    }
    @Override
    public  boolean containsAll(Collection<?> collection) {
        return s.containsAll(collection);
    }
    @Override
    public  boolean addAll(Collection<? extends E> collection) {
        return s.addAll(collection);
    }

}
