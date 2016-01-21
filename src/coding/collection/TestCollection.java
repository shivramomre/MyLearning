package coding.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class TestCollection {

	@Test
	public void testArrayList()
	{
		//Object type is non premitive
		ArrayList<Integer> al = new ArrayList<Integer>();

		al.add(25);
		al.add(35);

		System.out.println(al.size());

		//adding
		al.add(10);
		al.add(100);
		al.add(50);
		al.add(20);
		al.add(1500);

		//retrieving
		Integer temp = al.get(0);
		System.out.println(temp);

		//removing item (careful). May leads to IndexOutOfBoundsException
		//too slow. shifting happens
		al.remove(0);
		//fast. no shifting needed
		al.remove(al.size()-1);

		System.out.println("\nOriginal array list");
		printCollection(al);

		Collections.sort(al);

		System.out.println("\nSorted array list");
		printCollection(al);

		//if you not specify the array size then default it is 10 and double when index reaches its limit
		//Arraylist internally use array
		//IndexOutOfBoundsException
	}

	@Test
	public void testCompareLists()
	{
		List<Integer> al = new ArrayList<Integer>();
		List<Integer> ll = new LinkedList<Integer>();

		doTimingsList("ArrayList", al);
		doTimingsList("Linkedlist", ll);
	}

	public void doTimingsList(String type, List<Integer> list)
	{
		//Initial list having something in it
		for(int i=0; i<1E6; i++)
		{
			list.add(i);
		}

		long start = System.currentTimeMillis();

		//Inserting at end
		// ArrayList 102 ms, LinkedList 71 ms
		//		for(int i=0; i<1E6; i++)
		//		{
		//			list.add(i);
		//		}

		//Inserting at begining
		// ArrayList 526 ms, LinkedList 1 ms
		//		for(int i=0; i<1E3; i++)
		//		{
		//			list.add(0, i);
		//		}

		//Inserting at end-100
		// ArrayList 128 ms, LinkedList 170 ms
		for(int i=0; i<1E6; i++)
		{
			list.add(list.size()-100, i);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Time taken : "+(end-start)+" mili sec for "+type);
	}

	
	@Test
	public void testSet() {
		
		Set<String> hs = new HashSet<String>();
		Set<String> lhs = new LinkedHashSet<String>();
		Set<String> ts = new TreeSet<String>();
		
		if(hs.isEmpty())
		{
			System.out.println("Set is empty at the begining.");
		}
		hs.add("cat");
		hs.add("mouse");
		hs.add("donkey");
		hs.add("monkey");
		hs.add("elephant");
		hs.add("tiger");
		hs.add("tiger"); //Duplicate element
		System.out.println("Printing hash set : "+hs);
		
		if(!hs.isEmpty())
		{
			System.out.println("Set is not empty after adding element.");
		}
		
		if(hs.contains("cat"))
		{
			System.out.println("Set contains cat.");
		}
		
		if(!hs.contains("dog"))
		{
			System.out.println("Set does not contains dog.");
		}
		
		lhs.add("cat");
		lhs.add("mouse");
		lhs.add("donkey");
		lhs.add("monkey");
		lhs.add("elephant");
		lhs.add("tiger");
		System.out.println("Printing linked hash set : "+lhs);
		
		ts.add("cat");
		ts.add("mouse");
		ts.add("donkey");
		ts.add("monkey");
		ts.add("elephant");
		ts.add("tiger");
		System.out.println("Printing tree set : "+ts);
		
		
		Set<String> hs1 = new HashSet<String>();
		hs1.add("jiraffe");
		hs1.add("mouse");
		hs1.add("donkey");
		hs1.add("snake");
		hs1.add("elephant");
		hs1.add("lion");
		System.out.println("Printing hash set1 : "+hs1);
		
		//intersection
		Set<String> intersection = new HashSet<String>(hs);
		intersection.retainAll(hs1);
		System.out.println("Printing hash set and set1 intersection : "+intersection);
		
		//difference
		Set<String> diff = new HashSet<String>(hs);
		diff.removeAll(hs1);
		System.out.println("Printing hash set and set1 difference : "+diff);
	}


	@Test
	public void testMap()
	{
		Map<String, Integer> hm = new HashMap<String, Integer>();
		Map<String, Integer> lhm = new LinkedHashMap<String, Integer>();
		Map<String, Integer> tm = new TreeMap<String, Integer>();
		
		doTimingsMap("HashMap", hm);
		doTimingsMap("LinkedHashMap", lhm);
		doTimingsMap("TreeMap", tm);
		
		Integer val = hm.get("key:50");
		System.out.println(val);
		
		System.out.println(hm.entrySet());
		System.out.println(hm.values());
		
		System.out.println(lhm.entrySet());
		System.out.println(lhm.values());
		
		System.out.println(tm.entrySet());
		System.out.println(tm.values());
		
		//Time taken : 55 mili sec for HashMap for 1E5 elements
		//Time taken : 73 mili sec for LinkedHashMap for 1E5 elements
		//Time taken : 71 mili sec for TreeMap for 1E5 elements
	}
	
	@Test
	public void testQueue()
	{
	//	https://www.youtube.com/watch?v=KKN4zh7T3JE&list=PLB841C370FAFB8EC7&index=9
			
	}
	
	@Test
	public void testIterator()
	{
		//https://www.youtube.com/watch?v=o9ZYhHdZJNY&list=PLB841C370FAFB8EC7&index=10
		//https://www.youtube.com/watch?v=t3jxvshXDfg&index=11&list=PLB841C370FAFB8EC7
	}
	
	public void doTimingsMap(String type, Map<String, Integer> map)
	{
		long start = System.currentTimeMillis();
		for(int i=0; i<1E2; i++)
		{
			map.put("key:"+i,i);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken : "+(end-start)+" mili sec for "+type);
	}
	
	public void printCollection(Collection<Integer> c)
	{
		System.out.println("Printing data");
		for(Integer i : c)
		{
			System.out.println("Element : "+i);
		}
	}
}
