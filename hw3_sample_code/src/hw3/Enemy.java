package hw3;

public class Enemy extends BoundedSprite
{

	private Platform parent;
	public Enemy(double x, double y, int width, int height, Renderer givenRenderer) 
	{
		super(x, y, width, height, givenRenderer);
	}
	
	public void setParent(Platform givenParent)
	{
		parent=givenParent;
	}
	
	public void update()
	{
		super.update();
		double newX;
		double newY;
		if (!(parent==null))
		{
			this.setBounds(parent.getXExact(), parent.getXExact()+parent.getWidth());
			newX=this.getXExact()+parent.getDx()+this.getDx();
		}
		else
		{
			newX=this.getXExact()+this.getDx();			
		}
		
		if (newX<=this.getLeftBound())
		{
			newX=this.getLeftBound();
			this.setDirection(-this.getDx(), this.getDy());
		}
		else if (newX+this.getWidth()>=this.getRightBound())
		{
			newX=this.getRightBound()-this.getWidth();
			this.setDirection(-this.getDx(), this.getDy());
		}
		
		newY=this.getYExact()+this.getDy();
		this.setPosition(newX, newY);
		return;
		
	}

}
