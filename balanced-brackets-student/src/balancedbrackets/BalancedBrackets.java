package balancedbrackets;

import stack.ResizingArrayStack;
import stack.*;


/**
 * BalancedBrackets contains a single public static utility method and should
 * not be instantiated. It is marked as abstract to prevent attempts to
 * instantiate it.
 */
public abstract class BalancedBrackets {
    /**
     * Return true if and only if the string s is well-formed with respect to
     * matching brackets
     *
     * @param s a string to check for well-formedness
     * @return true iff the string is well-formed
     */
    public static boolean isBalanced(String s) {
        // TODO
    	ResizingArrayStack stack = new ResizingArrayStack(s.length());
    	
    	for(char chr : s.toCharArray()){
    		if(chr == '(' ||chr == '{' || chr== '[' ){
    			stack.push(chr);	
    		}
    		else if(chr == ')'){
    			if(stack.isEmpty() || (char)stack.pop() != '(')
    				return false;
    		}
    		else if(chr == ']'){
    			if(stack.isEmpty() || (char)stack.pop() != '[')
    				return false;
    		}
    		else if(chr == '}'){
    			if(stack.isEmpty() || (char)stack.pop() != '{')
    				return false;
    		}
    			/*try {
    			if((char)stack.pop() != '(' || (char)stack.pop() != '[' || (char)stack.pop() != '{' )
    				return false;
    			
    			}
    			catch(StackUnderflowException e){
    				return false;
    			
    		}
    	}*/
    		
    	    

    	
    	
    	
   
    }
    	if(stack.isEmpty()){
        	return true;}
        return false;
		
}
}
    
