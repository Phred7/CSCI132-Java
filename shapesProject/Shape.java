package shapesProject;

public interface Shape {

	/**
	 * @return area of a given shape
	 */
	public double getArea();
	
	/**
	 * @return perimeter of a given shape
	 */
	public double getPerimeter();
		
	/**
	 * @return number of sides for a given shape as a String
	 */
	public String printNumSides();
}
