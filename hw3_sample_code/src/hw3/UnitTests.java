package hw3;

import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import org.junit.Before;

public class UnitTests {
	private static final double EPSILON = 10e-07;

	private Projectile pp;
	private Projectile p2;
	private Platform plane;
	private Enemy ee;
	private Enemy e2;

	@Before
	public void start() {
		pp = new Projectile(1, 2, 3, 4, null);
		pp.setBallistic(true);
		p2 = new Projectile(1, 2, 3, 4, null);
		plane = new Platform(1, 1, 1, 1, null);
		ee = new Enemy(0, 0, 0, 0, null);
		e2 = new Enemy(1, 1, 1, 1, null);
	}

	@Test
	public void testSetDirection() {
		pp.setDirection(1, 1);
		assertEquals(0.0, pp.getDx(), EPSILON);
		assertEquals(1.0, pp.getDy(), EPSILON);

	}

	@Test
	public void testSetDirection2() {
		p2.setDirection(1, 1);
		assertEquals(1.0, p2.getDx(), EPSILON);
		assertEquals(1.0, p2.getDy(), EPSILON);

	}

	@Test
	public void testGravity() {
		p2.setGravity(1);
		p2.setDirection(1, 1);
		p2.update();
		assertEquals(2.0, p2.getDy(), EPSILON);
	}

	@Test
	public void ballisticTest() {
		assertEquals(true, pp.isBallistic());
	}

	@Test
	public void platformSetDir() {
		plane.setDirection(2, 3);
		assertEquals(2, plane.getDx(), EPSILON);
		assertEquals(3, plane.getDy(), EPSILON);
	}

	@Test
	public void platformChildren() {
		plane.addChild(ee);
		plane.addChild(e2);
		assertEquals(plane.getChildren().size(), 2);

	}

	@Test
	public void platformDeleteChild() {
		plane.addChild(ee);
		assertEquals(plane.getChildren().size(), 1);
		ee.markForDeletion();
		plane.deleteMarkedChildren();
		assertEquals(plane.getChildren().size(), 0);

	}

	@Test
	public void platformLocation() {
		plane.setDirection(1, 1);
		plane.update();
		assertEquals(2, plane.getX(), EPSILON);
		assertEquals(2, plane.getY(), EPSILON);
	}

	@Test
	public void platformBounds() {
		plane.setBounds(1, 6);
		plane.setDirection(4, 0);
		plane.update();
		assertEquals(-4, plane.getDx(), EPSILON);
		assertEquals(5, plane.getX(), EPSILON);

	}

	@Test
	public void enemyTests() {
		ee.setDirection(1, 10);
		assertEquals(1, ee.getDx(), EPSILON);
		assertEquals(10, ee.getDy(), EPSILON);
		ee.update();
		ee.update();
		assertEquals(2, ee.getX());
		assertEquals(20, ee.getY());
	}

	@Test
	public void enemyTests2() {
		ee.setDirection(1, 10);
		assertEquals(1, ee.getDx(), EPSILON);
		assertEquals(10, ee.getDy(), EPSILON);
		ee.update();
		ee.update();
		assertEquals(2, ee.getX());
		assertEquals(20, ee.getY());
		plane.setDirection(2, 2);
		plane.setBounds(1, 6);
		plane.addChild(ee);
		ee.update();
		assertEquals(-1, ee.getDx(), EPSILON);
		assertEquals(2, ee.getX(), EPSILON);

	}

	@Test
	public void enemyTest3() {
		Enemy e = new Enemy(100, 0, 10, 10, null);
		e.setBounds(90, 120);
		e.setDirection(15, 0);
		e.update();
		assertEquals(110, e.getX());
		assertEquals(-15, e.getDx(), EPSILON);
		e.update();
		e.update();
		assertEquals(90, e.getX());
		assertEquals(15, e.getDx(), EPSILON);

	}

	@Test
	public void platformTest1() {
		Platform p = new Platform(0, 100, 50, 10, null);
		Enemy e = new Enemy(25, 90, 10, 10, null);
		p.addChild(e);
		e.setDirection(-30, 0);
		p.update();
		assertEquals(0, e.getX());
		assertEquals(30, e.getDx(), EPSILON);
		p.update();
		p.update();
		assertEquals(40, e.getX());
		assertEquals(-30, e.getDx(), EPSILON);
	}

	// Explosion Class Tests
	@org.junit.Test
	public void getCount0() {
		Explosion exp = new Explosion(1, 1, 1, 1, new demo.ExplosionRenderer(10, Color.RED, Color.black), 10);
		exp.update();
		equals(exp.getCount() == 9);
	}

	@org.junit.Test
	public void getCount1() {
		Explosion exp = new Explosion(1, 1, 1, 1, new demo.ExplosionRenderer(10, Color.RED, Color.black), 10);
		exp.update();
		exp.update();
		equals(exp.getCount() == 8);
	}

