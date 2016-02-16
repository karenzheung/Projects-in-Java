package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ListImplementation<T> implements ListInterface<T> {
	private LinkedStack<T> cool;
	private Node<T> head; 
	private int size=0;
	private Node<T> tail;
	
	public ListImplementation(){
		cool = new LinkedStack<T>();
		head = null;
		tail = null;
		
	}
	@Override
	
	
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return (size() == 0);
	}

	@Override
	public T get(int n) throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(n < 0)
			throw new NoSuchElementException();
		if( n >= size())
			throw new NoSuchElementException();
		int i = 0;
		Node<T> temp = head;
		while(i!=n){
			temp = temp.getNext();
			i++;
		}
		
		return temp.getData();
	}

	@Override
	public ListInterface<T> append(T elem) {
		// TODO Auto-generated method stub
		if(elem == null)
			throw new NullPointerException();
		if(isEmpty()){
			head = new Node(elem, null);
			tail = head;
			size++;
		}
		else{
			tail.setNext(new Node(elem, null));
			tail = tail.getNext();
			size++;
		}
		
		return this;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator(head);
	}

	
}
