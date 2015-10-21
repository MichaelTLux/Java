package team033;

import battlecode.common.Direction;
import battlecode.common.GameConstants;
import battlecode.common.RobotController;
import battlecode.common.RobotType;
import battlecode.common.Team;

public class TheBasicBot 
{
	public static void run(RobotController rc) 
	{
		//global
		//a radio code
		while (true) {
			try {
//HQ start
				if (rc.getType() == RobotType.HQ) 
				{
					if (rc.isActive()) 
					{
						// Spawn a soldier
						Direction dir = rc.getLocation().directionTo(rc.senseEnemyHQLocation());
						if (rc.canMove(dir))
							rc.spawn(dir);
					}
				}
//HQ end
//Soldier Start
				else if (rc.getType() == RobotType.SOLDIER) 
				{
					if (rc.isActive()) 
					{
						if (Math.random()<.5) 
						{
							// Lay a mine 
							if(rc.senseMine(rc.getLocation())==null)
								rc.layMine();
						} 
						else 
						{ 
							//Defusing
							if(rc.senseMine(rc.getLocation())!=null)
							{
								rc.defuseMine(rc.getLocation());
							}
							// Choose to attack base, and move that way if possible
							Direction dir = rc.getLocation().directionTo(rc.senseEnemyHQLocation());
							if(rc.canMove(dir)) //&& !(rc.senseMineLocations(rc.getLocation(), 1, Team.NEUTRAL).equals(rc.getLocation()))) 
							{
								rc.move(dir);
								rc.setIndicatorString(0, "Last direction moved: "+dir.toString());
							}
						}
					}
					
					if (Math.random()<0.01 && rc.getTeamPower()>5)
					{
						// Write the number 5 to a position on the message board corresponding to the robot's ID
						rc.broadcast(rc.getRobot().getID()%GameConstants.BROADCAST_MAX_CHANNELS, 5);
					}
				}
//End of Soldier
// End turn
				rc.yield();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
