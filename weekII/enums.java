package weekII;

public class enums {
	
	enum Day {SUN, MON, TUE, WED, THU, FRI, SAT};
	
	public static void main(String[] args) {
		
		Day today;
		
		today = Day.FRI;
		
		/*if(today == Day.WED) {
			System.out.println("It's HUMP-DAY!!!");
		}else {
			System.out.println("nope.");
		}*/
		
		switch (today) {
		case SAT: 
		case SUN:
		case THU:
			System.out.println("Not Today");
			break;
		case TUE:
			System.out.println("Lab Day");
			break;
		case MON:
		case WED:
		case FRI:
			System.out.println("Class today");
			break;
		default:
			System.out.println("Error");
			break;
		}
	}

}
