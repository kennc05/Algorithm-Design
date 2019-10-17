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
          int max = 0;
          int count = 0;

          ArrayExample anArray = new ArrayExample(20);
          
          /** Read in test data into array **/
          anArray.readIn("inputs.txt");
          
          /** Display array **/
          anArray.display(10,"Array of Integers");
          
          /** Sum up array of values and display **/
          sum = anArray.sumEven();
          System.out.println("\n\nSum of array is " + sum);

          /** Get max value and display **/
          max = anArray.findMax();
          System.out.println("\n\nMax number in array is " + max);

           /** Get count value of how many numbers within a range and display **/
          count = anArray.countRange(0, 10); //Should return 8
          System.out.println("\n\nNumber of counts within the specified range is " + count);

          /** Get no of matches from an element **/

          match = anArray.findMatches(); //Should be 1
          System.out.println("\n\nNumber of matches is: " + match);
          
      }
    
} /** End of Test class **/