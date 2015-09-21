package hw1;

/**
 * The class constructs a ticket machine that keeps track of the number 
 * of tickets sold and the amount of money collected. It also makes tickets
 *  and their prices depending on different parameters including: number of 
 *  trips, amount desired on ticked, starting zones, and ending zones.
 *  Additionally, discounts are included in these calculations, if relevant. 
 * @author Michael Lux Section 14 Professor Kautz
 *
 */
public class TicketMachine {
	
	/**
	 * The total number of tickets sold on this particular machine
	 */
	private int ticketsSold;
	
	/**
	 * the total money collected on by this particular machine
	 */
	private int moneyCollected;
	
	/**
	 * Constructs a new ticket machine that has no tickets sold
	 * and no money collected
	 */
	public TicketMachine()
	{
		ticketsSold=0;
		
		moneyCollected=0;
	}
	
	/**
	 * Allows the user to by a ticket based on a desired start
	 * zone and end zone. The price will be calculated with a
	 * discount if relevant and is in cents.
	 * @param startZone
	 * 	the zone that the user want to start the ticket in
	 * @param endZone
	 * 	the zone the user wants to end in with the ticket
	 * @param discounted
	 * 	whether or not the user has a discount. True if there is
	 *  and false is there isn't
	 * @return
	 * 	A ticket with the amount for the trip specified by
	 * 	the parameters given, using the TicketUtil.
	 */
	public Ticket purchaseTicket(int startZone, int endZone, boolean discounted)
	{
		int costOfTicket=TicketUtil.calculateRideCost(startZone, endZone, discounted);
		Ticket zoneTicket= new Ticket(costOfTicket, discounted);
		ticketsSold=ticketsSold+1;
		moneyCollected=moneyCollected+costOfTicket;
		return zoneTicket;
	}
	
	/**
	 * Allows the user to by a ticket based on a desired start
	 * zone and end zone and number of trips. The price will be 
	 * calculated with a discount if relevant and is in cents.
	 * @param numRides
	 * 	the number of rides the user wants between two
	 * 	places
	 * @param startZone
	 * 	the zone that the user want to start the ticket in
	 * @param endZone
	 * 	the zone the user wants to end in with the ticket
	 * @param discounted
	 * 	whether or not the user has a discount. True if there is
	 *  and false is there isn't
	 * @return
	 * 	A ticket with the amount for the trips specified by
	 * 	the parameters given, using the TicketUtil.
	 */
	public Ticket purchaseTicket(int numRides, int startZone, int endZone, boolean discounted)
	{
		int costOfTicket=TicketUtil.calculateRideCost(numRides, startZone, endZone, discounted);
		Ticket zoneTicket= new Ticket(costOfTicket, discounted);
		ticketsSold=ticketsSold+1;
		moneyCollected=moneyCollected+costOfTicket;
		return zoneTicket;
	}
	
	/**
	 * Allows a user to purchase a ticket with a desired amount
	 * on it. This ticket will also keep tract of a discount
	 * for fares if relevant.
	 * @param amount
	 * 	the amount (in cents) that is desired to be on the card
	 * @param discounted
	 * 	whether or not the user has a discount. True if there is
	 *  and false is there isn't
	 * @return
	 * A ticket with the amount specified.
	 */
	public Ticket purchaseTicket(int amount, boolean discounted)
	{
		Ticket amountTicket= new Ticket(amount, discounted);
		ticketsSold=ticketsSold+1;
		moneyCollected=moneyCollected+amount;
		return amountTicket;
	}
	
	/**
	 * Tells how many tickets have been sold by this machine
	 * @return
	 * total number of tickets sold by this machine
	 */
	public int totalTickets()
	{
		return ticketsSold;
	}
	
	/**
	 * Tells the total amount collected by this machine
	 * @return
	 * total amount collected by this machine
	 */
	public int totalCost()
	{
		return moneyCollected;
	}

}




