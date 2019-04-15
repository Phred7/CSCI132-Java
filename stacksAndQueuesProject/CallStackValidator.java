package stacksAndQueuesProject;

import java.util.Scanner;

public class CallStackValidator {
	private DLLStack<String> buffer = new DLLStack<>(); //DLL Stack creation
	
	//valid
	private final String callStack1 = "A calls B B calls C C halts B halts A halts";
	private final String callStack2 = "A calls B B calls C C calls D D halts C calls E E halts C halts B halts A halts";
	private final String callStack3 = "A calls A A halts A halts";
	private final String callStack4 = "main calls functionA functionA calls testMe testMe halts functionA calls runRun runRun halts functionA halts main halts";
	
	//invalid
	private final String callStack5 = "main calls A A calls B A calls C B halts C halts A halts main halts";
	private final String callStack6 = "A calls B B halts";
	
	public CallStackValidator() {
		System.out.println("cs1: " + validateCallStack(callStack1));
		System.out.println("cs2: " + validateCallStack(callStack2));
		System.out.println("cs3: " + validateCallStack(callStack3));
		System.out.println("cs4: " + validateCallStack(callStack4));
		System.out.println("cs5: " + validateCallStack(callStack5));
		System.out.println("cs6: " + validateCallStack(callStack6));
	}
	
	/**
	 * This method checks the validity of a String of method calls
	 * @param calls the String list of method calls from a given method
	 * @return boolean validity of the call stacks method calls
	 */
	public boolean validateCallStack(String calls) {
		buffer.clear();
		Scanner callStack = new Scanner(calls);
		callStack.useDelimiter(" ");
		String operation = callStack.next();
		String lastOp = operation;
		buffer.push(operation); //adds first method name to stack
		while (callStack.hasNext()) { //runs while the param calls has another value
			lastOp = operation;
			operation = callStack.next();
			if(getStringEquality(lastOp, buffer.top()) || getStringEquality(lastOp, "halts")) { //checks to see if the operation or method name is valid
				if(getStringEquality(operation, "calls")) { //add next method name to stack
					operation = callStack.next();
					buffer.push(operation);
				} else if (getStringEquality(operation, "halts")) { //remove last method name from stack
					buffer.pop();
				}
			}else { //if the method calls are out of order break out of the method (invalid call stack)
				//System.out.printf("break:\t last: %s, current: %s, top: %s\t",lastOp, operation, buffer.top());
				break;
			}
		}
		callStack.close();
		return buffer.isEmpty(); //if the buffer is empty the callStack is valid all methods started and ended
	}

	/**
	 * This method is used to see if all elements of two strings are equal
	 * Note: This is probably  but I was having issues with the methods from other libraries 
	 * @param a String to compare to b
	 * @param b String to compare to a
	 * @return boolean of the equality of every element of String a and String b
	 * True = a and b elements are all equal
	 */
	public boolean getStringEquality(String a, String b) {
		int length = -1;
		boolean check = true;
		if(a.length() == b.length()) {
			length = a.length();
		}else {
			check = false;
			return false;
		}
		
		if(length == -1) {
			new NullPointerException("Strings without equal length or null strings");
			check = false;
			return false;
		}else {
			for(int i = 0; i < length; i++) {
				if((int)a.charAt(i) != (int)b.charAt(i)) {
					i = length;
					check = false;
					return false;
				} else {
					check = true;
				}
			}
		}
		return check;
	}
}
