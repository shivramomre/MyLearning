package coding.problem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Praveen {

	private static Scanner scanner;
	public static void main(String args[])
	{
		System.out.println("The requirement is removing the duplicate character from a given string,"
				+ "excluding vowels and whitespace.\nPlease enter the String."); 
		scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		System.out.println("The expected output is : "+removeDuplicateExceptVowelsAndWS(input));
	}

	private static String removeDuplicateExceptVowelsAndWS(String input) {
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

	public static Map<Character, Integer> insertStringToMap(String word)
	{
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		if(word != null && !word.equals(""))
		{
			char[] ca = word.toCharArray();
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
		}
		return map;
	}
}
