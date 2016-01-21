package coding.ds.LinkedList;

import javax.swing.JOptionPane;

import org.junit.Test;

import util.Input;
import util.Output;

public class LinkedListTest {

	@Test
	public void testSorting()
	{
		String output = null;
		boolean flag = false;
		LinkedList list = new LinkedList();
		
		while(!flag)
		{
			String[] choice = new String[]
					{
							"InsertAtStart",
							"InsertAtPos",
							"InsertAtEnd",
							"DeleteAtPos",
							"DeleteWithData",
							"ReverseList",
							"Find nth from last",
							"PrintList"
					};
			String choiceVal = (String) JOptionPane.showInputDialog(null, "Please input the linklist method.", "Sorting", JOptionPane.PLAIN_MESSAGE, null, choice, 0);
			
			if(choiceVal != null)
			{
				switch (choiceVal) {
				case "InsertAtStart":
					list.insertAtStart(Input.readIntValue("Enter the int value to insert."));
					Output.showMassage("Here is list data after insertion.\n"+list.printList());
					break;
				case "InsertAtPos":
					list.insertAtPos(Input.readIntValue("Enter the int value to insert."), Input.readIntValue("Enter the position"));
					Output.showMassage("Here is list data after insertion.\n"+list.printList());
					break;
				case "InsertAtEnd":
					list.insertAtEnd(Input.readIntValue("Enter the int value to insert."));
					Output.showMassage("Here is list data after insertion.\n"+list.printList());
					break;
				case "DeleteAtPos":
					list.deleteNodeAtPosition(Input.readIntValue("Enter the position to be deleted from the list."));
					Output.showMassage("Here is list data after deletion.\n"+list.printList());
					break;
				case "DeleteWithData":
					list.deleteNodeWithData(Input.readIntValue("Enter the data to be deleted from list."));
					Output.showMassage("Here is list data after deletion.\n"+list.printList());
					break;
				case "ReverseList":
					list.reverseList();
					Output.showMassage("Here is reversed list.\n"+list.printList());
					break;
				case "Find nth from last":
					Output.showMassage("Here is list.\n"+list.printList()+list.nthFromLast(Input.readIntValue("Enter the position.")));
					break;
				case "PrintList":
					output = list.printList();
					Output.showMassage(output);
					break;
				default:
					break;
				}
			}
			int val = JOptionPane.showConfirmDialog(null, "Do you want to continue ?", "Sorting", JOptionPane.YES_NO_OPTION);
			if(val != 0)
				flag = true;
		}
	}
}
