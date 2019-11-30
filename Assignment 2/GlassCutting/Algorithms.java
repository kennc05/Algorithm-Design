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
		//Will get redefined when a new sheet or shelf is needed
		Sheet currentSheet = new Sheet();
		Shelf currentShelf = new Shelf();
	
		int count = 0;
		for (Shape currentShape : shapes) //for every shape in the shapes list
		{
			//Check if the current shelf is empty
			System.out.println("Attempting to add in shape " +count);

			System.out.println("Check 1");

			if (currentShelf.getShapes().isEmpty()) {
				currentShelf.place(currentShape); //Place the first shape on a shelf
				count++;
				continue;
			}

			//Try to add a shape to a current shelf with a shape inside
			System.out.println("Check 2");
		
			
			if(!currentShelf.attemptAddShapeToShelf(currentShape, currentSheet)) {
			//If original and rotated orientation of shape doesn't fit still 
			//The shelf is considered full up - need to make a new one
			
				System.out.println("add current Shape to shelf failed, adding current filled shelf to sheet");
			
				if(!currentSheet.checkAddShelfToSheet(currentShelf)) {
					System.out.println("add to sheet failed, making a new sheet");
					usedSheets.add(currentSheet);

					System.out.println("Making a new sheet");
					currentSheet = new Sheet(); //make a new sheet 

					System.out.println("Adding the filled up shelf to new sheet");
					currentSheet.addShelf(currentShelf); //add the filled up shelf to the new sheet

				}
				currentSheet.addShelf(currentShelf); //If it can fit, add shelf to sheet 

				System.out.println("Making a new shelf + adding the shape to the new shelf");
				currentShelf = new Shelf();
				currentShelf.place(currentShape); //place the current shape that couldn't fit into the new shelf

				System.out.println("Checking that the new shelf can fit in to the sheet");
				if(!currentSheet.checkAddShelfToSheet(currentShelf)) {
					System.out.println("Rotating shape in shelf to see if it could fit");
					if(!currentSheet.attemptRotateShelf(currentShelf)) {
						System.out.println("Rotating shape didn't help, making new sheet");
						usedSheets.add(currentSheet);
						currentSheet = new Sheet(); //make a new sheet 
						continue;
					}
					System.out.println("Rotating shape helped, making new sehlf and placing rotated shape in it");
					currentShelf = new Shelf();
					currentShape.rotateShape();
					currentShelf.place(currentShape);
				}
			}
			count++;
		}
		if(!currentSheet.checkAddShelfToSheet(currentShelf)) {
			usedSheets.add(currentSheet);
			currentSheet = new Sheet();
			currentSheet.addShelf(currentShelf);
		}
		else {
			currentSheet.addShelf(currentShelf);
		}

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
