package language.arith;

import language.Operand;
import language.Operator;

public abstract class UnaryOperator<T> implements Operator<T>{
	private Operand<T> op0;
	
	public final int getNumberOfArguments() {
		return 1;
	}
	
	public Operand<T> getOp0() {
		return op0;
	}
	//just added
	public void setOp0(Operand<T> hm){
		op0 = hm;
	}
	public void setOperand(int i, Operand<T> operand) {
		if(operand == null)
			throw new NullPointerException("Could not set null operand.");
		if(i > 1)
			throw new IllegalArgumentException("Unary operator only accepts operands 0 and 1 but recieved " + i + ".");
		if(i == 0){
			if(op0 != null)
				throw new IllegalStateException("Position " + i + " has been previously set.");
			op0 = operand;
		} 
	}
}
