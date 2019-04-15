package animal;

public abstract class Animal {
	
	// Fields
	protected String name;
	protected int id;
	protected int age;
	
	// Constructors
	public Animal(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public Animal() {
		this("Nameless", 0, 0);
	}
	
	// Methods
	public void setName(String name) {
		this.name = name;
	}
	public void eat(String food) {
		System.out.println(this.name + " says, \"Nom, nom. Good " + food + ".\"");;
	}
}