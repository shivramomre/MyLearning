package coding.ds.LinkedList;

public class Node {

	private int data;
	private Node prev;
	private Node next;
	
	public Node()
	{
		data = 0;
		prev = null;
		next = null;
	}
	
	public Node(int data)
	{
		this.data = data;
		prev = null;
		next = null;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public Node getNext()
	{
		return this.next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	public static void delete(Node node)
	{
		node.setData(0);
		node.setNext(null);
		node.setPrev(null);
		node = null;
	}
}

