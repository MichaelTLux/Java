package mini2;

/**
 * This class allows the storage of a code word and a rule.
 * Once constructed, you will be able to make comparisons
 * of the stored code word to one you ask.
 * @author Michael Lux
 *
 */

public class CodeWord 
{
	/**
	 * This is the stored code word that is compared to everything else
	 */
	private String comparedString;
	
	/**
	 * This is the matching rule that will be used when considering
	 * all comparisons. 
	 */
	private MatchingRule rule;
	
	/**
	 * Constructs a new code word that uses the default
	 * matching rule (every character equals itself)
	 * @param givenData
	 * 	the code word that is compared in all operations
	 */
	public CodeWord(String givenData)
	{
		comparedString=givenData;
		rule=new MatchingRule();
	}
	
	/**
	 * Constructs a new code work that uses the given
	 * matching rule
	 * @param givenData
	 * 	the code word that is compared in all operations
	 * @param givenRule
	 * 	the rule that will determine what is considered equal
	 */
	public CodeWord(String givenData, MatchingRule givenRule)
	{
		comparedString=givenData;
		rule= givenRule;
	}
	
	/**
	 * Counts how many characters are matching if the target is
	 * shifted the given amount
	 * @param target
	 * 	the string that is going to be compared to the code word
	 * @param shiftAmount
	 * 	how much of an offset there is for the target
	 * @return
	 * 	how many characters matched according to the rule
	 */
	public int countMatchesInLeftShift(String target, int shiftAmount)
	{
	//TODO
		int total=0;
		for (int index=0; index<comparedString.length();index=index+1)
		{
			if(index+shiftAmount>=target.length() || index>=comparedString.length())
			{
				return total;
			}
			if (rule.matches(comparedString.charAt(index), target.charAt(index+shiftAmount)))
			{
				total=total+1;
			}
		}
		return total;
	}
	
	/**
	 * Counts how many characters are matching if the code word is
	 * shifted the given amount
	 * @param target
	 * 	the string that is going to be compared to the code word
	 * @param shiftAmount
	 * 	how much of an offset there is for the code word
	 * @return
	 * 	how many characters matched according to the rule
	 */
	public int countMatchesInRightShift(String target, int shiftAmount)
	{
		int total=0;
		for (int index=0; index<comparedString.length();index=index+1)
		{
			if(index>=target.length() || index+shiftAmount>=comparedString.length())
			{
				return total;
			}
			if (rule.matches(comparedString.charAt(index+shiftAmount), target.charAt(index)))
			{
				total=total+1;
			}
		}
		return total;
	}
	
	/**
	 * Counts how many characters match if both strings are
	 * lined up evenly
	 * @param target
	 * 	the string that is going to be compared to the code word
	 * @return
	 * 	how many characters matched
	 */
	public int countMatchesUnshifted(java.lang.String target)
	{
		int total=0;
		for (int index=0; index<comparedString.length();index=index+1)
		{
			if(index>=target.length() || index>=comparedString.length())
			{
				return total;
			}
			if (rule.matches(comparedString.charAt(index), target.charAt(index)))
			{
				total=total+1;
			}
		}
		return total;
	}
	
	/**
	 * counts the number of the given character there are in the string
	 * @param ch
	 * 	the character you are checking for
	 * @return
	 * 	the number of characters that matched
	 */
	public int letterCount(char ch)
	{
		int total=0;
		for (int i=0; i<comparedString.length(); i=i+1)
		{
			if (comparedString.charAt(i)==ch)
			{
				total=total+1;
			}
		}
		return total;
	}
	
	/**
	 * Counts how many characters are matching for all possible
	 * aligments for the two strings
	 * @param target
	 * 	the string that is going to be compared to the code word
	 * @param shiftAmount
	 * 	how much of an offset there is for the code word
	 * @return
	 * 	how many characters matched according to the rule
	 */
	public int maxMatches(java.lang.String target)
	{
		int max;
		max=countMatchesUnshifted(target);
		for(int i=0; i<= Math.max(target.length(),comparedString.length()); i=i+1)
			{
			max=Math.max(max, countMatchesInRightShift(target, i));
			max=Math.max(max, countMatchesInLeftShift(target, i));	
			}
		return max;
	}

}
