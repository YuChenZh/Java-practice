/**
 * Created by yujingchen on 10/2/17.
 */

import static org.junit.Assert.*;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGrowList {

    private GrowList list;

    @Before
    public void initialize(){
        list = new GrowList();

    }

    @Test
    public void testHasNext(){
        list.add("cat");
        list.add("dog");
        Iterator it = list.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void testHasNext2(){
        Iterator it = list.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    public void testNext(){
        list.add("cat");
        list.add("dog");
        Iterator it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals("cat", it.next());
        assertEquals("dog", it.next());

    }

    @Test(expected=NoSuchElementException.class)
    public void testNext2(){
        Iterator it = list.iterator();
        assertFalse(it.hasNext());
        it.next();
    }

    @Test
    public void testNext3(){
        list.add(null);
        Iterator it = list.iterator();
        assertTrue(it.hasNext());
        assertNull(it.next());

    }


    @Test(expected=UnsupportedOperationException.class)
    public final void testRemove() throws UnsupportedOperationException
    {
        list.add("cat");
        Iterator it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals("cat", it.next());
        it.remove();
    }

}
