package evaluator.arith;

import language.Operand;
import language.Operator;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser.Type;
import parser.Token;
import parser.arith.ArithPostfixParser;
import stack.LinkedStack;
import stack.StackInterface;
import stack.StackUnderflowException;
import evaluator.PostfixEvaluator;
import language.arith.*;

/**
 * An {@link ArithPostfixEvaluator} is a postfix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostfixEvaluator implements PostfixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;
	
	
	/**
	 * Constructs an {@link ArithPostfixEvaluator}
	 */
	public ArithPostfixEvaluator(){
		this.stack = new LinkedStack<Operand<Integer>>();
		
		//TODO initialize your LinkedStack
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer evaluate(String expr) throws IllegalPostfixExpressionException {
		// TODO use all of the things you've built so far to 
		// implement the algorithm for postfix expression evaluation
		
		ArithPostfixParser parser = new ArithPostfixParser(expr);
		for (Token<Integer> token : parser) {
			Type type = token.getType();
			switch(type){ 
			case OPERAND:
				//TODO What do we do when we see an operand?
				stack.push(token.getOperand());
				break;
			case OPERATOR:
				//TODO What do we do when we see an operator?
				
				Operator<Integer> oppp = token.getOperator();
				Operand<Integer> op0;
				Operand<Integer> op1;
				if(token.getOperator().getNumberOfArguments()==1){
					//System.out.println("Here");
					
					if(stack.isEmpty())
						throw new StackUnderflowException();
					op0 = stack.pop();
					//System.out.println(op0);
					oppp.setOperand(0, op0);
				}
				else{
				if(stack.isEmpty())
					throw new StackUnderflowException();
					op1 = stack.pop();
					oppp.setOperand(1, op1);
				if(stack.isEmpty())
					throw new StackUnderflowException();
					op0 = stack.pop();
					oppp.setOperand(0, op0);
				
				}
					Operand<Integer> result = oppp.performOperation();
					stack.push(result);
				
				
				break;
			default:
				//throw new IllegalPostfixExpressionException("Parser returned an invalid Type: " + type);
				throw new IllegalStateException("Parser returned an invalid Type: " + type);
			}			
		}
		
		
		Integer re = stack.pop().getValue();	
	
		//TODO What do we return?
		if(!stack.isEmpty())
			throw new IllegalPostfixExpressionException();
		return re; 
	}

}
