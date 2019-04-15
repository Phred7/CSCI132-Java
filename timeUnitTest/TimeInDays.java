/**
 * Lab 11
 * Program Correctness
 * 
 * Finish setting up the preconditions and postconditions for the 
 * TimeInDays unit test. We want to guarantee the user input is 
 * valid, and test output against several vectors to ensure correctness.
 * 
 * This program should take two command line argument, both integers between
 * 0 and 1000. The first arg is a number of years, and the second is a number
 * of days. The program is to return the whole amount of time as a number of days.
 * 
 * This Unit test uses assert, which can be tested at the command line by typing
 * the command line option -ea Ex: java -ea TimeInDays [arg1, arg2]
 * you may need to be in the bin directory to run it. Ex: java -ea lab10/TimeInDays [arg1, arg2]
 * It is also possible to use command line options and arguments inside the IDE.
 * In Eclipse: Run > Run Configurations... Arguments Tab, 
 * Example: Program Arguments (2, 20), VM Arguments (-ea)
 * 
 * Example: navigate to bin: java -ea lab11/TimeInDays 2 3
 * 
 */

package timeUnitTest;

public class TimeInDays { 
	
	private int years;
	private int days;
	
	public TimeInDays(String yearsArg, String daysArg) {
		
		// Pre-conditions: positive integers between 0 and 1000;
		// TODO: Exception handling for years and days; try/catch for user inputs
		
		years = Integer.parseInt(yearsArg);
		days = Integer.parseInt(daysArg);
		
		double allTheDays = convertToDays(years, days);
		System.out.println(allTheDays);
		
		// Post-conditions: Total number of days given days and years combined
		// to enable asserts at the command line, type -ea Ex: java -ea TimeInDays [arg1, arg2]
		
		System.out.println("START Unit Test");

		assert (convertToDays(0, 0) == 0) 	: 	"Assertion (0, 0) failed";
		assert (convertToDays(0, 1) == 1) 	: 	"Assertion (0, 1) failed";
		assert (convertToDays(1, 0) == 365) : 	"Assertion (1, 0) failed";
		assert (convertToDays(10, 0) == 3652) : 	"Assertion (10, 0) failed";
		
		// FIXME: Something appears to be a bug with this convertToDays() method. Fail on assertion (1, 0)..?
		// TODO: add several more test vectors here ...

		System.out.println("STOP Unit Test");
	}

	public int convertToDays(int numYears, int numDays) {

		int totalDays;
		totalDays = (numYears * 365) + numDays;
		
		// TODO: add 1 day for every 4 years to count leap years

		return numDays;
	}
	
	public static void ensureRange(int n, int max) throws IllegalArgumentException {
		if ((n < 0) || (n > max)) {
			throw new IllegalArgumentException("Out of Range.");
		}	
	}

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("ERROR: Please restart and provide two command line arguments:");
			System.out.println("Positive integers between 0 and 1000 for years and days.");
			return;
		}
		
		new TimeInDays(args[0], args[1]);

	}
}
