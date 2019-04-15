package shapesProject;

public class Rectangle implements Shape {
	
	/**
	 * Fields
	 * width: length of one side
	 * length: length of one side
	 */
	protected double width;
	protected double length;
	
	/**
	 * Constructor
	 */
	public Rectangle() {
		
	}
	
	/**
	 * Constructor 
	 * @param w length of one side
	 * @param h length of another side
	 */
	public Rectangle(double w, double h) {
		this.width = w;
		this.length = h;
	}
	
	/**
	 * Area of a rectangle is the length of a side * length of the other side
	 */
	@Override
	public double getArea() {
		return width * length;
	}
	
	/**
	 * Perimeter of a rectangle is 2 * (width + length)
	 */
	@Override
	public double getPerimeter() {
		return 2 * (width + length);
	}
	
	/**
	 * A rectangle has four sides
	 */
	@Override
	public String printNumSides() {
		return "Four sides";
	}
}
