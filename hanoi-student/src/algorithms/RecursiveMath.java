package algorithms;

/**
 * A class that implements some basic mathematical functions using recursion.
 * 
 * YOU MUST USE RECURSION, NOT ITERATION, TO IMPLEMENT THESE FUNCTIONS!
 *
 * @author jcollard
 */
public class RecursiveMath {

	/**
	 * Returns {@code true} if {@code val} is even and {@code false} otherwise.
	 *
	 * @param val
	 * @return {@code true} if {@code val} is even and {@code false} otherwise.
	 */
	public boolean isEven(int val) {
		// Without recursion this could be: return val % 2 == 0;
		if(val < 0)
			val = val*-1;
		if(val== 0)
			return true;
		else 
			return isOdd(val - 1);
		
	}

	/**
	 * Returns {@code true} if {@code val} is odd and {@code false} otherwise.
	 * 
	 * @param val
	 * @return {@code true} if {@code val} is odd and {@code false} otherwise.
	 */
	public boolean isOdd(int val) {
		// Without recursion this could be: return val % 2 == 1;
		if(val < 0)
			val = val*-1;
		if(val == 0)
			return false;
		else
			return isEven(val - 1);
		
	}

	/**
	 * Returns the sum of all values between 0 and n.
	 * 
	 * @param n
	 * @return the sum of all values between 0 and n.
	 * @throws IllegalArgumentException
	 *             if n is less than 0.
	 */
	public int sumN(int n){
		int value;
		if(n == 1)
			return 1;
		if(n == 0)
			return 0;
		if( n < 0)
			throw new IllegalArgumentException();
		else
			value = (n + sumN(n-1));
		return value;
	}

	/**
	 * Returns the multiplication of all values between 1 and n.
	 * 
	 * @param n
	 * @return the multiplication of all values between 1 and n.
	 * @throws IllegalArgumentException
	 *             if n is less than 1.
	 */
	public int factorial(int n) {
		int value;
		if(n == 1) 
			return 1;
		if(n < 1)
			throw new IllegalArgumentException();
		else
			value = (n*factorial(n-1));
		return value;
	}

	/**
	 * Returns 2 to the nth power. (2^n)
	 * 
	 * @param n
	 * @return 2 to the nth power.
	 * @throws IllegalArgumentException
	 *             if n is less than 0.
	 */
	public int biPower(int n) {
		int value;
		if(n < 0)
			throw new IllegalArgumentException();
		if(n == 0)
			return 1;
		if( n == 1)
			return 2;
		else
			value = (2*biPower(n-1));
		return value;
	}
}