	@org.junit.Test
	public void explosionMarkForDeletion() {
		Explosion exp = new Explosion(1, 1, 1, 1, new demo.ExplosionRenderer(10, Color.RED, Color.black), 10);
		for (int i = 0; i < 10; i++) {
			exp.update();
		}
		equals(exp.shouldDelete());
	}

	@org.junit.Test
	public void explosionMarkForDeletionFalse() {
		Explosion exp = new Explosion(1, 1, 1, 1, new demo.ExplosionRenderer(10, Color.RED, Color.black), 10);
		for (int i = 0; i < 9; i++) {
			exp.update();
		}
		equals(!exp.shouldDelete());
	}

	// Projectile Class Tests
	@org.junit.Test
	public void ballistic0() {
		Projectile proj = new Projectile(1, 1, 1, 1, new demo.ExplosionRenderer(10, Color.RED, Color.black));
		proj.setBallistic(true);
		equals(proj.isBallistic());
	}

	@org.junit.Test
	public void ballistic1() {
		Projectile proj = new Projectile(1, 1, 1, 1, new demo.ExplosionRenderer(10, Color.RED, Color.black));
		proj.setBallistic(false);
		equals(!proj.isBallistic());
	}

	@org.junit.Test
	public void updateTest0() {
		Projectile proj = new Projectile(1, 1, 1, 1, new demo.ExplosionRenderer(10, Color.RED, Color.black));
		proj.setDirection(2, 2);
		proj.setGravity(20);
		proj.update();
		equals(proj.getX() == 3 && proj.getY() == 23);
	}

	@org.junit.Test
	public void updateTest1() {
		Projectile proj = new Projectile(1, 1, 1, 1, new demo.ExplosionRenderer(10, Color.RED, Color.black));
		proj.setDirection(2, 2);
		proj.setGravity(20);
		proj.update();
		proj.update();
		equals(proj.getX() == 5 && proj.getY() == 45);
	}

	@org.junit.Test
	public void setDirectionTest0() {
		Projectile proj = new Projectile(1, 1, 1, 1, new demo.ExplosionRenderer(10, Color.RED, Color.black));
		proj.setBallistic(true);
		proj.setDirection(4, 4);
		equals(proj.getDx() == 1 && proj.getDy() == 4);
	}

	@org.junit.Test
	public void setDirectionTest1() {
		Projectile proj = new Projectile(1, 1, 1, 1, new demo.ExplosionRenderer(10, Color.RED, Color.black));
		proj.setBallistic(true);
		proj.setDirection(4, 4);
		equals(proj.getDx() == 4 && proj.getDy() == 4);
	}
	
	private Platform p = new Platform(100.0, 120.0, 50, 10, null);

	private Enemy e = new Enemy(100.0, 110.0, 10, 10, null);

	private Rectangle rightP = new Rectangle(100, 120, 50, 10);

	private Rectangle rightE = new Rectangle(100, 110, 10, 10); 
	
	public void setup()
	{
		p.addChild(e);
		for(int i=0; i<10; i+=1)
		{
			p.update();
		}
		p.setDirection(2.0, 4.0);
		p.setBounds(70.0, 130.0);
		e.setDirection(1.0, 3.0);
	}
	
	@Test
	public void testGet()
	{
		setup();
		//Platform
		assertEquals(10, p.getTicks());
		assertEquals(100, p.getX());
		assertEquals(100.0, p.getXExact(), EPSILON);
		assertEquals(120, p.getY());
		assertEquals(120.0, p.getYExact(), EPSILON);
		assertEquals(50, p.getWidth());
		assertEquals(10, p.getHeight());
		assertEquals(rightP, p.getRect());
		assertEquals(2.0, p.getDx(), EPSILON);
		assertEquals(4.0, p.getDy(), EPSILON);

		//Enemy
		assertEquals(10, e.getTicks());
		assertEquals(100, e.getX());
		assertEquals(100.0, e.getXExact(), EPSILON);
		assertEquals(110, e.getY());
		assertEquals(110.0, e.getYExact(), EPSILON);
		assertEquals(10, e.getWidth());
		assertEquals(10, e.getHeight());
		assertEquals(rightE, e.getRect());
		assertEquals(1.0, e.getDx(), EPSILON);
		assertEquals(3.0, e.getDy(), EPSILON);
	}

