package edu.iastate.cs228.hw1;

/**
 * This class allows codons to be pulled out of DNA sequences
 * and translated into protein sequences. This class will store 
 * a DNA sequence and check if it is valid
 * @author Michael Lux
 */

public class CodingDNASequence extends DNASequence
{
  /**
   * Creates a new DNA sequence if all the characters in an array are 
   * 'a', -'c', 'g', or 't' and allows it to be translated to a protein sequence
   * @param cdnaarr
   * 	the array that will be stored in the class
   * @throws IllegalArgumentException
   * 	thrown if the given array does not consist of only 'a', -'c', 'g', or 't'
   */
  public CodingDNASequence(char[] cdnaarr)
  {
	  super(cdnaarr);
	  for (int i=0; i<cdnaarr.length; i=i+1)
	    {
	    	if (!(isValidLetter(cdnaarr[i])|| super.isValidLetter(cdnaarr[i])))
	    	{
	    		throw new IllegalArgumentException("Invalid sequence letter for class edu.iastate.cs228.hw1.DNASequence");
	    	}
	    }
	    String copy="";
	    for (int i=0; i<cdnaarr.length; i=i+1)
	    {
	    	copy=copy+cdnaarr[i];
	    }
	    seqarr=copy.toCharArray();
  }

  /**
   * this method checks if there is a starting codon
   * at the beginning of the sequence which is "ATG"
   * @return
   * 	true if the sequence started with ATG false otherwise
   */
  public boolean checkStartCodon()
  {
    if (seqarr.length<3)
    {
    	return false;
    }
    return (seqarr[0]=='a' ||seqarr[0]=='A') && (seqarr[1]=='t' ||seqarr[1]=='T') && (seqarr[2]=='g' ||seqarr[2]=='G');
  }

  /**
   * First this checks if there is a start codon and if there is not it 
   * throws an exception. If there is a start codon, it will be translated
   * to a protein sequence until an end sequence is found or there is 2 or one 
   * amino acids left
   * @return
   * 	the translated protein sequence
   * @throws RuntimeException
   * 	thrown if there is not a starting codon in the sequence
   */
  public char[] translate() throws RuntimeException
  {
    if (!checkStartCodon())
    {
    	throw new RuntimeException("No start codon");
    }
    String returning="";
    for (int i=0; (i+2)<seqarr.length; i=i+3)
    {
    	String codon="";
    	codon=codon+seqarr[i]+seqarr[i+1]+seqarr[i+2];
    	if (getAminoAcid(codon)=='$')
    	{
    		break;
    	}
    	returning=returning+getAminoAcid(codon);
    }
    return returning.toCharArray();
  }

  private char getAminoAcid(String codon)
  {
    if ( codon == null ) return '$';
    char aa = '$';
    switch ( codon.toUpperCase() )
    {
      case "AAA": aa = 'K'; break;
      case "AAC": aa = 'N'; break;
      case "AAG": aa = 'K'; break;
      case "AAT": aa = 'N'; break;

      case "ACA": aa = 'T'; break;
      case "ACC": aa = 'T'; break;
      case "ACG": aa = 'T'; break;
      case "ACT": aa = 'T'; break;

      case "AGA": aa = 'R'; break;
      case "AGC": aa = 'S'; break;
      case "AGG": aa = 'R'; break;
      case "AGT": aa = 'S'; break;

      case "ATA": aa = 'I'; break;
      case "ATC": aa = 'I'; break;
      case "ATG": aa = 'M'; break;
      case "ATT": aa = 'I'; break;

      case "CAA": aa = 'Q'; break;
      case "CAC": aa = 'H'; break;
      case "CAG": aa = 'Q'; break;
      case "CAT": aa = 'H'; break;

      case "CCA": aa = 'P'; break;
      case "CCC": aa = 'P'; break;
      case "CCG": aa = 'P'; break;
      case "CCT": aa = 'P'; break;

      case "CGA": aa = 'R'; break;
      case "CGC": aa = 'R'; break;
      case "CGG": aa = 'R'; break;
      case "CGT": aa = 'R'; break;

      case "CTA": aa = 'L'; break;
      case "CTC": aa = 'L'; break;
      case "CTG": aa = 'L'; break;
      case "CTT": aa = 'L'; break;

      case "GAA": aa = 'E'; break;
      case "GAC": aa = 'D'; break;
      case "GAG": aa = 'E'; break;
      case "GAT": aa = 'D'; break;

      case "GCA": aa = 'A'; break;
      case "GCC": aa = 'A'; break;
      case "GCG": aa = 'A'; break;
      case "GCT": aa = 'A'; break;

      case "GGA": aa = 'G'; break;
      case "GGC": aa = 'G'; break;
      case "GGG": aa = 'G'; break;
      case "GGT": aa = 'G'; break;

      case "GTA": aa = 'V'; break;
      case "GTC": aa = 'V'; break;
      case "GTG": aa = 'V'; break;
      case "GTT": aa = 'V'; break;

      case "TAA": aa = '$'; break;
      case "TAC": aa = 'Y'; break;
      case "TAG": aa = '$'; break;
      case "TAT": aa = 'Y'; break;

      case "TCA": aa = 'S'; break;
      case "TCC": aa = 'S'; break;
      case "TCG": aa = 'S'; break;
      case "TCT": aa = 'S'; break;

      case "TGA": aa = '$'; break;
      case "TGC": aa = 'C'; break;
      case "TGG": aa = 'W'; break;
      case "TGT": aa = 'C'; break;

      case "TTA": aa = 'L'; break;
      case "TTC": aa = 'F'; break;
      case "TTG": aa = 'L'; break;
      case "TTT": aa = 'F'; break;
      default:    aa = '$'; break;
    }
    return aa;
  }
}
