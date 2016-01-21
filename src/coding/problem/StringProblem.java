package coding.problem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.junit.Test;

import util.Input;
import util.Output;

public class StringProblem {
	String input = null;
	String input1 = null;
	String output = null;
	int matches = 0;

	@Test
	public void testString()
	{
		boolean flag = false;
		while(!flag)
		{
			String[] choice = new String[]
					{
					"Find Duplicate",
					"Anagrams",
					"First NonRepeatative Char",
					"Remove duplicate adj",
					"Max count",
					"Reverse String using StringBuffer",
					"Reverse String using Iteration",
					"Reverse String using Recursion",
					"Substring occurance",
					"Remove duplicate except vowels and whitespace"
					};

			String choiceVal = (String) JOptionPane.showInputDialog(null, "Please choose the string operation.", "String problems", JOptionPane.PLAIN_MESSAGE, null, choice, 0);

			if(choiceVal != null)
			{
				switch (choiceVal) 
				{
				case "Find Duplicate":
					input = Input.readString();
					Output.showMassage(findDuplicate(input));
					break;

				case "Anagrams":
					input = Input.readString("Input String1");
					input1 = Input.readString("Input String2");
					output = anagrams(input, input1);
					if(output != null)
						Output.showMassage(output);
					break;

				case "First NonRepeatative Char":
					input = Input.readString();
					output = firstNonRepeatativeCharactor(input);
					if(output != null)
						Output.showMassage(output);
					break;

				case "Remove duplicate adj":
					input = Input.readString();
					output = removeDuplicateAdj(input);
					if(output != null)
						Output.showMassage(output);
					break;

				case "Max count":
					input = Input.readString();
					output = maxCount(input);
					if(output != null)
						Output.showMassage(output);
					break;

				case "Reverse String using StringBuffer":
					input = Input.readString();
					output = reverseStringBuffer(input);
					if(output != null)
						Output.showMassage(output);
					break;

				case "Reverse String using Iteration":
					input = Input.readString();
					output = reverseIteration(input);
					if(output != null)
						Output.showMassage(output);
					break;

				case "Reverse String using Recursion":
					input = Input.readString();
					output = reverseRecursion(input);
					if(output != null)
						Output.showMassage(output);
					break;
				case "Substring occurance":
					input = Input.readString("Input String");
					input1 = Input.readString("Input Substring");
					matches = substringOccurance(input, input1);
					if(matches >= 1)
						Output.showMassage(matches +" matches present with the given substring.");
					else
						Output.showMassage("No matches present with the given substring.");
					break;

				default:
					break;
				}
			}
			int val = JOptionPane.showConfirmDialog(null, "Do you want to continue ?", "String Operation", JOptionPane.YES_NO_OPTION);
			if(val != 0)
				flag = true;
		}
	}

	@Test
	public void testStringProblem() {
		System.out.println("Is 1001245s is a number : " + isStringADigitNumber("1001245s"));
		System.out.println("Is 1001245 is a number : " + isStringADigitNumber("1001245"));
		System.out.println("Is 100 is a six digit number : " + isStringSixDigitNumber("100"));
		System.out.println("Is 123456 is a six digit number : " + isStringSixDigitNumber("123456"));
	}

	public String findDuplicate(String word)
	{
		Map<Character, Integer> map = insertStringToMap(word);

		String returnVal = "For the word : "+word+ "\nHere is the character wise count.\n";
		String temp = "\n";
		returnVal += map.toString();

		boolean flag = false;
		int counter = 1;
		for(Map.Entry<Character, Integer> entry : map.entrySet())
		{
			if(entry.getValue() > 1 && counter<=3)
			{
				flag = true;
				counter++;
				temp += entry.getKey() +" : "+ entry.getValue() +"\n";
			}
		}

		if(flag == false)
		{
			returnVal += "\nThere is no duplicate character present.";
		}
		else
		{
			returnVal += "\nThere are duplicates character present for the following.";
			returnVal += temp;
			returnVal += "\nNote : Only first 3 repeatative characters are being shown.";
		}

		return returnVal;
	}

	public String anagrams(String word1, String word2)
	{
		Map<Character, Integer>  map1 = insertStringToMap(word1);
		Map<Character, Integer>  map2 = insertStringToMap(word2);

		if(map1.equals(map2))
			return word1 +" and "+ word2 + " are analgram.";
		else
			return word1 +" and "+ word2 + " are not analgram.";
	}

	public String firstNonRepeatativeCharactor(String word)
	{
		Map<Character, Integer> map = insertStringToMap(word);

		boolean flag = false;
		if(map != null)
		{
			for(Map.Entry<Character, Integer> entry : map.entrySet())
			{
				if(entry.getValue() == 1)
				{
					flag = true;
					return "The first non repeatative char in the word : "+word+" is "+entry.getKey();
				}
			}
			if(flag == false)
			{
				return "No non repeatative char in the word : "+word;
			}
		}
		return null;
	}

