package lab4;

import java.util.Scanner;

public class NumberPower 
{
	public static void main(String args[])
	{
		 // Create one scanner to read from System.in
	    Scanner scanner = new Scanner(System.in);
	    
	    boolean flag1=false;
	    
	    
	    System.out.println("This program will take one number to the power of the other.");
	    System.out.println("Please enter only integers");
	    System.out.println("Please enter your base");
	   
	    do
	    {
	    	flag1=(checkIfInt(flag1, scanner));
	    } while (!flag1);
	    
	    int base=scanner.nextInt();
	    flag1=false;
	    
	    System.out.println("Please enter your exponent");
	    do
	    {
	    	flag1=(checkIfInt(flag1, scanner));
	    } while (!flag1);
	    
	    int exponent=scanner.nextInt();
	    int result= (int) Math.pow(base, exponent);
	    System.out.println("The results for " + base + "^" + exponent + " equals: " + result + ".");
	   
	}
	
	private static boolean checkIfInt(boolean flag, Scanner scanner)
	{
		
		if (scanner.hasNextInt()==true)
		{
			flag=true;
			return flag;
		}
		else 
		{
		    System.out.println("Incorrect Input");
			System.out.println("Please enter your number");
			flag = false;
			scanner.next();
			return flag;
		}    
	}
}
