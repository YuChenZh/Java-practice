/**
 * Created by yujingchen on 11/18/17.
 */
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;


public class ForwardingCollectionTest {
    Set<String> r = new HashSet<String>();
    InstrumentedCollection<String> s = new InstrumentedCollection<>(r);
    InstrumentedCollection<String> t = new InstrumentedCollection<>(s);

    @Before
    public void testCollectionInheritanceAndComposition_dynamicDispatching() {
        r.add("ant");
        r.add("bee");

        s.add("ant");
        s.add("cat");
        s.add("fish");

        t.add("dog");

        r.remove("bee");
        s.remove("ant");
        t.remove("dog");

        System.out.println("s.addCount = " + s.getAddCount());
        System.out.println("t.addCount = " + t.getAddCount());

        System.out.println("r = " + r.toString());
        System.out.println("s = " + s.toString());
        System.out.println("t = " + t.toString());
    }

    @Test
    public void testEquals(){
        assertTrue(s.equals(r));
        assertFalse(r.equals(s));
        assertTrue(t.equals(r));
        assertFalse(r.equals(t));
        assertFalse(s.equals(t));
        assertFalse(t.equals(s));
    }

    @Test
    public void testgetAddCount(){
        assertEquals(4,s.getAddCount());
    }
}