	@Test
	public void testDirection()
	{	
		setup();
		//reset
		p.setDirection(0.0, 0.0);
		e.setDirection(0.0, 0.0);
		p.setBounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		p.setPosition(100.0, 120.0);
		e.setPosition(100.0, 110.0);
		p.update();

		p.setDirection(2.0, 0.0);
		for(int i=0; i<5; i+=1)
		{
			p.update();
		}
		assertEquals(110.0, p.getXExact(), EPSILON);
		assertEquals(120.0, p.getYExact(), EPSILON);

		//reset
		p.setDirection(0.0, 0.0);
		e.setDirection(0.0, 0.0);
		p.setBounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		p.setPosition(100.0, 120.0);
		e.setPosition(100.0, 110.0);
		p.update();
		
		p.setBounds(90.0, 160.0);
		p.setDirection(2.0, 0.0);
		for(int i=0; i<7; i+=1)
		{
			p.update();
		}
		assertEquals(106.0, p.getXExact(), EPSILON);
		assertEquals(106.0, e.getXExact(), EPSILON);
		
		//reset
		p.setDirection(0.0, 0.0);
		e.setDirection(0.0, 0.0);
		p.setBounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		p.setPosition(100.0, 120.0);
		e.setPosition(100.0, 110.0);
		p.update();		
		
		p.setBounds(50.0, 200.0);
		e.setPosition(105.0, 110.0);
		e.setDirection(3.0, 0.0);
		for(int i=0; i<10; i+=1)
		{
			p.update();
		}
		assertEquals(135.0, e.getXExact(), EPSILON);
		
		//reset
		p.setDirection(0.0, 0.0);
		e.setDirection(0.0, 0.0);
		p.setBounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		p.setPosition(100.0, 120.0);
		e.setPosition(100.0, 110.0);
		p.update();
		
		p.setBounds(100.0, 200.0);
		p.setDirection(2.0, 0.0);
		for(int i=0; i<5; i+=1)
		{
			p.update();
		}
		assertEquals(110.0, p.getXExact(), EPSILON);
		
		//reset
		p.setDirection(0.0, 0.0);
		e.setDirection(0.0, 0.0);
		p.setBounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		p.setPosition(100.0, 120.0);
		e.setPosition(100.0, 110.0);
		p.update();
		
		p.setBounds(50.0, 200.0);
		e.setPosition(140.0, 110.0);		
		p.setDirection(-3.0, 0.0);
		e.setDirection(-2.0, 0.0);	
		for(int i=0; i<14; i+=1)
		{
			p.update();
		}
		assertEquals(58.0, p.getXExact(), EPSILON);
		assertEquals(70.0, e.getXExact(), EPSILON);
		
		//reset
		p.setDirection(0.0, 0.0);
		e.setDirection(0.0, 0.0);
		p.setBounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		p.setPosition(100.0, 120.0);
		e.setPosition(100.0, 110.0);
		p.update();
		
		p.setBounds(50.0, 200.0);
		p.setDirection(5.0, 0);
		for(int i=0; i<33; i+=1)
		{
			p.update();
		}
		assertEquals(65.0, p.getXExact(), EPSILON);
		assertEquals(65.0, e.getXExact(), EPSILON);
		
		//reset
		p.setDirection(0.0, 0.0);
		e.setDirection(0.0, 0.0);
		p.setBounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		p.setPosition(100.0, 120.0);
		e.setPosition(100.0, 110.0);
		p.update();
	}


	@Test
	public void testChildren()
	{
		setup();
		Enemy e2 = new Enemy(120.0, 110.0, 10, 10, null);
		Enemy e3 = new Enemy(140.0, 110.0, 10, 10, null);
		p.addChild(e2);
		p.addChild(e3);
		
		//reset
		p.setDirection(0.0, 0.0);
		e.setDirection(0.0, 0.0);
		p.setBounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		p.setPosition(100.0, 120.0);
		e.setPosition(100.0, 110.0);
		e2.setPosition(120.0, 110.0);
		e3.setPosition(140.0, 110.0);
		p.update();
		
		p.setDirection(10.0, 0.0);
		p.update();
		p.update();
		assertEquals(120.0, e.getXExact(), EPSILON);
		assertEquals(140.0, e2.getXExact(), EPSILON);
		assertEquals(160.0, e3.getXExact(), EPSILON);
		
		//reset
		p.setDirection(0.0, 0.0);
		e.setDirection(0.0, 0.0);
		p.setBounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		p.setPosition(100.0, 120.0);
		e.setPosition(100.0, 110.0);
		e2.setPosition(120.0, 110.0);
		e3.setPosition(134.0, 110.0);
		p.update();
		
		p.setDirection(10.0, 0.0);
		e.setDirection(1.0, 0.0);
		e2.setDirection(2.0, 0.0);
		e3.setDirection(3.0, 0.0);
		p.update();
		p.update();
		assertEquals(122.0, e.getXExact(), EPSILON);
		assertEquals(144.0, e2.getXExact(), EPSILON);
		assertEquals(160.0, e3.getXExact(), EPSILON);	
	}
	
	@Test
	public void deletionTest() {
		Platform p = new Platform(0, 0, 0, 0, null);
		Enemy e1 = new Enemy(0, 0, 0, 0, null);
		p.addChild(e1);
		Enemy e2 = new Enemy(0, 0, 0, 0, null);
		p.addChild(e2);
		ArrayList<Enemy> children = p.getChildren();
		assertTrue(children.contains(e1));
		assertTrue(children.contains(e2));
		e1.markForDeletion();
		p.deleteMarkedChildren();
		children = p.getChildren();
		assertFalse(children.contains(e1));
		assertTrue(children.contains(e2));
	}

}