/**
 * @Purpose: The CorrectnessTest class is used to validate the correctness of
 *           the implemented algorithms. You can add additional methods if you
 *           need
 * 
 * @author RYK
 * @since 30/10/2019 extended by @author
 */


import java.util.ArrayList;
import java.util.List;

public class CorrectnessTest {
	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("*********** Correctness testing *************");
		System.out.println("*********************************************");
		System.out.println();

		/*
		 * Here you will need to validate that your algorithms (nextFit() and
		 * firstFit()) behave as expected on small data sets. 
		 * Think about normal cases and border cases. 
		 * You can use any additional method you created in this class
		 */


		System.out.println("*********************************************");
		System.out.println("*********** nextFit() testing *************");
		System.out.println("*********************************************");
		System.out.println();

		List<Sheet> usedSheets = new ArrayList<Sheet>();

		Algorithms algorithmsTest = new Algorithms();
		Generator generatedValues = new Generator();


		
		usedSheets = algorithmsTest.nextFit(generatedValues.generateShapeList(5));
		System.out.println("Used number of sheets: "+usedSheets.size());

		int sheetCount = 1;
		for (Sheet currentSheet : usedSheets) {
			System.out.println("Sheet "+sheetCount);
			currentSheet.printSheet();
			sheetCount++;
		}
	}
}
