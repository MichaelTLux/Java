package edu.iastate.cs228.hw1;

/**
 * This class holds the basic data for making and using a sequence of only letters.
 * This includes ways to get the length, how to print, returning the saved sequence
 * and asking if the sequences are equal
 * @author Michael Lux
 *
 */

public class Sequence
{
  /**
   * This is the stored sequence of the class
   */
  protected char[] seqarr;

  /**
   * Constructs a new sequence by first checking that it is all letters then storing it
   * @param sarr
   * 	the sequence you want stored in the class
   * @throws IllegalArgumentException
   * 	if the sequence given is null or has characters other then letters
   */
  public Sequence(char[] sarr) throws IllegalArgumentException
  {
    if (sarr==null)
    {
    	throw new IllegalArgumentException("Invalid sequence letter for " + getClass());
    }
    for (int i=0; i<sarr.length; i=i+1)
    {
    	if (!isValidLetter(sarr[i]))
    	{
    		throw new IllegalArgumentException("Invalid sequence letter for "+ getClass());
    	}
    }
    String copy="";
    for (int i=0; i<sarr.length; i=i+1)
    {
    	copy=copy+sarr[i];
    }
    seqarr=copy.toCharArray();
  }
  
  /**
   * Returns the length of the stored sequence
   * @return
   * The length of the stored sequence
   */
  public int seqLength()
  {
    //ask if 0 or negative one
	if (seqarr==null)
    {
    	return 0;
    }
    return seqarr.length;
  }
  
  /**
   * Returns the stored sequence
   * @return
   * the stored sequence
   */
  public char[] getSeq()
  {
	  String copy="";
	    for (int i=0; i<seqarr.length; i=i+1)
	    {
	    	copy=copy+seqarr[i];
	    }
	    return copy.toCharArray();
  }

  /**
   * turns the stored sequence into an array
   */
  public String toString()
  {
	if (seqarr==null || seqarr.length==0)
	{
		return "()";
	}
    String returning="";
    returning=returning+"(";
    for (int i=0; i<seqarr.length-1;i=i+1)
    {
    	returning=returning+seqarr[i]+ ", ";
    	
    }
    returning=returning+seqarr[seqarr.length-1]+")";
    return returning;
  }

  /**
   * Compares two objects and if they are both the same class,
   * it will compare if they have the same sequence
   */
  public boolean equals(Object obj)
  { 
    if (obj==this)
    {
    	return true;
    }
    if (obj==null)
    {
    	return false;
    }
    if (!(obj instanceof Sequence))
    {
    	return false;
    }
    Sequence check= (Sequence) obj;
    if (!(check.seqLength()==this.seqLength()))
    {
    	return false;
    }
    char[] checkSeq=check.getSeq();
    for (int i=0; i<seqLength(); i=i+1)
    {
    	if (!(seqarr[i]==checkSeq[i]))
    	{
    		return false;
    	}
    }
    return true;
  }

  /**
   * Checks if the character given is valid which means it 
   * is in the alphbet
   * @param let
   * 	the letter that is being checked
   * @return
   * 	true if valid false otherwise
   */
  public boolean isValidLetter(char let)
  {
    return Character.isUpperCase(let) || Character.isLowerCase(let);
  }

}
