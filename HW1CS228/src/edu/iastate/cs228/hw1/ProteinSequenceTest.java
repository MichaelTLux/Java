package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

public class ProteinSequenceTest 
{
	//bjouxz
	public void ProteinSequenceConstructorWorks()
	 {
		String message="Does it construct?";
		char[] charA={'a','c','y'};
		ProteinSequence s= new ProteinSequence(charA);
		assertEquals(message, s, s);
	 }
	
	public void ProteinSequenceIsValidCharacter1()
	 {
		boolean flag=false;
		String message="All lowercase characters are good minus bjouxz";
		char[] charA={'a','c','d','e','f','g', 'h','i','l','m','n','p','q','r','s','t','v','w','y'};
		ProteinSequence s= new ProteinSequence(charA);
		for (int i=0; i<charA.length; i=i+1)
		{
			if (!s.isValidLetter(charA[i]))
			{
				flag=true;
			}
		}
		assertEquals(message, false, flag);
	 }
	
	public void ProteinSequenceIsValidCharacter2()
	 {
		boolean flag=false;
		String message="All Uppercase characters are good minus bjouxz";
		char[] charA={'A','C','D','E','F','G', 'H','I','L','M','N','P','Q','R','S','T','V','W','Y'};
		ProteinSequence s= new ProteinSequence(charA);
		for (int i=0; i<charA.length; i=i+1)
		{
			if (!s.isValidLetter(charA[i]))
			{
				flag=true;
			}
		}
		assertEquals(message, false, flag);
	 }
	
	public void ProteinSequenceIsValidCharacter3()
	 {
		boolean flag=false;
		ProteinSequence s=null;
		String message="Numbers dont work";
		char[] charA={'1','C','D','E',};
		try 
		{
			s= new ProteinSequence(charA);
		}
		catch (IllegalArgumentException exception)
		{
			flag=true;
		}
		if (s==null);
		assertEquals(message, true, flag);
	 }
	
	public void ProteinSequenceIsValidCharacter4()
	 {
		boolean flag=false;
		ProteinSequence s=null;
		String message="Symbols dont work";
		char[] charA={':','C','D','E',};
		try 
		{
			s= new ProteinSequence(charA);
		}
		catch (IllegalArgumentException exception)
		{
			flag=true;
		}
		if (s==null);
		assertEquals(message, true, flag);
	 }
	
	public void ProteinSequenceIsValidCharacter5()
	 {
		boolean flag=false;
		ProteinSequence s=null;
		String message="BJOUXZ dont work";
		char[] charA={'A','B','C','D','E',};
		try 
		{
			s= new ProteinSequence(charA);
		}
		catch (IllegalArgumentException exception)
		{
			flag=true;
		}
		if (s==null);
		assertEquals(message, true, flag);
	 }
	
	public void ProteinSequenceSeqLength1()
	 {
		String message=" will be 8";
		char[] charA={'a','c','d','e','f','g', 'h','i'};
		ProteinSequence s= new ProteinSequence(charA);
		int total=s.seqLength();
		assertEquals(message, 8, total);
	 }
	
	public void ProteinSequenceSeqLength2()
	 {
		String message="nothing should be 0";
		char[] charA={};
		ProteinSequence s= new ProteinSequence(charA);
		int total=s.seqLength();
		assertEquals(message, 0, total);
	 }
	
	public void ProteinSequenceSeqChar1()
	 {
		String message="nothing should return nothing";
		char[] charA={};
		ProteinSequence s= new ProteinSequence(charA);
		char[] total=s.getSeq();
		assertEquals(message, charA, total);
	 }
	
	public void ProteinSequenceSeqChar2()
	 {
		String message="'a','c','d','e','f','g', 'h','i' should return 'a','c','d','e','f','g', 'h','i'";
		char[] charA={'a','c','d','e','f','g', 'h','i'};
		ProteinSequence s= new ProteinSequence(charA);
		char[] total=s.getSeq();
		assertEquals(message, charA, total);
	 }
	
	public void ProteinSequenceToString()
	{
		char[] charA={'a','c','d','e','f','g', 'h','i'};
		ProteinSequence s= new ProteinSequence(charA);
		System.out.println(	s.toString());
	}
	
	public void ProteinSequenceEquals1()
	{
		String message="two same arrays should be equal";
		char[] charA={'a','c','d'};
		char[] charb={'a','c','d'};
		ProteinSequence a=new ProteinSequence(charA);
		ProteinSequence b=new ProteinSequence(charb);
		assertEquals(message, true, a.equals(b));
	}
	
	public void ProteinSequenceEquals2()
	{
		String message="two different arrays should not be equal";
		char[] charA={'a','c','d'};
		char[] charb={'a','c'};
		ProteinSequence a=new ProteinSequence(charA);
		ProteinSequence b=new ProteinSequence(charb);
		assertEquals(message, false, a.equals(b));
	}
	
	public void ProteinSequenceEquals3()
	{
		String message="an empty array shouldnt equal a full one";
		char[] charA={'a','c','d'};
		char[] charb={};
		ProteinSequence a=new ProteinSequence(charA);
		ProteinSequence b=new ProteinSequence(charb);
		assertEquals(message, false, a.equals(b));
	}
	
	public void ProteinSequenceEquals4()
	{
		String message="Any object should be able to go through";
		char[] charA={'a','c','d'};
		ProteinSequence a=new ProteinSequence(charA);
		Object o=new Object();
		assertEquals(message, false, a.equals(o));
	}	
	
}
