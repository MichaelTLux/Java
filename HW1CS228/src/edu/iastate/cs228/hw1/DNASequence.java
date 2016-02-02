package edu.iastate.cs228.hw1;

/**
 * This class holds the basic data for working with DNA sequences, 
 * which entails storing the given sequence and checking to make sure it only has 'a',
 * 'c', 'g', or 't'.
 * @author Michael Lux
 */
public class DNASequence extends Sequence
{
  
  /**
   * Creates a new DNA sequence if all the characters in an array are 
   * 'a', -'c', 'g', or 't'
   * @param dnaarr
   * 	the array that will be stored in the class
   * @throws IllegalArgumentException
   * 	thrown if the given array does not consist of only 'a', -'c', 'g', or 't'
   */
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

  /**
   * Checks if the character given is valid which means it 
   * is 'a', -'c', 'g', or 't'
   * @param let
   * 	the letter that is being checked
   * @return
   * 	true if valid false otherwise
   */
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
