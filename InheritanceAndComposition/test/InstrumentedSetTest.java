/**
 * Created by yujingchen on 11/26/17.
 */
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;


public class InstrumentedSetTest {

    private Set<String> r;
    private InstrumentedSet<String> s;

    @Before
    public void SetUp(){
        r = new HashSet<String>();
        s =  new InstrumentedSet<String>(r);
    }

    @Test
    public void testAdd(){
        r.add("ant");
        r.add("bee");
        s.add("bat");
        s.add("ant");
        assertEquals(s.toString(),"[bee, bat, ant]");
    }

    @Test(expected = NullPointerException.class)
    public void testAdd2(){
        s.add(null);
        s.add("ant");
    }

    @Test
    public void testRemove(){
        r.add("ant");
        r.add("bee");
        s.add("bat");
        s.remove("ant");
        assertEquals(s.toString(),"[bee, bat]");
    }

    @Test
    public void testEquals(){
        r.add("ant");
        r.add("bee");
        s.add("bat");
        s.add("ant");
        assertTrue(s.equals(r) && r.equals(s));
    }

    @Test
    public void testHashcode(){
        r.add("ant");
        r.add("bee");
        s.add("bat");
        s.add("ant");
        assertTrue(s.hashCode() == r.hashCode());
    }

    @Test
    public void testGetAddCount(){
        r.add("ant");
        r.add("bee");
        s.add("bat");
        s.add("ant");
        s.add("ant");
        s.add("ant");
        assertEquals(s.getAddCount(), 4);
    }
}
