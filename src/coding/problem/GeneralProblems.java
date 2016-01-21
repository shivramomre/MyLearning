package coding.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import org.junit.Test;

import util.Input;
import util.Output;

public class GeneralProblems {

	@Test
	public void test()
	{
		boolean flag = false;
		String input = null;
		while(!flag)
		{
			String[] choice = new String[]
					{
							"IP address validation",
							"Two rectangle overlap"
					};
			String choiceVal = (String) JOptionPane.showInputDialog(null, "Please input the method.", "General problem", JOptionPane.PLAIN_MESSAGE, null, choice, 0);

			if(choiceVal != null)
			{
				switch (choiceVal) {
				case "IP address validation":
					input = Input.readString("Enter the ip address.");
					boolean isValid = checkIpAddressValidity(input);
					Output.showMassage("The entered ip address is \""+input+"\"\nIts validity is : "+isValid);
					break;

				case "Two rectangle overlap":
					Point r1p1 = new Point();
					r1p1.readvalue("Please enter the point1 of rect1.");
					Point r1p2 = new Point();
					r1p2.readvalue("Please enter the point2 of rect1.");
					Point r2p1 = new Point();
					r2p1.readvalue("Please enter the point1 of rect2.");
					Point r2p2 = new Point();
					r2p2.readvalue("Please enter the point2 of rect2.");
					boolean isOverlap = rectOverlap(r1p1, r1p2, r2p1, r2p2);

					if(isOverlap == true)
						Output.showMassage("Given rectangles are overlapping.");
					else
						Output.showMassage("Given rectangles are not overlapping.");
					break;

				default:
					break;
				}
			}
			int val = JOptionPane.showConfirmDialog(null, "Do you want to continue ?", "General problem", JOptionPane.YES_NO_OPTION);
			if(val != 0)
				flag = true;
		}
	}

	public boolean checkIpAddressValidity(String ipaddr)
	{
		boolean flag = false;
		//  Check if the string is valid
		if ( ipaddr == null || ipaddr.length() < 7 || ipaddr.length() > 15)
			return false;

		//  Check the address string, should be n.n.n.n format
		StringTokenizer token = new StringTokenizer(ipaddr,".");
		if ( token.countTokens() != 4)
			return false;

		while ( token.hasMoreTokens()) {
			//  Get the current token and convert to an integer value
			String ipNum = token.nextToken();
			try {
				int ipVal = Integer.valueOf(ipNum).intValue();
				if ( ipVal < 0 || ipVal > 255)
					return false;
			}
			catch (NumberFormatException ex) {
				return false;
			}
		} 
		flag = true;
		return flag;
	}

	boolean rectOverlap(Point r1p1, Point r1p2, Point r2p1, Point r2p2)
	{
		if((Math.max(r1p1.x, r2p1.x) < Math.min(r1p2.x, r2p2.x)) &&
				(Math.max(r1p1.y, r2p1.y) < Math.min(r1p2.y, r2p2.y)))
			return true;
		else
			return false;
	}

	//return true for "[()]{}{[()()]()}"
	//return false for "[(])"
	private static final Map<Character, Character> brackets = new HashMap<Character, Character>();
	static {
		brackets.put('[', ']');
		brackets.put('{', '}');
		brackets.put('(', ')');
	} 

	public boolean isBalanced(String str) {
		if (str.length() == 0) {
			throw new IllegalArgumentException("String length should be greater than 0");
		}

		if ((str.length() % 2) != 0) {
			return false;
		}

		final Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (brackets.containsKey(str.charAt(i))) {
				stack.push(str.charAt(i));
			} else if (stack.empty() || (str.charAt(i) != brackets.get(stack.pop()))) {
				return false;
			} 
		}
		return true;
	} 

	public void rotate(int[] arr, int order)
	{
		if (arr == null || order < 0) {
			throw new IllegalArgumentException("The array must be non-null and the order must be non-negative");
		}
		int offset = arr.length - order % arr.length;
		if (offset > 0) {
			int[] copy = arr.clone();
			for (int i = 0; i < arr.length; ++i) {
				int j = (i + offset) % arr.length;
				arr[i] = copy[j];
			}
		}
	}

	//find the longest even length substring which is palindrome.
	public String longestPalindrome(String s) 
	{
		String longestPalindrome = "";
		for(int i = 0; i < s.length(); i++){
			for(int j = s.length()-1; j >= 0 && j != i; j--)
			{
				if(isPalindrome(s.substring(i,j+1))){
					if(s.substring(i, j+1).length()>longestPalindrome.length())
					{
						longestPalindrome = s.substring(i, j+1);
						return longestPalindrome;
					}
				}
			}
		}
		return longestPalindrome;
	}

	public boolean isPalindrome(String s)
	{
		int end = s.length()-1;
		for(int i=0; i<s.length()/2; i++)
		{
			if(s.charAt(i)!=s.charAt(end))
			{
				return false;
			}
			end--;
		}
		return true;
	}

	public static int[] merge(int[] a, int[] b) 
	{

		int[] answer = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;

		while (i < a.length && j < b.length)
		{
			if (a[i] < b[j])       
				answer[k++] = a[i++];

			else        
				answer[k++] = b[j++];               
		}

		while (i < a.length)  
			answer[k++] = a[i++];


		while (j < b.length)    
			answer[k++] = b[j++];

		return answer;
	}

	public static Object binaryform(int number) {
		int remainder;

		if (number <=1) {
			System.out.print(number);
			return null;
		}

		remainder= number %2; 
		binaryform(number >>1);
		System.out.print(remainder);

		{ 
			return null;
		} 
	}

	@Test
	public void test1()
	{
		binaryform(14);
	}


}
class Point
{
	int x;
	int y;

	public void readvalue(String msg)
	{
		Output.showMassage(msg);
		this.x = Input.readIntValue("Please enter the X co-ordinate.");
		this.y = Input.readIntValue("Please enter the Y co-ordinate.");
	}
};