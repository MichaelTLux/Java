package lab7;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LineNumberer
{
  public static void main(String[] args) throws FileNotFoundException
  {
	File file = new File("src/lab7/LineNumberer.java");
	System.out.println(file.exists());          // true if the file exists
    System.out.println(file.getName());         // name of the file 
    System.out.println(file.getAbsolutePath()); // absolute path to the file
    System.out.println(file.length());          // size of the file
	Scanner scanner = new Scanner(file);
    int lineCount = 1;
    
    //add writing to a string
    File outFile = new File("mydocument.txt");
    PrintWriter out = new PrintWriter(outFile);

    while (scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      out.print(lineCount + " ");
      out.println(line);
      lineCount += 1;
    }
    System.out.println("Done");
    scanner.close();
    out.close();
  }
}