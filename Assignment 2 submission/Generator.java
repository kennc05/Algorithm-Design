/**
 *  @Purpose: The Generator class generates a list of shapes of random width and height.
 * Do NOT modify the names and signatures of the generator method
 * 
 * @author  RYK
 * @since   30/10/2019
 * extended by Kenneth 17045066 
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
		
		Random randomtInt = new Random();

		for (int i = 0; i < numberOfShapes; i++) //Create a set number of shapes to generate
		 {
			int height = randomtInt.nextInt(MAX_SIZE_HEIGHT) + 1; //Start from 1 to (MAX_SIZE_HEIGHT)
			int width = randomtInt.nextInt(MAX_SIZE_WIDTH) + 1; //Start from 1 - (MAX_SIZE_WIDTH)
			shapes.add(new Shape(width, height)); //Add to the shape list
		 } 
		return shapes;
	}
}