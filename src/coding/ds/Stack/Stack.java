package coding.ds.Stack;
public class Stack {

	private int size;
	private int top;
	private int[] stack;

	public Stack(int size)
	{
		this.size = size;
		this.stack = new int[size];
		this.top = -1;
	}

	public void push(int data)
	{
		if(!isFull())
		{
			top++;
			stack[top] = data;
		}
		else
		{
			System.out.println("Can't push element : "+ data +". Stack is full.");
		}
	}

	public int pop()
	{
		if(!isEmpty())
		{
			int temp = stack[top];
			top--;
			return temp;
		}
		else
		{
			System.out.println("Can't pop, Stack is empty.");
			return 0;
		}
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isEmpty()
	{
		return(top == -1);
	}

	public boolean isFull()
	{
		return(top == size-1);
	}

	public void printStack()
	{
		if(top != -1)
		{
			System.out.println("Printing stack elements.");
			for(int i=0; i <= top; i++)
			{
				System.out.println(stack[i]);
			}
		}
		else
		{
			System.out.println("Stack is empty");
		}
	}
}
