package lab10;
import java.awt.Graphics;
public class Portrait14AT extends Portrait
{
public Portrait14AT()
{
super(0.2);
 
setBodyHeight(0.2);
setArmSpan(1);
setSpreadEagleness(1);
setArmRaise(1);
}
@Override
public void paintComponent(Graphics g)
{
super.paintComponent(g);
int midX = getWidth() / 2;
// Draw a big eye right in the middle of the face.
int eyeRadius = (int)(0.05 * SIZE);
g.fillOval(midX - eyeRadius - 10, headRadius - eyeRadius * 2, 2 * eyeRadius,
2 * eyeRadius);
g.fillOval(midX - eyeRadius + 10, headRadius - eyeRadius * 2, 2 * eyeRadius,
2 * eyeRadius);
g.drawRect(midX - eyeRadius - 10 - 2, headRadius - eyeRadius * 2 - 2, 2 * eyeRadius + 4,
2 * eyeRadius + 4);
g.drawRect(midX - eyeRadius + 10 - 2, headRadius - eyeRadius * 2 - 2, 2 * eyeRadius + 4,
2 * eyeRadius + 4);
g.drawLine(midX + eyeRadius - 8, headRadius - eyeRadius, midX - eyeRadius + 8, headRadius - eyeRadius);
int smileRadius = (int)(0.5 * headRadius);
g.drawArc(midX - smileRadius, (int)(0.8 * headRadius), smileRadius * 2,
smileRadius * 2, 0, -180);
g.drawLine(midX - smileRadius, (int)(1.3 * headRadius), midX + smileRadius, (int)(1.3 * headRadius));
}
}