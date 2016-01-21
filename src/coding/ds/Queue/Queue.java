package coding.ds.Queue;

import coding.ds.LinkedList.LinkedList;
import coding.ds.LinkedList.Node;

public class Queue {

	int size;
	int len;
	Node front;
	Node rear;
	LinkedList queue;
	
	public Queue(int size)
	{
		this.size = size;
		this.len = 0;
		this.queue = new LinkedList();
	}
	
	public void push(int data)
	{
		if(!isFull())
		{
			queue.insertAtStart(data);
			len++;
		}
		else
		{
			System.out.println("Queue is full, can't push");
		}
	}
	public int pop()
	{
		if(!isEmpty())
		{
			int temp = queue.getEnd().getData();
			queue.deleteNodeAtPosition(len);
			len--;
			return temp;
		}
		else
		{
			System.out.println("Queue is empty, can't pop");
			return 0;
		}
	}
	
	public void printQueue()
	{
		queue.printList();
	}
	public boolean isEmpty()
	{
		return(len == 0);
	}
	
	public boolean isFull()
	{
		return (len == size);
	}
}
