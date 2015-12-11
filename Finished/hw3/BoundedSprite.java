package hw3;
/**
 * This class adds bounds to the movable sprite so that 
 * they have a limited area to go back and forth on, otherwise
 * it is simply an extension of movableSprite and Sprite.
 * @author Michael Lux
 */
public abstract class BoundedSprite extends MovableSprite
{
	/**
	 * the left most the x coordinate can go for this sprite
	 */
	private double leftBound;
	
	/**
	 * the right most the x coordinate can go for this sprite
	 */
	private double rightBound;
	
	/**
	 * Constructs a sprite that has the ability to move and is bounded
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
	public BoundedSprite(double x, double y, int width, int height, Renderer givenRenderer) 
	{
		super(x, y, width, height, givenRenderer);
		leftBound=Double.NEGATIVE_INFINITY;
		rightBound=Double.POSITIVE_INFINITY;
	}
	
	/**
	 * sets the bounds, left and right, for this object
	 * so that the x coordinate will not move beyond them
	 * @param left
	 * 	the left most the x coordinate can be
	 * @param right
	 * 	the right most the x coordinate can be
	 */
	public void setBounds(double left, double right)
	{
		leftBound=left;
		rightBound=right;
	}
	
	/**
	 * The furthest left the sprite can go
	 * @return
	 * the furthest left the sprite can go
	 */
	protected double getLeftBound()
	{
		return leftBound;
	}
	
	/**
	 * the furthest right the sprite can go
	 * @return
	 * 	the furthest right the sprite can go
	 */
	protected double getRightBound()
	{
		return rightBound;
	}
}
