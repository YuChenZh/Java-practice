/**
 * Created by yujingchen on 10/2/17.
 */

import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

//public class GrowListIterator<Integer,E> implements Iterable<Integer>{
public class GrowListIterator<E>{

    private HashMap<Integer,E> values;
    public GrowListIterator()
    {
        values = new HashMap<Integer, E>();
    }

//    public HashMap<Integer,E> values = new HashMap<Integer,E>();

    public Iterator<E> iterator(){
        return new IteratorList();
    }

    private class IteratorList implements Iterator<E>{

        int count = values.size();
        Iterator<Map.Entry<Integer, E>> mapIterator = values.entrySet().iterator();

        public boolean hasNext() throws ConcurrentModificationException{
            return count > 0;
        }

        public E next() throws NoSuchElementException{
            if(hasNext()){
                HashMap.Entry<Integer, E> entry = mapIterator.next();
                System.out.println("Key: " + entry.getKey() + " => Value : " + entry.getValue());
                count--;
                return entry.getValue();
            }
            throw new NoSuchElementException("GrowListIterator.next");
        }

        public void remove(){
            throw new UnsupportedOperationException("GrowListIterator.remove");
        }
    }

    // add to the end of the list
    public void add(E o) {
        values.put(values.size(), o);
    }

    public static void main(String[] args) {
        GrowListIterator<String> list = new GrowListIterator<String>();

        System.out.println("list is:" + list.values);
        list.values.put(1,"cat");
        list.values.put(2,"bag");

//        list.add("cat");

        for(Map.Entry<Integer, String> entry : list.values.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }


    }
}