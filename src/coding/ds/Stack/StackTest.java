package coding.ds.Stack;

import org.junit.Test;

public class StackTest {

	@Test
	public void testStack() {
		Stack stack = new Stack(5);
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.printStack();
		System.out.println(stack.pop());
		stack.printStack();
	}

}
