package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;

import structures.Queue;

/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem. A level-order traversal is equivalent to a breadth-
 * first search.
 * 
 * @author liberato
 *
 */
public class LevelOrderIterator extends FileIterator<File> {	
	private Queue<File> q;
	
	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * @param rootNode
	 * @throws FileNotFoundException if the rootNode does not exist
	 */
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
		// TODO 1
		if(!rootNode.exists())
			throw new FileNotFoundException();
		q = new Queue<File>();
		q.enqueue(rootNode);
	}
	
	@Override
	public boolean hasNext() {
		// TODO 2
		return (!q.isEmpty());
	}

	@Override
	public File next() throws NoSuchElementException {
		// TODO 3
		if(hasNext()){ 
				File check = q.dequeue();
				if(check.isDirectory()){
					File[] files = check.listFiles();
					Arrays.sort(files);
					for(int i = 0; i < files.length; i++){
					q.enqueue(files[i]); 
					
					}
			
				}
				
				return check;
			
		}
		else
			throw new NoSuchElementException();
		//return null;
		
		
	
	}

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

}
