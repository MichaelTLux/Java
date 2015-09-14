package mini1;

import java.awt.Rectangle;

/**
 * This class encapsulates information about the position and velocity of a 
 * projectile in two dimensions. A projectile also has a size that can be used 
 * to determine collisions with other projectiles based on a bounding box, assumed
 *  to be a size x size rectangle with its upper left corner at the projectile's 
 *  position. The horizontal and vertical components of the velocity represent the 
 *  change in horizontal and vertical position, respectively, per time unit. The 
 *  method timeStep simulates the passage of one time unit, updating the position 
 *  by adding the velocity components to the corresponding position components, 
 *  and adding the optional gravity parameter to the y-component of the velocity. 
 *  A projectile also has a status of alive or dead that applications may set or 
 *  check using the methods kill() and isAlive(). The "dead" status has no effect 
 *  on any method other than isAlive().
 */
public class Projectile {
	
	/**
	 * The position of the projectile on the "X" axis.
	 */
	private double positionX;
	
	/**
	 * The position of the projectile on the "Y" axis.
	 */
	private double positionY;
	
	/**
	 * How fast in in what direction the projectile is moving along the "X" axis.
	 */
	private double velocityX;
	
	/**
	 * How fast in in what direction the projectile is moving along the "Y" axis.
	 */
	private double velocityY;
	
	/**
	 * The size of the sides of the square projectile
	 */
	private int sizeOfObject;
	
	/**
	 * Keeps track of the "life" of the projectile and tells if applicant has used kill().
	 */
	private boolean isAlive;
	
	/**
	 * How long the object has existed
	 */
	private int ageOfObject;
	
	/**
	 * Constructs a projectile with the given position, velocity, and size that is initially alive and has age 0
	 * @param initialPositionX
	 * 	the original position on the "X" axis
	 * @param initialPositionY
	 * 	the original position on the "Y" axis
	 * @param initialVelocityX
	 * 	the original speed and direction on the "X" axis
	 * @param initialVelocityY
	 * 	the original speed and direction on the "X" axis
	 * @param givenSize
	 * 	the size of the projectile's square sides
	 */
	public Projectile(double initialPositionX, double initialPositionY, double initialVelocityX, double initialVelocityY, int givenSize)
	{
		positionX=initialPositionX;
		positionY=initialPositionY;
		velocityX=initialVelocityX;
		velocityY=initialVelocityY;
		sizeOfObject=givenSize;
		isAlive=true;
	}
	
	/**
	 * Determines whether this projectile's bounding box intersects 
	 * with the given projectile's bounding box, according to the 
	 * intersects() method of java.awt.Rectangle.
	 * @param givenProjectile
	 * 	the projectile to test a collision with
	 * @return
	 * 	True means there is a collision and false means there isn't
	 */
	public boolean collides(Projectile givenProjectile)
	{
		return this.getBoundingBox().intersects(givenProjectile.getBoundingBox());
	}
	
	/**
	 * Returns the number of times that timeStep has been called on 
	 * this projectile (regardless of whether it is marked or unmarked).
	 * @return
	 * 
	 */
	public int getAge()
	{
		return ageOfObject;
	}
	
	/**
	 * Returns the bounding box for this projectile as a new instance of java.awt.Rectangle.
	 * @return
	 * 
	 */
	public java.awt.Rectangle getBoundingBox()
	{
		int roundedX = (int) Math.round(positionX);
		int roundedY = (int) Math.round(positionY);
		Rectangle boundingBox= new Rectangle(roundedX,roundedY,sizeOfObject , sizeOfObject);
		return boundingBox;
	}
	
	/**
	 * Returns the horizontal component of this projectile's velocity.
	 * @return
	 * 
	 */
	public double getVelocityX()
	{
		return velocityX;
	}
	
	/**
	 * Returns the vertical component of this projectile's velocity.
	 * @return
	 * 
	 */
	public double getVelocityY()
	{
		return velocityY;
	}
	
	/**
	 * Returns this projectile's horizontal position.
	 * @return
	 * 
	 */
	public double getX()
	{
		return positionX;
	}
	
	/**
	 * Returns this projectile's vertical position.
	 * @return
	 * 
	 */
	public double getY()
	{
		return positionY;
	}
	
	/**
	 * Determines whether this projectile's status is "alive".
	 * @return
	 * 
	 */
	public boolean isAlive()
	{
		return isAlive;
	}
	
	/**
	 * Marks this projectile as "dead".
	 */
	public void kill()
	{
		isAlive=false;
	}
	
	/**
	 * Simulates motion over one time step.
	 */
	public void timeStep()
	{
		positionY=positionY+velocityY;
		positionX=positionX+velocityX;
		ageOfObject=ageOfObject+1;
	}
	
	/**
	 * Simulates motion over one time step.
	 * @param gravity
	 * 	how strong is gravity
	 */
	public void timeStep(double gravity)
	{
		positionY=positionY+velocityY;
		positionX=positionX+velocityX;
		velocityY=velocityY+gravity;
		ageOfObject=ageOfObject+1;	
	}
}
