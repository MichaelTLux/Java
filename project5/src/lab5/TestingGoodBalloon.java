package lab5;

import balloon.Balloon;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TestingGoodBalloon {

    Balloon b10;
    
    @Before
    public void setup()
    {
    	b10=new Balloon(10);
    }
    
    @Test
    public void testContructRadius()
    {
    	String msg="A newly contructed balloon should have a radius of zero.";
    	assertEquals(msg, 0, b10.getRadius());
    }
    
    @Test
    public void testContructIsPopped()
    {
    	String msg="A newly contructed balloon should not be popped.";
    	assertFalse(msg, b10.isPopped());
    }
    
    @Test
    public void testContruct()
    {
    	String msg="A newly contructed balloon should have a radius of zero.";
    	assertEquals(msg, 0, b10.getRadius());
    }
    
    @Test
    public void testBlowNotPopRadius()
    {
    	String msg="A newly contructed balloon should have a radius of 9 after blow(9).";
    	b10.blow(9);
    	assertEquals(msg, 9, b10.getRadius());
    }
    
    @Test
    public void testBlowNotPopIsPopped()
    {
    	String msg="A newly contructed balloon should not be popped after blow(9).";
    	b10.blow(9);
    	assertFalse(msg, b10.isPopped());
    }
    
    @Test
    public void testBlowPopRadius()
    {
    	String msg="A newly contructed balloon should have a radius of 0 after blow(11).";
    	b10.blow(11);
    	assertEquals(msg, 0, b10.getRadius());
    }
    
    @Test
    public void testBlowPopIsPopped()
    {
    	String msg="A newly contructed balloon should be popped after blow(11).";
    	b10.blow(11);
    	assertTrue(msg, b10.isPopped());
    }
    
    @Test
    public void testBlowIfPopped()
    {
    	String msg="A newly contructed balloon should not inflate if popped";
    	b10.pop();
    	b10.blow(5);
    	assertEquals(msg, 0, b10.getRadius());
    }
    
    @Test
    public void testBlowUseTwice()
    {
    	String msg="A newly contructed balloon should have a radius of 9 after blow(5) & blow(4).";
    	b10.blow(5);
    	b10.blow(4);
    	assertEquals(msg, 9, b10.getRadius());
    }
    
    @Test
    public void testDeflateIsPopped()
    {
    	String msg="A newly contructed ballon that is inflated then deflated not should be popped";
    	b10.blow(5);
    	b10.deflate();
    	assertFalse(msg, b10.isPopped());
    }
    
    @Test
    public void testDeflatedRadius()
    {
    	String msg="A newly contructed ballon that is inflated then deflated not should have a radius of zero";
    	b10.blow(5);
    	b10.deflate();
    	assertEquals(msg, 0 ,b10.getRadius());
    }
    
    

}
