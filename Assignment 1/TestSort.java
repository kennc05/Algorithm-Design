
/*************************************************/
/***  Simple test class for Sort class         ***/
/***                                           ***/
/***  Author: Jason Steggles    20/09/2019     ***/
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
        sortTest.readIn("test1.txt");
        
        /** Display array **/
        sortTest.display(15,"Values in test1.txt");


        System.out.println("\nInsertion sort testing");

        sortTest.readIn("test1.txt");
        sortTest.insertion();
        System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);
        sortTest.display(15, "Insertion sort result"); //15 is amount of numbers in one row


        sortTest.readIn("test1.txt");
        sortTest.quicksort(0, sortTest.getUsedSize()-1);

        System.out.println("\nQuicksort comparison counter: " + sortTest.compQS);
        sortTest.display(15, "Quick sort result"); //15 is amount of numbers in one row


    }
    
} /** End of TestSort class **/
