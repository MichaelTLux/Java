package lab10;

import java.awt.Color;
import java.awt.Graphics;

public class Portrait14CP extends Portrait
{

	  public Portrait14CP()
	  {
	    super(0.2);

	    // Construct body.
	    setBodyHeight(0.1);
	    setArmSpan(0.75);
	    setNeckHeight(0.2);
	    setArmRaise(-0.7);
	  }

	  @Override
	  public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g);

	    int midX = getWidth() / 2;

	    // Draw a two eyes.
	    int eyeRadius = (int)(0.05 * SIZE);
	    g.fillOval(midX - 10, headRadius - eyeRadius * 2, eyeRadius,
	        eyeRadius);
	    g.fillOval(midX + 7, headRadius - eyeRadius * 2, eyeRadius,
		        eyeRadius);

	    //glasses
	    g.drawRoundRect(midX - 13, headRadius-12, 10, 10, 5, 5);
	    g.drawRoundRect(midX + 5, headRadius-12, 10, 10, 5, 5);
	    
	    //connect glasses frame
	    g.drawLine(midX-3, headRadius-6, midX+5, headRadius-6);
	    
	    // And give him a crooked smile.
	    int smileRadius = (int)(0.5 * headRadius);
	    g.fillArc(midX - smileRadius, (int)(0.8 * headRadius), smileRadius * 2,
	        smileRadius * 2, 25, -180);
	    
	    // red tongue
	    Color col = new Color(155, 0, 0);
	    g.setColor(col); 
	    g.fillArc(midX - 3,headRadius +5, smileRadius,
		        smileRadius, 20, -180);
	    
	    //draw a nose
	    g.setColor(Color.BLACK);
	    g.drawRoundRect(midX, headRadius-2, 3, 3, 1, 1);
	    }
	}