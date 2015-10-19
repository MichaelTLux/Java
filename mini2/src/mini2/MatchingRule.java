package mini2;

public class MatchingRule 
{
	//TODO instance variables
	
	private String sourceString;
	private String targetString;
	
	public MatchingRule()
	{
		sourceString="abcdefghijklmnopqrstuvwxyz";
		targetString="abcdefghijklmnopqrstuvwxyz";
	}
	
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
