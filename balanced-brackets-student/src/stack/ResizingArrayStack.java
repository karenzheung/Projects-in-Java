package stack;

public class ResizingArrayStack<T> implements Stack<T> {
    private T[] stack;
    private int size = 0;
    private int topIndex = -1;
    
    /**
     * Creates a new ResizingArrayStack.
     * @param initialCapacity the initial length of the backing array for the
     *        stack
     */
    public ResizingArrayStack(int initialCapacity) {
    	// TODO 1
    	stack = (T[]) new Object[initialCapacity];
    }

    @Override
    public T pop() throws StackUnderflowException {
    	// TODO 2
    	if(isEmpty())
    		throw new StackUnderflowException();
    	T topOfStack = stack[topIndex];
    	stack[topIndex] = null;
		topIndex--;
		
		if(size() <= stack.length/4 && stack.length!=1)
			resize(stack.length/2);
		
    	return topOfStack;
    }

    @Override
    public T peek() throws StackUnderflowException {
    	// TODO 3
    	if(isEmpty())
    		throw new StackUnderflowException();
    	return stack[topIndex];
    }

    @Override
    public void push(T element) {
    	// TODO 4
    	if(isFull()){
    		resize(stack.length*2);
    	}
    	topIndex++;
    	stack[topIndex] = element;
    }

    @Override
    public boolean isEmpty() {
    	return topIndex == -1;
    }

    @Override
    public int size() {
    	/*for(int i = 0; i < stack.length; i++){
    		if(stack[i]!=null)
    			size++;
    	}*/
    	return topIndex+1;
    }

    @Override
    public int capacity() {
    	// TODO 5
    	return stack.length;
    }
    
    private void resize(int newCap){
    	T[] tempStack = (T[]) new Object[newCap];
    	for(int i = 0; i <= topIndex; i++)
    		tempStack[i]=stack[i];
    	stack = tempStack;
    	
    }
    
    private boolean isFull(){
    	return topIndex == (stack.length-1);
    }

}
