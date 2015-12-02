package lab11;

public class RecursiveDeli
{

	  public static void main(String[] args)
	  {
		System.out.println(getPyramidCount(4));  
	    //String result = makeDigitSandwich(4);
	    //System.out.println(result);
	  }
	  
	  public static int getPyramidCount(int n)
	  {
		  double total=0;
		  if (n==1)
		  {
			  return n;
		  }
		  else
		  {
			  total= Math.pow(n, 2)+ getPyramidCount(n-1);
		  }
		  return (int) total;
	  }

//	  public static String makeDigitSandwich(int outerDigit)
//	  {
//	    if (outerDigit == 0)
//	    {
//	      // Base case
//	      return "0";
//	    }
//	    else
//	    {
//	      // Recursive case
//	      String middle = makeDigitSandwich(outerDigit - 1); 
//	      String result = outerDigit + middle + outerDigit;
//	      return result;
//	    }
//	  }
//	  
//	  /**
//	   * Recursively computes the nth Fibonacci number.
//	   */
//	  public static int fibonacci(int n)
//	  {
//	    if (n == 0 || n == 1)
//	    {
//	      // base cases: return 1
//	      return 1;
//	    }
//	    else
//	    {
//	      // recursive case: sum of previous two values
//	      return fibonacci(n - 1) + fibonacci(n - 2);
//	    }
//	  }
	  
	  
}