package edu.iastate.cs228.hw1;

/*
 * @author
*/

public class GenomicDNASequence extends DNASequence
{
  public GenomicDNASequence(char[] gdnaarr) throws IllegalArgumentException
  {
    //think about throwing the correct exception, with the correct "message"
	  super(gdnaarr);
  }

  public char[] extractExons(int[] exonpos) throws IllegalArgumentException
  {
    if (exonpos==null || exonpos.length==0 || exonpos.length%2!=0)
    {
    	throw new IllegalArgumentException("Empty array or odd number of array elements");
    }
    for (int i=0; i<exonpos.length; i++)
    {
    	 int check=exonpos[i];
    	if (check>=super.seqLength() || check<0)
    	{
    		throw new IllegalArgumentException("Exon position is out of bounds");
    	}
    	
    }
    for (int i=0; i+1<exonpos.length; i++)
    {
    	if(exonpos[i]>exonpos[i+1])
    	{
    		throw new IllegalArgumentException("Exon positions are not in order");
    	}
    }
	String result=""; 
	for (int i=0; i+1<exonpos.length; i=i+2)
	{
		for (int j=exonpos[i];j<=exonpos[i+1];j++)
		{
			result=result+super.seqarr[j];
		}
	}
	return result.toCharArray();
  }

}
