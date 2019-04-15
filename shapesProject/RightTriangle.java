package shapesProject;

public class RightTriangle extends Triangle{

	/**
	 * Constructor
	 * @param a length of the shortest side
	 * @param b length of the longest side
	 */
	public RightTriangle(double a, double b) {
		super.base = a;
		super.height = b;
	}
	
	/**
	 * perimeter of a triangle = a + b + c
	 */
	@Override
	public double getPerimeter() {
		return base + height + getHypotenuse();
	}
	
	/**
	 * 
	 * @return c = hypotenuse of the triangle
	 * c is proportional to the square root of the sum of the squared side lengths (two shorter legs)
	 */
	public double getHypotenuse() {
		return Math.hypot(base, height);
		
	}
	
}
