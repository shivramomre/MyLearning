package coding.ds.Queue;

import org.junit.Test;

public class QueueTest {

	@Test
	public void testQueue() {
		
		Queue q = new Queue(5);
		q.printQueue();
		
		q.push(10);
		q.push(20);
		q.push(30);
		q.push(40);
		q.push(50);
		q.printQueue();
		q.push(60);
		System.out.println(q.pop());
		q.printQueue();
		q.push(60);
		q.printQueue();
		q.push(70);
		q.printQueue();
	}

}
