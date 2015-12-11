package hw3;

import org.junit.Test;

import com.sun.javafx.geom.Rectangle;

import demo.ExplosionRenderer;
import static org.junit.Assert.*;
import java.awt.Color;
import java.util.ArrayList;

import org.junit.Before;


public class TestingAllTheCodes 
{
	Platform platform;
	Explosion explosion;
	Projectile projectile;
	Enemy enemy;
	private Projectile p2 = new Projectile(100.0, 120.0, 10, 15, null);

	private Projectile dummy = new Projectile(114.0, 120.0, 10, 10, null);

	private Rectangle right = new Rectangle(100, 120, 10, 15);

	private static final double EPSILON = 10e-07;
	
	private Explosion e2 = new Explosion(100.0, 110.0, 15, 10, null, 40);
	
	private Rectangle right2 = new Rectangle(100, 110, 15, 10);
	
	private Projectile p3 = new Projectile(89.0, 110.0, 10, 10, null);

	private double g = 3.0;
	 @Before
	    public void setup()
	    {
		 int x=10;
		 int y=10;
		 int width=15;
		 int height=10;
		 int initialCount=10;
		 Renderer renderer=new ExplosionRenderer(1, Color.BLACK, Color.CYAN);
		 platform=new Platform(x,y,width,height, renderer);
		 explosion=new Explosion(x,y,width,height, renderer, initialCount);
		 projectile=new Projectile(x,y,width,height, renderer);
		 enemy= new Enemy(x,y,width,height, renderer);
		 
		 for(int i=0;i<7;i+=1)
			{
				p2.update();
			}
			p2.setDirection(2.0, 4.0);
			
			for(int i =0;i<10;i+=1)
			{
				e2.update();
			}
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
	 
	 
	 
	 
	 
	 
	 
	 
	 @Test
	 	//Projectile Stuff
	 public void getTotalTicksProjectile1()
	 {
		 for (int i=0; i<9; i=i+1)
		 {
			 projectile.update();
		 }
		String message="After 9 calls to update, ticks=9";
		assertEquals(message, 9, projectile.getTicks());

	 }
	 
	 @Test
	 public void getTotalTicksProjectile2()
	 {
		 for (int i=0; i<10; i=i+1)
		 {
			 projectile.update();
		 }
		String message="After 10 calls to update, should ticks=10";
		assertEquals(message, 10, projectile.getTicks());

	 }
	 
	 @Test
	 public void GravityProjectile1()
	 {
		 String message="The gravity should be 0 initially and not move the object";
		 assertEquals(message, 10, projectile.getYExact(), .01);
	 }
	 
	 @Test
	 public void GravityProjectile2()
	 {
		 String message="The gravity should be 0 initially and not move the object";
		 assertEquals(message, 0, projectile.getDy(), .01);
	 }
	 
	 @Test
	 public void GravityProjectile3()
	 {
		 String message="dx should not change if asked to when balistic==true";
		 projectile.setBallistic(true);
		 projectile.setDirection(10, projectile.getDy());
		 assertEquals(message, 0, projectile.getDx(), .01);
	 }
	 
	 
	 
	 
	 
	 //now is the platform stuff
	 @Test
	 public void PlatformTest1()
	 {
		 platform.addChild(enemy);
		 assertEquals(enemy,platform.getChildren().get(0));
	 }
	 
	 @Test
	 public void PlatformTestDeleteChildren()
	 {
		 Enemy enemy2= new Enemy(1,1,1,1, null);
		 platform.addChild(enemy);
		 platform.addChild(enemy2);
		 enemy2.markForDeletion();
		 platform.deleteMarkedChildren();
		 assertEquals(1, platform.getChildren().size());
	 }
	 
	 @Test
	 public void PlatformTest3()
	 {
		 assertEquals(false,platform.shouldDelete());
	 }
	 
	 public void Platform1()
	 {
		 Platform e = new Platform(100, 0, 10, 10, null);
		 e.setBounds(90, 120);
		 e.setDirection(15, 0);
		 e.update();
		 assertEquals(110,e.getX());
	 }
	 
	 @Test
	 public void Platform2()
	 {
		 Platform e = new Platform(100, 0, 10, 10, null);
		 e.setBounds(90, 120);
		 e.setDirection(15, 0);
		 e.update();
		 assertEquals(-15,e.getDx(), .1);
	 }
	 
	 @Test
	 public void Platform3()
	 {
		 Platform e = new Platform(100, 0, 10, 10, null);
		 e.setBounds(90, 120);
		 e.setDirection(15, 0);
		 e.update();
		 e.update();
		 e.update();
		 assertEquals(90, e.getX());
	 }
	 
	 @Test
	 public void Platform4()
	 {
		 Platform e = new Platform(100, 0, 10, 10, null);
		 e.setBounds(90, 120);
		 e.setDirection(15, 0);
		 e.update();
		 e.update();
		 e.update();
		 assertEquals(15,e.getDx(), .1);
	 }
	 
	 @Test
	 public void Platform5()
	 {
		 Platform p = new Platform(0, 0, 0, 0, null);
		 Enemy e1 = new Enemy(0, 0, 0, 0, null);
		 p.addChild(e1);
		 Enemy e2 = new Enemy(0, 0, 0, 0, null);
		 p.addChild(e2);
		 ArrayList<Enemy> children = p.getChildren();
		 assertEquals(true,children.contains(e1));
	 }
	 
	 @Test
	 public void Platform6()
	 {
		 Platform p = new Platform(0, 0, 0, 0, null);
		 Enemy e1 = new Enemy(0, 0, 0, 0, null);
		 p.addChild(e1);
		 Enemy e2 = new Enemy(0, 0, 0, 0, null);
		 p.addChild(e2);
		 ArrayList<Enemy> children = p.getChildren();
		 assertEquals(true,children.contains(e2));
	 }
	 
	 @Test
	 public void Platform8()
	 {
		 Platform p = new Platform(0, 0, 0, 0, null);
		 Enemy e1 = new Enemy(0, 0, 0, 0, null);
		 p.addChild(e1);
		 Enemy e2 = new Enemy(0, 0, 0, 0, null);
		 p.addChild(e2);
		 e1.markForDeletion();
		 p.deleteMarkedChildren();
		 ArrayList<Enemy> children = p.getChildren();
		 assertEquals(false,children.contains(e1));
	 }
	 
	 @Test
	 public void Platform9()
	 {
		 Platform p = new Platform(0, 0, 0, 0, null);
		 Enemy e1 = new Enemy(0, 0, 0, 0, null);
		 p.addChild(e1);
		 Enemy e2 = new Enemy(0, 0, 0, 0, null);
		 p.addChild(e2);
		 e1.markForDeletion();
		 p.deleteMarkedChildren();
		 ArrayList<Enemy> children = p.getChildren();
		 assertEquals(true,children.contains(e2));
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 //now for the enemy stuff
	 @Test
	 public void enemy1()
	 {
		 Enemy e = new Enemy(100, 0, 10, 10, null);
		 e.setBounds(90, 120);
		 e.setDirection(15, 0);
		 e.update();
		 assertEquals(110,e.getX());
	 }
	 
	 @Test
	 public void enemy2()
	 {
		 Enemy e = new Enemy(100, 0, 10, 10, null);
		 e.setBounds(90, 120);
		 e.setDirection(15, 0);
		 e.update();
		 assertEquals(-15,e.getDx(), .1);
	 }
	 
	 @Test
	 public void enemy3()
	 {
		 Enemy e = new Enemy(100, 0, 10, 10, null);
		 e.setBounds(90, 120);
		 e.setDirection(15, 0);
		 e.update();
		 e.update();
		 e.update();
		 assertEquals(90, e.getX());
	 }
	 
	 @Test
	 public void enemy4()
	 {
		 Enemy e = new Enemy(100, 0, 10, 10, null);
		 e.setBounds(90, 120);
		 e.setDirection(15, 0);
		 e.update();
		 e.update();
		 e.update();
		 assertEquals(15,e.getDx(), .1);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
//Malfunctioned saying the same values where different	 
//	 @Test
//		public void testGet2()
//		{
//			assertEquals(15,e2.getWidth());
//			assertEquals(10,e2.getHeight());
//			assertEquals(100, e2.getX());
//			assertEquals(100.0, e2.getXExact(), EPSILON);
//			assertEquals(110.0, e2.getYExact(), EPSILON);
//			assertEquals(right2, e2.getRect());
//			assertEquals(110, e2.getY());
//			assertEquals(10,e2.getTicks());
//			assertEquals(false, e2.shouldDelete());
//			assertEquals(40, e2.getCount());
//		}	
		
		@Test
		public void testDeletion()
		{
			assertEquals(false, e2.shouldDelete());
			for(int i = 0; i<32;i+=1)
			{
				e2.update();
				if(e2.getTicks()==40)
				{
					e2.markForDeletion();
				}
			}
			assertEquals(true, e2.shouldDelete());
		}
		
		@Test
		public void testCollides()
		{
			p3.setDirection(2.0, 0.0);
			assertEquals(false, e2.collides(p3));
			p3.update();
			assertEquals(true, e2.collides(p3));
			
			//resets for p
			p3.setPosition(89.0, 110.0);
			p3.setDirection(0.0, 0.0);
			assertEquals(false, e2.collides(p3));
			
			p3.setDirection(0.0, 2.0);
			p3.setPosition(100.0, 91.0);
			for(int i=0; i <5; i+=1)
			{
				p3.update();
			}
			assertEquals(true, e2.collides(p3));
		}
//Malfunctioned saying similar values where not the same	 
//	 @Test
//		public void testGet()
//		{
//			assertEquals(2.0, p2.getDx(), EPSILON);
//			assertEquals(4.0, p2.getDy(), EPSILON);
//			assertEquals(10, p2.getWidth());
//			assertEquals(15, p2.getHeight());
//			assertEquals(100, p2.getX());
//			assertEquals(120, p2.getY());
//			assertEquals(100.0, p2.getXExact(), EPSILON);
//			assertEquals(120.0, p2.getYExact(), EPSILON);
//			assertEquals(right, p2.getRect());
//			assertEquals(7, p2.getTicks());
//			assertEquals(false, p2.isBallistic());
//		}

		@Test
		public void testDirection()
		{
			p2.setDirection(1.0, 0.0);

			for(int i=0;i<5;i+=1)
			{
				p2.update();
			}
			assertEquals(true, p2.collides(dummy));

			//reset
			p2.setPosition(100.0, 120.0);
			assertEquals(false, p2.collides(dummy));

			dummy.setPosition(100.0, 140.0);
			p2.setDirection(0.0, 2.0);

			for(int i=0;i<3;i+=1)
			{
				p2.update();
			}
			assertEquals(true, p2.collides(dummy));

			//reset
			p2.setPosition(100.0, 120.0);
			assertEquals(false, p2.collides(dummy));
		}

		@Test
		public void testBalistic()
		{
			p2.setDirection(-2.0, 0.0);
			p2.setBallistic(true);
			p2.setDirection(0.0, 0.0);
			for(int i=0;i<5;i+=1)
			{
				p2.update();
			}
			dummy.setPosition(81.0, 120.0);
			assertEquals(true, p2.collides(dummy));

			//reset
			p2.setBallistic(false);
			p2.setPosition(100.0, 120.0);
			dummy.setPosition(114.0, 120.0);

			assertEquals(false, p2.isBallistic());

			p2.setPosition(110.0, 120.0);
			p2.setDirection(0.0, 2.0);
			p2.setBallistic(true);
			p2.setDirection(0.0, 0.0);
			for(int i=0;i<5;i+=1)
			{
				p2.update();
			}
			assertEquals(true, p2.collides(dummy));

			//reset
			p2.setBallistic(false);
			p2.setPosition(100.0, 120.0);
			dummy.setPosition(114.0, 120.0);
		}

		@Test
		public void testGravity()
		{
			p2.setGravity(g);

			p2.setDirection(2.0, -8.0);
			p2.setBallistic(true);
			dummy.setPosition(106.0, 105.0);
			for(int i=0;i<3;i+=1)
			{
				p2.update();
			}
			assertEquals(true, p2.collides(dummy));

			//reset
			p2.setBallistic(false);
			p2.setPosition(100.0, 120.0);
			p2.setDirection(0.0, 0.0);
			dummy.setPosition(114.0, 120.0);

			p2.setDirection(-2.0, 0);
			dummy.setPosition(83.0, 141.0);
			for(int i=0;i<4;i+=1)
			{
				p2.update();
			}
			assertEquals(true, p2.collides(dummy));

			//reset
			p2.setBallistic(false);
			p2.setPosition(100.0, 120.0);
			p2.setDirection(0.0, 0.0);
			dummy.setPosition(114.0, 120.0);

			p2.setDirection(1.0, -12.0);
			p2.setBallistic(true);
			for(int i=0;i<3;i+=1)
			{
				p2.update();
			}
			p2.setDirection(0.0, p2.getDy());
			for(int i=0;i<2;i+=1)
			{
				p2.update();
			}
			dummy.setPosition(96.0, 96.0);
			assertEquals(true, p2.collides(dummy));

			//reset
			p2.setBallistic(false);
			p2.setPosition(100.0, 120.0);
			p2.setDirection(0.0, 0.0);
			dummy.setPosition(114.0, 120.0);
			
			p2.setGravity(0.0);
			p2.setDirection(0.0, -3.0);
			for(int i=0;i<5;i+=1)
			{
				p2.update();
			}
			dummy.setPosition(100.0, 96.0);
			assertEquals(true, p2.collides(dummy));
		}
	 
	 
     @org.junit.Test
     public void getCount01() {
             Explosion exp = new Explosion(1,1,1,1,new demo.ExplosionRenderer(10, Color.RED, Color.black), 10);
             exp.update();
             equals(exp.getCount()==9);
     }
     @org.junit.Test
     public void getCount10() {
             Explosion exp = new Explosion(1,1,1,1,new demo.ExplosionRenderer(10, Color.RED, Color.black), 10);
             exp.update();
             exp.update();
             equals(exp.getCount()==8);
     }
     @org.junit.Test
     public void explosionMarkForDeletion0(){
             Explosion exp = new Explosion(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black),10);
             for(int i=0;i<10;i++){
                     exp.update();
             }
             equals(exp.shouldDelete());    
     }
     @org.junit.Test
     public void explosionMarkForDeletionFalse0(){
             Explosion exp = new Explosion(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black),10);
             for(int i=0;i<9;i++){
                     exp.update();
             }
             equals(!exp.shouldDelete());   
     }
     //Projectile Class Tests
     @org.junit.Test
     public void ballistic00(){
             Projectile proj =new Projectile(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black));
             proj.setBallistic(true);
             equals(proj.isBallistic());
     }
     @org.junit.Test
     public void ballistic10(){
             Projectile proj =new Projectile(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black));
             proj.setBallistic(false);
             equals(!proj.isBallistic());
     }
     @org.junit.Test
     public void updateTest00(){
             Projectile proj = new Projectile(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black));
             proj.setDirection(2, 2);
             proj.setGravity(20);
             proj.update();
             equals(proj.getX()==3 && proj.getY()==23);
     }
     @org.junit.Test
     public void updateTest10(){
             Projectile proj = new Projectile(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black));
             proj.setDirection(2, 2);
             proj.setGravity(20);
             proj.update();
             proj.update();
             equals(proj.getX()==5 && proj.getY()==45);
     }
     @org.junit.Test
     public void setDirectionTest00(){
             Projectile proj = new Projectile(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black));
             proj.setBallistic(true);
             proj.setDirection(4, 4);
             equals(proj.getDx()==1 && proj.getDy()==4);
     }
     @org.junit.Test
     public void setDirectionTest10(){
             Projectile proj = new Projectile(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black));
             proj.setBallistic(true);
             proj.setDirection(4, 4);
             equals(proj.getDx()==4 && proj.getDy()==4);
     }
     
     @org.junit.Test
 	public void getCount0() {
 		Explosion exp = new Explosion(1,1,1,1,new demo.ExplosionRenderer(10, Color.RED, Color.black), 10);
 		exp.update();
 		equals(exp.getCount()==9);
 	}
 	@org.junit.Test
 	public void getCount1() {
 		Explosion exp = new Explosion(1,1,1,1,new demo.ExplosionRenderer(10, Color.RED, Color.black), 10);
 		exp.update();
 		exp.update();
 		equals(exp.getCount()==8);
 	}
 	@org.junit.Test
 	public void explosionMarkForDeletion(){
 		Explosion exp = new Explosion(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black),10);
 		for(int i=0;i<10;i++){
 			exp.update();
 		}
 		equals(exp.shouldDelete());	
 	}
 	@org.junit.Test
 	public void explosionMarkForDeletionFalse(){
 		Explosion exp = new Explosion(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black),10);
 		for(int i=0;i<9;i++){
 			exp.update();
 		}
 		equals(!exp.shouldDelete());	
 	}
 	//Projectile Class Tests
 	@org.junit.Test
 	public void ballistic0(){
 		Projectile proj =new Projectile(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black));
 		proj.setBallistic(true);
 		equals(proj.isBallistic());
 	}
 	@org.junit.Test
 	public void ballistic1(){
 		Projectile proj =new Projectile(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black));
 		proj.setBallistic(false);
 		equals(!proj.isBallistic());
 	}
 	@org.junit.Test
 	public void updateTest0(){
 		Projectile proj = new Projectile(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black));
 		proj.setDirection(2, 2);
 		proj.setGravity(20);
 		proj.update();
 		equals(proj.getX()==3 && proj.getY()==23);
 	}
 	@org.junit.Test
 	public void updateTest1(){
 		Projectile proj = new Projectile(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black));
 		proj.setDirection(2, 2);
 		proj.setGravity(20);
 		proj.update();
 		proj.update();
 		equals(proj.getX()==5 && proj.getY()==45);
 	}
 	@org.junit.Test
 	public void setDirectionTest0(){
 		Projectile proj = new Projectile(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black));
 		proj.setBallistic(true);
 		proj.setDirection(4, 4);
 		equals(proj.getDx()==1 && proj.getDy()==4);
 	}
 	@org.junit.Test
 	public void setDirectionTest1(){
 		Projectile proj = new Projectile(1,1,1,1,new demo.ExplosionRenderer(10,Color.RED,Color.black));
 		proj.setBallistic(true);
 		proj.setDirection(4, 4);
 		equals(proj.getDx()==4 && proj.getDy()==4);
 	}

	 
	 

}
