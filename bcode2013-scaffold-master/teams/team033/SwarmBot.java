package team033;

import battlecode.common.*;

public class SwarmBot {
	public static void run(RobotController rc) {
        BaseBot myself;

        if (rc.getType() == RobotType.HQ) 
        {
            myself = new HQ(rc);
        }
//        } else if (rc.getType() == RobotType.BEAVER) {
//            myself = new Beaver(rc);
//        } else if (rc.getType() == RobotType.BARRACKS) {
//            myself = new Barracks(rc);
//        } 
        else if (rc.getType() == RobotType.SOLDIER) 
        {
            myself = new Soldier(rc);
        } 
//        else if (rc.getType() == RobotType.TOWER) {
//            myself = new Tower(rc);
//        }
        else 
        {
            myself = new BaseBot(rc);
        }

        while (true) {
            try {
                myself.go();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}

    public static class BaseBot 
    {
        protected RobotController rc;
        protected MapLocation myHQ, theirHQ;
        protected Team myTeam, theirTeam;

        public BaseBot(RobotController rc) 
        {
            this.rc = rc;
            this.myHQ = rc.senseHQLocation();
            this.theirHQ = rc.senseEnemyHQLocation();
            this.myTeam = rc.getTeam();
            this.theirTeam = this.myTeam.opponent();
        }

        public Direction[] getDirectionsToward(MapLocation dest) {
            Direction toDest = rc.getLocation().directionTo(dest);
            Direction[] dirs = {toDest,
		    		toDest.rotateLeft(), toDest.rotateRight(),
				toDest.rotateLeft().rotateLeft(), toDest.rotateRight().rotateRight()};

            return dirs;
        }

        public Direction getMoveDir(MapLocation dest) {
            Direction[] dirs = getDirectionsToward(dest);
            for (Direction d : dirs) {
                if (rc.canMove(d)) {
                    return d;
                }
            }
            return null;
        }

        public Direction getSpawnDirection(RobotType type) 
        {
        	
            Direction dir = rc.getLocation().directionTo(rc.senseEnemyHQLocation());
            return dir;
//            for (Direction d : dirs) 
//            {
//                if (rc.canSpawn(d, type)) 
//                {
//                    return d;
//                }
//            }
//            return null;
        }

        public Direction getBuildDirection(RobotType type) 
        {
//            Direction[] dirs = getDirectionsToward(this.theirHQ);
            Direction dir = rc.getLocation().directionTo(rc.senseEnemyHQLocation());
            return dir;
//            for (Direction d : dirs) {
//                if (rc.canBuild(d, type)) {
//                    return d;
//                }
//            }
//            return null;
        }

        public Robot[] getAllies() {
            Robot[] allies = rc.senseNearbyGameObjects(Robot.class, rc.getLocation(), 3 , myTeam);
            return allies;
        }

        public Robot[] getEnemiesInAttackingRange() {
            Robot[] enemies = rc.senseNearbyGameObjects(Robot.class, rc.getLocation(), 3 , theirTeam);
            return enemies;
        }

        public void attackLeastHealthEnemy(RobotInfo[] enemies) throws GameActionException {
            if (enemies.length == 0) {
                return;
            }

            double minEnergon = Double.MAX_VALUE;
            MapLocation toAttack = null;
            Direction dir=null;
            for (RobotInfo info : enemies) 
            {
                if (info.energon < minEnergon) 
                {
                    toAttack = info.location;
                    minEnergon = info.energon;
                    dir=rc.getLocation().directionTo(toAttack);
                }
            }

            rc.move(dir);
            
        }

        public void beginningOfTurn() {
            if (rc.senseEnemyHQLocation() != null) {
                this.theirHQ = rc.senseEnemyHQLocation();
            }
        }

        public void endOfTurn() {
        }

        public void go() throws GameActionException {
            beginningOfTurn();
            execute();
            endOfTurn();
        }

        public void execute() throws GameActionException {
            rc.yield();
        }
    }

    public static class HQ extends BaseBot {
        public HQ(RobotController rc) {
            super(rc);
        }

        public void execute() throws GameActionException {
            rc.yield();
        }
    }

    public static class Beaver extends BaseBot {
        public Beaver(RobotController rc) {
            super(rc);
        }

        public void execute() throws GameActionException {
            System.out.println(5);
            rc.yield();
        }
    }

    public static class Barracks extends BaseBot {
        public Barracks(RobotController rc) {
            super(rc);
        }

        public void execute() throws GameActionException {
            rc.yield();
        }
    }

    public static class Soldier extends BaseBot {
        public Soldier(RobotController rc) {
            super(rc);
        }

        public void execute() throws GameActionException {
            rc.yield();
        }
    }

    public static class Tower extends BaseBot {
        public Tower(RobotController rc) {
            super(rc);
        }

        public void execute() throws GameActionException {
            rc.yield();
        }
    }
}