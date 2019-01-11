/**
 * Created by yujingchen on 11/14/17.
 */
import java.util.Collection;
import java.util.ArrayList;

public class InstrumentedArrayList<E> extends ArrayList<E>{
    private int addCount = 0;
    public InstrumentedArrayList() {}

    @Override public boolean add(E e){
        addCount++;
        return super.add(e);
    }
    @Override public boolean addAll(Collection<? extends E> s){
        // What to do with addCount?
        return super.addAll(s);
    }
    public int getAddCount(){ return addCount; }
}
