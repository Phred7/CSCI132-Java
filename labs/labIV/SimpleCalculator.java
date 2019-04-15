package labs.labIV;

public class SimpleCalculator {
	
	// Fields
	// TODO: We need a way to keep track of the running total here
	private double total = 0;
	
	// Constructor (default is the empty constructor, which works here)
	public SimpleCalculator() {
		
	}
	// Methods
	public boolean checkUserOp(String op) {
		if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("^") || op.equals("=")) {
			return true;
		}else {
			System.out.print("Please enter a valid operator\t:");
			return false;
		}
		// FIXME: only return true only on valid arithmetic character, otherwise re-prompt user and return false
	}

	public void calculateAnswer(String op, double nextVal) {
		if(op.equals("+")) {
			total += nextVal;
		}else if(op.equals("-")) {
			total -= nextVal;
		}else if(op.equals("*")) {
			total *= nextVal;
		}else if(op.equals("/")) {
			total /= nextVal;
		}else if(op.equals("^")) {
			total = Math.pow(total, nextVal);
		}else {
			System.out.println("---error---");
		}
		// TODO: depending on the operator and the next value, update the runningTotal
	}

	public void printAnswer() {
		System.out.format("Total is now    : %1.1f%n", total);
		// TODO: print the answer for the user to see
	}
	
}
