package lab10;

import java.awt.Color;
import java.awt.Graphics;

public class Portrait14MTL extends Portrait
{
	public Portrait14MTL()
	  {
	    super(0.2);
	    setNeckHeight(.08);
	    setBodyHeight(0.3);
	    setArmSpan(0.4);
	    setArmRaise(-.1);
	    setSpreadEagleness(0.15);
	  }
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int middle=getWidth()/2;
		int downshift=6;
		//eye size
		int eyeRadius = (int)(0.025 * SIZE);
		
		//left eye
		g.fillOval(middle-eyeRadius-(headRadius/3),headRadius/3+downshift,eyeRadius*2,eyeRadius*2);
		
		//right eye
		g.fillOval(middle-eyeRadius+(headRadius/3),headRadius/3+downshift,eyeRadius*2,eyeRadius*2);
		
		//smile
		 int smileRadius= (int)(0.25 * headRadius);
		g.drawArc(middle - smileRadius, (int)(0.8 * headRadius)+downshift, smileRadius * 2,
		        smileRadius * 2, 0, -180);
		
		//nose
		int noseSize=1;
		g.drawOval(middle-noseSize, headRadius, noseSize*2, noseSize*2);
		
		//red head band
		g.setColor(Color.yellow);
		int length=30;
		int height=7;
		int arcWidth=10;
		int arcHeight=10;
		g.drawRoundRect(middle-(length/2), headRadius/8-2, length, height, arcWidth, arcHeight);
	}
}
