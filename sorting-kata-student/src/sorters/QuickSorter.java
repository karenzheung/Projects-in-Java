package sorters;

import java.util.Comparator;

import structures.SwapList;

public class QuickSorter<T> extends AbstractSorter<T> {

	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO

		/*
		 * Note: When choosing a pivot, choose the element in the middle of the
		 * sub-array. That is,
		 * 
		 * pivotIndex = (firstIndex + lastIndex) / 2;
		 */

		quickSortHelper(0, list.size() - 1);
		//System.out.println(list);
		return list;
	}

	private void quickSortHelper(int first, int last) {
		//System.out.println(list);
		if (first < last) {
			int splitPoint = split(first, last);
			//System.out.println(list);
			quickSortHelper(first, splitPoint - 1);
			quickSortHelper(splitPoint + 1, last);
		}
	}

	private int split(int first, int last) {
		/*
		int splitVIndex = first;

		int pivot = first;
		first++;
		do {
			while (first <= last && list.compare(first, pivot, comparator) <= 0) {
				//System.out.println("1");
				first++;
			}
			while (first <= last && list.compare(last, pivot, comparator) >= 0) {
				//System.out.println("2");
				last--;
			}
			if (first <= last) {
				list.swap(first, last);
			//	System.out.println(list);
				first++;
				last--;

			}
		} while (first <= last);
		list.swap(pivot, last);
		//System.out.println(list);
		return last;*/
		int pivot = (first+last)/2;
		//System.out.println(list);
		list.swap(pivot, last);
		pivot = last;
		int nextSwap = first;
		 for (int i = first; i < last; i++) {
			    if (list.compare(i, pivot, comparator) < 0) {
			      list.swap(i, nextSwap);
			      			      nextSwap++;
			    }
			  }
		 list.swap(nextSwap, last);
		 return nextSwap;

	}

}