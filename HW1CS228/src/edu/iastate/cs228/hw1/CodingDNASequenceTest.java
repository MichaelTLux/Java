package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodingDNASequenceTest 
{
	@Test
	public void CodingDNAContructorWorks()
	 {
		String message="Does it construct?";
		char[] charA={'a','c','g','t'};
		CodingDNASequence s= new CodingDNASequence(charA);
		assertEquals(message, s, s);
	 }
	@Test
	public void CodingDNASequenceIsValidCharacter1()
	 {
		boolean flag=false;
		String message="All lowercase agct are good in this instance";
		char[] charA={'a','c','g','t'};
		CodingDNASequence s= new CodingDNASequence(charA);
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
	public void CodingDNASequenceIsValidCharacter2()
	 {
		boolean flag=false;
		String message="All Uppercase AGCT are good";
		char[] charA={'A','G','C','T'};
		CodingDNASequence s= new CodingDNASequence(charA);
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
	public void CodingDNASequenceIsValidCharacter3()
	 {
		boolean flag=false;
		CodingDNASequence s=null;
		String message="Numbers dont work";
		char[] charA={'1','A','G','C','T'};
		try 
		{
			s= new CodingDNASequence(charA);
		}
		catch (IllegalArgumentException exception)
		{
			flag=true;
		}
		if (s==null);
		assertEquals(message, true, flag);
	 }
	@Test
	public void CodingDNASequenceIsValidCharacter4()
	 {
		boolean flag=false;
		CodingDNASequence s=null;
		String message="Symbols dont work";
		char[] charA={':','A','G','C','T'};
		try 
		{
			s= new CodingDNASequence(charA);
		}
		catch (IllegalArgumentException exception)
		{
			flag=true;
		}
		if (s==null);
		assertEquals(message, true, flag);
	 }
	@Test
	public void CodingDNASequenceIsValidCharacter5()
	 {
		boolean flag=false;
		CodingDNASequence s=null;
		String message="None AGCT dont work dont work";
		char[] charA={'B','A','G','C','T'};
		try 
		{
			s= new CodingDNASequence(charA);
		}
		catch (IllegalArgumentException exception)
		{
			flag=true;
		}
		if (s==null);
		assertEquals(message, true, flag);
	 }
	@Test
	public void CodingDNASequenceSeqLength1()
	 {
		String message="This should be 8";
		char[] charA={'A','G','C','T','A','G','C','T'};
		CodingDNASequence s= new CodingDNASequence(charA);
		int total=s.seqLength();
		assertEquals(message, 8, total);
	 }
	@Test
	public void CodingDNASequenceSeqLength2()
	 {
		String message="nothing should be 0";
		char[] charA={};
		CodingDNASequence s= new CodingDNASequence(charA);
		int total=s.seqLength();
		assertEquals(message, 0, total);
	 }
	@Test
	public void CodingDNASequenceSeqChar1()
	 {
		String message="nothing should return nothing";
		char[] charA={};
		CodingDNASequence s= new CodingDNASequence(charA);
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
	public void CodingDNASequenceSeqChar2()
	 {
		String message="'A','G','C','T' should return 'A','G','C','T'";
		char[] charA={'A','G','C','T'};
		CodingDNASequence s= new CodingDNASequence(charA);
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
	public void CodingDNASequenceToString()
	{
		char[] charA={'A','G','C','T'};
		CodingDNASequence s= new CodingDNASequence(charA);
		System.out.println(	s.toString());
	}
	@Test
	public void CodingDNASequenceEquals1()
	{
		String message="two same arrays should be equal";
		char[] charA={'a','c','a','t'};
		char[] charb={'a','c','a','t'};
		CodingDNASequence a=new CodingDNASequence(charA);
		CodingDNASequence b=new CodingDNASequence(charb);
		assertEquals(message, true, a.equals(b));
	}
	@Test
	public void CodingDNASequenceEquals2()
	{
		String message="two different arrays should not be equal";
		char[] charA={'a','c','a','t'};
		char[] charb={'a','t','c'};
		CodingDNASequence a=new CodingDNASequence(charA);
		CodingDNASequence b=new CodingDNASequence(charb);
		assertEquals(message, false, a.equals(b));
	}

	@Test
	public void CodingDNASequenceEquals3()
	{
		String message="an empty array shouldnt equal a full one";
		char[] charA={'a','c',};
		char[] charb={};
		CodingDNASequence a=new CodingDNASequence(charA);
		CodingDNASequence b=new CodingDNASequence(charb);
		assertEquals(message, false, a.equals(b));
	}
	@Test
	public void CodingDNASequenceEquals4()
	{
		String message="Any object should be able to go through";
		char[] charA={'a','g','c','c'};
		CodingDNASequence a=new CodingDNASequence(charA);
		Object o=new Object();
		assertEquals(message, false, a.equals(o));
	}
	
	@Test
	public void CodingDNASequenceEquals5()
	{
		String message="two different arrays should not be equal";
		char[] charA={'a','c','a','t'};
		char[] charb={'a','t','c','t'};
		CodingDNASequence a=new CodingDNASequence(charA);
		CodingDNASequence b=new CodingDNASequence(charb);
		assertEquals(message, false, a.equals(b));
	}
	@Test
	public void CodingDNASequenceCheckStartCodon1()
	{
		String message="two letters should be false";
		String charA="AT";
		CodingDNASequence a=new CodingDNASequence(charA.toCharArray());
		assertEquals(message, false, a.checkStartCodon());
	}
	@Test
	public void CodingDNASequenceCheckStartCodon2()
	{
		String message="3 wrong letters should be false";
		String charA="ATT";
		CodingDNASequence a=new CodingDNASequence(charA.toCharArray());
		assertEquals(message, false, a.checkStartCodon());
	}
	@Test
	public void CodingDNASequenceCheckStartCodon3()
	{
		String message="3 letters ATG should be True";
		String charA="ATG";
		CodingDNASequence a=new CodingDNASequence(charA.toCharArray());
		assertEquals(message, true, a.checkStartCodon());
	}
	@Test
	public void CodingDNASequenceCheckStartCodon4()
	{
		String message="should be false because not ATG";
		String charA="ACATGGTTCA";
		CodingDNASequence a=new CodingDNASequence(charA.toCharArray());
		assertEquals(message, false, a.checkStartCodon());
	}
	@Test
	public void CodingDNASequenceTranslate1()
	{
		boolean flag=false;
		String message="Throws a runtime when start codon doesnt exist";
		String charA="ATCGCTAAGTAACGC";
		CodingDNASequence a= new CodingDNASequence(charA.toCharArray());
		try
		{
			a.translate();
		}
		catch (RuntimeException e)
		{
			flag=true;
		}
		assertEquals(message, true, flag);
	}
	@Test
	public void CodingDNASequenceTranslate2()
	{
		String message="Returns a protien sequence ";
		String charA="ATGAGACCA";
		CodingDNASequence a= new CodingDNASequence(charA.toCharArray());
		char[] result=a.translate();
		String answer="MRP";
		char[] check=answer.toCharArray();
		boolean flag=true;
		for (int i=0; i<check.length; i=i+1)
		{
			if (!(check[i]==result[i]))
			{
				flag=false;
			}
		}
		assertEquals(message, true, flag);
	}
	@Test
	public void CodingDNASequenceTranslate3()
	{
		String message="Returns a protien sequence ";
		String charA="ATGAGACC";
		CodingDNASequence a= new CodingDNASequence(charA.toCharArray());
		char[] result=a.translate();
		String answer="MR";
		char[] check=answer.toCharArray();
		boolean flag=true;
		for (int i=0; i<check.length; i=i+1)
		{
			if (!(check[i]==result[i]))
			{
				flag=false;
			}
		}
		assertEquals(message, true, flag);
	}
	@Test
	public void CodingDNASequenceTranslate4()
	{
		String message="Returns a protien sequence ";
		String charA="ATGAGAC";
		CodingDNASequence a= new CodingDNASequence(charA.toCharArray());
		char[] result=a.translate();
		String answer="MR";
		char[] check=answer.toCharArray();
		boolean flag=true;
		for (int i=0; i<check.length; i=i+1)
		{
			if (!(check[i]==result[i]))
			{
				flag=false;
			}
		}
		assertEquals(message, true, flag);
	}


	
}
