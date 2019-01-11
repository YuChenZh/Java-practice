/**
 * Created by yujingchen on 9/30/17.
 */

////import java.util.*;
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//
//
//
//class Node<T> {
//
//    T value;
//    public Node<T> next;
//    public Node(T value)
//    {
//        this.value=value;
//        this.next=null;
//    }
//}
//class GrowListInterater<E> implements Iterator<E>
//{
//    Node<E> value;
//    public GrowListInterater(Node<E> node)
//    {
//        this.value=node;
//    }
//    public E next()
//    {
//        if(value.next==null){throw new NoSuchElementException("");}
//        Node<E> value=this.value;
//        this.value=value.next;
//        return value.value;
//    }
//    public void remove()
//    {
//        throw new UnsupportedOperationException("");
//    }
//    public boolean hasNext()
//    {
//        return this.value.next!=null;
//    }
//}
//
//
//
//public class GrowList<T> implements Iterable<T>{
//
//    Node<T> first;
//    int size=0;
//
//    public  GrowListInterater<T> iterator()
//    {
//
//        return new GrowListInterater<T>(first);
//
//    }
//
//
//
//    public void add(T value) {
//        Node<T> newFirst=new Node<T>(value);
//        newFirst.next=first;
//        this.first=newFirst;
//        this.size++;
//    }
//
//    public static void main(String[] args) {
//        GrowList<String> list = new GrowList<String>();
//
//        System.out.println("list is:" + list);
//        list.add("cat");
//        list.add("bag");
//        System.out.println("list is:" + list);
//
//        Iterator it = list.iterator();
//
//
//    }
//}


import java.util.*;
//  GrowList is a mutable list that only gets longer.
public class GrowList <E> implements Iterable<E>{

    private HashMap<Integer,E> values;
    public GrowList()
    {
        values = new HashMap<Integer, E>();
    }

    public Iterator<E> iterator()
    {
        return new GrowListIterator(this);
    }
    private static class GrowListIterator<E> implements Iterator<E>{
        private GrowList l;
        private int n = 0;
        GrowListIterator (GrowList<E> loc){
            l = loc;
        }
        public boolean hasNext() throws ConcurrentModificationException{
            return n < l.size();
        }
        public E next() throws NoSuchElementException{
            if(hasNext()) {
                E a = (E)l.get(n);
                n++;
                return a;
            }
            throw new NoSuchElementException("GrowListIterator.next");
        }
        public void remove() {
            throw new UnsupportedOperationException("GrowListIterator.remove");
        }
    }

    // add to the end of the list
    public void add(E o) {
        values.put(size(), o);
    }

    // number of values in list
    public int size() { return values.size(); }

    // get ith value in list
    public E get(int i) {
        if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
        return values.get(i);
    }

    // update ith value in list;  return previous value or null if none
    public E set(int i, E o) {
        if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
        return values.put(i, o);
    }

    // private helper method
    private boolean inRange(int i) { return (i >= 0) && (i < size()); }

    public String toString() {
        if (size() == 0) return "[]";
        String result = "[";
        for (int i = 0; i < size()-1; i++) {
            result += values.get(i) + ",";
        }
        return result + values.get(size() - 1) + "]";
    }

    public static void main(String[] args) {
        GrowList<String> list = new GrowList<String>();

        System.out.println("list is:" + list);
        list.add("cat");
        System.out.println("list is:" + list);
        list.add("dog");
        System.out.println("list is:" + list);
        list.set(1,"bat");
        System.out.println("list is:" + list);

    }
}