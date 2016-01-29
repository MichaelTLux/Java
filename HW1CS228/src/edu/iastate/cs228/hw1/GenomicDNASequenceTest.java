package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenomicDNASequenceTest
{
	@Test
	public void GDNAContructorWorks()
	 {
		String message="Does it construct?";
		char[] charA={'a','c','g','t'};
		GenomicDNASequence s= new GenomicDNASequence(charA);
		assertEquals(message, s, s);
	 }
	@Test
	public void GenomicDNASequenceIsValidCharacter1()
	 {
		boolean flag=false;
		String message="All lowercase agct are good in this instance";
		char[] charA={'a','c','g','t'};
		GenomicDNASequence s= new GenomicDNASequence(charA);
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
	public void GenomicDNASequenceIsValidCharacter2()
	 {
		boolean flag=false;
		String message="All Uppercase AGCT are good";
		char[] charA={'A','G','C','T'};
		GenomicDNASequence s= new GenomicDNASequence(charA);
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
	public void GenomicDNASequenceIsValidCharacter3()
	 {
		boolean flag=false;
		GenomicDNASequence s=null;
		String message="Numbers dont work";
		char[] charA={'1','A','G','C','T'};
		try 
		{
			s= new GenomicDNASequence(charA);
		}
		catch (IllegalArgumentException exception)
		{
			flag=true;
		}
		if (s==null);
		assertEquals(message, true, flag);
	 }
	@Test
	public void GenomicDNASequenceIsValidCharacter4()
	 {
		boolean flag=false;
		GenomicDNASequence s=null;
		String message="Symbols dont work";
		char[] charA={':','A','G','C','T'};
		try 
		{
			s= new GenomicDNASequence(charA);
		}
		catch (IllegalArgumentException exception)
		{
			flag=true;
		}
		if (s==null);
		assertEquals(message, true, flag);
	 }
	@Test
	public void GenomicDNASequenceIsValidCharacter5()
	 {
		boolean flag=false;
		GenomicDNASequence s=null;
		String message="None AGCT dont work dont work";
		char[] charA={'B','A','G','C','T'};
		try 
		{
			s= new GenomicDNASequence(charA);
		}
		catch (IllegalArgumentException exception)
		{
			flag=true;
		}
		if (s==null);
		assertEquals(message, true, flag);
	 }
	@Test
	public void GenomicDNASequenceSeqLength1()
	 {
		String message="This should be 8";
		char[] charA={'A','G','C','T','A','G','C','T'};
		GenomicDNASequence s= new GenomicDNASequence(charA);
		int total=s.seqLength();
		assertEquals(message, 8, total);
	 }
	@Test
	public void GenomicDNASequenceSeqLength2()
	 {
		String message="nothing should be 0";
		char[] charA={};
		GenomicDNASequence s= new GenomicDNASequence(charA);
		int total=s.seqLength();
		assertEquals(message, 0, total);
	 }
	@Test
	public void GenomicDNASequenceSeqChar1()
	 {
		
		String message="nothing should return nothing";
		char[] charA={};
		GenomicDNASequence s= new GenomicDNASequence(charA);
		char[] total=s.getSeq();
		boolean flag=true;
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
	public void GenomicDNASequenceSeqChar2()
	 {
		String message="'A','G','C','T' should return 'A','G','C','T'";
		char[] charA={'A','G','C','T'};
		GenomicDNASequence s= new GenomicDNASequence(charA);
		char[] total=s.getSeq();
		boolean flag=true;
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
	public void GenomicDNASequenceToString()
	{
		char[] charA={'A','G','C','T'};
		GenomicDNASequence s= new GenomicDNASequence(charA);
		System.out.println(	s.toString());
	}
	@Test
	public void GenomicDNASequenceEquals1()
	{
		String message="two same arrays should be equal";
		char[] charA={'a','c','a','t'};
		char[] charb={'a','c','a','t'};
		GenomicDNASequence a=new GenomicDNASequence(charA);
		GenomicDNASequence b=new GenomicDNASequence(charb);
		assertEquals(message, true, a.equals(b));
	}
	@Test
	public void GenomicDNASequenceEquals2()
	{
		String message="two different arrays should not be equal";
		char[] charA={'a','c','a','t'};
		char[] charb={'a','t','c'};
		GenomicDNASequence a=new GenomicDNASequence(charA);
		GenomicDNASequence b=new GenomicDNASequence(charb);
		assertEquals(message, false, a.equals(b));
	}

	@Test
	public void GenomicDNASequenceEquals3()
	{
		String message="an empty array shouldnt equal a full one";
		char[] charA={'a','c',};
		char[] charb={};
		GenomicDNASequence a=new GenomicDNASequence(charA);
		GenomicDNASequence b=new GenomicDNASequence(charb);
		assertEquals(message, false, a.equals(b));
	}
	@Test
	public void GenomicDNASequenceEquals4()
	{
		String message="Any object should be able to go through";
		char[] charA={'a','g','c','c'};
		GenomicDNASequence a=new GenomicDNASequence(charA);
		Object o=new Object();
		assertEquals(message, false, a.equals(o));
	}
	
	@Test
	public void GenomicDNASequenceEquals5()
	{
		String message="two different arrays should not be equal";
		char[] charA={'a','c','a','t'};
		char[] charb={'a','t','c','t'};
		GenomicDNASequence a=new GenomicDNASequence(charA);
		GenomicDNASequence b=new GenomicDNASequence(charb);
		assertEquals(message, false, a.equals(b));
	}
	@Test
	public void GenomicDNASequenceExtractExons1()
	{
		boolean flag=false;
		String message="Empty array of ints should throw an exeption";
		char[] charA={'a','c','a','t'};
		GenomicDNASequence s=new GenomicDNASequence(charA);
		int[] exonpos={};
		try 
		{
			s.extractExons(exonpos);
		} 
		catch (IllegalArgumentException e) 
		{
			flag=true;
		}
		assertEquals(message, true, flag);
	}
	@Test
	public void GenomicDNASequenceExtractExons2()
	{
		boolean flag=false;
		String message="Odd number of elements of ints should throw an exeption";
		char[] charA={'a','c','a','t'};
		GenomicDNASequence s=new GenomicDNASequence(charA);
		int[] exonpos={1,3,5};
		try 
		{
			s.extractExons(exonpos);
		} 
		catch (IllegalArgumentException e) 
		{
			flag=true;
		}
		assertEquals(message, true, flag);
	}
	@Test
	public void GenomicDNASequenceExtractExons3()
	{
		boolean flag=false;
		String message="out of bounds (-1) should throw an exeption";
		char[] charA={'a','c','a','t'};
		GenomicDNASequence s=new GenomicDNASequence(charA);
		int[] exonpos={-1};
		try 
		{
			s.extractExons(exonpos);
		} 
		catch (IllegalArgumentException e) 
		{
			flag=true;
		}
		assertEquals(message, true, flag);
	}
	@Test
	public void GenomicDNASequenceExtractExons4()
	{
		boolean flag=false;
		String message="out of bounds (5) should throw an exeption";
		char[] charA={'a','c','a','t'};
		GenomicDNASequence s=new GenomicDNASequence(charA);
		int[] exonpos={1,5};
		try 
		{
			s.extractExons(exonpos);
		} 
		catch (IllegalArgumentException e) 
		{
			flag=true;
		}
		assertEquals(message, true, flag);
	}
	@Test
	public void GenomicDNASequenceExtractExons5()
	{
		boolean flag=false;
		String message="2 is greater then 1 should throw an exeption";
		char[] charA={'a','c','a','t'};
		GenomicDNASequence s=new GenomicDNASequence(charA);
		int[] exonpos={2,1,3};
		try 
		{
			s.extractExons(exonpos);
		} 
		catch (IllegalArgumentException e) 
		{
			flag=true;
		}
		assertEquals(message, true, flag);
	}
	@Test
	public void GenomicDNASequenceExtractExons6()
	{
		boolean flag=false;
		String message="2 is greater then 1 should throw an exeption";
		char[] charA={'a','c','a','t'};
		GenomicDNASequence s=new GenomicDNASequence(charA);
		int[] exonpos={2,1,3,4};
		try 
		{
			s.extractExons(exonpos);
		} 
		catch (IllegalArgumentException e) 
		{
			flag=true;
		}
		assertEquals(message, true, flag);
	}
	@Test
	public void GenomicDNASequenceExtractExons7()
	{
		String message="AATGCCAGTCAGCATAGCG should return ATGCCTCAATAG";
		char[] charA={'a','a','t','g', 'c','c','a','g','t','c','a','g','c','a','t','a','g','c','g'};
		GenomicDNASequence s=new GenomicDNASequence(charA);
		int[] exonpos={1,5,8,10,13,16};
		char[] result=s.extractExons(exonpos);
		char[] answer={'a','t','g','c','c','t','c','a','a','t','a','g'};
		boolean flag=true;
		for (int i=0; i<answer.length; i++)
		{
			if (!(result[i]==answer[i]))
			{
				flag=false;
			}
		}
		
		assertEquals(message, true, flag);
	 }

	
}
