package structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class MinQueueTest {

  MinQueue<String> queue;
	
  @Before
  public void setup() {
    queue = new MinQueue<String>();
  }

  @Test (timeout = 100)
  public void testQueue() {
    queue.enqueue(100, "Low priority");
    queue.enqueue(50, "Medium priority");
    queue.enqueue(25, "High priority");
    queue.enqueue(0, "Highest priority");
    assertEquals("Highest priority", queue.dequeue());
    assertEquals("High priority", queue.dequeue());
    assertEquals("Medium priority", queue.dequeue());
    assertEquals("Low priority", queue.dequeue());
  }
  
  @Test
  public void testIsNotEmpty(){
	  assertTrue(queue.isEmpty());
  }
  
  @Test
  public void testIsEmpty(){
	  queue.enqueue(0, "low");
	  assertFalse(queue.isEmpty());
  }
  
  @Test
  public void testPeek(){
	  queue.enqueue(0, "hee");
	  assertEquals("hee", queue.peek());
  }
  
  @Test (timeout = 100, expected = IllegalStateException.class)
  public void testPeekException(){
	  queue.peek();
  }
  
  @Test(timeout = 100, expected = NullPointerException.class)
  public void testEnqueueException(){
	  queue.enqueue(null, "i");
	  
  }

  @Test
  public void testEnqueue(){
	  queue.enqueue(1, "med");
	  assertEquals("med", queue.peek());
	  queue.enqueue(0, "high");
	  assertEquals("high", queue.peek());
	  queue.enqueue(3, "low");
	  assertEquals("high", queue.peek());
	  assertEquals(3, queue.size());
  }
  
  @Test (timeout = 100, expected = IllegalStateException.class)
  public void testDequeueException(){
	  queue.dequeue();
  }
  
  @Test
  public void testDequeueandEnqeue(){
	  queue.enqueue(0, "high");
	  assertEquals("high", queue.peek());
	  queue.enqueue(1, "med");
	  assertEquals("high", queue.peek());
	  queue.enqueue(2, "low");
	  assertEquals("high", queue.peek());
	  assertEquals("high", queue.dequeue());
	  assertEquals("med", queue.dequeue());
  }
  
  @Test
  public void testGetComparator(){
	assertEquals(1, queue.getComparator().compare(6, 9));
	assertEquals(-1, queue.getComparator().compare(100, 0));
	assertEquals(0, queue.getComparator().compare(-9, -9));
	assertEquals(-1, queue.getComparator().compare(-7, -99));
	assertEquals(1, queue.getComparator().compare(-9, 0));
  }
  
  @Test 
  public void testIterator(){
	  assertFalse(queue.iterator().hasNext());
	  queue.enqueue(0, "high");
	  queue.enqueue(1, "med");
	  queue.enqueue(2, "low");
	  assertTrue(queue.iterator().hasNext());
	  boolean b = false;
	  Iterator it = queue.iterator();
	  while(it.hasNext()){
		  Entry<Integer, String> entry = (Entry<Integer, String>) it.next();
		  if(entry.getPriority()==2 && entry.getValue().equals("low"))
			  b = true;
	  }
	  assertTrue(b);
  }
}
