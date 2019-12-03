/**
 *  @Purpose: The Generator class generates a list of shapes of random width and height.
 * Do NOT modify the names and signatures of the generator method
 * 
 * @author  RYK
 * @since   30/10/2019
 * extended by @author 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

	public static final int MAX_SIZE_HEIGHT = 250;
	public static final int MAX_SIZE_WIDTH = 300;

	/**
	 * This method will generate a list of shapes of random width and height
	 * (integers). The random width is between 1 and MAX_SIZE_WIDTH inclusive.
	 * The random height is between 1 and MAX_SIZE_HEIGHT inclusive.
	 * 
	 * @param numberOfShapes: the number of shapes to generate
	 * @return a list of shapes of random sizes
	 */

	public List<Shape> generateShapeList(int numberOfShapes) {

		List<Shape> shapes = new ArrayList<Shape>();

		
		/*
		shapes.add(new Shape(82, 60));
		shapes.add(new Shape(10, 130));
	    shapes.add(new Shape(182, 71));
		shapes.add(new Shape(172, 82));
		shapes.add(new Shape(293, 27)); 
		shapes.add(new Shape(293, 27)); 
		

		*/

		/*
		shapes.add(new Shape(300, 250));
		shapes.add(new Shape(10, 35));
	    shapes.add(new Shape(100, 110));
		shapes.add(new Shape(147, 210));
		shapes.add(new Shape(115, 25)); 
		shapes.add(new Shape(157, 90)); 
		

		//Check shape limit

		/*
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		shapes.add(new Shape(10, 10));
		*/

		/*
		shapes.add(new Shape(235, 164));
		shapes.add(new Shape(294, 143));
		shapes.add(new Shape(150, 135));
		shapes.add(new Shape(190, 175));
		shapes.add(new Shape(212, 49));
		*/


		/*
		shapes.add(new Shape(235, 164));
		shapes.add(new Shape(294, 143));
		shapes.add(new Shape(300, 86));
		shapes.add(new Shape(190, 107));
		shapes.add(new Shape(49, 212));
		*/

		/*
		shapes.add(new Shape(300, 200));
		shapes.add(new Shape(50, 250));
		*/

		/*
		shapes.add(new Shape(224, 74));
		shapes.add(new Shape(247, 216));
		shapes.add(new Shape(67, 121));
		shapes.add(new Shape(9, 182));
		shapes.add(new Shape(178, 169));

		

		shapes.add(new Shape(101, 134));
		shapes.add(new Shape(51, 98));
		shapes.add(new Shape(291, 246));
		shapes.add(new Shape(68, 76));
		shapes.add(new Shape(150, 6));
		shapes.add(new Shape(262, 17));


		*/

		Random randomtInt = new Random();

		for (int i = 0; i < numberOfShapes; i++) //Create a set number of shapes to generate
		 {
			int height = randomtInt.nextInt(MAX_SIZE_HEIGHT) + 1; //Start from 1 to (MAX_SIZE_HEIGHT-1)
			int width = randomtInt.nextInt(MAX_SIZE_WIDTH) + 1; //Start from 1 - (MAX_SIZE_WIDTH-1)

			//System.out.println("Shape "+i+" Height: "+height+" | Width: "+width);
			shapes.add(new Shape(width, height)); //Add to the shape list
		 }
		 
		 /*
		 int i = 0;
		 System.out.println("Shapes added: \n");
		 for(Shape currentShape : shapes) {
			System.out.println("Shape "+i+" Height: "+currentShape.getHeight()+" | Width: "+currentShape.getWidth());
			i++;
		 }
		 */
		 
		return shapes;
	}
}