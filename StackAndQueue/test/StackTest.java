import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class StackTest {

	private Stack<String> s;
	@Before
	public void initialize(){
		s = new Stack<String>();
	}
	
    /*
     *   Test case values: push "hello"
     *   Expected output: [hello ]
     */
	@Test
	public void testPush() {
		s.push("hello");
		assertEquals(s.toString(),"[hello ]");
	}
	
    /*
     *   Test case values: push "hello" and "again"
     *   Expected output: [hello again ]
     */
	@Test
	public void testPush2() {
		s.push("hello");
		s.push("again");
		assertEquals(s.toString(),"[hello again ]");
	}
	
	
    /*
     *   Test case values: push "hello","again" and get the top
     *   Expected output: again
     */
	@Test
	public void testTop() {
		s.push("hello");
		s.push("again");
		assertEquals(s.top().toString(),"again");
	}
	
	
    /*
     *   Test case values: push "hello" and get the top
     *   Expected output: hello
     */
	@Test
	public void testTop2() {
		s.push("hello");
		assertEquals(s.top().toString(),"hello");
	}
	
    /*
     *   Test case values: get the top from empty
     *   Expected output: throw IndexOutOfboundException
     */
	@Test (expected=IndexOutOfBoundsException.class)
	public void testTop3() {
		s.top();
	}
	
	/*
     *   Test case values: push "hello" and "again" and then pop
     *   Expected output: return again
     */
	@Test 
	public void testPop() {
		s.push("hello");
		s.push("again");
		assertEquals(s.pop().toString(),"again");
		assertEquals(s.toString(),"[hello ]");
	}
	
	/*
     *   Test case values: push "hello" then pop
     *   Expected output: return hello
     */
	@Test 
	public void testPop2() {
		s.push("hello");
		assertEquals(s.pop().toString(),"hello");
		assertEquals(s.toString(),"[]");
	}
	
	/*
     *   Test case values: pop
     *   Expected output: return IndexOutOfBoundsException
     */
	@Test (expected=IndexOutOfBoundsException.class)
	public void testPop3() {
		s.pop();
	}
	
	/*
     *   Test case values: empty stack
     *   Expected output: return 0
     */
	@Test 
	public void testSizeOf() {
		assertEquals(0,s.sizeOf());
	}
	
	/*
     *   Test case values: push 1 elements to the stack
     *   Expected output: return 1
     */
	@Test 
	public void testSizeOf2() {
		s.push("hi");
		assertEquals(1,s.sizeOf());
	}
	
	
	/*
     *   Test case values: push 2 elements to the stack
     *   Expected output: return 2
     */
	@Test 
	public void testSizeOf3() {
		s.push("hi");
		s.push("hello");
		assertEquals(2,s.sizeOf());
	}
	
	/*
     *   Test case values: push 2 elements to the stack
     *   then pop 1 element
     *   Expected output: return 1
     */
	@Test 
	public void testSizeOf4() {
		s.push("hi");
		s.pop();
		assertEquals(0,s.sizeOf());
	}
}
