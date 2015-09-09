package lab2;

/**
 * This is a model of an atom for use in atomic calculations.
 */
public class Atom {
	
	/**
	 * How many protons are in the Atom
	 */
	private int numberOfProtons;
	
	/**
	 * How many Neutrons are in the Atom
	 */
	private int numberOfNeutrons;
	
	/**
	 * How many Electrons are in the Atom
	 */
	private int numberOfElectrons;
	
	
	/**
	 * Constructs an atom with the specified number of protons neutrons and electrons
	 * @param givenProtons
	 * 	the number of protons for this atom
	 * @param givenNeutrons
	 * 	the number of neutrons for this atom
	 * @param givenElectrons
	 * 	the number of electrons for this atom
	 */
	public Atom(int givenProtons, int givenNeutrons, int givenElectrons)
	{
		numberOfProtons=givenProtons;
		numberOfNeutrons=givenNeutrons;
		numberOfElectrons=givenElectrons;
	}
	
	/**
	 * returns the Atomic Mass of the Atom which is the protons plus the neutrons
	 * @return 
	 * 	protons plus neutrons for this Atom
	 */
	 public int getAtomicMass()
	  {
	    return numberOfProtons+numberOfNeutrons;
	  }
	 
	 /**
	  * Returns the Atomic Charge of the Atom which is protons minus electrons
	  * @return
	  * 	Atomic charge of this Atom
	  */
	 public int getAtomicCharge()
	 {
		 return numberOfProtons-numberOfElectrons;
	 }
	 
	 /**
	  * Causes the Atom to decay which makes it lose 2 protons and 2 electrons
	  */
	 public void decay()
	 {
		 numberOfProtons=numberOfProtons-2;
		 numberOfNeutrons=numberOfNeutrons-2;
	 }
}
