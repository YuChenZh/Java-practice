/**
 * Created by yujingchen on 11/17/17.
 */
import java.util.*;
import java.util.Collection;
import java.util.Iterator;

public class ForwardingMap<K, V> implements Map<K ,V> {
    private final Map<K, V> s;

    public ForwardingMap(Map<K, V> s){ this.s = s; }
    @Override
    public boolean equals(Object o) {
        return o == this || s.equals(o);
    }
    @Override public int hashCode() { return s.hashCode(); }
    @Override public String  toString() { return s.toString(); }
    @Override public int size() {return s.size();}
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        s.putAll(map);
    }
    @Override
    public Set<K> keySet() {
        return s.keySet();
    }
    @Override
    public boolean containsKey(Object key) {
        return s.containsKey(key);
    }
    @Override
    public V put(K key, V value) {
        return s.put(key, value);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
     return s.entrySet();
    }
    @Override
    public boolean containsValue(Object value) {
        return s.containsValue(value);
    }
    @Override
    public Collection<V> values() {
        return s.values();
    }
    @Override
    public V get(Object key) {
        return s.get(key);
    }
    @Override
    public V remove(Object key) {
        return s.remove(key);
    }

    @Override public boolean isEmpty() {return s.isEmpty();}
    @Override public void clear() {s.clear();}
}
