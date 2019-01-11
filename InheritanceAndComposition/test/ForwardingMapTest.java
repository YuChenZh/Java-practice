
/**
 * Created by yujingchen on 11/18/17.
 */
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;


public class ForwardingMapTest {
    Map<Object,Object > r = new HashMap<Object,Object>();
    InstrumentedHashMap<Object,Object> sh = new InstrumentedHashMap<Object,Object>();
    InstrumentedMap<Object,Object> s =  new InstrumentedMap<Object,Object>(r);
    InstrumentedMap<Object,Object> t = new InstrumentedMap<Object,Object>(s);

    @Before
    public void testMapInheritanceAndComposition_dynamicDispatching(){
        r.put(1, "ant"); r.put(2, "bee");

        sh.putAll(r);
        sh.put(1,"ant");

        s.put(1, "ant"); s.put(4, "cat"); s.put(3, "fish");

        t.put(2, "dog");

        r.remove(1);
        s.remove(2);

        System.out.println("s.addCount = " + s.getAddCount());
        System.out.println("t.addCount = " + t.getAddCount());
        System.out.println("sh.addCount = " + sh.getAddCount());

        System.out.println("r = " + r.toString());
        System.out.println("s = " + s.toString());
        System.out.println("t = " + t.toString());
        System.out.println("sh = " + sh.toString());

    }

    @Test
    public void testEquals(){
        assertTrue(s.equals(r));
        assertTrue(r.equals(s));
        assertTrue(t.equals(r));
        assertTrue(r.equals(t));
        assertTrue(s.equals(t));
        assertTrue(t.equals(s));
    }
}
