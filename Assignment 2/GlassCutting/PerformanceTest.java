import java.util.ArrayList;
import java.util.List;

/**
 * @Purpose: The PerformanceTest class is used to compare the implemented
 *           algorithms in term of time and the number of sheets used
 *
 *           You can add additional methods if you need to in this class
 * 
 * @author RYK
 * @since 30/10/2019 extended by @author
 */

public class PerformanceTest {

	public static void main(String[] args) {

		System.out.println("***********************************************");
		System.out.println("*********** Performance analysis **************");
		System.out.println("**********************************************");

		System.out.println();
		/*
		 * You must complete the Generator class in order to generate a random
		 * test values. You must complete the Algorithms class in order to call
		 * the two algorithms.
		 * 
		 * You can use any additional method you created in this class
		 */

		

		/**
		 * Remember: You need to calculate the time and number of sheets used
		 * for each run of each algorithm.
		 * 
		 * You are expected to run several tests (e.g. noOfTests=5) of your
		 * programs for, 10000, 20000, 30000, 40000, 50000 shapes
		 * (noOfShapes=10000, increment=10000) so that one can see how the
		 * algorithms perform for large datasets.
		 * 
		 * You are expected to run the same test a number of times to ensure
		 * accurate result (noOfRep=4). In this case, you need to calculate the
		 * average time and sheets needed for each run
		 **/

		// total number of tests - you need to CHANGE this value: Run 5 tests for each no of shapes
		int noOfTests = 5; 

		// arrays which will hold the time taken and sheets used for each algorithm
		double[] resultsNextFitTime = new double[noOfTests];
		double[] resultsNextFitSheets = new double[noOfTests];

		double[] resultsFirstFitTime = new double[noOfTests];
		double[] resultsFirstFitSheets = new double[noOfTests];

		// number of repetitions for each test - you need to CHANGE this value: Run each test 5 times
		int noOfRep = 5;

		// number of shapes needed for the first run - you need to CHANGE this value: Start with 10000 shapes
		int noOfShapes = 10000;

		// the increment in the number of shapes - you need to CHANGE this value: Increment by 10000 after each set
		int increment = 10000;

		for(int i = 0; i < noOfTests; i++) { //Run a test up to the number of tests specified and each time noOfShapes will be increased by increment value

			Generator generateShapes = new Generator();
			Algorithms algorithmsTest = new Algorithms();

			List<Sheet> usedSheets = new ArrayList<Sheet>();
			List<Shape> generatedShapes = new ArrayList<Shape>();

			//Variables which will hold the results after the tests complete on each algorithm
			double avgTimeTaken = 0.0;
			double avgSheetsUsed = 0.0;

			//Test nextFit()
			for (int j = 0; j < noOfRep; j++) { //Repeat a test several times
				generatedShapes = generateShapes.generateShapeList(noOfShapes); //The list of shapes that will be passed to the algorithm
				long startTime = System.currentTimeMillis();
				usedSheets = algorithmsTest.nextFit(generatedShapes);
				long elapsedTime = System.currentTimeMillis() - startTime;
				avgTimeTaken += elapsedTime;
				avgSheetsUsed += usedSheets.size();
			}

			//Calculate the averages and add to results array
			avgTimeTaken = avgTimeTaken / noOfRep;
			resultsNextFitTime[i] = avgTimeTaken;

			avgSheetsUsed = avgSheetsUsed / noOfRep;
			resultsNextFitSheets[i] = avgSheetsUsed;

			//Reset values
			avgTimeTaken = 0.0;
			avgSheetsUsed = 0.0;

			//Test firstFit()
			for (int j = 0; j < noOfRep; j++) { //Repeat a test several times
				generatedShapes = generateShapes.generateShapeList(noOfShapes); //The list of shapes that will be passed to the algorithm
				long startTime = System.currentTimeMillis();
				usedSheets = algorithmsTest.firstFit(generatedShapes);
				long elapsedTime = System.currentTimeMillis() - startTime;
				avgTimeTaken += elapsedTime;
				avgSheetsUsed += usedSheets.size();
			}

			//Calculate the averages and add to results array
			avgTimeTaken = avgTimeTaken / noOfRep;
			resultsFirstFitTime[i] = avgTimeTaken;

			avgSheetsUsed = avgSheetsUsed / noOfRep;
			resultsFirstFitSheets[i] = avgSheetsUsed;

			noOfShapes += increment; //Increment number of shapes to generate for next test


		}




		//Output the results in a tabulated format
		noOfShapes = 10000;
		System.out.printf("%-30s | %-20s | %-20s | %-20s | %-20s |\n", "", "nextFit()", "", "firstFit()", "");
		System.out.printf("%-30s | %-20s | %-20s | %-20s | %-20s |\n", "Test number & Shapes", "Avg time taken (ms)", "Avg sheets used", "Avg time taken (ms)", "Avg sheets used");

		for (int i = 0; i < noOfTests; i++) {
			System.out.printf("%-30s | %-20s | %-20s | %-20s | %-20s |\n", "Test "+(i + 1)+" - Shapes(n): "+noOfShapes, resultsNextFitTime[i], resultsNextFitSheets[i], resultsFirstFitTime[i], resultsFirstFitSheets[i]);
			noOfShapes += increment;
		}
	}
}

