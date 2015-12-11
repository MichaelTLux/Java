package hw3;

/**
 * This is a base class for objects that can move,
 * however, they do not have to move. It extends the
 * abstract class Sprite
 * @author Michael Lux
 */
public abstract class MovableSprite extends Sprite
{
	/**
	 * The distance this object will move horizontally each time update is called
	 */
	private double xSpeed;
	
	/**
	 * The distance this object will move vertically each time update is called
	 */
	private double ySpeed;
	
	/**
	 * Constructs a sprite that has the ability to move
	 * However as an abstract class this shouldn't happen
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
	public MovableSprite(double x, double y, int width, int height, Renderer givenRenderer) 
	{
		super(x, y, width, height, givenRenderer);
	}
	
	/**
	 * Sets the objects speed in the desired directions for both axis
	 * @param givenDx
	 * 	the desired horizontal speed
	 * @param givenDy
	 * 	the desired vertical  speed
	 */
	public void setDirection(double givenDx, double givenDy)
	{
		xSpeed=givenDx;
		ySpeed=givenDy;
	}
	
	/**
	 * the current horizontal speed of the Sprite
	 * @return
	 */
	public double getDx()
	{
		return xSpeed;
	}
	
	/**
	 * the current vertical speed of the Sprite
	 * @return
	 */
	public double getDy()
	{
		return ySpeed;
	}
	

}
