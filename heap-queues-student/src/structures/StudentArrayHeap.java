package structures;

import java.util.Comparator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {

	protected StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getLeftChildOf(int index) {
		// TODO Auto-generated method stub
		if(index < 0 )
			throw new IndexOutOfBoundsException();
		return (index*2)+1;
	}

	@Override
	protected int getRightChildOf(int index) {
		// TODO Auto-generated method stub
		if(index < 0 )
			throw new IndexOutOfBoundsException();
		return (index*2)+2;
	}

	@Override
	protected int getParentOf(int index) {
		// TODO Auto-generated method stub
		if(index < 1 )
			throw new IndexOutOfBoundsException();
		return (index-1)/2;
	}

	@Override
	protected void bubbleUp(int index) {
		// TODO Auto-generated method stub
		int hole = index;
		int parent = (hole-1)/2;
		while(hole > 0 && 
		 comparator.compare(heap.get(hole).getPriority(), heap.get(parent).getPriority())>0){
			swap(hole, parent);
			hole = parent;
			parent = (hole-1)/2;
		}
	}

	@Override
	protected void bubbleDown(int index) {
		// TODO Auto-generated method stub
		
		int left = getLeftChildOf(index);
		int right = getRightChildOf(index);
		//int swapChild = left;
		
		if (left < size() && comparator.compare(heap.get(index).getPriority(), heap.get(left).getPriority()) < 0) {
			swap(index, left);
			bubbleDown(left);
		}
		else if (right < size() && comparator.compare(heap.get(index).getPriority(), heap.get(right).getPriority()) < 0) {
			swap(index, right);
			bubbleDown(right);
		}
		
		/*int hole = index;
		int left = (2 * hole) + 1;
		int right = (2 * hole) + 2;

		while (left <= size() - 1) {
			if (right <= size() - 1) {
				if (comparator.compare(heap.get(left).getPriority(),
						heap.get(right).getPriority()) >= 0
						&& comparator.compare(heap.get(hole).getPriority(),
								heap.get(left).getPriority()) < 0) {		
					 swap(hole, left);
					 hole = left;
					 left = (2*hole)+1;
					 right = (2*hole)+2;
				} else if (comparator.compare(heap.get(right).getPriority(),
						heap.get(left).getPriority()) > 0
						&& comparator.compare(heap.get(hole).getPriority(),
								heap.get(right).getPriority()) < 0) {
				 swap(hole, right);
				 hole = right;
				right = (2 * hole) + 2;
				left = (2 * hole) + 1;
				}
			} else if (!(right <= size() - 1)) {
				if (comparator.compare(heap.get(left).getPriority(),
						heap.get(hole).getPriority()) > 0) {
					swap(hole, left);
					hole = left;
					left = (2 * hole) + 1;
				}

			}
		}*/

	}
}
