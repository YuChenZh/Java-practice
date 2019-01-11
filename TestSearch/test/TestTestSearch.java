
/*
@author: Yujing Chen
*/

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Before;
import static org.junit.Assert.*;


public class TestTestSearch {
    private ListIndexer<String> c;

    @Before
    public void initialize(){

        c = new ListIndexer<String>();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testSearch(){

        c.add("A");
        c.add("B");
        c.add("C");

        try {
            int i = TestSearch.search(c, "B");
            assertTrue(i == 1);
        }catch(Exception e){e.printStackTrace();}

    }

    @Test
    public void testSearch2(){
        c.add(null);
        try {
            int i = TestSearch.search(c, null);
            thrown.expect(NullPointerException.class);
        }catch(Exception e){e.printStackTrace();
        }
    }

    @Test
    public void testSearch3(){

        c.add("A");
        c.add("B");
        c.add("C");
        try {
            int i = TestSearch.search(c, "D");
            thrown.expect(NotFoundException.class);
        }catch(Exception e){e.printStackTrace();
            }

    }

    @Test
    public void testSearch4(){
        c.add("%%");
        try {
            int i = TestSearch.search(c, "a");
            thrown.expect(ClassCastException.class);
        }catch(Exception e){e.printStackTrace();
        }

    }

}

