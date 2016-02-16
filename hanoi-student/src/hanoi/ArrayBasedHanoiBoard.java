package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {
	private StackBasedHanoiPeg[] gameBoard;
	private int numofRings;
	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 */
	
	public ArrayBasedHanoiBoard(int n) {
		if( n < 0)
			throw new IllegalArgumentException();
		numofRings = n;
		gameBoard= new StackBasedHanoiPeg[3];
		for(int i = 0; i < 3; i++)
			gameBoard[i] = new StackBasedHanoiPeg();
		for(int i = n; i > 0; i--){
			gameBoard[0].addRing(new HanoiRing(i));
		}
		
	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if (!isLegalMove(move)) {
			throw new IllegalHanoiMoveException(
					"Could not perform illegal move.");
		}
		int to = move.getToPeg();
		int from = move.getFromPeg();
		HanoiRing ring = gameBoard[from].remove();
		gameBoard[to].addRing(ring);
		
		
	}

	@Override
	public boolean isSolved() {
		return(!gameBoard[0].hasRings() && !gameBoard[1].hasRings());
		
	}

	@Override
	public boolean isLegalMove(HanoiMove move) {
		if(move == null)
			throw new NullPointerException();
		int to = move.getToPeg();
		int from = move.getFromPeg();
		if(!gameBoard[from].hasRings())
			return false;
		if(to==from)
			return false;
		if(!gameBoard[to].hasRings())
			return true;
		if(gameBoard[from].getTopRing().getSize() < gameBoard[to].getTopRing().getSize())
			return true;
		return false;
	
			
	}
}
