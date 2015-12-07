package hw3;

/**
 * This class contains the information needed to render an
 * explosion on screen. It extends the abstract class Sprite.
 * It is fairly similar with to Sprite with the addition of 
 * a life time that the explosion will last on screen.
 * @author Michael Lux
 */
public class Explosion extends Sprite
{
	/**
	 * The total number of updates an Explosion will last
	 */
	private int lifeTime;
	
	/**
	 * Constructs a new Explosion
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
	 * @param initialCount
	 * 	the life time of the given explosion
	 */
	public Explosion(double x, double y, int width, int height, Renderer givenRenderer, int initialCount) 
	{
		super(x, y, width, height, givenRenderer);
		// TODO Auto-generated constructor stub
		lifeTime=initialCount;
	}
	
	@Override
	/**
	 * Decreases the Explosions life time and increases the
	 * total tick life of the Explosion
	 */
	public void update()
	{
		if (lifeTime>0)
		{
		lifeTime=lifeTime-1;
		}
		super.update();
		if (lifeTime<=0)
		{
			super.markForDeletion();
			return;
		}
		else
		{
			return;
		}
		
	}
	
	/**
	 * Returns the remaining life time of the Explosion
	 * @return
	 * 	the remaining life the Explosion has
	 */
	public int getCount()
	{
		return lifeTime;
	}

}
