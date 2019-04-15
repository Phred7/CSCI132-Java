package labs;

import java.util.Scanner;

public class Doggo {
	
	private int age = 0;
	private int ageD;
	private String in;
	private double weight;
	private double weightKg;
	private String name;
	private boolean validity = false;
	private static final double lbsToKg = 0.453592;
	
	Scanner input = new Scanner(System.in);	
	
	public Doggo(){
		
	}
	
	public void setName() {
		System.out.println("Doggo's name: ");
		name = input.next();
	}
	
	public String getName() {
		return name;
	}
	/*
	 * Asks the user for the doggo's age or increments the age by 1 if an age has already been entered.
	 */
	public void setAge() {
		if(age == 0) {
			System.out.format("%s's age (in human yrs): ", getName());
			while(validity == false) {
				age = input.nextInt();
				if(age <= 0 || age >= 35) { //oldest doggo ever was 29.41666yrs ols (human)
					System.out.println("Please enter a valid age: ");
				}else {
					validity = true;
				}
			}
		}else {
			age++;
			System.out.format("%nHappy birthday, %s!%nUpdated Age: %d dog years.", getName(), getAgeD());
		}
		validity = false;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getAgeD() {
		ageD = age * 7;
		return ageD;
	}
	
	public void setAgeII() {
		if(age == 0) {
			System.out.format("%s's age (in human yrs): ", getName());
			while (!input.hasNextInt()) {
				System.out.println("Need an integer");
				String x = input.next();
			}
			age = input.nextInt();
		}else {
			age++;
			System.out.format("%nHappy birthday, %s!%nUpdated Age: %d dog years.", getName(), getAgeD());
		}
		validity = false;
	}
	
	public void setWeight() {
		System.out.format("%s's weight (in lbs): ", getName());
		while(validity == false) {
			while (!input.hasNextDouble()) {
				System.out.println("Need an double");
				String x = input.next();
			}
			weight = input.nextDouble();
			if(weight <= 0) {
				System.out.println("Please enter a valid weight: ");
			}else {
				validity = true;
			}
		}
		validity = false;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getWeightKg() {
		weightKg = weight * lbsToKg;
		return weightKg;
	}

	public void printDoggoInfo() {
		System.out.format("%n--Doggo's Info--%nDoggo's Name: %s%nDoggo's Age: %d dog years%nDoggo's Weight: %fkilos%n", getName(), getAgeD(), getWeightKg());
		setAgeII();
	}
	
	public void run() {
		setName();
		setAgeII();
		setWeight();
		printDoggoInfo();
	}

}