	public String removeDuplicateAdj(String input)
	{
		if(input == null)
			return null;

		if(input.length() ==1)
			return input;

		String result;

		if(input.charAt(0) == input.charAt(1) )
			return removeDuplicateAdj(input.substring(1) );
		else
			result = input.charAt(0) + removeDuplicateAdj(input.substring(1) );

		return result;
	}

	public String maxCount(String input)
	{
		String output = null;

		Map<Character, Integer> map = insertStringToMap(input);

		boolean flag = false;
		Map.Entry<Character, Integer> outEntry = null;
		for(Map.Entry<Character, Integer> entry : map.entrySet())
		{
			if(outEntry != null)
			{
				if(outEntry.getValue()  < entry.getValue())
				{
					outEntry = entry;
					flag = true;
				}
			}
			else
			{
				outEntry = entry;
			}
		}
		if(flag == false)
		{
			output = "All the characters in given string \""+input+"\" occurs only once.\n";
			output += "Here is the detail count.\n";
			output += map.toString();
		}
		else
		{
			output = "For the given string \""+input+"\"\n";
			output += "The max occurance count of the character is : "+outEntry.toString() + "\n";
			output += "Here is the detail count.\n";
			output += map.toString();
		}
		return output;
	}

	public String reverseStringBuffer(String input)
	{
		return new StringBuffer(input).reverse().toString();
	}

	public String reverseIteration(String input)
	{
		StringBuilder sb = new StringBuilder();
		char[] arr = input.toCharArray();
		for(int i=arr.length-1; i>=0; i--)
		{
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	public String reverseRecursion(String str)
	{
		if (str.length() < 2) {
			return str;
		}
		return reverseRecursion(str.substring(1)) + str.charAt(0);
	}

	public String removeDuplicateExceptVowelsAndWS(String input) {
		Map<Character, Integer> map = insertStringToMap(input);
		char[] inArr = input.toCharArray();
		List<Character> output = new ArrayList<>();
		List<Character> list = new ArrayList<Character>();
		list.add('A');list.add('E');list.add('I');list.add('O');list.add('U');
		list.add('a');list.add('e');list.add('i');list.add('o');list.add('u');list.add(' ');list.add('.');		

		for(Character ch : inArr)
		{
			if(map.get(ch) != -1)
			{
				output.add(ch);
				if(!list.contains(ch))
					map.put(ch, -1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character ch : output)
			sb.append(ch);
		return sb.toString();
	}
	public int substringOccurance(String input, String substring)
	{
		int matches = 0;

		int lengthInp = input.length();
		int lengthSubs = substring.length();
		int lengthDiff = lengthInp - lengthSubs;

		if(lengthDiff >= 0)
		{
			for (int i = 0; i <= lengthDiff; i++){
				for (int j = 0; j < lengthSubs; j++){
					if (input.charAt(i + j) == substring.charAt(j))
					{
						if (j == substring.length()-1)
						{
							matches++;
							break;
						} 
					}else
					{
						break;
					}
				}
			} 
		}
		return matches;
	}

	// return the longest repeated string in s
	public String lrs(String s) {

		// form the N suffixes
		int N  = s.length();
		String[] suffixes = new String[N];
		for (int i = 0; i < N; i++) {
			suffixes[i] = s.substring(i, N);
		}

		// sort them
		Arrays.sort(suffixes);

		// find longest repeated substring by comparing adjacent sorted suffixes
		String lrs = "";
		for (int i = 0; i < N - 1; i++) {
			String x = lcp(suffixes[i], suffixes[i+1]);
			if (x.length() > lrs.length())
				lrs = x;
		}
		return lrs;
	}

	// return the longest common prefix of s and t
	public String lcp(String s, String t) {
		int n = Math.min(s.length(), t.length());
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != t.charAt(i))
				return s.substring(0, i);
		}
		return s.substring(0, n);
	}

	public boolean isStringSixDigitNumber(String str)
	{
		Pattern pattern = Pattern.compile("\\d{6}");
		return pattern.matcher(str).matches();
	}

	public boolean isStringADigitNumber(String str)
	{
		Pattern pattern = Pattern.compile(".*\\D.*");
		return !pattern.matcher(str).matches();
	}

	private Map<Character, Integer> insertStringToMap(String word)
	{
		if(word.equals(""))
		{
			Output.showMassage("Input String is empty. Operation can't perform");
			return null;	
		}

		char[] ca = word.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		for(Character ch : ca)
		{
			if(map.containsKey(ch))
			{
				map.put(ch, map.get(ch)+1);
			}
			else
			{
				map.put(ch, 1);
			}
		}
		return map;
	}
}
