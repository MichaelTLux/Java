package hw3;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class JTests {
	private static final double EPSILON = 10e-07;

	private Projectile p;
	private Projectile p2;
	private Platform plane;
	private Enemy e;
	private Enemy e2;
	
	@Before
	public void start()
	{
		p = new Projectile(1,2,3,4,null);
		p.setBallistic(true);
		p2 = new Projectile(1,2,3,4,null);
		plane = new Platform(1, 1, 1, 1, null);
		e = new Enemy(0, 0, 0, 0, null);
		e2 = new Enemy(1,1,1,1,null);
	}
	
	@Test
	public void testSetDirection()
	{
		p.setDirection(1, 1);
		assertEquals(0.0,p.getDx(),EPSILON);
		assertEquals(1.0,p.getDy(),EPSILON);
		
	}
	
	@Test
	public void testSetDirection2()
	{
		p2.setDirection(1, 1);
		assertEquals(1.0,p2.getDx(),EPSILON);
		assertEquals(1.0,p2.getDy(),EPSILON);
		
	}
	
	@Test
	public void testGravity(){
		p2.setGravity(1);
		p2.setDirection(1, 1);
		p2.update();
		assertEquals(2.0,p2.getDy(),EPSILON);
	}
	
	@Test
	public void ballisticTest()
	{
		assertEquals(true,p.isBallistic());
	}
	
	@Test
	public void platformSetDir()
	{
		plane.setDirection(2, 3);
		assertEquals(2,plane.getDx(),EPSILON);
		assertEquals(3,plane.getDy(),EPSILON);
	}
	
	@Test
	public void platformChildren()
	{
		plane.addChild(e);
		plane.addChild(e2);
		assertEquals(plane.getChildren().size(),2);
		
	}
	
	@Test
	public void platformDeleteChild()
	{
		plane.addChild(e);
		assertEquals(plane.getChildren().size(),1);
		e.markForDeletion();
		plane.deleteMarkedChildren();
		assertEquals(plane.getChildren().size(),0);
		
	}
	
	@Test
	public void platformLocation()
	{
		plane.setDirection(1, 1);
		plane.update();
		assertEquals(2,plane.getX(),EPSILON);
		assertEquals(2,plane.getY(),EPSILON);
	}
	
	@Test
	public void platformBounds()
	{
		plane.setBounds(1, 6);
		plane.setDirection(4, 0);
		plane.update();
		assertEquals(-4,plane.getDx(),EPSILON);
		assertEquals(5,plane.getX(),EPSILON);
		
	}
	
	@Test
	public void enemyTests()
	{
		e.setDirection(1, 10);
		assertEquals(1,e.getDx(),EPSILON);
		assertEquals(10,e.getDy(),EPSILON);
		e.update();
		e.update();
		assertEquals(2,e.getX());
		assertEquals(20,e.getY());
	}
	
	@Test
	public void enemyTests2()
	{
		e.setDirection(1, 10);
		assertEquals(1,e.getDx(),EPSILON);
		assertEquals(10,e.getDy(),EPSILON);
		e.update();
		e.update();
		assertEquals(2,e.getX());
		assertEquals(20,e.getY());
		plane.setDirection(2, 2);
		plane.setBounds(1, 6);
		plane.addChild(e);
		e.update();
		assertEquals(-1,e.getDx(),EPSILON);
		assertEquals(5,e.getX(),EPSILON);

	}
	
	@Test
	public void enemyTests3()
	{
		e.setDirection(1, 10);
		plane.addChild(e);
		plane.setDirection(2, 2);
		plane.setBounds(1, 6);
		plane.update();
		assertEquals(3,plane.getX());
		assertEquals(3,e.getX());
		assertEquals(-1,e.getDx(),EPSILON);
		plane.update();
		assertEquals(5,plane.getX());
		assertEquals(-2,plane.getDx(),EPSILON);
		assertEquals(0,e.getX());
		assertEquals(1,e.getDx(),EPSILON);
		
		
		
		
		
	}
	
}