/*
* First, for clone() method, it's not suposed to call constructor in clone(). For in subtype 'Subclass',
* clone() method call super.clone() will return a IntSet object, then cast it to the Subclass object
* and lead to the 'ClassCastException'. So we should change the implementation of clone() in IntSet to super.clone().
*
* Second, the original equals()method of IntSet just return false, and this is not correct. s equals to els when they
* contain the same elements. So I change 'return false' to 'return s.els.containsAll(els)&& els.containsAll(s.els)'.
*
* Third, hashcode() in IntSet is legal, but very bad. Because it ensures that every object has the same hash code.
* Therefore, every object hashes to the same bucket, and hash tables degenerate to linked lists. This would cause the
* program run in quadratic time. So we need to assign each element a distinct bucket.
* */

import java.util.*;

public class IntSet implements Cloneable {
    private List<Integer> els;

    @Override public boolean equals(Object obj) {  // Standard recipe
        if (!(obj instanceof IntSet)) return false;

        IntSet s = (IntSet) obj;
        return s.els.containsAll(els)&& els.containsAll(s.els);
    }

    @Override public int hashCode() {
        int sum = 0;
        for (Integer i : els) sum += i.hashCode();
        return sum;
    }
//    @Override public int hashCode() {
//        int result = 17;
//        for(int i=0; i< els.size();i++) {
//            result = 31 * result + els.get(i);
//        }
//        return result;
//    }

    public IntSet () { els = new ArrayList<Integer>(); }

    private IntSet (List<Integer> list) { els = list; }

//    @Override public IntSet clone() {
//        return new IntSet (new ArrayList<Integer>(els));
//    }

    @Override public IntSet clone(){
        IntSet clone = null;

        try {
            clone = (IntSet) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }


////////////    extra methods
    public void insert (int x) {

        Integer y = new Integer(x);
        if (!(els.contains(y)))
            els.add(y);
    }


    public String toString( ) {
        if(els.size( )==0)return"{}";
        String s="{"+els.get(0).toString( );
        for(int i=1; i<els.size( ); i++)
            s=s+" , "+els.get(i).toString( );
        return s +"}"; }

    public static void main(String[] args)  {
        IntSet test = new IntSet();
        test.insert(1);

        IntSet cloneTest = (IntSet) test.clone();
        cloneTest.insert(2);

        cloneTest.insert(123);
        test.insert(123);
        test.insert(2);

        System.out.println(cloneTest.toString());
        System.out.println(test.toString());
        System.out.println(cloneTest.equals(test));
        System.out.println(test.hashCode());
        System.out.println(cloneTest.hashCode());

    }
}

