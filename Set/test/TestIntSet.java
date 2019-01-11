/**
 * Created by yujingchen on 11/12/17.
 */
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class TestIntSet {
    IntSet test = new IntSet();

    @Test
    public void testClone(){
        test.insert(2);
        test.insert(23);
        test.insert(4);
        assertTrue(test.clone()!=test);
        assertTrue(test.clone().getClass()==test.getClass());
        assertTrue(test.clone().equals(test));

    }


    @Test
    public void testEquals(){
        test.insert(2);
        IntSet cloneTest = (IntSet) test.clone();
        cloneTest.insert(4);
        cloneTest.insert(23);
        test.insert(23);
        test.insert(4);
        assertTrue(test.equals(cloneTest));
    }

    @Test
    public void testHashcode(){
        test.insert(2);
        IntSet cloneTest = (IntSet) test.clone();
        cloneTest.insert(4);
        cloneTest.insert(23);
        test.insert(23);
        test.insert(4);
        assertEquals(test.hashCode(),cloneTest.hashCode());
    }

}
