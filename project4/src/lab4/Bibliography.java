package lab4;

import java.util.Scanner;
import lab4.BibItem;

public class Bibliography 
{
	public static void main(String[] args)
	  {
		//DATA
	    String s1 = "Dijkstra, Edsger#Go To Statement Considered Harmful#Communications of the ACM#1968#11";
	    String s2 = "Levoy, Marc#Display of Surfaces from Volume Data#IEEE Computer Graphics and Applications#1988#8";
	    String s3 = "Dean, Jeffrey; Ghemawat, Sanjay#MapReduce: Simplified Data Processing on Large Clusters#Communications of the ACM#2008#51";
	    
	    BibItem item1= myHelperMethod(s1);
	    BibItem item2= myHelperMethod(s2);
	    BibItem item3= myHelperMethod(s3);
	    
	    System.out.println(item1);
	    System.out.println(item2);
	    System.out.println(item3);
	    
	  }
	    private static BibItem myHelperMethod(String s)
	    {
	      // parse the given string s and return a new BibItem
	    	Scanner scanner= new Scanner(s);
	    	scanner.useDelimiter("#");
	    	String givenAuthors= scanner.next();
	    	String givenTitle= scanner.next();
	    	String givenJournal= scanner.next();
	    	int givenYear= scanner.nextInt();
	    	int givenVolume= scanner.nextInt();
	    	
	    	BibItem bibItem= new BibItem( givenAuthors, givenTitle, givenJournal, givenYear, givenVolume);
	    	return bibItem;
	    }
	}
