package hw3;

/**
 * This class contains the information needed to render a projectile
 * onto the screen. It includes gravity and whether or not it is a 
 * ballistic projectile. It extends the abstract class MoveableSprite 
 * @author Michael Lux
 *
 */
public class Projectile extends MovableSprite
{
	/**
	 * The "gravity" this object will experience
	 */
	private double gravity;
	
	/**
	 * whether or not the projectile is ballistic true if it is and false otherwise
	 */
	private boolean ballistic;
	
	/**
	 * Constructs a projectile with the given parameters
	 * @param x
	 * 	top left horizontal location
	 * @param y
	 * 	top left vertical location
	 * @param width
	 * 	the width of the explosion
	 * @param height
	 * 	the height of the explosion
	 * @param givenRenderer
	 * 	the screen in which the explosion will appear
	 */
	public Projectile(double x, double y, int width, int height, Renderer givenRenderer) 
	{
		super(x, y, width, height, givenRenderer);
	}
	
	/**
	 * Sets the gravity this object
	 * @param givenGravity
	 * 	the "gravity" this object will experience
	 */
	public void setGravity(double givenGravity)
	{
		gravity=givenGravity;
	}
	
	/**
	 * Changes the ballistic state to the given parameter
	 * @param givenIsBallistic
	 * 	whether or not the object is ballistic, true if it is and false otherwise
	 */
	public void setBallistic(boolean givenIsBallistic)
	{
		ballistic=givenIsBallistic;
	}
	
	/**
	 * Returns whether or not the object is ballistic
	 * @return
	 * 	whether or not hte object is ballistic, true if so and false otherwise
	 */
	public boolean isBallistic()
	{
		return ballistic;
	}
	
	@Override
	/**
	 * This sets the vertical and horizontal speeds to the given parameters
	 * but if the object is ballistic it does nothing to the horizontal speed
	 * @param givenDx
	 * 	the desired horizontal speed
	 * @param givenDy
	 * 	the desired vertical  speed
	 */
	public void setDirection(double givenDx, double givenDy)
	{
		if (ballistic)
		{
			super.setDirection(super.getDx(), givenDy);
		}
		else
		{
			super.setDirection(givenDx, givenDy);
		}
	}
	
	@Override
	/**
	 * updates the projectile by adding the horizontal speed to
	 * the x and the vertical speed to the y along with the gravity
	 * being added to the vertical speed
	 */
	public void update()
	  {
	    super.update();
	    double newX=super.getXExact()+super.getDx();
	    double newY=super.getYExact()+super.getDy();
	    super.setDirection(super.getDx(), super.getDy()+gravity);
	    super.setPosition(newX, newY);
	  }
	
	

}
