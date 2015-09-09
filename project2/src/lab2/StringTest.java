package lab2;

public class StringTest 
{
	public static void main(String args[])
	{
		//Sets up the message to work with the rest of lab
		String message = "Hello, world!";
		System.out.println(message);
		int theLength = message.length();
		System.out.println(theLength);
		
		//Testing how the char method works
		char theChar = message.charAt(0);
		System.out.println(theChar);
		theChar = message.charAt(1);
		System.out.println(theChar);
		
		// Changes the message to upper case
		String upperCaseMessage= message.toUpperCase();
		System.out.println(upperCaseMessage);
		
		//Pulls out the first word by picking the
		//Starting and ending points by hand
		//then prints
		String firstHalf= message.substring(0,5);
		System.out.println(firstHalf);
		
		//Using the replace method to change 
		//instances of "o" to *
		String replaceO=message.replace("o", "*");
		System.out.println(replaceO);
	}

}