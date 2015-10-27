package hw2;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;



public class UnitTesting {
	
    
    @Before
    public void setup()
    {
    	
    }
    
    @Test 
    public void testFindNextNonemptycell()
    {
    	String msg="The next non empty from index 1 is 3 in 2, 0, 0, 4, 0, 2";
    	int[] testArr ={2, 0, 0, 4, 0, 2};
    	int test=GameUtil.findNextNonemptyCell(testArr,1);
    	assertEquals(msg, 3, test);
    }
    
    @Test 
    public void testFindNextNonemptycellLast()
    {
    	String msg="The next non empty from index 5 is 5 in 2, 0, 0, 4, 0, 2";
    	int[] testArr ={2, 0, 0, 4, 0, 2};
    	int test=GameUtil.findNextNonemptyCell(testArr,5);
    	assertEquals(msg, 5, test);
    }
    
    @Test 
    public void testFindNextNonemptycellOnFilledCell()
    {
    	String msg="The next non empty from index 0 is 1 in 2, 0, 0, 4, 0, 2";
    	int[] testArr ={2, 0, 0, 4, 0, 2};
    	int test=GameUtil.findNextNonemptyCell(testArr,0);
    	assertEquals(msg, 3, test);
    }
    
    @Test
    public void testCollapseArrayNoCombine()
    {
    	String msg="Array  [2, 0, 0, 4, 0, 2] should return [2, 4, 2, 0, 0, 0]";
    	int[] testArr ={2, 0, 0, 4, 0, 2};
    	int[] compareArr={2, 4, 2, 0, 0, 0};
    	assertEquals(msg, compareArr, GameUtil.collapseArray(testArr));
    }
    
    @Test
    public void testCollapseArrayCombine()
    {
    	String msg="Array [2, 0, 2, 4, 0, 4] should return  [4, 8, 0, 0, 0, 0]";
    	int[] testArr ={2, 0, 2, 4, 0, 4};
    	int[] compareArr={4, 8, 0, 0, 0, 0};
    	assertEquals(msg, compareArr, GameUtil.collapseArray(testArr));
    }

    @Test
    public void testCollapseArrayCombineOrder()
    {
    	String msg="Array [0, 2, 2, 2, 0, 0] should return  [4, 2, 0, 0, 0, 0]";
    	int[] testArr ={0, 2, 2, 2, 0, 0};
    	int[] compareArr={4, 2, 0, 0, 0, 0};
    	assertEquals(msg, compareArr, GameUtil.collapseArray(testArr));
    }
    
    @Test
    public void testCollapseArrayFull()
    {
    	String msg="Array [2, 2, 2, 2, 2, 0] should return  [4, 4, 2, 0, 0, 0]";
    	int[] testArr ={2, 2, 2, 2, 2, 0};
    	int[] compareArr={4, 4, 2, 0, 0, 0};
    	assertEquals(msg, compareArr, GameUtil.collapseArray(testArr));
    }
    
}
