package weekII;

import java.text.DecimalFormat;
import java.util.Scanner;

public class IODemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// System.out.println("Hello again.");
		
		// float myFloat = 3.24f;
		
		// System.out.println(myFloat);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your name?");
		
		String yourName = input.nextLine();
		
		System.out.println("Hi, " + yourName + ", how many lbs of cheese would you like?");
		
		double lbsOfCheese;
		
		
		
		while (!input.hasNextDouble()) {
			input.nextLine();
			System.out.println("I need a number here.");
		}
		
		lbsOfCheese = input.nextDouble();
		
		DecimalFormat price = new DecimalFormat("$0.00");
		
		String total = price.format(lbsOfCheese * 5);
		
		System.out.println("That will be " + total + ", please.");
		
		input.close();

		

	}

}
