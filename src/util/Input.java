package util;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class Input {

	public static final String ENTER_INTEGER = "Please enter an integer.";
	public static final String ENTER_FLOAT = "Please enter a float.";
	public static final String ENTER_STRING = "Please enter a string.";

	public static int readIntValue()
	{
		try{
			String input = JOptionPane.showInputDialog(ENTER_INTEGER);
			return Integer.parseInt(input);
		}
		catch(NumberFormatException e)
		{
			int optionIndex = JOptionPane.showConfirmDialog(null, "You have entered an invalid input. Do you want enter again", "", JOptionPane.YES_NO_OPTION);
			if(optionIndex == 0)
			{
				return readIntValue();
			}
			else
			{
				return Integer.MIN_VALUE;
			}
		}
	}

	public static int readIntValue(String msg)
	{
		try{
			String input = JOptionPane.showInputDialog(msg);
			return Integer.parseInt(input);
		}
		catch(NumberFormatException e)
		{
			int optionIndex = JOptionPane.showConfirmDialog(null, "You have entered an invalid input. Do you want enter again", "", JOptionPane.YES_NO_OPTION);
			if(optionIndex == 0)
			{
				return readIntValue();
			}
			else
			{
				return Integer.MIN_VALUE;
			}
		}
	}
	
	public static Integer[] readIntArrayValues()
	{
		Integer[] arr = null;
		int num = Integer.parseInt(JOptionPane.showInputDialog("How many integer values you want to input?"));
		if(num > 0)
		{
			arr = new Integer[num];
			for(int i=0; i<num; i++)
			{
				arr[i] = readIntValue();
			}
		}
		return arr;
	}

	public static String readString()
	{
		return JOptionPane.showInputDialog("Please input the string");
	}
	
	public static String readString(String msg)
	{
		return JOptionPane.showInputDialog(msg);
	}
	
	public static int readStringOption(String message, String title, String[] options)
	{
		Component comp = new JList<String>();
		return JOptionPane.showOptionDialog(comp, message, title,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
	}
}
