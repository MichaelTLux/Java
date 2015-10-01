package lab4;

import java.util.Random;
import java.util.Scanner;

public class PracticeForTest1 
{
	public static void main(String args[])
	{
		int n=150;
		double total=0;
		int i=0;
		
		if (n!=0)
		{
			i=Math.min(n, 10);
			total=i*.15+total;
			n=n-i;
		}
		if (n!=0)
		{
			i=Math.min(n, 100);
			total=total+i*.12;
			n=n-i;
		}
		if (n!=0)
		{
			i=n;
			total=i*.08+total;
			n=n-i;
		}
		System.out.println(total);
		
	}
}
