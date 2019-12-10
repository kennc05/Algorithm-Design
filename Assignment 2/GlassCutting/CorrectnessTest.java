
/**
 * @Purpose: The CorrectnessTest class is used to validate the correctness of
 *           the implemented algorithms. You can add additional methods if you
 *           need
 * 
 * @author RYK
 * @since 30/10/2019 extended by Kenneth 17045066
 */

import java.util.ArrayList;
import java.util.List;

public class CorrectnessTest {
	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("*********** Correctness testing *************");
		System.out.println("*********************************************");
		System.out.println();

		List<Sheet> usedSheets = new ArrayList<Sheet>();

		Algorithms algorithmsTest = new Algorithms();
		/*
		 * Here you will need to validate that your algorithms (nextFit() and
		 * firstFit()) behave as expected on small data sets. 
		 * Think about normal cases and border cases. 
		 * You can use any additional method you created in this class
		 */

		//Logic tests that can be run - see Assignment 2 report
		List<Shape> logicTest1 = new ArrayList<Shape>(); 
		logicTest1.add(new Shape(101, 134));
		logicTest1.add(new Shape(51, 98));
		logicTest1.add(new Shape(152, 100));
		logicTest1.add(new Shape(68, 76));
	

		List<Shape> logicTest2 = logicTest1;
		logicTest2.add(new Shape(110, 82));
		logicTest2.add(new Shape(100, 50));


		List<Shape> logicTest3 = new ArrayList<Shape>(); 
		logicTest3.add(new Shape(100, 50));
		logicTest3.add(new Shape(70, 60));
		logicTest3.add(new Shape(250, 225));
		logicTest3.add(new Shape(200, 130));


		 //List of rule tests that can be run - see Assignment 2 report
		List<Shape> ruleTest1 = new ArrayList<Shape>(); 
		ruleTest1.add(new Shape(101, 134));
		ruleTest1.add(new Shape(51, 98));
		ruleTest1.add(new Shape(50, 146));
		ruleTest1.add(new Shape(105, 200));
		ruleTest1.add(new Shape(291, 246));
		ruleTest1.add(new Shape(68, 76));
		ruleTest1.add(new Shape(150, 6));
		ruleTest1.add(new Shape(262, 17));

		List<Shape> ruleTest2 = new ArrayList<Shape>(); 
		for (int i = 0; i < 25; i++) {
			ruleTest2.add(new Shape(50,50));
		}

		//Depending on the test put in this variable, it will be passed onto both nextFit and firstFit
		
		
		for (int test= 0; test < 5; test++) {

			System.out.println("\n*********** Running test "+test+ " *********** ");
			List<Shape> testToRun = new ArrayList<Shape>();

			switch(test) {
				case 0:
				testToRun = logicTest1;
				break;

				case 1:
				testToRun = logicTest2;
				break;

				case 2:
				testToRun = logicTest3;
				break;

				case 3:
				testToRun = ruleTest1;
				break;

				case 4:
				testToRun = ruleTest2;
				break;
			}

			System.out.println("\n*********** nextFit() testing\n");
			usedSheets = algorithmsTest.nextFit(testToRun);
			System.out.println("Used number of sheets for next fit: "+usedSheets.size());

			int sheetCount = 1;
			for (Sheet currentSheet : usedSheets) {
				System.out.println("\n----------------------------------------------- \n");
				System.out.println("Sheet "+sheetCount+" information\n");
				System.out.printf("Sheet "+sheetCount);
				currentSheet.printSheet();
				sheetCount++;
			}

			usedSheets =  new ArrayList<Sheet>();
			
			sheetCount = 1;
			System.out.println("\n*********** firstFit() testing\n");
			usedSheets = algorithmsTest.firstFit(testToRun);
			System.out.println("Used number of sheets for first fit: "+usedSheets.size());
			
			sheetCount = 1; //Reset sheet count
			for (Sheet currentSheet : usedSheets) {
				System.out.println("\n----------------------------------------------- \n");
				System.out.println("Sheet "+sheetCount+" information\n");
				System.out.printf("Sheet "+sheetCount);
				currentSheet.printSheet();
				sheetCount++;
			}


		}

	}

}
