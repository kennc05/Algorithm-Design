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
				//Where the current shape can't be added to the shelf, then add the current shelf to the current sheet
				//Then make a new shelf and add the shape to it
				currentSheet.addShelf(currentShelf); //add the current shelf to the sheet
				currentShelf = new Shelf(); //Make a new shelfxw
				currentShelf.place(currentShape); //Place the current shape in the shelf
			}

			//Add this point the shape has been added
			//Check if it is the first shape on shelf, check that it fits in to current sheet
			if (currentShelf.getShapes().size() == 1) {
				if(!currentSheet.attemptAddShelfToSheet(currentShelf)) {
					//If the shelf can't be added to the sheet, then try to rotate the shape in the sheet
					if(currentSheet.attemptRotateShelf(currentShelf)) { 
						continue; //continue to the next shape
					}

					//The current sheet is considered full up - add current sheet to list and make a new sheet
					usedSheets.add(currentSheet); //Add current sheet to usedSheets list
					currentSheet = new Sheet();
				}
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

		int count = 0;
		for (Shape currentShape : shapes) //for every shape in the shapes list
		{
			System.out.println("Attempting to add shape "+count);

			//If the current sheet is empty
			if (currentSheet.getShelves().size() == 0) {
				currentShelf.place(currentShape);
				currentSheet.addShelf(currentShelf);
				usedSheets.add(currentSheet);

				System.out.println ("Added first shape to first sheet");
				count++;
				continue;
			}
			
			//If its not the first shape then
			//Go through every shelf in every sheet to find a fit
			Boolean shapeAdded = false;
			for(int i = 0; i < usedSheets.size(); i++){

				System.out.println("Going into sheet "+i);
				currentSheet = usedSheets.get(i);
				System.out.println("No of shelves available is "+currentSheet.getShelves().size());

				
				for(int j = 0; j < currentSheet.getShelves().size(); j++){
					//Try to add current shape to current shelf
					System.out.println("Going into shelf "+j);

					currentShelf = currentSheet.getShelves().get(j);

					if (currentShelf.attemptAddShapeToShelf(currentShape, currentSheet)) {
						shapeAdded = true;
						break;
					}
				}
				System.out.println("Check that shape was added "+shapeAdded);
				if (shapeAdded) {
					System.out.println("Shape was added moving to next shape");
					break;
				}

				/*


					//Where the current shape can't be added to the shelf, then add the current shelf to the current sheet
					//Then make a new shelf and add the shape to it
						currentSheet.addShelf(currentShelf); //add the current shelf to the sheet
						currentShelf = new Shelf(); //Make a new shelf
						currentShelf.place(currentShape); //Place the current shape in the shelf
						if(currentSheet.attemptAddShelfToSheet(currentShelf)) {
							shapeAdded = true;
						}
				}
				if (shapeAdded) {
					break;
				}
				*/
			}

			if (shapeAdded) {
				System.out.println("Shape was added moving to next shape");
				count++;
				continue;
			}

			

			System.out.println("Shape couldn't fit in any exiting shelf in every sheet used, making a new shelf and trying to fit shape in every sheet");
			
			currentShelf = new Shelf();
			currentShelf.place(currentShape);

			shapeAdded = false;
			for(int i = 0; i < usedSheets.size(); i++){
				currentSheet = usedSheets.get(i);

				if(currentSheet.attemptAddShelfToSheet(currentShelf)) {
					currentSheet.addShelf(currentShelf); //Add the shelf to the sheet
					System.out.println("Shelf was added to sheet!");
					count++;
					shapeAdded = true;
				}
				if (shapeAdded) {
					break;
				}
			}

			if (shapeAdded) {
				continue;
			}



			System.out.println("Shelf wasn't added, trying to rotate the shelf, to see if it fits");
			if(currentSheet.attemptRotateShelf(currentShelf)) {
				count++;
				continue;
			}
			
			
			System.out.println("Couldn't add shelf to current sheet, so making a new one");
			
			currentSheet = new Sheet();
			currentSheet.addShelf(currentShelf);
			usedSheets.add(currentSheet);

			System.out.println("Number of sheets used is now "+usedSheets.size());
			count++;
		}
		return usedSheets;
	}

}
