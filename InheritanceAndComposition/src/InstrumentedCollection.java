/**
 * Created by yujingchen on 11/18/17.
 */
import java.util.*;

public class InstrumentedCollection<E> extends ForwardingCollection<E> {
    private int addCount = 0;
    public InstrumentedCollection (Collection<E> s) { super(s);}
    @Override public boolean equals(Object o){ return super.equals(o);  } // Now, we’re dead!
    @Override public boolean add(E e){ addCount++; return super.add(e); }
    public int getAddCount(){ return addCount; }

}



