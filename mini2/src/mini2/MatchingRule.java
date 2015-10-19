package mini2;


/**
 * This Class allows a user to set up a rule 
 * for what characters match what. Corresponding 
 * indexes mean that the characters are equal.
 * @author Michael Lux
 *
 */
public class MatchingRule 
{
	/**
	 * the first part of the rule that states
	 * what characters can be valid and sets up
	 * the corresponding indexes
	 */
	private String sourceString;
	
	/**
	 * the second part of the rule, the indexes
	 * that correspond with the source mean that
	 * they are equal
	 */
	private String targetString;
	
	/**
	 * This constructs a default matching rule that
	 * has every character equal itself
	 */
	public MatchingRule()
	{
		sourceString="abcdefghijklmnopqrstuvwxyz";
		targetString="abcdefghijklmnopqrstuvwxyz";
	}
	
	/**
	 * This constructs a matching rule using the parameters given
	 * for a source and a target
	 * @param givenSourceChars
	 * 	the first part of the rule that states
	 * what characters can be valid and sets up
	 * the corresponding indexes
	 * @param givenTargetChars
	 * 	the second part of the rule, the indexes
	 * that correspond with the source mean that
	 * they are equal 
	 */
	public MatchingRule(String givenSourceChars, String givenTargetChars)
	{
		sourceString=givenSourceChars;
		targetString=givenTargetChars;
	}
	
	/**
	 * Returns true if all the characters in the given string are
	 * valid according to this rule. A character is defined to be
	 * valid if it appears at least once in this rule's source 
	 * character string.
	 * @param s
	 * 	string to check
	 * @return
	 * 	true if valid false if not
	 */
	public boolean isValidSource(String s)
	{
		boolean flag=true;
		
		for (int i=0; i<s.length(); i=i+1)
		{
			char currentChar=s.charAt(i);
			if (!checkIfValidChar(currentChar))
			{
				flag=false;
			}
		}
		
		return flag;
	}
	/**
	 * uses the matching rule to determine of the characters
	 * have been deemed equal
	 * @param sourceChar
	 * 	the character that is to correspond to the source
	 * @param targetChar
	 * 	the character that is to correspond to the target
	 * @return
	 * 	whether or not the two values where equal
	 */
	public boolean matches(char sourceChar, char targetChar)
	{
		int sourceIndex=validCharIndex(sourceChar);
		for (int index=0; index<sourceString.length();index=index+1)
		{
			if (sourceIndex>=targetString.length() )
			{
				//please explain why c == $ when abac to xyz?
				return true;
			}
			if (sourceChar==sourceString.charAt(index) && targetChar==targetString.charAt(index) && sourceChar==sourceString.charAt(index))
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * Determines if the given character is valid
	 * according to the rule
	 * @param checkThis
	 * 	the character that is being checked
	 * @return
	 * 	whether or not the character is valid
	 */
	private boolean checkIfValidChar(char checkThis)
	{
		for (int index=0; index<sourceString.length();index=index+1)
		{
			if (checkThis==sourceString.charAt(index))
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * private helper method that finds the index if a valid
	 * source character (already in java libraries just keeping
	 * as a friendly reminder that I should check)
	 * @param indexThis
	 * 	the character that is being found
	 * @return
	 * 	the index of the character in the source string
	 */
	private int validCharIndex(char indexThis)
	{
		for (int index=0; index<sourceString.length();index=index+1)
		{
			if (indexThis==sourceString.charAt(index))
			{
				return index;
			}
		}
		return 0;
	}

}
