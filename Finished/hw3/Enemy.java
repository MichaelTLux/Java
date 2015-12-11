package hw3;

/**
 * This class encapsulates that information needed to
 * create an entity that will stay within the bounds of 
 * a parent sprite
 * @author Michael Lux
 *
 */
public class Enemy extends BoundedSprite
{
	/**
	 * the parent entity that this sprite will be bounded by
	 */
	private Platform parent;
	
	/**
	 * Constructs an enemy that is able to follow a parent but 
	 * starts off with no bounds
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
	public Enemy(double x, double y, int width, int height, Renderer givenRenderer) 
	{
		super(x, y, width, height, givenRenderer);
	}
	
	/**
	 * Sets the parent sprite for this enemy
	 * @param givenParent
	 * 	the platform that is the desired parent
	 */
	public void setParent(Platform givenParent)
	{
		parent=givenParent;
	}
	
	public void update()
	{
		//keeps the ticks on track
		super.update();
		double newX;
		double newY;
		//if there is a parent set new bounds
		if (!(parent==null))
		{
			this.setBounds(parent.getXExact(), parent.getXExact()+parent.getWidth());
			//now if the parent is AT the boundary that means they just flipped the Dx
			//and therefore it should not be added normally
			if (!(parent.getX()==parent.getLeftBound()) && !(parent.getX()==parent.getRightBound()))
			{
				newX=this.getXExact()+parent.getDx()+this.getDx();
			}
			//if it is at the bound use the old non flipped dx (by using minus)
			else
			{
				newX=this.getXExact()-parent.getDx()+this.getDx();
			}
		}
		//if there isn't just add dx to your x
		else
		{
			newX=this.getXExact()+this.getDx();			
		}
		
		//now check the bounds
		if (newX<=this.getLeftBound())
		{
			newX=this.getLeftBound();
			this.setDirection(-this.getDx(), this.getDy());
		}
		else if (newX+this.getWidth()>=this.getRightBound())
		{
			//this following line is a discrepancy I found with other programmers "may be wrong"
			newX=this.getRightBound()-this.getWidth();
			this.setDirection(-this.getDx(), this.getDy());
		}
		//y isn't bounded so it just is
		newY=this.getYExact()+this.getDy();
		this.setPosition(newX, newY);
		return;
		
	}

}
