/**
 * Created by yujingchen on 10/17/17.
 */

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestLiskovGeneericSet {

    private LiskovGenericSet list;

    @Before
    public void initialize(){

        list = new LiskovGenericSet();
    }


    @Test
    public void testIsert(){
        list.insert("cat");
        list.insert("dog");
        list.insert("null");
        assertEquals(list.toString(), "[cat, dog, null]");
    }

    @Test
    public void testSize(){
        list.insert("cat");
        list.insert("dog");
        list.insert("dog");
        assertEquals(list.size(), 2);
    }

    @Test
    public void testIsIn(){
        list.insert("cat");
        list.insert("dog");
        list.insert("dog");
        assertTrue(list.isIn("cat"));
    }


    @Test
    public void testRemove(){
        list.insert("cat");
        list.insert("dog");
        list.insert("dog");
        assertEquals(list.toString(), "[cat, dog]");
        assertEquals(list.size(), 2);
        list.remove("dog");
        assertEquals(list.toString(), "[cat]");
        assertEquals(list.size(), 1);
    }
}







