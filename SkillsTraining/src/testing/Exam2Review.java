package testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Exam2Review 
{
	public static void main(String args[]) throws FileNotFoundException
	{
		int[] nums={1,2,3,4,5,6,7,8,9};
		System.out.println(getAverage(nums));
		String testSentence= "1 12 123 1234 12345 123456 1234567";
		String testSentence2="1234 1234567 123 12 1 123456 12345";
		System.out.println(longestWord(testSentence));
		System.out.println(longestWord(testSentence2));
		System.out.println(removeNonAlphabet(testSentence));
		String test3="hi i am a person!";
		System.out.println(removeNonAlphabet(test3));
		double balance=2000;
		double APR=1;
		System.out.println(doubleBalance(APR, balance));
//		ArrayList arr=new ArrayList<Integer>();
//		arr.add(1);
//		arr.add(2);
//		arr.add(3);
//		arr.add(7);
//		arr.add(9);
//		arr.add(12);
//		ArrayList arr2=new ArrayList<Integer>();
//		arr2.add(0);
//		arr2.add(1);
//		arr2.add(7);
//		arr2.add(9);
//		arr2.add(8);
//		System.out.println(isIncreaseing(arr));
//		System.out.println(isIncreaseing(arr2));
//		withoutComments();
		mystery(12,0);
		int[] test = {6, 7, 4, 3, 5, 2, 7, 9, 8};
		enigma(test);
		for (int i=0; i<test.length; i=i+1)
		{
			System.out.print(test[i]);
		}
		System.out.println();
		
		
	}
			private static double getAverage(int[] nums)
			{
				double count=0;
				double total=0;
				for (int i=0; i<nums.length; i=i+1)
				{
					total=total+nums[i];	
					count=count+1;
				}
				return total/count;
			}


			private static String longestWord(String sentence)
			{
				Scanner s= new Scanner(sentence);
				int largestLength=0;
				int largestIndex=0;
				int count=0;
				while (s.hasNext())
				{
					String compare=s.next();
					if (compare.length()>largestLength)
					{
						largestIndex=count;
						largestLength=compare.length();
					}
				count=count+1;
				}
				Scanner s2=new Scanner(sentence);
				for (int i=0; i<largestIndex; i=i+1)
				{
					s2.next();
				}
				return s2.next();
			}

			private static String removeNonAlphabet(String sentence)
			{
				String result="";
				for (int i=0; i<sentence.length(); i=i+1)
				{
					if (!Character.isAlphabetic(sentence.charAt(i)))
					{
						result=result+"#";
					}
					else
					{
						result=result+sentence.charAt(i);
					}
				}
				return result;
			}
			private static int doubleBalance(double APR, double balance)
			{
				double goal=balance*2;
				int numOfMonths=0;
				double current=balance;
				while (goal>current)
				{
					current=current+(current*(APR/12));
					numOfMonths=numOfMonths+1;
				}
				return numOfMonths;
			}
			private static boolean isIncreaseing(ArrayList<Integer> arr)
			{
				for(int i=0; i<arr.size(); i=i+1)
				{
					if (i+1<arr.size() && !(arr.get(i)<=arr.get(i+1)))
					{
					return false;
					}
				}
				return true;
			}
			public static void withoutComments() throws FileNotFoundException 
			{
				System.out.println("src/testing/Exam2Review.java");
				Scanner filePlac=new Scanner(System.in);
				String filePlace= filePlac.nextLine();
				File file= new File(filePlace);
				Scanner whole= new Scanner(file);
				PrintWriter out = new PrintWriter(filePlace + ".out");
				while (whole.hasNextLine())
				{
					String thisLine=whole.nextLine();
					if((thisLine.contains("//")));
					{
						out.println(thisLine);
					}
				}
				whole.close();
				filePlac.close();
				out.close();
			}
			 private static void mystery(int x, int y)
			 {
			 while (x > 0)
			 {
			 if (x % 2 == 0)
			 {
			 y = y + 1;
			 }
			 else
			 {
			 x = x + 2;
			 }
			 x = x - y;
			 System.out.println(x + ", " + y);
			 }
			 }
			 
			 
			 public static void enigma (int[] arr)
			 {
			 int i = 0;
			 for (int count = 0; count < arr.length; count += 1)
			 {
			 if (arr[i] % 2 != 0)
			 {
			 for (int j = i; j < arr.length - 1; j += 1)
			 {
			 arr[j] = arr[j + 1];
			 }
			 arr[arr.length - 1] = 0;
			 }
			 else
			 {
			 i += 1;
			 }
			 }
			 }
}
