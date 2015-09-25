package hw1;
/**
 * This class encapsulates information in a ticket which includes 
 * the balance of the ticket, the presence of a discount, whether 
 * or not a trip is in progress, and where the ticket was last rung 
 * up. It allows access to the location, balance, presence of a discount,
 *  and presence of a trip. With this ticket you can also charge money
 *  against the balance and start a trip.
 * @author Michael Lux Section 14 Professor Kautz 
 *
 */
public class Ticket 
{
	/**
	 * The total amount of money (in cents) on the ticket
	 */
	private int balanceOfTicket;
	
	/**
	 * Tells whether or not a ticket get access to discounts
	 * True if there is a discount and false if there isn't.
	 */
	private boolean isDiscountedTicket;
	
	/**
	 * Tells whether or not a ticket has a trip in progress.
	 * True if there is and false if there isn't.
	 */
	private boolean tripInProgress;
	
	/**
	 *Holds the value of the Smart Zone the ticket was last used in 
	 */
	private int currentSmartZone;
	
	/**
	 * Constructs a new ticket using the value given as a balance and 
	 * stores the presence of a discount. The ticket starts out without
	 * a trip in progress and with an invalid smart zone.
	 * @param givenBalance
	 * 	the total amount (in cents) that is to be present on the ticket
	 * @param discounted
	 * 	whether or not there is a discount on the ticket. True if there is and false if there isn't.
	 */
	public Ticket(int givenBalance, boolean discounted)
	{
		
		balanceOfTicket=givenBalance;
		
		isDiscountedTicket=discounted;
		
		tripInProgress=false;
		
		currentSmartZone= TicketUtil.INVALID_ZONE;
	}
	
	/**
	 * Starts the trip for the ticket and stores the given Smart Zone.
	 * Subsequent calls of the ticket will say it is in a trip.
	 * @param zone
	 * 	the smart zone the ticket was used at to begin trip
	 */
	public void beginTrip(int zone)
	{
		tripInProgress=true;
		currentSmartZone=zone;
	}
	
	/**
	 * Returns the smart zone from which the ticket was originally used at for that ticket
	 * @return
	 * 	the smart zone the ticket was originally used at to start the trip
	 */
	public int getStartZone()
	{
		return currentSmartZone;
	}
	
	/**
	 * Tells if the current ticket is discounted or not. True if it is and false if it isn't.
	 * @return
	 * 	the presence of a discount, true if there is and false if there isn't.
	 */
	public boolean isDiscounted()
	{
		return isDiscountedTicket;
	}
	
	/**
	 * Returns how much money is left on a ticket (in cents)
	 * @return
	 * 	the amount left on the ticket in cents
	 */
	public int getBalance()
	{
		return balanceOfTicket;
	}
	
	/**
	 * Reduces the balance on this ticket by the given amount, if possible. If the balance is less
	 * than the ride cost, this method returns false without modifying the ticket balance; otherwise 
	 * reduces the balance by the given amount and returns true.
	 * @param rideCost
	 * 	the total cost of the ride
	 * @return
	 * 	True is returned if the transaction was successful, false if it wasn't.
	 */
	public boolean charge(int rideCost)
	{
		if (balanceOfTicket>rideCost)
		{
			currentSmartZone=TicketUtil.INVALID_ZONE;
			tripInProgress=false;
			balanceOfTicket=balanceOfTicket-rideCost;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Tells whether or not the ticket has been swiped in successfully (true), or if it has been successfully
	 *  swiped out (false). If the ticket has not been used it will return false.
	 * @return
	 * 	the swiped in or out status. True if swiped in successfully or false if swiped out successfully.
	 * 	Will return false if ticket has not been used
	 */
	public boolean isInTransit() 
	{
		return tripInProgress;
	}
}









