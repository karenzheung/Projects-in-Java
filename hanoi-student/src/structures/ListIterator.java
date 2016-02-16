package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<T>  implements Iterator<T> {
	 
		private Node<T> head = null;
	
	  public ListIterator(Node<T> head) {
	   
		  this.head = head;
	  }

	  @Override
	  public boolean hasNext() {
	    // TODO (3)
		  
	    return(head!=null);
	  }

	  @Override
	  public T next() {
	    // TODO (4)
		  
	   if(hasNext()){
		   Node<T> temp = head;
		   head = head.getNext();
		   return temp.getData();
	   }
	   else
		   throw new NoSuchElementException();
	  
	  }

}
