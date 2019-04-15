package labs.labX;

public class BikeRental {

	//Fields
	private String firstName;
	private String lastName;
	private int hoursRented;
	private boolean available;

	// Constructor
	public BikeRental() {}
	
	// Methods
	/**
	 * Setters
	 */
	
	/**
	 * Initializes the BikeRental fields with the renter's name and how many hours
	 * 
	 * @param resFirstName		First Name of the guest
	 * @param resLastName		Last Name of the guest
	 * @param resHoursRented	Number of hours for reservation
	 * @param available			Whether the bike is available
	 */
	public void checkBikeOut(String resFirstName, String resLastName, int resHoursRented) {
		firstName = resFirstName;
		lastName = resLastName;
		hoursRented = resHoursRented;
		available = false;
	}

	/**
	 * Make a Bike available
	 */
	public void checkBikeIn() {
		firstName = "--";
		lastName = "--";
		hoursRented = 0;
		available = true;
	}

	/**
	 * Getters
	 */
	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public double getHoursRented() {
		return this.hoursRented;
	}

	public boolean isAvailable() {	
		
		return this.available; 
	}
	
	/**
	 * Print Bike fields
	 */
	public void printReservation() {	
		System.out.println(this.getFirstName() + "\t" + this.getLastName() + "\t" + this.getHoursRented());

	}
}
