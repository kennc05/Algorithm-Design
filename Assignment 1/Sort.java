
/*****************************************************/
/*** Sort class currently contains some initial    ***/
/*** methods for implementing sorting algorithms   ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/19   ***/
/***     Extended by: Kenneth Cajigas 170450661    ***/
/*****************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Sort {

/** Size of array **/
private int size;

/** Number of used elements in array **/
private int usedSize;

/** Array of integers **/
private int[] A;

/** Global variables for counting sort comparisons **/
public int compIS; /** Global comparison count for Insertion Sort **/
public int compQS; /** Global comparison count for Quicksort **/
public int compNS; /** Global comparison count for newsort **/

/*****************/
/** Constructor **/
/*****************/
Sort(int max)
{
    /** Initialiase global sort count variables **/
    compIS = 0;
    compQS = 0;
    compNS = 0;
    
    /** Initialise size variables **/
    usedSize = 0;
    size = max;
    
    /** Create Array of Integers **/
    A = new int[size];
}



/*********************************************/
/*** Read a file of integers into an array ***/
/*********************************************/
public void readIn(String file)
{
   try
   {
       /** Initialise loop variable **/
       usedSize = 0;
       
       /** Set up file for reading **/
       FileReader reader = new FileReader(file);
       Scanner in = new Scanner(reader);
       
       /** Loop round reading in data while array not full **/
       while(in.hasNextInt() && (usedSize < size))
       {
           A[usedSize] = in.nextInt();
           usedSize++;
       }
       
    }
    catch (IOException e)
    {
       System.out.println("Error processing file " + file);
    }
   
}

/**********************/
/*** Display array  ***/
/**********************/
public void display(int line, String header)
{
    /*** Integer Formatter - three digits ***/
    NumberFormat FI = NumberFormat.getInstance();
    FI.setMinimumIntegerDigits(3);

    /** Print header string **/
    System.out.print("\n"+header);

    /** Display array data **/
    for (int i=0;i<size;i++)
    {
        /** Check if new line is needed **/
        if (i%line == 0) 
        { 
            System.out.println(); 
        }
        
        /** Display an array element **/
        System.out.print(FI.format(A[i])+" ");
    }
}

/*********************************************/
/*** Insertion Sort Algorithm ***/
/*********************************************/

public void insertion() 
{
    for (int i=1;i<size;i++) //Index to iterate through the array - starts from index 1 as first value is already "inserted"
    {
        int key = A[i]; // Contains the next value to insert
        int j = i; // Make j equal to i  -> J will contain the current index to try and compare to the current index


        while (j>0 && key<A[j-1]) // Finds the correct position for the key to insert it. 
        //This will shift the "space" left until either j has reached element 0, or the key is no longer less than the element before it
    
        {
            compIS++; //Increment by 1 as a comparasion has been made
            A[j] = A[j-1]; // Push the space left
            j=j-1; // Decrement j by 1 to move to previous element
        }

        compIS++; //Final comparasion before the key is allocated to the correct space
        A[j] = key; //"Insert" the element into its correct position 
    }
}

/*********************************************/
/*** Quick Sort Algorithm ***/
/*********************************************/

//Quicksort method which will call onto the partition method 
public void quicksort(int L, int R)
{
    if (R > L) //If the right pointer is more than the left pointer ie if they haven't crossed yet
    {
        int partitionResult = partition(L, R); //Intial partition stored in variable to hold the position of pivot from partition

        //Will recursively partition left side and right side of arrays

        quicksort(L, partitionResult-1); //Partion the left portion of the array after sorting elements less than Pivot
        quicksort(partitionResult+1, R); //Partion the right portion of the array after sorting elements more than Pivot
    }
}

//The partition function splits the array depending on the pivot. Left < Pivot | Right > Pivot
private int partition(int L, int R)
{
    int pivot = A[R]; //The pivot element for partitioning - far rightmost element


    //Intialise both left and right pointers which will be used to sort out elements relative to the pivot
    //These contain the index within the array
    int leftPointer = L; 
    int rightPointer = R;


    while (leftPointer < rightPointer) //Loop whilst the pointers haven't crossed
    {
        while (A[leftPointer] < pivot)
        {
            compQS++; //Comparasion 1 of array
            leftPointer++; //Go to the next element on the right until an element that is more th§an the pivot is found
        }
        compQS++; //Accounts for the comparasion where the loop breaks

        while (A[rightPointer] >= pivot && rightPointer > L) //Prevents the rightPointer from going off the array
        {
            compQS++; //Comparasion 2 of array
            rightPointer--; //Go to the next element on the left until an element that is less than the pivot is found
        }
        compQS++; //Accounts for the comparasion where the loop breaks

        //Swap elements at index of left and right pointers once both left and right elements in the wrong place are found
        if (leftPointer < rightPointer) 
        {
            swap(leftPointer, rightPointer); //Swap the elements if they have crossed
        }
    }

    swap(leftPointer, R); //Place the pivot in its final position and swap with the element at the left index

    return leftPointer; //return Pivot position
}

// Getters and Setters for usedSized for calling quicksort in TestSort.java
public int getUsedSize() 
{
    return usedSize;
}

public void setUsedSize(int usedSize) 
{
    this.usedSize = usedSize;
}

/*********************************************/
/*** New Sort Algorithm ***/
/*********************************************/

public void newsort() 
{
    int pos = 0; //Set inital value to 0

    while (pos < size) //A while loop which continues until the pos variable is less than the size specified
    {
        int min = findMinFrom(pos);

        for (int i = pos; i < size; i++) //Make i equal to value of pos and then add by 1 each time
        {
            if (A[i] == min)
            {
                swap(i, pos);
                pos++; //Increase position by one
                // System.out.println("Position " +pos);
            }
            compNS++; //Comparasion 1 which involves an array element
        }
    }
}

private int findMinFrom (int pos)
{
    int min = A[pos]; //Set the current minimum to be the constructor value of pos

    for (int i=pos+1; i < size; i++)
    {
        if (A[i] < min) //Check if the current element is less than the set minimum 
        {
            min = A[i]; //Set the minimum to the current element
        }
        compNS++; //Comparasion 2 which involves an array element
    }
    return min;
}

/*********************************************/
/*** Swap method used in all Quicksort and Newsort ***/
/*********************************************/


private void swap(int a, int b){
    int temp = A[a];
    A[a] = A[b];
    A[b] = temp;
}

}  /** End of Sort Class **/


/*

TO DO:

-Implement a swap method
-Simplify code to make it shorter

*/