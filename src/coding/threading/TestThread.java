package coding.threading;

public class TestThread {

	
	public static void main(String args[])
	{
		ThreadUsingRunnableInterface turi1 = new ThreadUsingRunnableInterface("Sachin's thread");
		turi1.start();

		ThreadUsingRunnableInterface turi2 = new ThreadUsingRunnableInterface("Megha's thread");
		turi2.start();
		
		ThreadUsingRunnableInterface turi3 = new ThreadUsingRunnableInterface("Kajal's thread");
		turi3.start();
		
		ThreadUsingThreadClass tutc1 = new ThreadUsingThreadClass("Sachin1's thread");
		tutc1.start();

		ThreadUsingThreadClass tutc2 = new ThreadUsingThreadClass("Megha1's thread");
		tutc2.start();
		
		ThreadUsingThreadClass tutc3 = new ThreadUsingThreadClass("Kajal1's thread");
		tutc3.start();
	}
	
}
