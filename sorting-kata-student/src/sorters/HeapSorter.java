package sorters;

import java.util.Comparator;

import structures.SwapList;

public class HeapSorter<T> extends AbstractSorter<T> {

	public HeapSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO
		//build my heap
		//System.out.println(list);
		int index = list.size()-1;
		int nonleafIndex = (list.size()-1)/2;
		for(int i = nonleafIndex; i >= 0; i--){
			bubbleDown(i, index);
			
		}
		
		for(int i = list.size()-1; i>=1; i--){
			list.swap(0, i);
			//System.out.println(list);
			bubbleDown(0, i-1);
			
		}
		return list;
	}
	
	private void bubbleDown(int hole, int lastIndex){
		
		   int l = 2 * hole + 1;
		    int r = 2 * hole + 2;
		    if (l > lastIndex) { return; }
		    int big = l;
		    if (r <= lastIndex &&
		        list.compare(r, l, comparator) > 0)
		      {
		        big = r;
		      }
		    if (list.compare(hole, big, comparator) < 0) {
		        list.swap(big, hole);
		        //System.out.println(list);
		        bubbleDown( big, lastIndex);
		    }
		    
		
		
	}
	
	private void bubbleDown(SwapList<T> list, int index){
		int l = 2 * index + 1;
	    int r = 2 * index + 2;
	   System.out.println(index);
	    if (l >= list.size()) { return; }
	    int big = l;
	    if (r < list.size() &&
	        list.compare(r, l, comparator) > 0)
	      {
	        big = r;
	      }
	    if (list.compare(index, big, comparator) < 0) {
	      list.swap(big, index);
	      System.out.println(list);
	      //bubbleDown(list, index-1);
	    }
	   
	}
	
	
}
