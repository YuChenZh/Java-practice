import java.util.List;
import java.util.ArrayList;

public class Stack<T> {
   /*  Overview: A stack is a mutable object where it can
	*  push an element in and pop an element out. 
	*/

	// the rep is a List
	private List<T> stack;
	
	// Constructor
	public Stack(){
		stack = new ArrayList<T>();
	}
	
	// methods
	public boolean push(T x){
		// Effect: add x to the stack
		return stack.add(x);
	}
	
	public T top(){
		// Effect: return element on the top of the stack
		if (stack.size() == 0) throw new IndexOutOfBoundsException("stack.top");
		return stack.get(stack.size() - 1);
	}
	
	public T pop(){
		// Effect: return the last element of the stack and also remove it.
		if (stack.size() == 0) throw new IndexOutOfBoundsException("stack.top");
		return stack.remove(stack.size() - 1);
	}
	
	public int sizeOf(){
		// Effect: return the size of the stack.
		return stack.size();
	}
	
	// Abstract Function: [obj1 obj2 ]
	public String toString(){
		String result="[";
		for(T obj:stack){
			result += obj.toString();
			result += " ";
		}
		result += "]";
		return result;
	}

}
