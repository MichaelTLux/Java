package testing;

public class Final
{
	public static void main(String args[])
	{
		mystery(-1);
	}
	
	 public static void mystery(int x)
	 {
	 if (x == 0)
	 {
	 System.out.println("pooh");
	 }
	 else if (x % 2 == 0)
	 {
	 System.out.println(x);
	 mystery(x / 2);
	 }
	 else
	 {
	 mystery(x - 1);
	 }
	 }

}
