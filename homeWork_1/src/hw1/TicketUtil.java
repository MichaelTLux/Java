package hw1;

/**
 * This is the utility class for the Ticket System. It run calculations for ticket fairs and
 * holds the values of all the FINAL values of the system.
 * @author Michael Lux
 *
 */
public class TicketUtil {
	
		/**
		 *	Fare	(in	cents)	for	a	trip	within	a	zone.
		 */
		public static final int RIDE_COST =	200;

		/**
		 *	Discounted	fare	(in	cents)	for	a	trip	within	a	zone.
		 */
		public static final int RIDE_COST_DISCOUNTED =	150;

		/**
		 *	Additional	fare	(in	cents)	for	travel	between	zones.
		 */
		public static final int ZONE_COST =	175;

		/**
		 *	Additional	discounted	fare	(in	cents)	for	travel	between	zones.
		 */
		public static final int ZONE_COST_DISCOUNTED =	120;
		/**
		 *	Constant	representing	a	nonexistent	start	zone.
		 */
		public static final int INVALID_ZONE =	-1;
		
		
		/**
		 * Private constructor of the class so that an object cannot be created as this is a "pure"
		 * class that does not need objects, it simply runs calculations.
		 */
		private TicketUtil()
		{
		//empty	
		}
		
		/**
		 * Calculates the cost of a ride (in cents) from a start zone to an end zone, taking into account
		 * if the ticket has a discount or not.
		 * @param startZone
		 * 	this is where the ticket is swiped in on a turnstile
		 * @param endZone
		 * 	this is where the ticket is swiped out on a turnstile
		 * @param discounted
		 * 	this is whether or not the ticket is a discount ticket
		 * @return
		 * 	this will return the total cost (in cents) of the ride
		 */
		public static int calculateRideCost(int startZone, int endZone,boolean discounted)
		{
			int zonesTraveledThrough=Math.abs(startZone-endZone);
			
			if (discounted)
			{
				int throughZoneTravel=(zonesTraveledThrough*ZONE_COST_DISCOUNTED);
				int totalRideCost=throughZoneTravel+RIDE_COST_DISCOUNTED;
				return totalRideCost;
			}
			else
			{
				int throughZoneTravel=(zonesTraveledThrough*ZONE_COST);
				int totalRideCost=throughZoneTravel+RIDE_COST;
				return totalRideCost;
			}
		}
		
		/**
		 * Calculates the cost of a ride (in cents) from a start zone to an end zone, taking into account
		 * if the ticket has a discount or not, and then multiplies it by the desired number of rides.
		 * @param numRides
		 * 	the number of desired rides between the desired zones
		 * @param startZone
		 * 	this is where the ticket is swiped in on a turnstile
		 * @param endZone
		 * 	this is where the ticket is swiped out on a turnstile
		 * @param discounted
		 * 	this is whether or not the ticket is a discount ticket
		 * @return
		 * 	this will return the total cost (in cents) of the ride
		 */
		public static int calculateRideCost(int numRides, int startZone, int endZone, boolean discounted)
		{
			int zonesTraveledThrough=Math.abs(startZone-endZone);
			
			if (discounted)
			{
				int throughZoneTravel=(zonesTraveledThrough*ZONE_COST_DISCOUNTED);
				int totalRideCost=(throughZoneTravel+RIDE_COST_DISCOUNTED)*numRides;
				return totalRideCost;
			}
			else
			{
				int throughZoneTravel=(zonesTraveledThrough*ZONE_COST);
				int totalRideCost=(throughZoneTravel+RIDE_COST)*numRides;
				return totalRideCost;
			}
		}
		
		/**
		 * Checks if a ticket is discounted or not, then returns the appropriate minimum fare
		 * for that particular ticket. 
		 * @param discounted
		 * 	whether or not that particular ticket gets discounts or not
		 * @return
		 * 	the value of the minimum fare for that ticket
		 */
		public static int getMinimumFare(boolean discounted)
		{
			if (discounted)
			{
				return RIDE_COST_DISCOUNTED;
			}
			else
			{
				return RIDE_COST;
			}
		}

}
