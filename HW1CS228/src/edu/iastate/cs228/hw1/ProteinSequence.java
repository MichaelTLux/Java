package edu.iastate.cs228.hw1;

/**
 * This class holds the data for a protein sequence
 * and checks to make sure the sequence only has
 * valid characters
 * @author Michael Lux
 */

public class ProteinSequence extends Sequence
{
  /**
   * Contructs a new protein sequence the stores the given
   * sequence if it has all valid characters
   * @param psarr
   * 	the desired sequence for the class
   * @throws IllegalArgumentException
   * 	thrown if the given sequence contains an invalid character
   */
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
  /**
   * Checks if the character given is valid which means it 
   * is in the alphabet but isn't b, j, o, u, x, or z.
   * @param let
   * 	the letter that is being checked
   * @return
   * 	true if valid false otherwise
   */
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
