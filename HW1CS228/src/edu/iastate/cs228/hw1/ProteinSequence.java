package edu.iastate.cs228.hw1;

/*
 * @author
*/

public class ProteinSequence extends Sequence
{
  public ProteinSequence(char[] psarr) throws IllegalArgumentException
  {
    super(psarr);
    for (int i=0; i<psarr.length; i=i+1)
    {
    	if (!isValidLetter(psarr[i]))
    	{
    		throw new IllegalArgumentException("Invalid sequence letter for "+ getClass());
    	}
    }
    String copy="";
    for (int i=0; i<psarr.length; i=i+1)
    {
    	copy=copy+psarr[i];
    }
    seqarr=copy.toCharArray();
  }

  @Override
  public boolean isValidLetter(char let)
  {
	 if (!super.isValidLetter(let))
	 {
		 return false;
	 }
    char[] notValid={'B', 'b', 'J', 'j', 'O', 'o', 'U', 'u','X', 'x', 'Z', 'z'};
    for (int i=0; i<notValid.length; i++)
    {
    	if (let==notValid[i])
    	{
    		return false;
    	}
    }
    return true;
  }
}
