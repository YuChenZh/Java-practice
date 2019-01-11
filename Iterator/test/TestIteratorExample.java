/**
 * Created by yujingchen on 11/17/17.
 */
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestIteratorExample {
    ArrayList<String> list = new ArrayList<String>();

    IteratorExample<String> iter = new IteratorExample(list);

    @Test
    public void testRemove(){
        list.add("aa");
        list.add("bb");
        list.add("cc");
        iter.next();
        iter.remove();
        assertEquals(list.toString(),"[bb, cc]");
    }

    @Test
    public void testRemove2(){
        list.add("aa");
        list.add("bb");
        list.add("cc");
        iter.remove();
        assertEquals(list.toString(),"[bb, cc]");
    }
}
