package lab11;

import java.io.File;

public class FindFileSize 
{
	public static void main(String[] args)
	  {
	    String rootDirectory = "."; 
	    System.out.println(countBytes(new File(rootDirectory)));
	  }
	public static long countBytes(File f)
	  { 
	    long total=0;
	    //this is the base case
		if (!f.isDirectory())
	    {
	     return f.length();
	    }
	    else
	    {
	      //total=total+f.length();
	      File[] files = f.listFiles();
	      for (int i = 0; i < files.length; ++i)
	      {
	        total= total+countBytes(files[i]);
	      }
	    }
		return total;

	  }
}
