package util;

import javax.swing.JOptionPane;

public class Output {

	public static void showMassage(String msg)
	{
		JOptionPane.showMessageDialog(null, msg);
	}

	public static void showMassageWithTitle(String msg, String title)
	{
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showMassageWithTitleAndMsgType(String msg, String title, int msgType)
	{
		if(msgType >=-1 && msgType <=3)
		{
			JOptionPane.showMessageDialog(null, msg, title, msgType);
		}
		else
		{
			System.out.println("Invalid message type provided. So displaying the message as plain message.");
			JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE);
		}
	}

}
