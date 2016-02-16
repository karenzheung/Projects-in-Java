package structures;

import java.util.NoSuchElementException;

public class Queue<T> implements UnboundedQueueInterface<T> {

	private int size=0; 
	private Node<T> head;
	private Node<T> tail; 
	
	public Queue() {
		// TODO 1
		head = null; 
		tail = null;
	}
	
	public Queue(Queue<T> other) {
		// TODO 2
		// Hint: Maybe save this one until after you finish enqueue()/dequeue()
		Queue<T> a = new Queue<T>();
		for (int i = other.size(); i >0; i--) {
			T elem = other.dequeue();
			this.enqueue(elem);
			a.enqueue(elem);
		}
		for (int j = a.size(); j > 0; j--)
			other.enqueue(a.dequeue());

	}
	
	@Override
	public boolean isEmpty() {
		// TODO 3
		return (head==null);
	}

	@Override
	public int size() {
		// TODO 4
		return size;
	}

	@Override
	public void enqueue(T element) {
		// TODO 5;
		if(element == null)
			throw new NullPointerException();
		if(isEmpty()){
			head = new Node<T>(element, null);
			tail = head;
			size++;
		}
		else{
			tail.setNext(new Node<T>(element, null));
			tail = tail.getNext();
			size++;
		}
		
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		// TODO 6;
		if(isEmpty())
			throw new NoSuchElementException();
		T temp = head.getData();
		head = head.getNext();
		if(head == null)
			tail = null;
		size--;
		return temp ;
	}

	@Override
	public T peek() throws NoSuchElementException {
		// TODO 7
		if(isEmpty())
			throw new NoSuchElementException();
 		return head.getData();
	}

	@Override
	public UnboundedQueueInterface<T> reversed() {
		// TODO 8
		// Hint: Maybe save this one until after you finish enqueue()/dequeue()
		Queue<T> temp = new Queue<T>(this);
		Queue<T> reverse = new Queue<T>();
		LinkedStack<T> stack = new LinkedStack<T>();
		while(!temp.isEmpty()){
			stack.push(temp.dequeue());
		}
		while(!stack.isEmpty())
			reverse.enqueue(stack.pop());
		
		return reverse;
	}
}
