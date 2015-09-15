package lab3;

public class Check2 
{
	public static void main(String args[])
	{
		//checkpoint two is to see what happens when you don't initialize constructors
		  Person person1= new Person("Jimmy", 5);
		  System.out.println(person1.getAge() + " <-age, name length ->" + person1.getNameLength());
	}
}
