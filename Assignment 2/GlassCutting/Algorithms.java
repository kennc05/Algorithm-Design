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
		Sheet currentSheet = new Sheet();
		Shelf currentShelf = new Shelf();
	
		int count = 0;
		for (Shape currentShape : shapes) //for every shape in the shapes list
		{
			//Check if the current shelf is empty
			System.out.println("Adding in shape " +count);
			if (currentShelf.getShapes().isEmpty()) {
				currentShelf.place(currentShape); //Place the first shape on a shelf
				count++;
				continue;
			}

			//Try to add a shape to a current shelf

			System.out.println("Check 2");
			count++;

		
			if(!currentShelf.attemptAddToShelf(currentShape, currentSheet)) {
			//If original and rotated orientation of shape doesn't fit still 
			//The shelf is considered full up - make a new one
				
				System.out.println("add to shelf failed, adding current shelf to sheet");



				if(!currentSheet.attemptAddToSheet(currentShelf)) {
					System.out.println("add to sheet failed, making a new sheet");
					usedSheets.add(currentSheet);
					currentSheet = new Sheet(); //make a new sheet 
					currentSheet.addShelf(currentShelf);
				}

				currentShelf = new Shelf();
				currentShelf.place(currentShape);
			}
		}
		
		//Add the last created sheet to the 
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
