package lab3;

public class Check4 
{
	public static void main(String args[])
	{
		//Testing what happens when you go over or under integer limits
				System.out.println("Max" + Integer.MAX_VALUE);
				System.out.println("Min" + Integer.MIN_VALUE);
				int i=Integer.MAX_VALUE;
				i=i+1;
				System.out.println("After adding 1 to max " +i);
				i=Integer.MAX_VALUE;
				i=i+2;
				System.out.println("After adding 2 to max "+ i);
				i=Integer.MAX_VALUE+Integer.MAX_VALUE;
				System.out.println("After adding max and max " + i);
	}

}
