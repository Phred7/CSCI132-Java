package labs.labIX;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionSortDemo {
	
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String args[]) {
		Random rand = new Random();
		int choice = 0;
		int capacity = 10;
		
		do {
			/**
			 * Grabs the next int from the user/terminal
			 */
			System.out.printf("Enter array capacity: ");
			while (!input.hasNextInt()) {
				System.out.println("Need an integer");
				String x = input.next();
			}
			capacity = input.nextInt();
			
			capacity = checkCapacity(capacity); //recursively verifies the array capacity entered
			
			/**
			 * creates new array of entered size
			 * populates array with random ints between 1 and 50
			 * prints array as String
			 */
			int[] data = new int[capacity]; 
			for(int i = 0; i < data.length; i++) {
				data[i] = rand.nextInt(50);
			}
			System.out.println(Arrays.toString(data));
			
			/**
			 * Prints and gets option
			 * if the user enters a number other than 0, 1, or 2 it is set to 0
			 */
			System.out.printf("\n1. Sort in ascending order\n2. Sort in decending order\n0. Quit\nEnter choice: ");
			while (!input.hasNextInt()) {
				System.out.println("Need an integer");
				String x = input.next();
			}
			choice = input.nextInt();
			if(choice != 0 && choice != 1 && choice != 2) {
				choice = 0;
			}
			
			/**
			 * runs each case
			 */
			switch(choice) {
			case 1: //ascending
				data = InsertionSort.insertionSortAscending(data);
				System.out.println(Arrays.toString(data));
				break;
			case 2: //descending
				data = InsertionSort.insertionSortDescending(data);
				System.out.println(Arrays.toString(data));
				break;
			case 0: //other
				System.out.println("Quit");
				break;
			}
			System.out.println("");
		}while(choice != 0); //ends when the user enters 0 or an invalid number
	}
	
	/**
	 * checks a number to ensure it is greater than or equal to 0
	 * recursively prompts user for new size until it is valid
	 * @param cap capacity of the array to verify is greater than or equal to 0
	 * @return new/valid array capacity
	 */
	public static int checkCapacity(int cap) {
		if(0 <= cap) {
			return cap;
		}else {
			System.out.println("Why is you this person??? Feel the judgment...");
			System.out.printf("Enter new array capacity: ");
			while (!input.hasNextInt()) {
				System.out.println("Need an integer");
				String x = input.next();
			}
			cap = input.nextInt();
			return checkCapacity(cap);
		}
	}
}
