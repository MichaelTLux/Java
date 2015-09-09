package lab2;

public class AtomTest 
{
	public static void main(String args[])
	{
		//constructing an atom
		Atom atom1;
		atom1= new Atom(92, 146, 92);
		
		//printing initials
		System.out.println("The atomic mass at the start is " + atom1.getAtomicMass() + ".");
		System.out.println("The atomic charge at the start is " +atom1.getAtomicCharge() + ".");
		
		//decay to change values
		atom1.decay();
		System.out.println();
		System.out.println("The atom has decayed.");
		System.out.println();
		
		//print new results
		System.out.println("The new atom mass is " + atom1.getAtomicMass()+ ".");
		System.out.println("The new atomic charge is " +atom1.getAtomicCharge()+ ".");
		
		
	}
}
