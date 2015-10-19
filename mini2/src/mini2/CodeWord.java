package mini2;

public class CodeWord 
{
	private String comparedString;
	private MatchingRule rule;
	
	public CodeWord(String givenData)
	{
		comparedString=givenData;
		rule=new MatchingRule();
	}
	
	public CodeWord(String givenData, MatchingRule givenRule)
	{
		comparedString=givenData;
		rule= givenRule;
	}
	
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
	
	public int maxMatches(java.lang.String target)
	{
	//TODO
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
