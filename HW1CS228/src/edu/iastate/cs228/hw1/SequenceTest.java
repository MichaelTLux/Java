package edu.iastate.cs228.hw1;


import static org.junit.Assert.*;
import org.junit.Test;

public class SequenceTest 
{
	
	@Test
	public void SequenceConstructorWorks()
	 {
		String message="Does it construct?";
		char[] charA={'a','b','c'};
		Sequence s= new Sequence(charA);
		assertEquals(message, s, s);
	 }
	@Test
	public void SequenceIsValidCharacter1()
	 {
		boolean flag=false;
		String message="All lowercase characters are good";
		char[] charA={'a','b','c','d','e','f','g', 'h','i','j','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		Sequence s= new Sequence(charA);
		for (int i=0; i<charA.length; i=i+1)
		{
			if (!s.isValidLetter(charA[i]))
			{
				flag=true;
			}
		}
		assertEquals(message, false, flag);
	 }
	@Test
	public void SequenceIsValidCharacter2()
	 {
		boolean flag=false;
		String message="All Uppercase characters are good";
		char[] charA={'A','B','C','D','E','F','G', 'H','I','J','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		Sequence s= new Sequence(charA);
		for (int i=0; i<charA.length; i=i+1)
		{
			if (!s.isValidLetter(charA[i]))
			{
				flag=true;
			}
		}
		assertEquals(message, false, flag);
	 }
	@Test
	public void SequenceIsValidCharacter3()
	 {
		boolean flag=false;
		Sequence s=null;
		String message="Numbers dont work";
		char[] charA={'1','B','C','D','E',};
		try 
		{
			s= new Sequence(charA);
		}
		catch (IllegalArgumentException exception)
		{
			flag=true;
		}
		if (s==null);
		assertEquals(message, true, flag);
	 }
	@Test
	public void SequenceIsValidCharacter4()
	 {
		boolean flag=false;
		Sequence s=null;
		String message="Symbols dont work";
		char[] charA={':','B','C','D','E',};
		try 
		{
			s= new Sequence(charA);
		}
		catch (IllegalArgumentException exception)
		{
			flag=true;
		}
		if (s==null);
		assertEquals(message, true, flag);
	 }
	@Test
	public void SequenceSeqLength1()
	 {
		String message="whole alphabet will be 26";
		char[] charA={'a','b','c','d','e','f','g', 'h','i','j', 'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		Sequence s= new Sequence(charA);
		int total=s.seqLength();
		assertEquals(message, 26, total);
	 }
	@Test
	public void SequenceSeqLength2()
	 {
		String message="nothing should be 0";
		char[] charA={};
		Sequence s= new Sequence(charA);
		int total=s.seqLength();
		assertEquals(message, 0, total);
	 }
	@Test
	public void SequenceSeqChar1()
	 {
		boolean flag=true;
		String message="nothing should return nothing";
		char[] charA={};
		Sequence s= new Sequence(charA);
		char[] total=s.getSeq();
		for (int i=0; i<s.seqLength(); i++)
		{
			if (!(charA[i]==total[i]))
			{
				flag=false;
			}
		}
		
		assertEquals(message, true, flag);
	 }
	@Test
	public void SequenceSeqChar2()
	 {
		boolean flag=true;
		String message="alphabet should return alphabet";
		char[] charA={'a','b','c','d','e','f','g', 'h','i','j','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		Sequence s= new Sequence(charA);
		char[] total=s.getSeq();
		for (int i=0; i<s.seqLength(); i++)
		{
			if (!(charA[i]==total[i]))
			{
				flag=false;
			}
		}
		
		assertEquals(message, true, flag);
	 }
	@Test
	public void SequenceToString()
	{
		char[] charA={'a','b','c','d','e','f','g', 'h','i','j','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		Sequence s= new Sequence(charA);
		System.out.println(	s.toString());
	}
	@Test
	public void SequenceEquals1()
	{
		String message="two same arrays should be equal";
		char[] charA={'a','b','c','d'};
		char[] charb={'a','b','c','d'};
		Sequence a=new Sequence(charA);
		Sequence b=new Sequence(charb);
		assertEquals(message, true, a.equals(b));
	}
	@Test
	public void SequenceEquals2()
	{
		String message="two different arrays should not be equal";
		char[] charA={'a','b','c','d'};
		char[] charb={'a','b','c'};
		Sequence a=new Sequence(charA);
		Sequence b=new Sequence(charb);
		assertEquals(message, false, a.equals(b));
	}
	@Test
	public void SequenceEquals3()
	{
		String message="an empty array shouldnt equal a full one";
		char[] charA={'a','b','c','d'};
		char[] charb={};
		Sequence a=new Sequence(charA);
		Sequence b=new Sequence(charb);
		assertEquals(message, false, a.equals(b));
	}
	@Test
	public void SequenceEquals4()
	{
		String message="Any object should be able to go through";
		char[] charA={'a','b','c','d'};
		Sequence a=new Sequence(charA);
		Object o=new Object();
		assertEquals(message, false, a.equals(o));
	}	
}
