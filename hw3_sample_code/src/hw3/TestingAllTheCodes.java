package hw3;

import org.junit.Test;
import demo.ExplosionRenderer;
import static org.junit.Assert.*;
import java.awt.Color;
import org.junit.Before;

public class TestingAllTheCodes 
{
	Platform platform;
	Explosion explosion;
	Projectile projectile;
	Enemy enemy;
	
	 @Before
	    public void setup()
	    {
		 int x=0;
		 int y=0;
		 int width=10;
		 int height=10;
		 int initialCount=10;
		 Renderer renderer=new ExplosionRenderer(1, Color.BLACK, Color.CYAN);
		 platform=new Platform(x,y,width,height, renderer);
		 explosion=new Explosion(x,y,width,height, renderer, initialCount);
		 projectile=new Projectile(x,y,width,height, renderer);
		 enemy= new Enemy(x,y,width,height, renderer);
	    }
	 @Test
	 	//Explosion Stuff
	 public void getTotalTicksExplosion1()
	 {
		 for (int i=0; i<9; i=i+1)
		 {
			 explosion.update();
		 }
		String message="After 9 calls to update, ticks=9";
		assertEquals(message, 9, explosion.getTicks());

	 }
	 
	 @Test
	 public void getTotalTicksExplosion2()
	 {
		 for (int i=0; i<10; i=i+1)
		 {
			 explosion.update();
		 }
		String message="After 10 calls to update, should ticks=10";
		assertEquals(message, 10, explosion.getTicks());

	 }
	 
	 @Test
	 	//Explosion Stuff
	 public void getTotalLifeExplosion1()
	 {
		 for (int i=0; i<9; i=i+1)
		 {
			 explosion.update();
		 }
		String message="After 9 calls to update, life=1";
		assertEquals(message, 1, explosion.getCount());

	 }
	 
	 @Test
	 public void getTotalLifeExplosion2()
	 {
		 for (int i=0; i<10; i=i+1)
		 {
			 explosion.update();
		 }
		String message="After 10 calls to update, should life=0";
		assertEquals(message, 0, explosion.getCount());

	 }
	 
	 @Test
	 public void getTotalLifeExplosion3()
	 {
		 for (int i=0; i<9; i=i+1)
		 {
			 explosion.update();
		 }
		String message="After 9 calls to update, should delete=false";
		assertEquals(message, false, explosion.shouldDelete());

	 }
	 
	 @Test
	 public void getTotalLifeExplosion4()
	 {
		 for (int i=0; i<10; i=i+1)
		 {
			 explosion.update();
		 }
		String message="After 10 calls to update, should delete=true";
		assertEquals(message, true, explosion.shouldDelete());
	 }
	 
	 @Test
	 public void getTotalLifeExplosion5()
	 {
		 for (int i=0; i<11; i=i+1)
		 {
			 explosion.update();
		 }
		String message="After 11 calls to update, should life=0";
		assertEquals(message, 0, explosion.getCount());
	 }
	 
	 

}
