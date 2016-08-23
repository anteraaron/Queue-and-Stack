import static org.junit.Assert.*;

import org.junit.Test;


public class QueueUnitTest {

	@Test
	public void test() {
		Queue<Integer> q = new LinkedQueue<Integer>();
		
		for(int i = 0; i < 20; i++) {
			q.enqueue(new Integer(i));
			assertEquals(0, ((Integer)q.front()).intValue());
			assertEquals(i + 1, q.size());
		}
		
		for(int i = 0; i < 20; i++) {
			assertEquals(i, ((Integer) q.dequeue()).intValue());
			assertEquals(20 - i - 1, q.size());
		}
		
		Queue<String> stringQueue = new ArrayQueue<String>();
		
		stringQueue.enqueue("Richard");
		stringQueue.enqueue("Bryann");
		stringQueue.enqueue("Chua");
		assertEquals("Richard", stringQueue.dequeue());
		assertEquals("Bryann", stringQueue.dequeue());
		assertEquals("Chua", stringQueue.dequeue());
	}

}
