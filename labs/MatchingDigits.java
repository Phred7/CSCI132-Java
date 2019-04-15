package labs;

import java.util.Scanner;

public class MatchingDigits {
	
	private static boolean match = false;
	private static int length = 0;
	private static int number = 0;
	private static int[] arrayM;
	private static boolean validity = false;
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		play();
	}
	
	public static int[] generateArray() { //creates an array of user input length/size 
		while(validity == false) { //if a users input is valid (see if statement)
			System.out.println("How many digits are in the non-negative integer you want to test?");
			length = input.nextInt();
			if(length <= 1) { //if the user wants to use a number that contains one or less than one digits that is non valid
				System.out.println("Sorry that input is invalid please try again");
			}else { //if the users input is valid break out of the while loop
				validity = true;
			}
		}
		validity = false; //reset boolean
		int[] array = new int[length]; //create array of given length
		return array; //return the array for use in other methods
	}
	
	public static int[] populateArray(int[] array) { //grabs user inputs and stores them in an array at given indexes
		System.out.println("Enter the number, each non-negative integer on a new line:");
		for(int i = 0; i < array.length; i++) { 
			validity = false; //reset boolean
			while(validity == false) { //until the user input is valid do the following
				array[i] = input.nextInt();
				if(array[i] < 0 || array[i] > 9) { //if the entered value is greater than 10 or less than 0 the input is invalid
					System.out.println("Sorry that input is invalid please try again");
				}else {//if a user input is valid
					validity = true; 
				}
			}
			
		}
		return array; //return the array for use in other methods
	}
	
	public static int[] matching(int[] array) { //compares the values in the array to each other
		for(int i = 0; i < array.length; i++) { 
			for(int j = 0; j < array.length; j++) {
				if(array[i] == array[j] && i != j) { //if the values of the array are equal and i and j are not equal
					match = true;
				}else if(match != true){ //this is to ensure that if a match does exist it is not overwritten
					match = false;
				}
			}
		}
		return array; //returns the array for use in other methods
	}
	
	public static int getNumber() { //generates the number based on the length and the array (used for print statements)
		for(int i = 0; i < arrayM.length; i++) {
			number += (arrayM[i] * Math.pow(10, (arrayM.length - (i+1)))); //calculation that takes each index and multiplies it by 10^(length - i+1)
		}
		return number; //returns the number for use in formatted print statements
	}
	
	public static void play() { //runs the program
		arrayM = matching(populateArray(generateArray())); //sets the local variable equal to the array generated by all of the methods
		if(match == true) { //in the event that the boolean match is set to true in the matching method then print this statement
			System.out.format("Yes. %d contains matching digits%n", getNumber()); //prints with the number generated by getNumber method
		}else {
			System.out.format("No. %d contains no matching digits%n", getNumber()); //prints with the number generated by getNumber method
		}
	}

}