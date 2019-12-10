/**
 * @Purpose: The Sheet class represents a sheet with a list of shelves.
 * DO NOT MODIFY THE EXISTING METHODS SIGNITURE, You may add additional methods if you wish
 * 
 * @author  RYK 
 * @since   30/10/2019
 * extended by Kenneth 17045066
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

	//HELPER FUNCTION: Validate if a shelf can fit in sheet by height
	public boolean checkAddShelfToSheet (Shelf shelf) {
		if (shelf.getHeight() <= (getHeight() - allShelvesHeight())) {
			return true;
		}
		return false;
	}

	//HELPER FUNCTION: Attempts to add a shelf to sheet
	//This tries to see if a shelf with one shape can fit in a sheet. It also makes sure that the shape limit hasn't been reached. If it fails, then it will try rotating the shape in the shelf
	public boolean attemptAddShelfToSheet (Shelf shelf) {
		if (checkShapeLimit() == 0) { //if max shapes have been added
			return false;
		}

		if(!checkAddShelfToSheet(shelf)) { //if it still doesn't fit
			shelf.rotateShelf(); //Try to rotate shelf
			if(!checkAddShelfToSheet(shelf)) { //if it still doesn't fit
				shelf.rotateShelf(); //Go back to original orientation
				return false;
			}
			//Rotating 1st shape in shelf does help 
		}
		return true; 
	}

	//HELPER FUNCTION: Returns how many more shape can be added to a sheet
	public int checkShapeLimit () {
		int allowedShapes = SHAPE_LIMIT; 
		for (Shelf currentShelf : shelves) {
			allowedShapes -= currentShelf.getShapes().size();
		}
		return allowedShapes;
	}

	//HELPER FUNCTION: Output information about the sheet
	public void printSheet() {
		
		System.out.printf("%-5s - %-17s | %-17s | %-17s |\n", "", "Total height: "+allShelvesHeight(), "Shapes: "+(SHAPE_LIMIT - checkShapeLimit()), "Shelves: "+getShelves().size());
		int shelfCount = 1;
		for (Shelf currentShelf : shelves) {
			System.out.printf("\nShelf "+shelfCount);
			currentShelf.outputShelf();
			shelfCount++;
		}
	}
}
