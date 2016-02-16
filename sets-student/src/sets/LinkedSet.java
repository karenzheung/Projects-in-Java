package sets;

import java.util.Iterator;

public class LinkedSet<E> implements Set<E> {
	private LinkedNode<E> head = null;

	// Constructors
	public LinkedSet() {
	}

	public LinkedSet(E e) {
		this.head = new LinkedNode<E>(e, null);
	}

	private LinkedSet(LinkedNode<E> head) {
		this.head = head;
	}

	@Override
	public int size() {
		// TODO (1)
		int size = 0;
		Iterator<E> currHead =this.iterator();
		while(currHead.hasNext()){
			size++;
			currHead.next();
		if(size > Integer.MAX_VALUE)
			size = Integer.MAX_VALUE;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO (2)

		return(head==null);
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedNodeIterator<E>(this.head);
	}

	@Override
	public boolean contains(Object o) {
		// TODO (3)
		Iterator<E> currHead =this.iterator();
		while(currHead.hasNext()){
			 if(currHead.next().equals(o))
				 return true; 
		 }


		 return false;
	}

	@Override
	public boolean isSubset(Set<E> that) {
		// TODO (4)
		Iterator<E> i = this.iterator();

		while(i.hasNext())
			if(!that.contains(i.next()))
				return false;
		return true;
	}

	@Override
	public boolean isSuperset(Set<E> that) {
		// TODO (5)
		return (that.isSubset(this));
	}

	@Override
	public Set<E> adjoin(E e) {
		// TODO (6)
		LinkedNode<E> hi = new LinkedNode<E>(e, this.head);

		if(this.contains(e))
			return this;
		else{
			LinkedSet<E> newSet = new LinkedSet<E>(hi);  
			return newSet;
		}
		
	}

	@Override
	public Set<E> union(Set<E> that) {
		// TODO (7)  
		Set<E> newSet = new LinkedSet<E>(this.head);
		for (E e : that){
			if(!newSet.contains(e))
				newSet = newSet.adjoin(e);
		}
	
		return newSet;
	}

	@Override
	public Set<E> intersect(Set<E> that) {
		// TODO (8)
		Set<E> newSet = new LinkedSet<E>();
		for (E e : that){
			if(this.contains(e))
				newSet = newSet.adjoin(e);
		}
		
		return newSet;
	}

	@Override
	public Set<E> subtract(Set<E> that) {
		// TODO (9)
		Set<E> newSet = new LinkedSet<E>();
		for (E e : this){
			if(!that.contains(e)){
				newSet = newSet.adjoin(e);
			}
		}
	
		return newSet;
	}

	@Override
	public Set<E> remove(E e) {
		// TODO (10)
		Set<E> newSet = new LinkedSet<E>();
		for (E a : this){
			if(!a.equals(e))
				newSet = newSet.adjoin(a);
		}
		return newSet;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if (! (o instanceof Set)) {
			return false;
		}
		Set<E> that = (Set<E>)o;
		return this.isSubset(that) && that.isSubset(this);
	}

	@Override
	public int hashCode() {
		int result = 0;
		for (E e : this) {
			result += e.hashCode();
		}
		return result;
	}
}
