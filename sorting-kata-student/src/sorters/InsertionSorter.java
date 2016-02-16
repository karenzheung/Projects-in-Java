package sorters;

import java.util.Comparator;

import structures.SwapList;

public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO
		int size = list.size();
		for(int count = 1; count < size; count++ ){
			insertElement(0, count, list, comparator);
		}
		return list;
	}
	
	private void insertElement(int start, int end, SwapList<T> list, Comparator<T> comparator){
		boolean finished = false;
		int current = end;
		boolean moreToSearch = true;
		while(moreToSearch && !finished){
			if(list.compare(current, current-1, comparator)<0){
				list.swap(current, current-1);
				current--;
				moreToSearch = (current!= start);
			}
			else
				finished = true;
		}
	}
}
