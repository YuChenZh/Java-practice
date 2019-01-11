/**
 * Created by yujingchen on 10/17/17.
 */

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public class BagTest {

    private Bag b;

    @Before
    public void initialize(){

        b = new Bag();
    }

    @Test
    public void testIsert(){
        b.insert("cat");
        b.insert("dog");
        b.insert("null");
        assertEquals(b.toString(), "{null=1, cat=1, dog=1}");
    }

    @Test
    public void testSize(){
        b.insert("cat");
        b.insert("dog");
        b.insert("dog");
        assertEquals(b.size(), 2);
    }

    @Test
    public void testIsIn(){
        b.insert("cat");
        b.insert("dog");
        b.insert("dog");
        assertTrue(b.isIn("cat"));
    }


    @Test
    public void testRemove(){
        b.insert("cat");
        b.insert("dog");
        b.insert("dog");
        assertEquals(b.toString(), "{cat=1, dog=2}");
        assertEquals(b.size(), 2);
        b.remove("dog");
        assertEquals(b.toString(), "{cat=1, dog=1}");
        assertEquals(b.size(), 2);
    }
}
