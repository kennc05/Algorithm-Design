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


		double[] resultsNextFitTime = new double[5];
		double[] resultsNextFitSheets = new double[5];

		double[] resultsFirstFitTime = new double[5];
		double[] resultsFirstFitSheets = new double[5];

		// total number of tests - you need to CHANGE this value
		int noOfTests = 5;

		// number of repetitions for each test - you need to CHANGE this value

		//Run each test 5 times
		int noOfRep = 5;

		// number of shapes needed for the first run - you need to CHANGE this
		// value
		int noOfShapes = 10000;

		// the increment in the number of shapes - you need to CHANGE this value
		int increment = 10000;

		for(int i = 0; i < noOfTests; i++) {
			//Test number of sheets used by algoritms

			double avgSheetsUsed = 0.0;
			double avgTimeTaken = 0.0;

			Generator generateShapes = new Generator();
			Algorithms algorithmsTest = new Algorithms();

			List<Sheet> usedSheets = new ArrayList<Sheet>();
			List<Shape> generatedShapes = new ArrayList<Shape>();

			generatedShapes = generateShapes.generateShapeList(noOfShapes);

			//Test nextFit()
			for (int j = 0; j < noOfRep; j++) {//Repeat a test several times
				long startTime = System.currentTimeMillis();
				usedSheets = algorithmsTest.nextFit(generatedShapes);
				long elapsedTime = System.currentTimeMillis() - startTime; //Millseconds - need to divide by 1000 to get seconds
				avgTimeTaken += elapsedTime;
				avgSheetsUsed += usedSheets.size();
			}

			//Calculate the averages
			avgSheetsUsed = avgSheetsUsed / noOfRep;
			avgTimeTaken = avgTimeTaken / noOfRep;
			resultsNextFitSheets[i] = avgSheetsUsed;
			resultsNextFitTime[i] = avgTimeTaken;

			avgSheetsUsed = 0.0; //reset

			//Test firstFit()
			for (int j = 0; j < noOfRep; j++) {//Repeat a test several times
				long startTime = System.currentTimeMillis();
				usedSheets = algorithmsTest.firstFit(generatedShapes);
				long elapsedTime = System.currentTimeMillis() - startTime; //Millseconds - need to divide by 1000 to get seconds
				avgTimeTaken += elapsedTime;
				avgSheetsUsed += usedSheets.size();
			}

			//Calculate the averages
			avgSheetsUsed = avgSheetsUsed / noOfRep;
			avgTimeTaken = avgTimeTaken / noOfRep;
			resultsFirstFitSheets[i] = avgSheetsUsed;
			resultsFirstFitTime[i] = avgTimeTaken;

			noOfShapes += increment; //Increment number of shapes to generate for next test
		}




		noOfShapes = 10000;
		System.out.printf("%-30s | %-20s | %-20s | %-20s | %-20s |\n", "", "nextFit()", "", "firstFit()", "");
		System.out.printf("%-30s | %-20s | %-20s | %-20s | %-20s |\n", "Test number + shapes", "Avg time taken", "Avg sheets used", "Avg time taken", "Avg sheets used");

		for (int i = 0; i < noOfTests; i++) {
			System.out.printf("%-30s | %-20s | %-20s | %-20s | %-20s |\n", "Test "+i+" Shapes:"+noOfShapes, resultsNextFitTime[i], resultsNextFitSheets[i], resultsFirstFitTime[i], resultsFirstFitSheets[i]);
			noOfShapes += increment;
		}
	}


	
}
