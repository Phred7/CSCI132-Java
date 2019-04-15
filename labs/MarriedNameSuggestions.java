package labs;

import java.util.Scanner;

public class MarriedNameSuggestions {

	public static void main(String[] args) { //main method
		
		Scanner input = new Scanner(System.in); //define objects
		String personOneFirst;
		String personOneLast;
		String personTwoFirst;
		String personTwoLast;		
		
		System.out.print("Person one, first name: "); //prints question
		personOneFirst = input.nextLine();			  //grabs user input
		System.out.print("Person one,  last name: ");
		personOneLast = input.nextLine();
		System.out.print("Person two, first name: ");
		personTwoFirst = input.nextLine();
		System.out.print("Person two, last name: ");
		personTwoLast = input.nextLine();

		System.out.println("\nBelow are some possible names a married couple go with..."); //prints
		System.out.println(personOneFirst + " " + personOneLast + " and " + personTwoFirst + " " + personTwoLast); //prints both separately
		System.out.println(personOneFirst + " and " + personTwoFirst + " " + personOneLast); //prints with same last names (two cases)
		System.out.println(personOneFirst + " and " + personTwoFirst + " " + personTwoLast);
		System.out.println(personOneFirst + " and " + personTwoFirst + " " + personOneLast + "-" + personTwoLast); //prints hyphenated
		System.out.println(personOneFirst + " and " + personTwoFirst + " " + personTwoLast + "-" + personOneLast);		
		
		input.close(); //close input stream
	}

}