package shapesProject;

public class EquilateralTriangle extends Triangle{
	
	/**
	 * Constructor takes in the side length and sets it equal to both the base and height of this triangle
	 * @param side length of one side (technically the two shorter legs)
	 */
	public EquilateralTriangle(double side) {
		super.base = side;
		super.height = 0.5 * Math.sqrt((3*Math.pow(side, 2)));
		//System.out.printf("%nheight: %1.2f%n%n", super.height);
	}
	
	/**
	 * gets the perimeter of this triangle
	 */
	@Override
	public double getPerimeter() {
		return 3 * super.base;
	}

	
}
