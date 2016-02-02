package edu.iastate.cs228.hw1;

/**
 * This class holds a DNA sequence and allows codons
 * to be pulled from the given sequence if it contains
 * valid characters
 * @author Michael Lux
 */

public class GenomicDNASequence extends DNASequence
{
  /**
   * Contructs a new GenomicDNASequence storing the 
   * given sequence if it has all valid characters
   * @param gdnaarr
   *  the desired DNA sequence
   * @throws IllegalArgumentException
   *  thrown if the sequence contains any illegal characters
   */
  public GenomicDNASequence(char[] gdnaarr) throws IllegalArgumentException
  {
	  super(gdnaarr);
  }

  /**
   * Allows codons to be extracted from the DNA sequence
   * by giving pairs of start and stop indexes, the method
   * will fail if an odd number are given or if the numbers
   * don't go from smallest to largest of if the index is out of bounds
   * @param exonpos
   * 	the indexes in the DNA sequence the the exons exist, start and stop
   * @return
   * 	returns the parsed exons for the given indexes
   * @throws IllegalArgumentException
   *   thrown if there is an odd number of indexes or if the numbers
   * don't go from smallest to largest of if the index is out of bounds
   */
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
