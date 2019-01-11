
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public class TestGrowList {

    private GrowList l;

    @Before
    public void initialize(){

        l = new GrowList();
    }


    /*  Test case: testToString
     *  Test case values: add "cat","dog" and "dog" into the list, then set the second value to "bat"
     *  Expected output: [cat, dog,bat]
     */

    @Test
    public void testTostring(){
        l.add("cat");
        l.add("dog");
        l.add("dog");
        l.set(2,"bat");
        assertEquals(l.toString(), "[cat,dog,bat]");
    }

    /*  Test case: testToString2
     *  Test case values: add no value into the list
     *  Expected output: []
     */

    @Test
    public void testTostring2(){
        assertEquals(l.toString(), "[]");
    }

    /*  Test case: testAdd
     *  Test case values: add "cat","dog" into the list
     *  Expected output: [cat, dog]
     */
    @Test
    public void testAdd(){
        l.add("cat");
        l.add("dog");
        assertEquals(l.toString(),"[cat,bat]");
    }

    /*  Test case: testSize
     *  Test case values: add "cat","dog" into the list
     *  Expected output: 2
     */
    @Test
    public void testSize(){
        l.add("cat");
        l.add("dog");
        assertEquals(l.size(), 2);
    }

    /*  Test case: testSet
     *  Test case values: add "cat","dog" into the list, then set the second value to "bat"
     *  Expected output: throw IndexOutOfBoundsException exception
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testSet0(){
        l.add("cat");
        l.add("dog");
        l.set(-2,"bat");
        assertEquals(l.repOk(), false);
    }

    @Test
    public void testSet(){
        l.add("cat");
        l.add("dog");
        l.set(-2,"bat");
        assertEquals(l.repOk(), true);
    }

    /*  Test case: testSet2
     *  Test case values: add "cat","dog" into the list, then set the first value to "bat"
     *  Expected output: [cat, bat]
     */
    @Test
    public void testSet2(){
        l.add("cat");
        l.add("dog");
        l.set(1,"bat");
        assertEquals(l.toString(), "[cat,bat]");
    }


    /*  Test case: testGet
     *  Test case values: add "cat","dog" into the list, then get the second element
     *  Expected output: throw IndexOutOfBoundsException exception
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGet(){
        l.add("cat");
        l.add("dog");
        l.get(2);
    }

    /*  Test case: testGet2
     *  Test case values: add "cat","dog" into the list, then get the first element
     *  Expected output: "dog"
     */
    @Test
    public void testGet2(){
        l.add("cat");
        l.add("dog");
        l.get(1);
        assertEquals(l.get(1), "dog");
    }


}
