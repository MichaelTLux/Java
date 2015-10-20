package lab7;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Point;
import plotter.PolylinePlotter;

public class MyPolyPlotter2 
{
	 public static void main(String[] args) throws FileNotFoundException
	  {
		 PolylinePlotter plotter = new PolylinePlotter();
		 // open the file
		    File file = new File("hello.txt");    
		    Scanner scanner = new Scanner(file);
		    String why="#";
		    char commentChar= why.charAt(0);
		    
		 // while there are more lines...
		    while (scanner.hasNextLine())
		    {
		      // get the next line
		      String line = scanner.nextLine();
		      line=line.trim();
		      if (line.length()!=0 && !(line.charAt(0)==commentChar))
		      	{
		    	  contructTheObject(line, plotter);
		      	}
		    }

		    
		    
		    
		    
		    
		    scanner.close();
	  }
	 private static void contructTheObject(String line, PolylinePlotter plotter)
	 {
		 
		 Scanner temp=new Scanner(line);
		 int width;
		 String color;
		 if (temp.hasNextInt())
		 {
			 width=temp.nextInt();
		 }
		 else
		 {
			 width=1;
		 }
		 color=temp.next();
		 int xCordinate=temp.nextInt();
		 int yCordinate=temp.nextInt();
		 plotter.startLine(color, new Point(xCordinate, yCordinate), width);
		 while (temp.hasNextInt())
		 {
			 xCordinate=temp.nextInt();
			 yCordinate=temp.nextInt();
			 plotter.addPoint(new Point(xCordinate, yCordinate));
		 }
		 
	 }

}
