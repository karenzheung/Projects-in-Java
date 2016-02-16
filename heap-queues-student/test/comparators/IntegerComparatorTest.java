package comparators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class IntegerComparatorTest {

  IntegerComparator comparator;
	
  @Before
  public void setup() {
    comparator = new IntegerComparator();
  }

  @Test (timeout = 100)
  public void testOne() {
	  assertEquals(-1, comparator.compare(0, 1));
	  assertEquals(-1, comparator.compare(1, 4));
	  assertEquals(1, comparator.compare(5, 4));
	  assertEquals(1, comparator.compare(15, 8));
	  assertEquals(0, comparator.compare(-1, -1));
  }

}
