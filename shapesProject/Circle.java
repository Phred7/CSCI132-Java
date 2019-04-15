package shapesProject;

public class Circle implements Shape {

	/**
	 * Fields
	 * radius: Used for calculations
	 */
	protected double radius;
	
	/**
	 * Constructor
	 * @param radius: radius of the circle
	 */
	public Circle(double radius) {
		this.radius = radius;
	}
	
	/**
	 * Area of a Circle = pi*r^2
	 */
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	/**
	 * Perimeter of this circle = Circumference of this circle
	 */
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	/**
	 * A circle has an infinite amount of tangent lines and therefore an infinite number of sides
	 */
	@Override
	public String printNumSides() {
		return "Infinatly many sides";
	}
	
	/**
	 * gets the diameter of this circle
	 * @return diameter = radius * 2
	 */
	public double getDiameter() {
		return radius * 2;
	}

}
