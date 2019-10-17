/************************************************/
/*** Simple class for reading, displaying     ***/
/*** and processing an array of integers.     ***/
/***                                          ***/
/***         Jason Steggles 20/09/2017        ***/
/***         Modified by: Name Date           ***/
/************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class ArrayExample {

/** Size of array **/
private int size;

/** Number of used elements in array **/
private int usedSize;

/** Array of integers **/
private int[] A;

/** Constructor **/
ArrayExample (int max)
{
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
          /** Read in next value **/
          A[usedSize] = in.nextInt();
          
          /** Update number read in **/
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

/**************************************/
/*** Sum up the values in an array  ***/
/**************************************/
public int sumArray()
{
    /*** Initialise sum variable ***/
    int sum = 0;

    /** Loop round summing array elements **/
    for (int i=0;i<usedSize;i++)
    {
        /** Add next array value to sum **/
        sum = sum + A[i];
    }
    
    return sum;
}

/**************************************/
/*** Sum up the values in an array - Even numbers only ***/
/**************************************/
public int sumEven() //Even numbers 
{
    /*** Initialise sum variable ***/
    int sum = 0;

    /** Loop round summing array elements **/
    for (int i=0;i<usedSize;i++)
    {
        /** Add next array value to sum **/
        if (A[i] % 2 == 0) 
        {
            sum = sum + A[i];
        }
    }
    
    return sum;
}

/**************************************/
/*** Finding the maximum value within an array ***/
/**************************************/
public int findMax() //Finding the Max
{
    /*** Initialise max variable ***/
    int max = 0;

    /** Loop round summing array elements **/
    for (int i=0;i<usedSize;i++)
    {
        /** Add next array value to sum **/
        if (A[i] > max)
        {
            max = A[i];
        }
    }
    return max;
}

/**************************************/
/*** Finding the  value within an array ***/
/**************************************/
public int countRange(int min, int max) //Having a range
{
    /*** Initialise count variable ***/
    
    int count = 0;

    /** Loop round summing array elements **/
    for (int i=0;i<usedSize;i++)
    {
        /** Add next array value to sum **/
        if (A[i] > min & A[i] < max)
        {
            count+=1;
        }
    }
    return count;
}

} /** End of ArrayExample Class **/