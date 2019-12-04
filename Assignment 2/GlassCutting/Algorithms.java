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
		//They will get redefined when a new one is needed
		Sheet currentSheet = new Sheet();
		Shelf currentShelf = new Shelf();
		
		for (Shape currentShape : shapes) //for every shape in the shapes list
		{
			//Try to add current shape to current shelf
			if (!currentShelf.attemptAddShapeToShelf(currentShape, currentSheet)) {
				//Where the current shape can't be added to the shelf, the shelf is now full up
				//Add the current shelf to the current sheet, then make a new shelf and add the shape to it
				currentSheet.addShelf(currentShelf); //add the current shelf to the sheet
				currentShelf = new Shelf(); //Make a new shelf
				currentShelf.place(currentShape); //Place the current shape in the shelf
			}

			//Add this point the shape has been added
			//Check if it is the first shape on shelf, check that it fits in to current sheet
			if (currentShelf.getShapes().size() == 1) {
				if(!currentSheet.attemptAddShelfToSheet(currentShelf)) {
					//If the shelf can't be added to the sheet, normal and rotated orientation 
					//The current sheet is considered full up - add current sheet to list and make a new sheet
					usedSheets.add(currentSheet); //Add current sheet to usedSheets list
					currentSheet = new Sheet();
				}
				//Shelf was added to sheet
				continue; //Continue to next shape
			}
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

		//Define the current sheet + shelf being worked on based on next fit
		//They will get redefined when a new one is needed
		Sheet currentSheet = new Sheet();
		Shelf currentShelf = new Shelf();


		for (Shape currentShape : shapes) //for every shape in the shapes list
		{
			Boolean shapeAdded = false; //This will indicate if a shape was added to a shelf / sheet 

			//If the current sheet is empty, then add shape to empty shelf and add to sheet
			if (currentSheet.getShelves().size() == 0) {
				currentShelf.place(currentShape);
				currentSheet.addShelf(currentShelf);
				usedSheets.add(currentSheet);
				continue;
			}
			
	
			if (!shapeAdded) {
			//If its not the first shape then
			//Go through every shelf in every sheet to find a fit for shape
				for(int i = 0; i < usedSheets.size() && !shapeAdded; i++){
					currentSheet = usedSheets.get(i); //Get the next current sheet
	
					//Go through every shelf within that sheet to add a shape
					for(int j = 0; j < currentSheet.getShelves().size() && !shapeAdded; j++){
						currentShelf = currentSheet.getShelves().get(j);
	
						//Try to add current shape to current shelf
						if (currentShelf.attemptAddShapeToShelf(currentShape, currentSheet)) {
							shapeAdded = true;
						}
					}
				}
			}
			
			if (!shapeAdded) {
			//At this point the current shape hasn't been added still
			//Make a new shelf with the current shape inside and go through each sheet to try fit new shelf
				currentShelf = new Shelf();
				currentShelf.place(currentShape);

				for(int i = 0; i < usedSheets.size() && !shapeAdded; i++){
					currentSheet = usedSheets.get(i); //Get the current sheet 

					if(currentSheet.attemptAddShelfToSheet(currentShelf)) { //Shelf can be added to sheet
						currentSheet.addShelf(currentShelf); //Add the shelf to the sheet - whether rotated or not
						shapeAdded = true;
					}
					//Loop if the shelf can't be added
				}
			}
			
			if (!shapeAdded) {
			//At this point all sheets have been tried and the shelf still can't fit
			//Make a new sheet and add the shelf to the sheet

				currentSheet = new Sheet();
				currentSheet.addShelf(currentShelf);
				usedSheets.add(currentSheet);  
			}
		}
		return usedSheets;
	}
}
	


