package shapesProject;

public abstract class Triangle implements Shape {
	
	/**
	 * Fields
	 * base length of the base of this triangle
	 * height length of the height of this triangle
	 */
	protected double base;
	protected double height;
	
	/**
	 * gets the area of a triangle = .5 * base * height
	 */
	@Override
	public double getArea() {
		return 0.5 * base * height;
	}
	
	/**
	 * returns the number of sides of a TRIangle as a string 
	 */
	@Override
	public String printNumSides() {
		return "Three sides";
	}
}
