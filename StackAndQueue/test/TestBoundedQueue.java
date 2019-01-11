/**
 * Created by yujingchen on 10/30/17.
 */

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.*;


public class TestBoundedQueue {

    private BoundedQueue q;

    @Before
    public void initialize(){
        q = new BoundedQueue(10);
    }


    @Test
    public void testIsEmpty(){
        q.put(1);
        q.put(2);
        assertFalse(q.isEmpty());
    }

    @Test
    public void testIsFull(){
        q.put(1);
        q.put(2);
        assertFalse(q.isFull());
    }

    @Test
    public void testGetCount(){
        q.put(1);
        q.put(2);
        assertEquals(q.getCount(),2);
    }

    @Test
    public void testPut(){
        q.put(1);
        q.put(2);
        assertEquals(q.toString(), "[2, 1]");
    }

    @Test
    public void testGet(){
        q.put(1);
        q.put(2);
        assertEquals(q.get(), 1);
        assertEquals(q.toString(), "[2]");
    }

    @Test
    public void testPutAll(){
        ArrayList l = new ArrayList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        q.putAll(l);
        assertEquals(q.toString(), "[4, 3, 2, 1]");
    }

    @Test
    public void testGetAll(){
        ArrayList l = new ArrayList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        q.putAll(l);
        q.put(5);
        q.put(6);
        q.getAll();
        assertEquals(q.toString(), "[]");
    }


}
