package lab11;

import java.io.File;
import java.util.ArrayList;

public class AllJavaFiles 
{
	public static void main(String[] args)
	  {
	    String rootDirectory = "."; 

	    System.out.println(AllJavaFile(new File(rootDirectory)).toString());
	    
	  }
	  
	 
	  public static ArrayList<String> AllJavaFile(File f)
	  {
	    ArrayList<String> result= new ArrayList<>();
	    AllJavaFileRec(f, result);
	    return result;
	  }
	  
	  
	  private static ArrayList<String> AllJavaFileRec(File f, ArrayList<String> result)
	  { 
	    if (!f.isDirectory())
	    {
	      String name=f.getName();
	      if (name.endsWith(".java"))
	      {
	    	  result.add(name);
	      }
	    }
	    else
	    {
	      File[] files = f.listFiles();
	      for (int i = 0; i < files.length; ++i)
	      {
	        AllJavaFileRec(files[i], result);
	      }
	    }
	    return result;
	  }
}
