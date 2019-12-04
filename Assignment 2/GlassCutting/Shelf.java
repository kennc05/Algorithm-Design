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

	//HELPER FUNCTION: Validate that a shape can be added in checking against its height and width
	public boolean checkAddShapeToShelf(Shape currentShape, Sheet currentSheet) {
		if (currentShape.getHeight() <= getHeight() && currentShape.getWidth() <= (currentSheet.getWidth() - getWidth())) {
			place(currentShape); //place the shape on the shelf
			return true;
		}
		return false;
	}

	//HELPER FUNCTION: Attempts to add a shape to shelf, if it is the first shape on shelf, then add it.
	//It also checks if the shape limit has been reached first. 
	//If the limit hasn't been reached then: Add shape (1) By its original orientation (2) If it fails, by its rotated orientation
	public boolean attemptAddShapeToShelf (Shape currentShape, Sheet currentSheet) {
		if(getShapes().size() == 0) {
			place(currentShape);
			return true;
		}

		if(getShapes().size() + 1 > currentSheet.checkShapeLimit()) {
			//System.out.println("Shape limit reached! Adding in shape will mean sheet has " +(getShapes().size() + 1)+" shapes");
			return false;
		}

		if(!checkAddShapeToShelf(currentShape, currentSheet)) {
			//If it wasn't added in successfully then rotate shape and try again
			
			currentShape.rotateShape();
			if (!checkAddShapeToShelf(currentShape, currentSheet)) {
				//If it still failed, then rotate shape back to original orientation and return false
				currentShape.rotateShape();
				return false;
			}
		}
		return true; //if it was added, then return true
	}

	//HELPER FUNCTION: When there is only one shape in a shelf, and it doesn't fit a sheet in its original orientation, this will be used
	//to rotate the shape 
	public void rotateShelf () {
		shapes.get(0).rotateShape();
	}

	//HELPER FUNCTION: To output information about a shelf
	public void outputShelf () {
		
		System.out.printf("%-5s - %-17s | %-17s | %-17s |\n", "", "Height used: "+getHeight(), "Width: "+usedWidth, "Shapes: "+getShapes().size());
		int shapeCount = 1;
		for (Shape currentShape : shapes) {
			System.out.printf("Shape "+shapeCount);
			currentShape.outputShape();
			shapeCount++;
		}
	}
}
