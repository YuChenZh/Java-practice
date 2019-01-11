/**
 * Created by yujingchen on 11/12/17.
 */
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public class TestSubclass {

    Subclass sub = new Subclass(4);

    @Test
    public void testClone(){
        sub.insert(1);
        sub.insert(23);
        sub.insert(4);
        assertTrue(sub.clone()!=sub);
//        assertTrue(sub.clone().getClass()==sub.getClass());
//        assertTrue(sub.clone().equals(sub));
    }
}
