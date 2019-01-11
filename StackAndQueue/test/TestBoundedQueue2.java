/**
 * Created by yujingchen on 10/25/17.
 */
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestBoundedQueue2 {

    private BoundedQueue2 l;

    @Before
    public void initialize(){

        l = new BoundedQueue2();
    }

    /*  Test case: testEnQueue
     *  Test case values: add "cat","dog" into the Queue, then remove them
     *  Expected output: empty queue
     */

    @Test
    public void testEnQueue(){
        l.enQueue("cat");
        l.enQueue("dog");
        l.deQueue();
        l.enQueue("cat");
        l.deQueue();
        l.deQueue();
        l.enQueue("cat");
        l.deQueue();
        assertEquals(l.toString(), "[]");
    }
}
