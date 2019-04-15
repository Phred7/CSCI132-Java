package animal;

public class AnimalDemo {

	public static void main(String[] args) {
		
		Animal anim01 = new SlowLoris("Pete", 1234, 3);
		System.out.println("First animal is " + anim01.name);
		
		SlowLoris anim02 = new SlowLoris("Sabrina", 4321, 2);
		System.out.println("Second up is " + anim02.name);
		
		anim02.eat("leaves");
		
//		Animal anim03 = new Animal("Betty", 3, 2);		// We don't want to be able to do this.
//		System.out.println("Next is " + anim03.name);	// So we can make the animal class abstract.

	}

}
