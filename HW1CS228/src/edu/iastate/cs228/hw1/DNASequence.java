package edu.iastate.cs228.hw1;

/*
 * @author
*/

public class DNASequence extends Sequence
{
  public DNASequence(char[] dnaarr) throws IllegalArgumentException
  { 
	  super(dnaarr);
	  for (int i=0; i<dnaarr.length; i=i+1)
	    {
	    	if (!(isValidLetter(dnaarr[i])|| super.isValidLetter(dnaarr[i])))
	    	{
	    		throw new IllegalArgumentException("Invalid sequence letter for " + getClass());
	    	}
	    }
	    String copy="";
	    for (int i=0; i<dnaarr.length; i=i+1)
	    {
	    	copy=copy+dnaarr[i];
	    }
	    seqarr=copy.toCharArray();
  }

  @Override
  public boolean isValidLetter(char let)
  {
	char[] valid={'a','A','c','C','g','G','t','T'};
    for (int i=0; i<valid.length; i++)
    {
    	if (let==valid[i])
    	{
    		return true;
    	}
    }
    return false;
  }

}
