
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

        System.out.println("\n\n- Insertion sort testing -");
        Sort insertionSortTest = new Sort(50);
        insertionSortTest.readIn("test1.txt");
        insertionSortTest.display(15, "Values before Insertion sort");
        insertionSortTest.insertion();
        insertionSortTest.display(15, "\nValues after Insertion sort");
        System.out.println("\nInsertion sort comparison counter: " + insertionSortTest.compIS);



        System.out.println("\n\n- Quicksort testing -");
        Sort quickSortTest = new Sort(50); 
        quickSortTest.readIn("test1.txt");
        quickSortTest.display(15, "Values before Quick sort");
        quickSortTest.quicksort(0, sortTest.getUsedSize()-1);
        quickSortTest.display(15, "\nValues after Quick sort");
        System.out.println("\nQuicksort comparison counter: " + quickSortTest.compQS);



        System.out.println("\n\n- Newsort testing -");
        Sort newSortTest = new Sort(50);
        newSortTest.readIn("test1.txt");
        newSortTest.display(15, "Values before New sort");
        newSortTest.newsort();
        newSortTest.display(15, "\nValues after New sort");
        System.out.println("\nNewsort comparison counter: " + newSortTest.compNS);
    }

    
} /** End of TestSort class **/
