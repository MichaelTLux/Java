package mini1;

import java.awt.Rectangle;

public class ProjectileTest 
{
	public static void main(String args[])
	{
		
		
		//issue is with the backward time step
		Projectile testProjectile1;
		testProjectile1=new Projectile(0,0,10,34,4);
		
		//start of tests
		System.out.println("expecting 0,0,4" +(testProjectile1.getBoundingBox()).getBounds());
		testProjectile1.timeStep();
		System.out.println("expecting 0,0,4" +(testProjectile1.getBoundingBox()).getBounds());
		
		
	}

}
