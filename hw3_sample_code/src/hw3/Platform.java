package hw3;

import java.util.ArrayList;
import java.awt.Graphics;

public class Platform extends BoundedSprite
{
	/**
	 * A list of all the Enemy sprites that are on this particular platform
	 */
	private ArrayList<Enemy> children;
	
	public Platform(double x, double y, int width, int height, Renderer givenRenderer) 
	{
		super(x, y, width, height, givenRenderer);
		children=new ArrayList<>();
	}
	
	/**
	 * Adds the given Enemy to this platform's list of children, and sets the child's parent to be this object
	 * @param e
	 * 	the Enemy to be added to the platform
	 */
	public void addChild(Enemy e)
	{
		children.add(e);
		e.setParent(this);
	}
	
	/**
	 * Returns this platform's list of children. The child objects are not cloned.
	 * @return
	 * 	all the "child" enemies on this platform
	 */
	public ArrayList<Enemy> getChildren()
	{
		return children;
	}

	/**
	 * Removes all children that have been marked for deletion.
	 */
	public void deleteMarkedChildren()
	{
		for (int i=0;i<children.size();i=i+1)
		{
			if (children.get(i).shouldDelete())
			{
				children.remove(i);
			}
		}
	}
	
	
	//upper javadoc is fine
	  public void draw(Graphics g)
	  {
	    super.draw(g);
	    for (int i=0; i<children.size(); i=i+1)
	    {
	    	children.get(i).draw(g);
	    }
	  } 
	  
	  @Override
	  /**
	   * Updates the position of the platform by first updating all of its children
	   * then it adds its dx and dy values to its current location and checks to
	   * make sure it is in its bounds
	   */
	  public void update()
	  {
		  super.update();
		  for (int i=0; i<children.size(); i=i+1)
		    {
		    	children.get(i).update();
		    }
		  double newX= super.getDx()+super.getXExact();
		  double newY= super.getDy()+super.getYExact();
		  if (newX<=super.getLeftBound())
		  {
			  newX=super.getLeftBound();
			  super.setDirection(-super.getDx(), super.getDy());
		  }
		  else if (newX+this.getWidth()>=super.getRightBound())
		  {
			  newX=super.getRightBound()-this.getWidth();
			  super.setDirection(-super.getDx(), super.getDy());
		  }
		  
		  super.setPosition(newX, newY);
		  
	  }

}
