package structures;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;



public class UnboundedQueueInterfaceTest {
	//just added
	private Queue impl;
	@Test
	public void testCopyConstructorEmpty() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		r = new Queue<Integer>(q);
		assertTrue(r.isEmpty());
		assertTrue(q.isEmpty());		
	}

	@Test
	public void testCopyConstructorEmptyNotAliased() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		r = new Queue<Integer>(q);
		assertTrue(r.isEmpty());
		assertTrue(q.isEmpty());		

		q.enqueue(1);
		q.enqueue(2);
		assertEquals(2, q.size());
		assertTrue(r.isEmpty());
				
		r.enqueue(3);
		r.enqueue(4);
		r.enqueue(5);
		assertEquals(2, q.size());
		assertEquals(3, r.size());
		
		r.dequeue();
		r.dequeue();
		r.dequeue();
		assertTrue(r.isEmpty());
		assertEquals(2, q.size());
		
		q.dequeue();
		q.dequeue();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void testCopyConstructorOneElement() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		q.enqueue(1);
		r = new Queue<Integer>(q);
		
		assertEquals(1, q.size());
		assertEquals(1, r.size());
	}

	@Test
	public void testCopyConstructorOneElementNotAliased() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		q.enqueue(1);
		r = new Queue<Integer>(q);

		q.enqueue(2);
		assertEquals(1, (int)r.dequeue());
		assertTrue(r.isEmpty());
		assertEquals(2, q.size());
	}

	@Test
	public void testCopyConstructorTwoElements() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		q.enqueue(1);
		q.enqueue(2);
		r = new Queue<Integer>(q);
		
		assertEquals(2, q.size());
		assertEquals(2, r.size());
	}

	@Test
	public void testCopyConstructorTwoElementsNotAliased() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		q.enqueue(1);
		q.enqueue(2);
		r = new Queue<Integer>(q);

		q.enqueue(3);
		assertEquals(1, (int)r.dequeue());
		assertEquals(3, q.size());
		assertEquals(1, r.size());
	}
	// my added test
	@Before
	
	public void setup() {
		impl = new Queue<Integer>();
	}

	@Test(timeout = 500)
	public void testQueue0() {
		assertTrue("Newly constructed queue should be empty", impl.isEmpty());
	}

	@Test(timeout = 500)
	public void testQueue1() {
		assertTrue("Newly constructed queue should be empty", impl.isEmpty());
		assertEquals("Newly constructed queue should have size 0", 0,
				impl.size());
	}

	@Test
    public void testNewQueueIsEmpty() {
        assertTrue(impl.isEmpty());
        assertEquals(impl.size(), 0);
    }

	@Test(timeout = 500)
	public void testQueueUnbounded() {
		for (int i = 0; i < 500000; i++) {
			assertEquals(i, impl.size());
			impl.enqueue(i);
		}
	}

	@Test(timeout = 500, expected = NullPointerException.class)
	public void testNullPointer() {
		impl.enqueue(null);
	}
	
	   @Test
	    public void testInsertsToEmptyQueue() {
	        int numberOfInserts = 6;
	        for (int i = 0; i < numberOfInserts; i++) {
	            impl.enqueue("zzz");
	        }
	        assertTrue(!impl.isEmpty());
	        assertEquals(impl.size(), numberOfInserts);
	    }
	   
	   @Test
	    public void testEnqueueThenDequeue() {
	        String message = "hello";
	        impl.enqueue(message);
	        assertEquals(impl.dequeue(), message);
	    }
	   
	   @Test
	    public void testEnqueueThenPeek() {
	        String message = "hello";
	        impl.enqueue(message);
	        int size = impl.size();
	        assertEquals(impl.peek(), message);
	        assertEquals(impl.size(), size);
	    }
	   
	   @Test(expected=NoSuchElementException.class)
	    public void testRemoveOnEmptyQueue() {
	        assertTrue(impl.isEmpty());
	        impl.dequeue();
	    }
	   
	   @Test
	   public void testReverseQueue(){
		   Queue<Integer> q = new Queue<Integer>();
		   q.enqueue(1);
		   q.enqueue(2);
		   q.enqueue(3);
		   Queue<Integer> rev = (Queue<Integer>) q.reversed();
		   assertEquals(3, (int)rev.dequeue());
		   assertEquals(2, (int)rev.dequeue());
		   assertEquals(1, (int)rev.dequeue());
	   }
	   
	   @Test 
	   public void testReverseOrigQueue(){
		   Queue<Integer> q = new Queue<Integer>();
		   q.enqueue(1);
		   q.enqueue(2);
		   q.enqueue(3);
		   Queue<Integer> rev = (Queue<Integer>) q.reversed();
		   assertEquals(1, (int)q.dequeue());
		   assertEquals(2, (int)q.dequeue());
		   assertEquals(3, (int)q.dequeue());
	   }
	   
	   


}
