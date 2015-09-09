package lab2;

public class BasketballTest 
{
	public static void main(String args[])
	{
		//Constructs a new basketball
		Basketball b;
		b = new Basketball(4.0);
		
		//Testing the initials of the basketball
		System.out.println("The diameter is " +b.getDiameter() + ".");
		System.out.println("Is the ball bribbleable? " +b.isDribbleable());
		
		//construct a new basketball
		Basketball b2 = new Basketball(6.0);
		
		//modify the old basketball
		b.inflate();
		
		//print the results
		System.out.println("Is the ball 2 bribbleable? " +b.isDribbleable());  // should be true now
		System.out.println("Is the ball 1 bribbleable? " +b2.isDribbleable()); // should still be false 
	}

}
