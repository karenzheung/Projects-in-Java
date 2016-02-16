package stack;

import stack.LLNode;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
	LLNode<T> head;
	
	
	public LinkedStack(){
		head = null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if( head == null)
			throw new StackUnderflowException();
		T data = head.getData();
		head = head.getNext();	
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(head == null)
			throw new StackUnderflowException();
		return head.getData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head==null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		int size = 0;
		LLNode<T> temp = head;
		while(temp!=null){
			size++;
			temp = temp.getNext();
		}
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
		// TODO Auto-generated method stub
		LLNode<T> Link = head;
    	head = new LLNode<T>(elem);
    	head.setNext(Link);
		
	}

}
