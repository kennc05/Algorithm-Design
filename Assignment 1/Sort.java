
/*****************************************************/
/*** Sort class currently contains some initial    ***/
/*** methods for implementing sorting algorithms   ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/19   ***/
/***     Extended by: ?                            ***/
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
    for (int i=0;i<usedSize;i++)
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
    for (int i=1;i<usedSize;i++)
    {
        int key = A[i]; // Contains the next value to insert
        int j = i; // Make j equal to i  -> J will contain the current index to try and compare


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

public void quicksort(int L, int R)
{

}
}  /** End of Sort Class **/
