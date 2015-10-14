package lab6;

public class StringUtilTest 
{
	public static void main(String[] args)
	  {
	    // should return "ready"
	    System.out.println(StringUtil.fixSpelling("raedy"));
	    
	    // should return "happyi"
	    System.out.println(StringUtil.fixSpelling("happyi"));
	    
	    // should return "potato"
	    System.out.println(StringUtil.fixSpelling("potato"));
	    
	    // should return "blue"
	    System.out.println(StringUtil.fixSpelling("bleu"));
	    
	    // should return "aeiou"
	    System.out.println(StringUtil.fixSpelling("eaoiu"));
	    
	  }


}
