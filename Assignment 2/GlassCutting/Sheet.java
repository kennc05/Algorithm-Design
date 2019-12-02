/**
 * @Purpose: The Sheet class represents a sheet with a list of shelves.
 * DO NOT MODIFY THE EXISTING METHODS SIGNITURE, You may add additional methods if you wish
 * 
 * @author  RYK 
 * @since   30/10/2019
 * extended by @author 
 */
import java.util.ArrayList;
import java.util.List;

public class Sheet {

	public static final int SHEET_HEIGHT = 250; // sheet height

	public static final int SHEET_WIDTH = 300; // sheet width

	public static final int SHAPE_LIMIT = 20; // maximum number of shapes that can be placed in each sheet (rule F)

	private List<Shelf> shelves = new ArrayList<Shelf>(); // list of shelves

	/**
	 * empty constructor
	 */
	public Sheet() {
	}

	/**
	 * This method is used to add a shelf to a sheet
	 * @param a shelf
	 */
	public void addShelf(Shelf shelf) {
		shelves.add(shelf);
	}

	/**
	 * @return height of all shelves in a sheet
	 */
	public int allShelvesHeight() {

		int total = 0;

		for (Shelf shelf : this.shelves) {

			// has a shelf with at least 1 shape
			if (!shelf.getShapes().isEmpty()) {

				// add all shelf height to total
				total += shelf.getHeight();
			}
		}
		return total;
	}

	/**
	 * @return list of all shelves in a sheet
	 */
	public List<Shelf> getShelves() {
		return this.shelves;
	}

	/**
	 * @return height
	 */
	public int getHeight() {
		return SHEET_HEIGHT;
	}

	/**
	 * @return width
	 */
	public int getWidth() {
		return SHEET_WIDTH;
	}

	//HELPER FUNCTION ADDED - check if you can add shelf to a sheet
	public boolean checkAddShelfToSheet (Shelf shelf) {
		System.out.println("Shelf height is "+shelf.getHeight());
		System.out.println("Checking remaining height before adding shelf: "+(getHeight() - allShelvesHeight()));
		System.out.println("Checking if shape limit has been reached. Allowed shapes left: "+checkShapeLimit());

		if (shelf.getHeight() <= (getHeight() - allShelvesHeight()) && checkShapeLimit() != 0) {
			return true;
		}

		
		System.out.println("Shelf can't fit - either too big or limit reached");
		return false;
	}

	//HELPER FUNCTION: Attempts to add a shelf to sheet - ONLY with its first shape in it (1) By its original orientation (2) If it fails, by its rotated orientation
	public boolean attemptRotateShelf (Shelf shelf) {
		shelf.rotateShelf(); //try rotate and see if it fit
		System.out.println("Rotating shelf to see if it fits");
		if(!checkAddShelfToSheet(shelf)) { //check again and see if it fits
			System.out.println("Rotated shelf doesn't help");
			//shelf.rotateShelf(); //Go back to original orientation
			return false;
		}
		System.out.println("Rotating shelf helps!!");
		return true; 
	}

	//HELPER FUNCTION: Check how many more shapes can be added

	public int checkShapeLimit () {
		int allowedShapes = SHAPE_LIMIT; //How many more shapes can be added to a sheet
		for (Shelf currentShelf : this.shelves) {
			allowedShapes -= currentShelf.getShapes().size();
		}
		return allowedShapes;
	}

	public int checkTotalShapes () {
		int count = 0;
		for (Shelf currentShelf : this.shelves) {
			count += currentShelf.getShapes().size();
		}
		return count;
	}

	//HELPER FUNCTION: Output information about the sheet
	public void printSheet() {
		System.out.println("Shapes in sheet: "+checkTotalShapes());
		System.out.println("Number of shelves: "+getShelves().size());
		System.out.println("Height of all shelves: "+allShelvesHeight());
	}

}
