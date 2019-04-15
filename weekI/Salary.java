package weekI;

import java.util.Scanner;

import week0.Counter;

public class Salary {

	public static void main(String[] args) {
		
		int wage = 0;
		
		System.out.print("What is your wage? ");
		Scanner input = new Scanner(System.in);
		wage = input.nextInt();
		
		
		System.out.print("Salery is: ");
		System.out.println(wage * 50 * 40);
		
		input.close();

	}

}
