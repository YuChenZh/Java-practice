/**
 * Created by yujingchen on 11/14/17.
 */
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.*;

public class ForwardingListTest {
    List<String> r = new ArrayList<String>();
    InstrumentedArrayList<String> sh = new InstrumentedArrayList<String>();
    InstrumentedList<String> s =  new InstrumentedList<String>(r);
    InstrumentedList<String> t = new InstrumentedList<String>(s);

    @Before
    public void testListInheritanceAndComposition_dynamicDispatching2(){
        r.add("ant"); r.add("bee");

        sh.addAll(r);
        sh.add("ant");

        s.add("ant"); s.add("cat"); s.add("fish");

        t.add("dog");

        r.remove("bee");
        s.remove("ant");

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
