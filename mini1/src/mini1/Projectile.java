package mini1;

import java.awt.Rectangle;

public class Projectile {
	
	
	private double positionX;
	private double positionY;
	private double velocityX;
	private double velocityY;
	private int sizeOfObject;
	private boolean isAlive;
	private int ageOfObject;
	
	
	public Projectile(double initialPositionX, double initialPositionY, double initialVelocityX, double initialVelocityY, int givenSize)
	{
		positionX=initialPositionX;
		positionY=initialPositionY;
		velocityX=initialVelocityX;
		velocityY=initialVelocityY;
		sizeOfObject=givenSize;
		isAlive=true;
	}
	
	public boolean collides(Projectile givenprojectile)
	{
		//todo
		return false;
	}
	
	public int getAge()
	{
		return ageOfObject;
	}
	
	public java.awt.Rectangle getBoundingBox()
	{
		int roundedX = (int) Math.round(positionX);
		int roundedY = (int) Math.round(positionY);
		Rectangle boundingBox= new Rectangle(roundedX,roundedY,sizeOfObject , sizeOfObject);
		return boundingBox;
	}
	
	public double getVelocityX()
	{
		return velocityX;
	}
	
	public double getVelocityY()
	{
		return velocityY;
	}
	
	public double getX()
	{
		return positionX;
	}
	
	public double getY()
	{
		return positionY;
	}
	
	public boolean isAlive()
	{
		return isAlive;
	}
	
	public void kill()
	{
		isAlive=false;
	}
	
	public void timeStep()
	{
		positionY=positionY+velocityY;
		positionX=positionX+velocityX;
		ageOfObject=ageOfObject+1;
	}
	
	public void timeStep(double gravity)
	{
		positionY=positionY+velocityY;
		positionX=positionX+velocityX;
		velocityY=velocityY+gravity;
		ageOfObject=ageOfObject+1;	
	}
}
