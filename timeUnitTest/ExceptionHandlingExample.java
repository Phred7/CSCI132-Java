/**
 * Given 2 Command Line Arguments: a String, and an integer
 * the output will repeat the string the specified number of times
 * 
 * This program is a throwback to Week 5 when we first looked at running a program
 * with command line arguments. The method main(String[] args) has a parameter:
 * an array of String objects. We use it here to collect a String and an integer from
 * the user, and then print the String the number of times given as the secound arg.
 * 
 * Also in this example are some try, catch, throw, and throws keywords. 
 * 
 * To run a program from the command line...
 * 1. navigate with a Terminal window (Mac, Linux) or Command window (Microsoft) to your bin directory
 * 2. type >> java lab10/ExceptionHandlingExample "test" 2 
 * ... where "test" and 2 are your command line arguments, and lab10 is the package (containing folder)
 * 
 * OR
 * You can use your IDE to configure command line inputs. Do a web search or see your IDE's Help for specifics.
 * In Eclipse, it's Run > Run Configurations: Arguments Tab
 * 
 * 
 */
package timeUnitTest;

public class ExceptionHandlingExample {
	
	public static void ensurePositive(int n) throws IllegalArgumentException {
		if (n < 0) {
			throw new IllegalArgumentException("It's not a positive int.");
		}
	}

	public static void main(String[] args) {

		/**
		 * There's a problem when we don't put args in, and the program expects them...
		 * We can put a check in place for the right number of arguments, and end if
		 * needed.
		 * 
		 * We get a message that says "NumberFormatException" if the user didn't enter
		 * an int properly Java gives us a way to handle those kinds of "unexpected"
		 * issues: try, catch statements...
		 */

		if (args.length != 2) {
			System.out.println("ERROR: You need two arguments to run this program: a string and a positive int.");
			return;
		}

		// capture first arg to our String variable userString
		String userString = args[0];

		// convert second arg from string to int, and capture to our int variable n
		int n = 0;
		try {
			n = Integer.parseInt(args[1]); // attempt the thing that may not work
			ensurePositive(n); // test your condition and throw an exception
		} catch (NumberFormatException e) { // catch the exception that might happen,
			n = 1; // ...and handle it
			System.out.println(args[1] + " is not an integer. Using 1.");
		} catch (IllegalArgumentException e) {
			n = Math.abs(n); // ...and handle it
			System.out.println(args[1] + " won't work. Making it positive. " + e.getMessage());
		}

		// write a for loop to print userString n times
		for (int i = 0; i < n; i++) {
			System.out.println(userString);
		}

	}

}
