import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujingchen on 11/18/17.
 */
public class InstrumentedHashMap<K, V> extends HashMap<K, V> {
    private int addCount = 0;
    public InstrumentedHashMap() {}

    @Override public V put(K key, V value){
        addCount++;
        return super.put(key, value);
    }
    @Override public void putAll(Map<? extends K, ? extends V> s){
        // What to do with addCount?
        super.putAll(s);
    }
    public int getAddCount(){ return addCount; }
}
