import java.util.List;

import java.util.ArrayList;
import java.util.Collections;

      
/** The Sorte
 *           Test class is used to compare the implemented algorithms
 *           in term of the number of sheets used WHEN the list of
 *           shapes is SORTED
 *           You can add additional methods if you need to in this class
 *  @author RYK
 * @since 30/10/2019
 * extended by @author
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

		SortedTest sortTest = new SortedTest();
		
	
	
		// total number of tests - you need to CHANGE this value: Run 5 tests for each no of shapes
		int noOfTests = 5; 

		// arrays which will hold the time taken and sheets used for each algorithm
		double[] resultsNextFitUnsorted = new double[noOfTests];
		double[] resultsNextFitSortedHeightIncreasing = new double[noOfTests];
		double[] resultsNextFitSortedHeightDecreasing = new double[noOfTests];








		double[] resultsFirstFitUnsorted = new double[noOfTests];
		double[] resultsFirstFitSortedHeightIncreasing = new double[noOfTests];
		double[] resultsFirstFitSortedHeightDecreasing = new double[noOfTests];
	




		// number of repetitions for each test - you need to CHANGE this value: Run each test 5 times
		int noOfRep = 5;

		// number of shapes needed for the first run - you need to CHANGE this value: Start with 10000 shapes
		int noOfShapes = 10;

		// the increment in the number of shapes - you need to CHANGE this value: Increment by 10000 after each set
		int increment = 10;


/*
		System.out.println("Test sort by height");
		generatedShapes = generateShapes.generateShapeList(noOfShapes); //The list of shapes that will be passed to the algorithm
		Collections.sort(generatedShapes, Shape.compareByHeight);


		int shapeCount = 0;
		for (Shape currentShape: generatedShapes) {
			System.out.println("Shape "+shapeCount);
			currentShape.outputShape();
			shapeCount++;
		}

		System.out.println("Test sort by width");
		generatedShapes = generateShapes.generateShapeList(noOfShapes); //The list of shapes that will be passed to the algorithm
		Collections.sort(generatedShapes, Shape.compareByWidth);


		shapeCount = 0;
		for (Shape currentShape: generatedShapes) {
			System.out.println("Shape "+shapeCount);
			currentShape.outputShape();
			shapeCount++;
		}
*/




		for(int i = 0; i < noOfTests; i++) { //Run a test up to the number of tests specified and each time noOfShapes will be increased by increment value


			//Variables which will hold the results after the tests complete on each algorithm
			double avgSheetsUsed = 0.0;

	
			//TEST BY UNSORTED ARRAY OF SHAPES

			//Test nextFit() - unsorted
			for (int j = 0; j < noOfRep; j++) { //Repeat a test several times
				generatedShapes = generateShapes.generateShapeList(noOfShapes); //The list of shapes that will be passed to the algorithm
				usedSheets = algorithmsTest.nextFit(generatedShapes); //Number of sheats
				avgSheetsUsed += usedSheets.size();
			}
			avgSheetsUsed = avgSheetsUsed / noOfRep;
			resultsNextFitUnsorted[i] = avgSheetsUsed;


			avgSheetsUsed = 0.0;


			for (int j = 0; j < noOfRep; j++) { //Repeat a test several times
				generatedShapes = generateShapes.generateShapeList(noOfShapes); //The list of shapes that will be passed to the algorithm
				usedSheets = algorithmsTest.firstFit(generatedShapes); //Number of sheats
				avgSheetsUsed += usedSheets.size();
			}
			avgSheetsUsed = avgSheetsUsed / noOfRep;
			resultsFirstFitUnsorted[i] = avgSheetsUsed;

			//TEST BY SORTED ARRAY OF SHAPES BY HEIGHT

			avgSheetsUsed = 0.0;
			Collections.sort(generatedShapes, Shape.compareByWidth);
			//Test nextFit() - unsorted
			for (int j = 0; j < noOfRep; j++) { //Repeat a test several times
				generatedShapes = generateShapes.generateShapeList(noOfShapes); //The list of shapes that will be passed to the algorithm
				Collections.sort(generatedShapes, Shape.compareByHeight);
				usedSheets = algorithmsTest.nextFit(generatedShapes); //Number of sheats
				avgSheetsUsed += usedSheets.size();
			}
			avgSheetsUsed = avgSheetsUsed / noOfRep;
			resultsNextFitSortedHeightIncreasing[i] = avgSheetsUsed;


			avgSheetsUsed = 0.0;

			for (int j = 0; j < noOfRep; j++) { //Repeat a test several times
				generatedShapes = generateShapes.generateShapeList(noOfShapes); //The list of shapes that will be passed to the algorithm
				Collections.sort(generatedShapes, Shape.compareByHeight);
				usedSheets = algorithmsTest.firstFit(generatedShapes); //Number of sheats
				avgSheetsUsed += usedSheets.size();
			}
			avgSheetsUsed = avgSheetsUsed / noOfRep;
			resultsFirstFitSortedHeightIncreasing[i] = avgSheetsUsed;


			noOfShapes += increment;

		}

		







		//Sort the array
		
		System.out.printf("\n%-30s | %-30s  %-30s  %-30s  %-30s  %-30s\n", "", "Average sheets used:", "", "", "", "");
		System.out.printf("%-30s | %-30s | %-30s | %-30s | %-30s | %-30s\n", "Algorithm", "Unsorted", "Sorted by increasing height", "Sorted by decreasing height", "Sorted by increasing width", "Sorted by decreasing width");


		noOfShapes = 10;
		for (int k = 0; k < noOfTests; k++) {
			System.out.printf("%-30s | %-30s | %-30s | %-30s | %-30s | %-30s\n", "Shapes: "+noOfShapes+" - nextFit()", resultsNextFitUnsorted[k], resultsNextFitSortedHeightIncreasing[k], resultsNextFitSortedHeightDecreasing[k], "", "");
			System.out.printf("%-30s | %-30s | %-30s | %-30s | %-30s | %-30s\n", "Shapes: "+noOfShapes+" - firstFit()", resultsFirstFitUnsorted[k], resultsFirstFitSortedHeightIncreasing[k], resultsFirstFitSortedHeightDecreasing[k], "", "");
			noOfShapes += increment;
		}

	}



	public void sortShapes (List<Shape> generatedShapes) {
		Collections.sort(generatedShapes, Shape.compareByHeight);
	}




	
	public List<Shape> reverseOrder(List<Shape> generatedShapes) {
		Collections.reverse(generatedShapes);
		return generatedShapes;

	}

}
