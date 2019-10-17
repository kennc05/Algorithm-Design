/************************************************/
/*** Simple test class for ArrayExample class ***/
/***                                          ***/
/***         Jason Steggles 20/09/2017        ***/
/************************************************/


public class Test
{
      public static void main(String[] args) 
      {
          /** Initialise variables **/
          int sum = 0;
          ArrayExample anArray = new ArrayExample(20);
          
          /** Read in test data into array **/
          anArray.readIn("inputs.txt");
          
          /** Display array **/
          anArray.display(10,"Array of Integers");
          
          /** Sum up array of values and display **/
          sum = anArray.sumArray();
          System.out.println("\n\nSum of array is " + sum);
          
      }
    
} /** End of Test class **/