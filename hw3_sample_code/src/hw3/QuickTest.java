package hw3;

public class QuickTest {
	public static void main(String args[])
	{
	Explosion e = new Explosion(0, 0, 0, 0, null, 3);
	System.out.println(e.getCount());  // expected 3
	System.out.println(e.shouldDelete()); // expected false
	e.update();
	System.out.println(e.getCount());  // expected 2
	e.update();
	e.update();
	System.out.println(e.getCount());  // expected 0
	System.out.println(e.shouldDelete()); // expected true
	}

}
