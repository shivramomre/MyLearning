package coding.ds.LinkedList;


public class LinkedList {

	private Node start;
	private Node end;
	private int size;

	public LinkedList()
	{
		start = null;
		end = null;
		size = 0;
	}


	public Node getStart() {
		return start;
	}


	public void setStart(Node start) {
		this.start = start;
	}


	public Node getEnd() {
		return end;
	}


	public void setEnd(Node end) {
		this.end = end;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}


	public boolean isEmpty()
	{
		return start == null;
	}

	public void insertAtStart(int data)
	{
		Node nodeToInsert = new Node(data);

		if(isEmpty())
		{
			setStart(nodeToInsert);
			setEnd(nodeToInsert);
		}
		else
		{
			nodeToInsert.setNext(getStart());
			getStart().setPrev(nodeToInsert);
			setStart(nodeToInsert);
		}

		setSize(getSize()+1);
	}

	public void insertAtPos(int data, int pos)
	{
		if(pos > 0 && pos <= getSize()+1)
		{
			if(pos == 1)
			{
				insertAtStart(data);
			}
			else if(pos == getSize()+1)
			{
				insertAtEnd(data);
			}
			else
			{
				Node nodeToInsert = new Node(data);

				Node temp = getStart();
				for(int i=1; i<pos-1 ; i++)
				{
					temp = temp.getNext();
				}

				nodeToInsert.setNext(temp.getNext());
				nodeToInsert.setPrev(temp);
				temp.setNext(nodeToInsert);
				nodeToInsert.getNext().setPrev(nodeToInsert);

				setSize(getSize()+1);
			}
		}
		else
		{
			System.out.println("Invalid position. Please input a valid position number");
		}
	}

	public void insertAtEnd(int data)
	{
		Node nodeToInsert = new Node(data);

		if(isEmpty())
		{
			setStart(nodeToInsert);
			setEnd(nodeToInsert);
		}
		else
		{
			nodeToInsert.setPrev(getEnd());
			getEnd().setNext(nodeToInsert);
			setEnd(nodeToInsert);
		}
		setSize(getSize()+1);
	}

	public void deleteNodeAtPosition(int pos)
	{
		if(!isEmpty())
		{
			if(!(pos > size || pos < 1))
			{
				if(pos == 1)
				{
					deleteStartNode();
				}
				else if(pos == getSize())
				{
					deleteEndNode();
				}
				else
				{
					Node temp = getStart();
					for(int i=1; i<pos; i++)
					{
						temp = temp.getNext();
					}

					temp.getPrev().setNext(temp.getNext());
					temp.getNext().setPrev(temp.getPrev());

					Node.delete(temp);
					setSize(getSize()-1);
				}
			}
			else
			{
				System.out.println("Invalid position to delete. Please input valid position");
			}
		}
		else
		{
			System.out.println("Deletion can't be performed. List is empty.");
		}

	}

	public void deleteNodeWithData(int data)
	{
		if(!isEmpty())
		{
			Node temp = getStart();
			boolean flag = false;
			for(int i=1; i<=getSize(); i++)
			{
				if(temp.getData() == data)
				{
					flag = true;
					deleteNodeAtPosition(i);
					break;
				}
				temp = temp.getNext();
			}

			if(!flag)
			{
				System.out.println("The element to be delete not found. Try again.");
			}
		}
	}

	public void reverseList()
	{
		if(isEmpty() || getSize()==1)
			return;
		else
		{
			Node second = getStart().getNext();
			Node third = second.getNext();

			second.setNext(getStart());
			getStart().setNext(null);

			if(third == null)
			{
				setStart(second);
				return;
			}

			Node curr = third;
			Node prev = second;

			while(curr != null)
			{
				Node next = curr.getNext();
				curr.setNext(prev);

				prev = curr;
				curr = next;
			}
			setStart(prev);
		}
	}

	public void swapPairwiseIterative()
	{
		Node startNode = getStart();
		int temp;

		while(startNode != null && startNode.getNext() != null)
		{
			temp =  startNode.getData();
			startNode.setData(startNode.getNext().getData());
			startNode.getNext().setData(temp);
			startNode = startNode.getNext().getNext();
		}
	}

	public String nthFromLast(int pos)
	{
		String output = "";
		if(pos > getSize() || pos < 1)
		{
			output += "Entered position is either invalid or greater than the list size. Please enter a valid value.";
			return output;
		}
		else
		{
			Node temp1 = getStart();
			Node temp2 = getStart();

			for(int i = 1; i <= pos; i++ )
			{
				temp1 = temp1.getNext();
			}

			while(temp1 != null)
			{
				temp1 = temp1.getNext();
				temp2 = temp2.getNext();
			}

			output += "The "+pos+"(th) node from last is : "+temp2.getData();
		}
		return output;
	}

	private void deleteEndNode() 
	{
		if(!isEmpty())
		{
			if(getSize() == 1)
			{
				Node.delete(getEnd());
				setSize(0);
			}
			else
			{
				setEnd(getEnd().getPrev());
				Node.delete(getEnd().getNext());
				setSize(getSize()-1);
			}
		}
	}

	private void deleteStartNode() 
	{
		if(!isEmpty())
		{
			if(getSize() == 1)
			{
				Node.delete(getStart());
				setSize(0);
			}
			else
			{
				setStart(getStart().getNext());
				Node.delete(getStart().getPrev());
				setSize(getSize()-1);
			}
		}
	}

	public String printList()
	{
		String output = "";
		Node temp = getStart();
		if(size > 0)
		{
			for(int i=0; i<size; i++)
			{
				if(i < size-1)
					output += temp.getData() + " -> ";
				else
					output += temp.getData();
					temp = temp.getNext();
			}
		}
		else
		{
			output = "LinkedList is empty. Please add some nodes to it.";
		}
		return output+"\n";
	}
}
