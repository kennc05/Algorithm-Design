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

		// Run 5 tests for each number of shapes
		int noOfTests = 5; 

		// arrays which will hold the time taken and sheets used for each algorithm. Each index will hold the result for each test
		long[] resultsNextFitTime = new long[noOfTests];
		double[] resultsNextFitSheets = new double[noOfTests];

		long[] resultsFirstFitTime = new long[noOfTests];
		double[] resultsFirstFitSheets = new double[noOfTests];

		// Repeat each test 4 times
		int noOfRep = 4;

		// Start with 10000 shapes
		int noOfShapes = 10000;

		// After a test has been completed, increment number of shapes by 10000
		int increment = 10000;
		
		Generator generateShapes = new Generator();
		Algorithms algorithmsTest = new Algorithms();

		List<Sheet> usedSheets = new ArrayList<Sheet>();
		List<Shape> generatedShapes = new ArrayList<Shape>();

		for(int testNumber = 0; testNumber < noOfTests; testNumber++) { //Run a test up to the number of tests specified and each time noOfShapes will be increased by increment value

			for (int j = 0; j < noOfRep; j++) { //Repeat a test several times with a different list of shapes 
				generatedShapes = generateShapes.generateShapeList(noOfShapes); //Generate a new list of shapes after every replication
					
				//Run test with list of shapes on nextFit
				long startTime = System.nanoTime();
				usedSheets = algorithmsTest.nextFit(generatedShapes);
				long elapsedTime = System.nanoTime() - startTime;
				resultsNextFitTime[testNumber] += elapsedTime; 
				resultsNextFitSheets[testNumber] += usedSheets.size();

				//Run test with same list of shapes on firstFit
				startTime = System.nanoTime();
				usedSheets = algorithmsTest.firstFit(generatedShapes);
				elapsedTime = System.nanoTime() - startTime;
				resultsFirstFitTime[testNumber] += elapsedTime;
				resultsFirstFitSheets[testNumber] += usedSheets.size();
			}
			
			//Calculate averages after repeated tests with same number of shapes to generate are done and both algorithms tested
			resultsNextFitSheets[testNumber] = resultsNextFitSheets[testNumber] / noOfRep;
			resultsNextFitTime[testNumber] = resultsNextFitTime[testNumber] / noOfRep;

			resultsFirstFitSheets[testNumber] = resultsFirstFitSheets[testNumber] / noOfRep;
			resultsFirstFitTime[testNumber] = resultsFirstFitTime[testNumber] / noOfRep;

			noOfShapes += increment; //Increment number of shapes to generate for next test
		
		}




		//Output the results in a tabulated format
		noOfShapes = 10000;
		System.out.printf("%-30s | %-20s | %-20s | %-20s | %-20s |\n", "", "nextFit()", "", "firstFit()", "");
		System.out.printf("%-30s | %-20s | %-20s | %-20s | %-20s |\n", "Test number & Shapes", "Avg time taken (ms)", "Avg sheets used", "Avg time taken (ms)", "Avg sheets used");

		for (int i = 0; i < noOfTests; i++) {
			//Convert each time taken to milliseconds
			System.out.printf("%-30s | %-20s | %-20s | %-20s | %-20s |\n", "Test "+(i + 1)+" - Shapes(n): "+noOfShapes, resultsNextFitTime[i]/1000000, resultsNextFitSheets[i], resultsFirstFitTime[i]/1000000, resultsFirstFitSheets[i]);
			noOfShapes += increment;
		}
	}
}

