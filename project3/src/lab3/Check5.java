package lab3;

import java.util.Random;

public class Check5 {
	public static void main(String args[])
	{
		//Playing with the random class
			Random rand = new Random();
			System.out.println(rand.nextInt(6));
			System.out.println(rand.nextInt(6));
			System.out.println(rand.nextInt(6));
			System.out.println(rand.nextInt(6));
			System.out.println();
			
			//with a seed
			Random rand2 = new Random(137);
			System.out.println(rand2.nextInt(6));
			System.out.println(rand2.nextInt(6));
			System.out.println(rand2.nextInt(6));
			System.out.println(rand2.nextInt(6));		
	}		

}
