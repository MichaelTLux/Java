package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class DNASequenceTest {
	@Test
	public void DNAContructorWorks()
	 {
		String message="Does it construct?";
		char[] charA={'a','c','g','t'};
		DNASequence s= new DNASequence(charA);
		assertEquals(message, s, s);
	 }
	@Test
	public void DNASequenceIsValidCharacter1()
	 {
		boolean flag=false;
		String message="All lowercase agct are good in this instance";
		char[] charA={'a','c','g','t'};
		DNASequence s= new DNASequence(charA);
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
	public void DNASequenceIsValidCharacter2()
	 {
		boolean flag=false;
		String message="All Uppercase AGCT are good";
		char[] charA={'A','G','C','T'};
		DNASequence s= new DNASequence(charA);
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
	public void DNASequenceIsValidCharacter3()
	 {
		boolean flag=false;
		DNASequence s=null;
		String message="Numbers dont work";
		char[] charA={'1','A','G','C','T'};
		try 
		{
			s= new DNASequence(charA);
		}
		catch (IllegalArgumentException exception)
		{
			flag=true;
		}
		if (s==null);
		assertEquals(message, true, flag);
	 }
	@Test
	public void DNASequenceIsValidCharacter4()
	 {
		boolean flag=false;
		DNASequence s=null;
		String message="Symbols dont work";
		char[] charA={':','A','G','C','T'};
		try 
		{
			s= new DNASequence(charA);
		}
		catch (IllegalArgumentException exception)
		{
			flag=true;
		}
		if (s==null);
		assertEquals(message, true, flag);
	 }
	//how to run an exception thrown
	@Test (expected=IllegalArgumentException.class)
	public void DNASequenceIsValidCharacter5()
	 {
		DNASequence s=null;
		if (null==s);
		char[] charA={'B','A','G','C','T'};
			s= new DNASequence(charA);
	 }
	@Test
	public void DNASequenceSeqLength1()
	 {
		String message="This should be 8";
		char[] charA={'A','G','C','T','A','G','C','T'};
		DNASequence s= new DNASequence(charA);
		int total=s.seqLength();
		assertEquals(message, 8, total);
	 }
	@Test
	public void DNASequenceSeqLength2()
	 {
		String message="nothing should be 0";
		char[] charA={};
		DNASequence s= new DNASequence(charA);
		int total=s.seqLength();
		assertEquals(message, 0, total);
	 }
	@Test
	public void DNASequenceSeqChar1()
	 {
		boolean flag=true;
		String message="nothing should return nothing";
		char[] charA={};
		DNASequence s= new DNASequence(charA);
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
	public void DNASequenceSeqChar2()
	 {
		boolean flag=true;
		String message="'A','G','C','T' should return 'A','G','C','T'";
		char[] charA={'A','G','C','T'};
		DNASequence s= new DNASequence(charA);
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
	public void DNASequenceToString()
	{
		char[] charA={'A','G','C','T'};
		DNASequence s= new DNASequence(charA);
		System.out.println(	s.toString());
	}
	@Test
	public void DNASequenceEquals1()
	{
		String message="two same arrays should be equal";
		char[] charA={'a','c','a','t'};
		char[] charb={'a','c','a','t'};
		DNASequence a=new DNASequence(charA);
		DNASequence b=new DNASequence(charb);
		assertEquals(message, true, a.equals(b));
	}
	@Test
	public void DNASequenceEquals2()
	{
		String message="two different arrays should not be equal";
		char[] charA={'a','c','a','t'};
		char[] charb={'a','t','c'};
		DNASequence a=new DNASequence(charA);
		DNASequence b=new DNASequence(charb);
		assertEquals(message, false, a.equals(b));
	}

	@Test
	public void DNASequenceEquals3()
	{
		String message="an empty array shouldnt equal a full one";
		char[] charA={'a','c',};
		char[] charb={};
		DNASequence a=new DNASequence(charA);
		DNASequence b=new DNASequence(charb);
		assertEquals(message, false, a.equals(b));
	}
	@Test
	public void DNASequenceEquals4()
	{
		String message="Any object should be able to go through";
		char[] charA={'a','g','c','c'};
		DNASequence a=new DNASequence(charA);
		Object o=new Object();
		assertEquals(message, false, a.equals(o));
	}
	
	@Test
	public void DNASequenceEquals5()
	{
		String message="two different arrays should not be equal";
		char[] charA={'a','c','a','t'};
		char[] charb={'a','g','c','t'};
		DNASequence a=new DNASequence(charA);
		DNASequence b=new DNASequence(charb);
		assertEquals(message, false, a.equals(b));
	}

	
}
