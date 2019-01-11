/**
 * Created by yujingchen on 11/14/17.
 */
import java.util.Collection;
import java.util.HashSet;
import java.util.*;

public class InstrumentedHashSet<E> extends HashSet<E>{
    private int addCount = 0;
    public InstrumentedHashSet() {}

    @Override public boolean add(E e){
        addCount++;
        return super.add(e);
    }
    @Override public boolean addAll(Collection<? extends E> s){
        // What to do with addCount?
//        addCount += s.size();
//        System.out.println("addCount = " + addCount);
//        System.out.println("s.size = " + s.size());
        return super.addAll(s);
    }
    public int getAddCount(){ return addCount; }

    public static void main(String[] args){
        InstrumentedHashSet<String> s = new InstrumentedHashSet<String>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));

        System.out.println("s = " + s.toString());
        System.out.println("s.addCount = " + s.getAddCount());


    }
}
