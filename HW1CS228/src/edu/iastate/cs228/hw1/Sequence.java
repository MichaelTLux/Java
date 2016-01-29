package edu.iastate.cs228.hw1;

/*
 * @author
*/

public class Sequence
{
  protected char[] seqarr;

  public Sequence(char[] sarr) throws IllegalArgumentException
  {
    if (sarr==null)
    {
    	throw new IllegalArgumentException("Invalid sequence letter for class edu.iastate.cs228.hw1.Sequence");
    }
    for (int i=0; i<sarr.length; i=i+1)
    {
    	if (!isValidLetter(sarr[i]))
    	{
    		throw new IllegalArgumentException("Invalid sequence letter for class edu.iastate.cs228.hw1.Sequence");
    	}
    }
    String copy="";
    for (int i=0; i<sarr.length; i=i+1)
    {
    	copy=copy+sarr[i];
    }
    seqarr=copy.toCharArray();
  }

  public int seqLength()
  {
    //ask if 0 or negative one
	if (seqarr==null)
    {
    	return 0;
    }
    return seqarr.length;
  }
  
  public char[] getSeq()
  {
	  String copy="";
	    for (int i=0; i<seqarr.length; i=i+1)
	    {
	    	copy=copy+seqarr[i];
	    }
	    return copy.toCharArray();
  }

  public String toString()
  {
    return seqarr.toString();
  }

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

  public boolean isValidLetter(char let)
  {
    return Character.isUpperCase(let) || Character.isLowerCase(let);
  }

}
