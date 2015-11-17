package lab10;

import java.awt.Graphics;

public class Portrait14MTL extends Portrait
{
	public Portrait14MTL()
	  {
	    super(0.2);
	    setNeckHeight(.01);
	    setBodyHeight(0.3);
	    setArmSpan(0.3);
	    setArmRaise(0.6);
	    setSpreadEagleness(0.3);
	  }
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int xThird= getWidth()/3;
		int yThird= getHeight()/3;
		int eyeRadius = (int)(0.025 * SIZE);
		g.fillOval(xThird, yThird, 4 * eyeRadius,
		        4 * eyeRadius);
	
	}
}
