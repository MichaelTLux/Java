package hw1;

public class Turnstile {
	
	private int zoneOfTurnstile;
	
	private int numberEntered;
	
	private int numberExited;
	
	public Turnstile(int zone)
	{
		zoneOfTurnstile=zone;
	}
	
	public boolean swipeIn(Ticket ticket)
	{
		//to do
		zoneOfTurnstile=zoneOfTurnstile+0;
		
		return false;
	}
	
	public boolean swipeOut(Ticket ticket)
	{
		//to do
		return false;
	}
	
	public int getEntranceCount()
	{
		return numberEntered;
	}
	
	public int getExitCount()
	{
		return numberExited;
	}

}







