/*
@author Yujing Chen
*/

import java.util.*;
import java.util.Map.Entry;

/*
    An SDL mutant that causes the rep-invariant to fail.
     SDL: if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.set"); in set() method.

     test: @Test
            public void testSet(){
                l.add("cat");
                l.add("dog");
                l.set(-2,"bat");
                assertEquals(l.repOk(), true);
            }
     If delete this sentence, this test failed for negative key value.
*/

/*
    An SDL mutant that causes a method contract to be violated.
     SDL: values.put(size(), o); in set() method.

     test:  @Test
            public void testAdd(){
                l.add("cat");
                l.add("dog");
                assertEquals(l.toString(),"[cat,bat]");
            }
     If delete this sentence, this test failed for not adding in the elements.
*/

//  GrowList is a mutable list that only gets longer.
public class GrowList <E> {

    private Map<Integer,E> values;

    public GrowList() { values = new HashMap<Integer,E>();}

    // add to the end of the list
    public void add(E o) {
//        values.put(size(), o);
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
//        if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
        return values.put(i, o);
    }

    // private helper method
    private boolean inRange(int i) { return (i >= 0) && (i < size()); }


    //rep-inv: values != null  && value.size() >= 0
    // no duplicate values
    // key >0 && key < size()
    // for each <key, v> pair, key !=null && v != null
    public boolean repOk(){
        if (values == null) return false;
        if (values.size() < 0) return false;
        for(Entry<Integer, E> entry : values.entrySet()) {
            if ((entry.getKey() < 0) || (entry.getKey() > values.size())) return false;
            if (entry.getKey() == null) return false;
            if (entry.getValue() == null) return false;

            for (Entry<Integer, E> entry1 : values.entrySet()){
                if ((entry1.getValue() == entry.getValue())&& (entry1.getKey() != entry.getKey())) return false;
            }
        }
    return true;
    }

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
        list.repOk();

    }
}