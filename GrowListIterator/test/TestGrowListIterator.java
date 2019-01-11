import static org.junit.Assert.*;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestGrowListIterator {

    private GrowListIterator list;

    @Before
    public void initialize(){
        list = new GrowListIterator();
        list.add("cat");
        list.add("dog");
    }

    @Test
    public void testHasNext(){
        list = new GrowListIterator();
        list.add("cat");
        list.add("dog");
        Iterator it = list.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void testHasNext2(){
        list = new GrowListIterator();
        Iterator it = list.iterator();
        assertFalse(it.hasNext());
    }

//    @Test(expected=ConcurrentModificationException.class)
//    public void testHasNext3(){
//        list = new GrowListIterator();
//        list.add("cat");
//        Iterator it = list.iterator();
//        list.add("dog");
//        assertTrue(it.hasNext());
//    }

    @Test
    public void testNext(){
        list = new GrowListIterator();
        list.add("cat");
        list.add("dog");
        Iterator it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals("cat", it.next());
        assertEquals("dog", it.next());
    }

    @Test(expected=NoSuchElementException.class)
    public void testNext2(){
        list = new GrowListIterator();
        Iterator it = list.iterator();
        assertFalse(it.hasNext());
        it.next();

    }

    @Test
    public void testNext3(){
        list = new GrowListIterator();
        list.add(null);
        Iterator it = list.iterator();
        assertTrue(it.hasNext());
        assertNull(it.next());

    }

    @Test(expected=ConcurrentModificationException.class)
    public void testNext4(){
        list = new GrowListIterator();
        list.add("cat");
        Iterator it = list.iterator();
        assertTrue(it.hasNext());
        list.add("dog");
        it.next();
    }

    @Test(expected=UnsupportedOperationException.class)
    public final void testRemove() throws UnsupportedOperationException
    {
        list = new GrowListIterator();
        list.add("cat");
        Iterator it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals("cat", it.next());
        it.remove();
    }



}
