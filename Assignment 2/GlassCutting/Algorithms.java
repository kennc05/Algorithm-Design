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

		Sheet currentSheet = new Sheet();
		Shelf currentShelf = new Shelf();

		for (Shape currentShape : shapes) //for every shape in the shapes list
		{

			//Check if the current shelf is empty
			if (currentShelf.getShapes().isEmpty()) {
				currentShelf.place(currentShape); //Place the first shape on a shelf
				continue;
			}

			//ADD SHAPE STAGE 1:
			//Check that the shape can fit onto the current shelf

			boolean shapeAddedToCurrentShelf = false;

			while(!shapeAddedToCurrentShelf) {
				

			}
			
			


		}
			

	


			/*
			if (currentShelf.checkPlace(currentShape) && currentShape.getWidth() < (currentSheet.getWidth() - currentShelf.getWidth())){ //check that the shape can fit in the shelf
				continue; //break out of the loop if it fits


			} else {
				//If it fails, try to rotate the shape and check if it fits in
				
				System.out.println("Rotate shape before. Height: "+currentShape.getHeight()+" | Width: "+currentShape.getWidth());
				currentShape.rotateShape();
				System.out.println("Rotate shape after. Height: "+currentShape.getHeight()+" | Width: "+currentShape.getWidth());
				
				if (currentShelf.checkPlace(currentShape) && currentShape.getWidth() < (currentSheet.getWidth() - currentShelf.getWidth())) {
					continue; //break out of the loop if it fits
				}
			}

			//At this point it still hasn't fit after rotating. The shelf is considered filled. 
			//Check if you can add the filled shelf to the sheet,  then create a new shelf
			
			currentShape.rotateShape(); //rotate shape back 


			//try to add the filled up shelf to a sheet  - if it returns false, then create a new sheet then add the shelf to the sheet
			if (!currentSheet.checkAddShelf(currentShelf)) { 
				usedSheets.add(currentSheet); //Add the current sheet
				currentSheet = new Sheet(); //create a brand new sheet
				currentSheet.addShelf(currentShelf); //add the shelf to the new sheet
			}

			//Creating a new shelf to put the current shape into
			currentShelf = new Shelf(); //make a new shelf
			currentShelf.place(currentShape); //Add the new shape to the new shelf

			if (shapes.get(shapes.size() - 1) == currentShape) 
			{
				currentSheet.addShelf(currentShelf);
			}
		}

		*/

		return usedSheets;
	}

	public boolean checkAddShelfToSheet (Shelf currentShelf, Sheet currentSheet) {
		if (currentShelf.getHeight() <= currentSheet.allShelvesHeight()) {
			/* 
			If it can fit: 
			1. Add the shelf to the current sheet
			*/

			currentSheet.addShelf(currentShelf);
			return true;
		}

		return false;
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
