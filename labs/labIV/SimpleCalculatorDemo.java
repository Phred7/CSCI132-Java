package labs.labIV;

import java.util.Scanner;
/**
 * Driver for SimpleCalculator Class
 * 
 * This driver class does not need to be modified.
 * Instead, (1) fix the SimpleCalculator.java code
 * by adding functionality for checking that the
 * user enters a valid operator when prompted,
 * and (2) implement the .calculateAnswer() method
 * so that it updates the total with the correct
 * answer.
 *
 */

public class SimpleCalculatorDemo {
	
	public SimpleCalculatorDemo() {
		SimpleCalculator myCalc = new SimpleCalculator();
		Scanner scnr = new Scanner(System.in);
		double nextVal;
		
		String op = "+"; // set operator to 'add' for the first time through
		
		do {
			System.out.print("Enter number\t: "); 		// prompt user for number
			
			while (!scnr.hasNextDouble()) {				// skip this loop if it's a double
				scnr.nextLine();						// otherwise get to next line
				System.out.print("Enter number\t: ");	// and prompt for a number
			}
			nextVal = scnr.nextDouble(); 				// capture a valid double

			// TODO: implement .calculateAnswer() method to recalculate the running total, given operator and nexVal
			myCalc.calculateAnswer(op, nextVal);		
			myCalc.printAnswer();					

			System.out.print("Enter operator\t: "); 	// prompt user for operator (or '=' to quit)
			
			op = scnr.next();		
			// TODO: update .checkUserOp() method to make sure we have a valid operator (+, -, *, /, ^, or =)
			while (!(myCalc.checkUserOp(op))) {
				op = scnr.next();
			}
		}
		while (!op.equals("="));						// '=' to quit

		scnr.close();
		// TODO: implement .printAnswer() method to show the running total to the user
		myCalc.printAnswer();
		System.out.println("<end>");
		
	}

	public static void main(String[] args) {
		
		new SimpleCalculatorDemo();
		
	}
}