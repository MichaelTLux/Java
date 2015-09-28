package hw1;

/**
 * This class encapsulates the information for a turnstile 
 * in the transportation network. It includes the zone the turnstile
 * exists at. It allows tickets to be swiped in and out so that
 * cost of rides can be calculated.
 * @author Michael Lux
 *
 */
public class Turnstile {
	
	/**
	 * The smart zone the turnstile is located in
	 */
	private int zoneOfTurnstile;
	
	/**
	 * The total number of people that have entered successfully at this
	 * turnstile
	 */
	private int numberEntered;
	
	/**
	 * The total number of people that have exited successfully at this
	 * turnstile
	 */
	private int numberExited;
	
	/**
	 * Constructs a new turnstile in the given location with no users successfully
	 * entering or exiting
	 * @param zone
	 * 	the smart zone the turnstile exists in
	 */
	public Turnstile(int zone)
	{
		zoneOfTurnstile=zone;
		numberEntered=0;
		numberExited=0;
	}
	
	/**
	 * Attempts to put the ticket into transit, however, first it runs a few tests.
	 * If the ticket is already in transit, it attempts to charge the person based
	 * on their smart zone and the smart zone on the ticket. If there isn't enough money on 
	 * the ticket for that fare, false is returned. If there is enough money, that amount is 
	 * charged to the ticket. Following this check, the minimum fare is assessed against the 
	 * balance and if there isn't enough on the ticket, false is returned. If there is enough
	 * on the ticket for the minimum fare, the ticket is put into transit and the zone of the
	 * turnstile is recorded.
	 * @param ticket
	 * 	the ticket that is being used for the transaction
	 * @return
	 * 	whether or not the ticket swipe was successful
	 */
	public boolean swipeIn(Ticket ticket)
	{
		if (ticket.isInTransit())
		{
			if (ticket.getBalance()>=TicketUtil.calculateRideCost(ticket.getStartZone(), zoneOfTurnstile, ticket.isDiscounted()))
			{
				ticket.charge(TicketUtil.calculateRideCost(ticket.getStartZone(), zoneOfTurnstile, ticket.isDiscounted()));
				numberExited=numberExited+1;
			}
			else
			{
				return false;
			}
		}
		if (ticket.getBalance()>=TicketUtil.getMinimumFare(ticket.isDiscounted()))
		{
			ticket.beginTrip(zoneOfTurnstile);
			numberEntered=numberEntered+1;
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	/**
	 * Attempts to charge the ticket for the fare based on start and end zone. 
	 * If this transaction is successful (the balance is large enough for the fare)
	 * then the fare is subtracted from the account balance and true is returned.
	 * Also the ticket is taken out of transit. However, if there isn't enough balance on
	 * the ticket, nothing is edited and false is returned.
	 * @param ticket
	 * 	the ticket that is being used for the transaction
	 * @return
	 * 	whether or not the transaction was successful
	 */
	public boolean swipeOut(Ticket ticket)
	{
			if (ticket.getBalance()>=TicketUtil.calculateRideCost(ticket.getStartZone(), zoneOfTurnstile, ticket.isDiscounted()))
			{
				ticket.charge(TicketUtil.calculateRideCost(ticket.getStartZone(), zoneOfTurnstile, ticket.isDiscounted()));
				numberExited=numberExited+1;
				return true;
			}
			else
			{
				return false;
			}
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







