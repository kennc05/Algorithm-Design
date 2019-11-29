/**
 * @Purpose: The Shelf class represents a shelf with a list of shapes.
 * DO NOT MODIFY THE EXISTING METHODS, You may add additional methods if you wish
 * 
 * @author  RYK 
 * @since   30/10/2019
 * extended by @author 
 */

import java.util.ArrayList;
import java.util.List;

public class Shelf {

	// The used width: the width of all the shapes placed in the shelf
	private int usedWidth;

	// Shelf height: Equals to the height of the first shape placed in the shelf
	private int shelfHeight;
	
	//List of shapes stored in the shelf
	List<Shape> shapes = new ArrayList<Shape>();

	/**
	 * empty constructor
	 */
	public Shelf() {

	}

	/**
	 * @return Height of the shelf
	 */
	public int getHeight() {

		if (shapes.size() != 0) {
			// equals to the height of shape placed at the left
			this.shelfHeight = shapes.get(0).getHeight();
			return this.shelfHeight;
		} else
			return 0;
	}

	/**
	 * This method is used to place a shape on a shelf
	 * @param shape: a shape
	 */
	public void place(Shape shape) {

		// add shape width to the shelf width
		usedWidth += shape.getWidth();
		shapes.add(shape);
	}

	/**
	 * @return list of all shapes placed in the shelf
	 */
	public List<Shape> getShapes() {
		return shapes;
	}

	 
	/**
	 * @return the used width of the shelf
	 */
	public int getWidth() {
		return usedWidth;
	}

	//HELPER FUNCTION ADDED - check that a shape can be added in checking height and width
	public boolean checkAddShapeToShelf(Shape shape, Sheet currentSheet) {
		if (shape.getHeight() <= getHeight() && shape.getWidth() <= (currentSheet.getWidth() - getWidth())) {
			place(shape); //place the shape on the shelf
			System.out.println("Shape has been added in!!");
			return true;
		}
		return false;
	}

	//Attempts to add a shape to shelf (1) By its original orientation (2) By its rotated orientation
	public boolean attemptAddToShelf (Shape shape, Sheet currentSheet) {
		if(!checkAddShapeToShelf(shape, currentSheet)) {
			//If it wasn't added in successfully then rotate shape and try again
			shape.rotateShape();
			System.out.println("Rotating shape");
			if (!checkAddShapeToShelf(shape, currentSheet)) {
				//If it still failed, then rotate shape back to original orientation
				System.out.println("Rotating shape back to original orientation");
				shape.rotateShape();
				return false;
			}
		}
		return true; //if it was added, then return true
	}

	//Another one...
	public void rotateShelf () {
		int tempWidth = usedWidth;

		usedWidth = shelfHeight;
		shelfHeight = tempWidth;

	}
}
