package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MileageCalculator 
{
	public static void main(String args[]) throws FileNotFoundException
	{
		File file = new File("mileage.txt");

		Scanner scanner= new Scanner(file);
		ArrayList<FillUp> list = new ArrayList<FillUp>();
		list=getFileInfo(list,scanner);
		for (int index=0; index+1<list.size(); index=index+1)
		{
			int firstOd=list.get(index).getOdometer();
			int secondOd=list.get(index+1).getOdometer();
			double gallonsNeeded=list.get(index+1).getGallons();
			double result=(secondOd-firstOd)/gallonsNeeded;
			System.out.println("Mileage "+ (index+1) + ": " + result);
		}
	}
	
	private static ArrayList<FillUp> getFileInfo(ArrayList<FillUp> list, Scanner scanner)
	{
		while (scanner.hasNextLine())
		{
			int odemeter=scanner.nextInt();
			double gallons=scanner.nextDouble();
			FillUp fillup=new FillUp(odemeter, gallons);
			list.add(fillup);
		}
		return list;
	}

}
