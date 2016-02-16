package hanoi;

import java.util.NoSuchElementException;

import structures.LinkedStack;


/**
 * A {@link StackBasedHanoiPeg} is an implementation of {@link HanoiPeg}.
 * 
 * @author jcollard
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	private LinkedStack<HanoiRing> game;
	

	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	public StackBasedHanoiPeg() {
	game = new LinkedStack<HanoiRing>();
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if(ring == null)
			throw new NullPointerException();
		Object HanoiRing;
		if(game.isEmpty())
			game.push(ring);
		else{
		/*try{
			game.peek();
		}
		catch (NoSuchElementException e){
			game.push(ring);
			
		}*/
		HanoiRing temp = game.peek();
		if(ring.getSize() >= temp.getSize())
			throw new IllegalHanoiMoveException("Ring must be smaller");
		game.push(ring);
		//if(ring == null)
			//throw new NullPointerException();
		}
		
		
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		if(game.isEmpty())
			throw new IllegalHanoiMoveException("Nothing here");
		return game.pop();
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if(game.isEmpty())
			throw new IllegalHanoiMoveException("Nothing on the peg!");
		return game.peek();
	}

	@Override
	public boolean hasRings() {
		return(!game.isEmpty());
		
	}
}
