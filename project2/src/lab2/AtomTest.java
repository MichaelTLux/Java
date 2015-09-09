package lab2;

public class AtomTest 
{
	public static void main(String args[])
	{
		//constructing an atom
		Atom atom1;
		atom1= new Atom(92, 146, 92);
		
		//printing initials
		System.out.println(atom1.getAtomicMass());
		System.out.println(atom1.getAtomicCharge());
		
		//decay to change values
		atom1.decay();
		
		//print new results
		System.out.println(atom1.getAtomicMass());
		System.out.println(atom1.getAtomicCharge());
		
	}
}
