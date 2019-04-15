package shapesProject;

/**
 * @version 1.0
 * @author Walker Ward
 * @since 2/6/2019
 * 
 * This set of classes and one interface are used to calculate various parts of certain shapes ie: area, hyptoenuse, perimeter, circumfrence, number of sides...
 */

public class ShapeDriver {

	public static void main(String[] args) {
		
		/**
		 * First shape is a Rectangle lengths 5 and 9
		 * Second shape is a Square length 7
		 * Third shape is a Circle radius 3
		 * Fourth shape is a Equilateral Triangle with side length 11
		 * Fifth shape is a Right Triangle with side lengths 3 and 4
		 * Each print statement is a format making it easier to concatenate each piece of each object into each print
		 */
		
		Rectangle rect = new Rectangle(5, 9);
		System.out.format("First Shape: Rectangle with length: %1.1f and width: %1.1f%nArea: %1.2f | Perimeter: %1.2f | Number of Sides: %s%n%n", rect.length, rect.width, rect.getArea(), rect.getPerimeter(), rect.printNumSides());
	
		Square squr = new Square(7);
		System.out.format("Second Shape: Square with side length: %1.1f%nArea: %1.2f | Perimeter: %1.2f | Number of Sides: %s%n%n", squr.length , squr.getArea(), squr.getPerimeter(), squr.printNumSides());
		
		Circle circ = new Circle(3);
		System.out.format("Third Shape: Circle with diameter: %1.1f%nArea: %1.2f Circumfrence: %1.2f | Number of Sides: %s%n%n", circ.getDiameter(), circ.getArea(), circ.getPerimeter(), circ.printNumSides());
		
		EquilateralTriangle triEq = new EquilateralTriangle(11);
		System.out.format("Fourth Shape: Equilateral Triangle with 3 side lengths of: %1.1f and height: %1.2f%nArea: %1.2f | Perimeter: %1.2f | Number of Sides: %s%n%n", triEq.base, triEq.height, triEq.getArea(), triEq.getPerimeter(), triEq.printNumSides());
		
		RightTriangle triR = new RightTriangle(3, 4);
		System.out.format("Fifth Shape: Right Triangle with side a: %1.1f and side b: %1.1f%nArea: %1.2f | Perimeter: %1.2f | Hypotenuse: %1.2f%n%n", triR.base, triR.height, triR.getArea(), triR.getPerimeter(), triR.getHypotenuse(), triR.printNumSides());
	}

}
