
/*************************************************/
/***  Simple test class for Sort class         ***/
/***                                           ***/
/***  Author: Kenneth Cajigas 10/10/2019       ***/
/*************************************************/


public class TestSort
{
	public static void main(String[] args) 
    {
        /*****************************************************************************************/
        /*** Will create new arrays each time, print values after and the comparasion counter ***/
        /****************************************************************************************/

        System.out.println("\n\n- Insertion sort testing test1.txt -");
        Sort insertionSortTest = new Sort(50);
        insertionSortTest.readIn("test1.txt");
        insertionSortTest.display(15, "Values before Insertion sort");
        insertionSortTest.insertion();
        insertionSortTest.display(15, "\nValues after Insertion sort");
        System.out.println("\nInsertion sort comparison counter: " + insertionSortTest.compIS);



        System.out.println("\n\n- Quicksort testing test1.txt -");
        Sort quickSortTest = new Sort(50); 
        quickSortTest.readIn("test1.txt");
        quickSortTest.display(15, "Values before Quick sort");
        quickSortTest.quicksort(0, quickSortTest.getUsedSize()-1);
        quickSortTest.display(15, "\nValues after Quick sort");
        System.out.println("\nQuicksort comparison counter: " + quickSortTest.compQS);



        System.out.println("\n\n- Newsort testing test1.txt -");
        Sort newSortTest = new Sort(50);
        newSortTest.readIn("test1.txt");
        newSortTest.display(15, "Values before New sort");
        newSortTest.newsort();
        newSortTest.display(15, "\nValues after New sort");
        System.out.println("\nNewsort comparison counter: " + newSortTest.compNS);


        System.out.format("\nThe rest of the tests:\n| %-15s | %-20s | %-20s |\n","Test file","Algorithm","Comparasion counter");

        for (int i=2; i!=7; i++) //Loop until test6.txt is completed
        {
            System.out.format("| %-15s | %-20s | %-20s |\n","test"+i+".txt","","");


            insertionSortTest = new Sort(50);
            insertionSortTest.readIn("test"+i+".txt");
            insertionSortTest.insertion();
            System.out.format("| %-15s | %-20s | %-20s |\n","","Insertion sort",insertionSortTest.compIS);

            quickSortTest = new Sort(50);
            quickSortTest.readIn("test"+i+".txt");
            quickSortTest.quicksort(0, quickSortTest.getUsedSize()-1);
            System.out.format("| %-15s | %-20s | %-20s |\n","","Quicksort",quickSortTest.compQS);

            newSortTest = new Sort(50);
            newSortTest.readIn("test"+i+".txt");
            newSortTest.newsort();
            System.out.format("| %-15s | %-20s | %-20s |\n\n","","Newsort",newSortTest.compNS);
        }

    }
    
} /** End of TestSort class **/
