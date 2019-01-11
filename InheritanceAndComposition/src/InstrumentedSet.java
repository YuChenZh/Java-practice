/**
 * Created by yujingchen on 11/14/17.
 */
import java.util.Set;

public class InstrumentedSet<E> extends ForwardingSet<E>{
    private int addCount = 0;

    public InstrumentedSet(Set<E> s){ super(s); }
    @Override public boolean add(E e){
        if (e==null) throw new NullPointerException("null element");
        addCount++;
        return super.add(e);
    }

    @Override public boolean remove(Object o)
    {
        if (o==null) throw new NullPointerException("null element");
        return super.remove(o);
    }

    public int getAddCount(){ return addCount; }
}
