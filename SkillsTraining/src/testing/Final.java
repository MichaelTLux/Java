package testing;

import java.util.Scanner;

public class Final
{
	public static void main(String args[])
	{
		
		
//		mystery(-1);
//	
//	 public static void mystery(int x)
//	 {
//	 if (x == 0)
//	 {
//	 System.out.println("pooh");
//	 }
//	 else if (x % 2 == 0)
//	 {
//	 System.out.println(x);
//	 mystery(x / 2);
//	 }
//	 else
//	 {
//	 mystery(x - 1);
//	 }
//	 }
	
//	System.out.println(tryStuff("10 20 23skidoo 30 foo bar"));
		
		
	}

public static int tryStuff(String text) 
{
	int total = 0;
	int i = 0;
	Scanner scanner = new Scanner(text);
	while (scanner.hasNext()) {
		try {
			String s = scanner.next();
			i = Integer.parseInt(s);
			total += i;
		} catch (NumberFormatException nfe) {
			total -= i;
		}
	}
	return total;
}

public String allStar(String str) 
{
 return allStarRec(str, 0, str.length()-1); 
}

private String allStarRec(String str, int start, int end)
{
  String result="";
  if (str.length()==0 || end-start==0)
  {
  return str;
  }
  if (end-start==1)
  {
   result=result + "*" + str;
  }
  result=result+ str.charAt(start);
  result=result+allStarRec(str, start+1, end);
  return result;
}

}

