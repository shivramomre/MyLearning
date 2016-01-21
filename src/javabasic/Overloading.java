package javabasic;

public class Overloading {

	public void add(int a, int b)
	{

	}

	public void add(int a)
	{

	}

	public int add(int a, float b)
	{
		return 0;
	}


	// If only return type differs then it will lead to compilation error(duplicate method)
	//	public float add(int a, float b)
	//	{
	//		return 0.1;
	//	}
}
