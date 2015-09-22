package lab4;

import java.util.Scanner;

public class NumberPower2 
{
	public static void main(String args[])
	{
		 // Create one scanner to read from System.in
	    Scanner scanner = new Scanner(System.in);
	    Scanner scanner2= new Scanner(System.in);
	    
	    int base;
	    int exponent;
	    
	    
	    System.out.println("This program will take one number to the power of the other.");
	    System.out.println("Please enter only integers or the number will be one");
	    
	    System.out.println("Please enter your base");
	    base= helper(scanner);
	    
	    System.out.println("Please enter your exponent");
	    exponent=helper(scanner2);
	    
	    int result= (int) Math.pow(base, exponent);
	    System.out.println("The results for " + base + "^" + exponent + " equals: " + result + ".");
	}
	
	
    private static int helper(Scanner scanner)
    {
    	if (scanner.hasNextInt())
    	{
    		int returned = scanner.nextInt();
    		return returned;
    	}
    	else
    	{
    		int returned=1;
    		return returned;
    	}
    }
}
	   
