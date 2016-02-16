package comparators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class ReverseIntegerComparatorTest {

  ReverseIntegerComparator comparator;
	
  @Before
  public void setup() {
    comparator = new ReverseIntegerComparator();
  }

  @Test (timeout = 100)
  public void testOne() {
	  assertEquals(1, comparator.compare(-5, -1));
	  assertEquals(1, comparator.compare(7, 99));
	  assertEquals(-1, comparator.compare(0, -1));
	  assertEquals(-1, comparator.compare(-6, -30));
	  assertEquals(0, comparator.compare(0, 0));
	  assertEquals(0, comparator.compare(-3, -3));
  }

}
