package mini2;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class Testing {
	MatchingRule matchD;
	MatchingRule matchABC_XYZ;
	
	
	
	@Before
	public void setup()
	{
		matchD= new MatchingRule();
		matchABC_XYZ= new MatchingRule("abc", "xyz");
	}
	
	@Test
	public void testIsValidOnDefaultYes()
	{
		String msg="Should be valid if using default and send normal lowercase strings";
		assertEquals(msg, true, matchD.isValidSource("rjklsndvjfk"));
	}
	
	@Test
	public void testIsValidOnDefaultYes2()
	{
		String msg="Should be valid if using default and send normal lowercase strings";
		assertEquals(msg, true, matchD.isValidSource("z"));
	}
	
	@Test
	public void testIsValidOnDefaultNo()
	{
		String msg="Should not be valid if using default and send 1";
		assertEquals(msg, false, matchD.isValidSource("1"));
	}
	
	@Test
	public void testIsValidOnDefaultNo2()
	{
		String msg="Should not be valid if using default and send asd3kls";
		assertEquals(msg, false, matchD.isValidSource("asd3kls"));
	}
	
	@Test
	public void testIsValidOnABCYes()
	{
		String msg="Should be valid if using default and send abc";
		assertEquals(msg, true, matchABC_XYZ.isValidSource("abc"));
	}
	
	@Test
	public void testIsValidOnABCYes2()
	{
		String msg="Should be valid if using default and send abc";
		assertEquals(msg, true, matchABC_XYZ.isValidSource("cba"));
	}
	
	@Test
	public void testIsValidOnABCNo()
	{
		String msg="Should not be valid if using default and send ajb";
		assertEquals(msg, false, matchABC_XYZ.isValidSource("ajb"));
	}
	
	@Test
	public void testIsValidOnABCNo2()
	{
		String msg="Should not be valid if using default and send jabc";
		assertEquals(msg, false, matchABC_XYZ.isValidSource("jabc"));
	}
	
	@Test
	public void testMatchesYes()
	{
		String a="banana";
		char b=a.charAt(1);
		char c=a.charAt(3);
		assertEquals(true,matchD.matches(b,c));
	}
		
	@Test
	public void offSpecCheck()
	{
		MatchingRule m=new MatchingRule("abac","xyz");
		String foo="azzle";
		char a=foo.charAt(0);
		char z=foo.charAt(1);
		m.matches(a,z);
	}
}
