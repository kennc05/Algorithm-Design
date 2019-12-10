import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

      
/** The Sorted
 *           Test class is used to compare the implemented algorithms
 *           in term of the number of sheets used WHEN the list of
 *           shapes is SORTED
 *           You can add additional methods if you need to in this class
 * @author RYK
 * @since 30/10/2019
 * extended by Kenneth 17045066
 */

public class SortedTest {
	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("**************** Sorted Test ****************");
		System.out.println("*********************************************");
		System.out.println();

		/*
		 * Generate a random shape list and then check the number of sheets used
		 * when
		 ** this shape list is passed un-sorted
		 ** the list is sorted based on different criteria as set in the speciication document.
		 * 
		 * run several tests for different sizes of the "list of shapes" 
		 */

		/*
		 * HINT: you might want to implements the comparTo method in the Shape
		 * class or implement the Comparator Interface to do the sorting
		 */


		Generator generateShapes = new Generator();
		Algorithms algorithmsTest = new Algorithms();

		List<Sheet> usedSheets = new ArrayList<Sheet>();
		List<Shape> generatedShapes = new ArrayList<Shape>();
	
	
		//Run 5 tests for each no of shapes
		int noOfTests = 5; 

		//Repeat each test 4 times for an accurate result
		int noOfRep = 4;

		// Start with 10000 shapes
		int noOfShapes = 10000;

		// Increment by 10000 after each test
		int increment = 10000;


		//2D arrays which will hold the results from the tests [test number][{unsorted array}, {increasing height}, {decreasing height}, {increasing width}, {decreasing width}, {increasing area}, {decreasing area}]
		double[][] resultsNextFit = new double[noOfTests][7];
		double[][] resultsFirstFit = new double[noOfTests][7];


		//Run a test up to the number of tests specified and each time noOfShapes will be increased by increment value. On each test, nofOfShapes to generate will be different
		for(int testNumber = 0; testNumber < noOfTests; testNumber++) { 

			//typeOfComparasion: See below 
			for (int typeOfComparasion = 0; typeOfComparasion < 7; typeOfComparasion++) {
			//Test nextFit() and firstFit() - unsorted

				//Repeat the same test several times
				for (int j = 0; j < noOfRep; j++) { 
					generatedShapes = generateShapes.generateShapeList(noOfShapes); //The list of shapes that will be passed to the algorithm - newly generated
					
					//Check if the shapes should be sorted, and if so select the type of sort
					switch (typeOfComparasion) {
						//case 0: Unsorted shapes - runs on first test

						case 1: // 1: Sorted by decreasing height
							Collections.sort(generatedShapes, Shape.compareByHeight);
							break;
	
						case 2: // 2: Sorted by increasing height
							Collections.sort(generatedShapes, Shape.compareByHeight.reversed());
							break;

						case 3: // 3: Sorted by decreasing width
							Collections.sort(generatedShapes, Shape.compareByWidth);
							break;
	
						case 4: // 4: Sorted by increasing width
							Collections.sort(generatedShapes, Shape.compareByWidth.reversed());
							break;

						case 5: // 1: Sorted by decreasing area
							Collections.sort(generatedShapes, Shape.compareByArea);
							break;
	
						case 6: // 2: Sorted by increasing area
							Collections.sort(generatedShapes, Shape.compareByArea.reversed());
							break;
					}
					//Test the selected generated shape list (depending on the case above)
					//Pass the same list to both algorithms
					usedSheets = algorithmsTest.nextFit(generatedShapes); //Number of sheets
					resultsNextFit[testNumber][typeOfComparasion] += usedSheets.size();
						
					//The list will remain unchanged as in both nextFit() and firstFit() I make a copy of the shape before rotating the shape to fit it in
					usedSheets = algorithmsTest.firstFit(generatedShapes); //Number of sheets
					resultsFirstFit[testNumber][typeOfComparasion] += usedSheets.size();
				}

				//Calculate the averages after doing tests on both algorithms
				resultsNextFit[testNumber][typeOfComparasion] = resultsNextFit[testNumber][typeOfComparasion] / noOfRep;
				resultsFirstFit[testNumber][typeOfComparasion] = resultsFirstFit[testNumber][typeOfComparasion] / noOfRep;
			}
			//Increase no of shapes to generate
			noOfShapes+= increment;
		}


		System.out.printf("\n%-30s | %-30s  %-30s  %-30s  %-30s  %-30s\n", "", "Sorted by (avg sheets used):", "", "", "", "");
		System.out.printf("%-30s | %-10s | %-17s | %-17s | %-17s | %-17s | %-17s | %-17s\n", "Algorithm", "Unsorted", "Increasing height", "Decreasing height", "Increasing width", "Decreasing width", "Increasing area", "Decreasing area");

		noOfShapes = 10000;
		for (int testNumber = 0; testNumber < noOfTests; testNumber++) {
			System.out.printf("%-30s | %-10s | %-17s | %-17s | %-17s | %-17s | %-17s | %-17s\n", "Shapes: "+noOfShapes+" - nextFit()", resultsNextFit[testNumber][0], resultsNextFit[testNumber][1], resultsNextFit[testNumber][2], resultsNextFit[testNumber][3], resultsNextFit[testNumber][4], resultsNextFit[testNumber][5], resultsNextFit[testNumber][6]);
			System.out.printf("%-30s | %-10s | %-17s | %-17s | %-17s | %-17s | %-17s | %-17s\n\n", "Shapes: "+noOfShapes+" - firstFit()", resultsFirstFit[testNumber][0], resultsFirstFit[testNumber][1], resultsFirstFit[testNumber][2], resultsFirstFit[testNumber][3], resultsFirstFit[testNumber][4], resultsFirstFit[testNumber][5], resultsFirstFit[testNumber][6]);
			noOfShapes += increment;
		}
	}
}


	


