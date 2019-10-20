
/*************************************************/
/***  Simple test class for Sort class         ***/
/***                                           ***/
/***  Author: Kenneth Cajigas 10/10/2019       ***/
/*************************************************/


public class TestSort
{
	public static void main(String[] args) 
    {
        Sort sortTest = new Sort(50);
        
        /** Some simple tests using class Sort **/
        
        /** Display two comparison counters **/
        System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);
        System.out.println("Quicksort comparison counter: " + sortTest.compQS);
        
        /** Read in test data into array **/
        sortTest.readIn("test.txt");
        
        /** Display array **/
        sortTest.display(15,"Values in test1.txt");


        System.out.println("\nInsertion sort testing");
        sortTest.readIn("test1.txt");
        sortTest.insertion();
        System.out.println("\nInsertion sort comparison counter: " + sortTest.compIS);
        sortTest.display(15, "Insertion sort results"); //15 is amount of numbers in one row



        System.out.println("\n\nQuicksort testing");
        sortTest.readIn("test1.txt");
        sortTest.quicksort(0, sortTest.getUsedSize()-1);
        System.out.println("\nQuicksort comparison counter: " + sortTest.compQS);
        sortTest.display(15, "Quick sort results"); //15 is amount of numbers in one row


    }
    
} /** End of TestSort class **/
