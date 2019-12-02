/**
 * @Purpose: The Algorithms class contains the two algorithms you have to implement  
 * Do NOT modify the names and signatures of the two algorithm methods
 * 
 * @author  RYK
 * @since   30/10/2019
 * extended by @author 
 *
 **/

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Algorithms {

	/**
	 * This method is used to implement the next fit algorithm
	 * 
	 * @param shapes:a list of shapes representing customer requests(shapes to be
	 *            cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e.
	 *         place all the shapes). e.g. if you pass a "shapes" list that has
	 *         two shapes {(w=200,h=200),(w=50,h=100)}, then the returned list
	 *         of sheets should show us all the information needed (e.g. that
	 *         one sheet is used, this sheet has one shelf and this shelf has
	 *         two shapes in it). In the test program, you can use the returned
	 *         list to retrieve the total number of sheets used.
	 **/

	public List<Sheet> nextFit(List<Shape> shapes) {

		/*
		 * Start with an empty list of sheets (remember each sheet has a width
		 * of 300 and a height of 250 as specified in the Sheet class)
		 */
		List<Sheet> usedSheets = new ArrayList<Sheet>();

		/*
		 * Add in your own code so that the method will place all the shapes
		 * according to NextFit under ALL the assumptions mentioned in the
		 * specification
		 */

		//Define the current sheet + shelf being worked on based on next fit
		//They will get redefined when a new one is needed
		Sheet currentSheet = new Sheet();
		Shelf currentShelf = new Shelf();

		
		int count = 0;
		for (Shape currentShape : shapes) //for every shape in the shapes list
		{
			System.out.println("Attempting to add shape "+count);

			//Try to add current shape to current shelf
			if (!currentShelf.attemptAddShapeToShelf(currentShape, currentSheet)) {
				//Where the current shape can't be added to the shelf, then add the current shelf to the current sheet
				//Then make a new shelf and add the shape to it

				System.out.println("Shape can't be added to shelf");

				System.out.println("Shelf is full, adding current shelf to sheet and making new one");
				currentSheet.addShelf(currentShelf); //add the current shelf to the sheet
				currentShelf = new Shelf(); //Make a new shelf
				currentShelf.place(currentShape); //Place the current shape in the shelf

				System.out.println("Shelf has been added in to sheet");

				System.out.println("New shelf made");

			}

			System.out.println("Shape added!");

			
			//Check if it is the first shape on shelf, check that it fits in to current sheet
			
			if (currentShelf.getShapes().size() == 1) {
				System.out.println("First item on a shelf, checking if it fits in current sheet");

				if(!currentSheet.checkAddShelfToSheet(currentShelf)) {
					if(currentSheet.attemptRotateShelf(currentShelf)) { //Rotating sheet helps, reset sheet and place rotated shape on it
						currentShelf = new Shelf (); //Reset shelf
						currentShelf.rotateShapeThenAdd(currentShape); //Rotate current shape then add to shelf
					}
					System.out.println("Concluded that the current sheet is full up, making a new sheet and adding current shelf to it");
					usedSheets.add(currentSheet); //Make a new sheet
					currentSheet = new Sheet();
					//currentSheet.addShelf(currentShelf);
					//currentShelf = new Shelf();
				}
			}
			
			
			count++;
		
	
		}

		//Add the last shelf to the sheet and add the last sheet to the usedSheets
		//No need to validate as they will have been checked above
		currentSheet.addShelf(currentShelf);
		usedSheets.add(currentSheet);
		return usedSheets;
	}
		
	
	















	/**
	 * This method is used to implement the first fit algorithm
	 * 
	 * @param shapes:a list of shapes representing customer requests (shapes to be
	 *            cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e. place
	 *         all the shapes). e.g. if you pass a "shapes" list that has two
	 *         shapes {(w=200,h=200),(w=50,h=100)}, then the returned list of
	 *         sheets should show us all the information needed (e.g. that one
	 *         sheet is used, this sheet has one shelf and this shelf has two
	 *         shapes in it). In the test program, you can use the returned list
	 *         to retrieve the total number of sheets used
	 **/
	public List<Sheet> firstFit(List<Shape> shapes) {

		/*
		 * Start with an empty list of sheets (remember each sheet has a width
		 * of 300 and a height of 250 as specified in the Sheet class)
		 */
		List<Sheet> usedSheets = new ArrayList<Sheet>();

		/*
		 * Add in your own code so that the method will place all the shapes
		 * according to FirstFit under the assumptions mentioned in the spec
		 */
		
		return usedSheets;
	}

}
