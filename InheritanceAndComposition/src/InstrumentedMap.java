import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yujingchen on 11/18/17.
 */
public class InstrumentedMap<K, V> extends ForwardingMap<K,V> {
    private int addCount = 0;

    public InstrumentedMap(Map<K, V> s){ super(s); }
    @Override public V put(K key, V value){ addCount++; return super.put(key,value); }
    public int getAddCount(){ return addCount; }
}
