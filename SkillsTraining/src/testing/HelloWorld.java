package testing;

public class HelloWorld 
{
	public static void main(String args[])
	{
		System.out.println("Hello World");
		String first="potato";
		String second="second";
		char a=first.charAt(1);
		char b=second.charAt(3);
		System.out.println(a==b);
		System.out.println(first.indexOf(b,2));
		
	}

}
