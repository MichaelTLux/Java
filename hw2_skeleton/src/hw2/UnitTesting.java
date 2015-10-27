package hw2;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import api.Move;



public class UnitTesting {
	
    
    @Before
    public void setup()
    {
    	
    }
    
//Testing FindNextNonemptyCell
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
    	String msg="The next non empty from index 5 is non-existant so '-1' in 2, 0, 0, 4, 0, 2";
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
    	assertEquals(msg, 0, test);
    }
    
    @Test 
    public void testFindNextNonemptycellNone()
    {
    	String msg="The next non empty from index 0 is non-existant so '-1' in 0, 0, 0, 0, 0, 0";
    	int[] testArr ={0, 0, 0, 0, 0, 0};
    	int test=GameUtil.findNextNonemptyCell(testArr,5);
    	assertEquals(msg, -1, test);
    }
    
//Testing the FindNextMove
    @Test
    public void testFindNextMoveNoMove()
    {
    	String msg="The next move should be a null when index is 0 on a {2, 0, 0, 4, 0, 2}";
    	int[] testArr ={2, 0, 0, 4, 0, 2};
    	Move move= GameUtil.findNextMove(testArr, 0);
    	assertEquals(msg, null, move);
    }
    
    @Test
    public void testFindNextMoveNoSecondNumber()
    {
    	String msg="The next move should be a move 4 when index is 0 on a {0, 0, 0, 4, 0, 0}";
    	int[] testArr ={0, 0, 0, 4, 0, 0};
    	Move move= GameUtil.findNextMove(testArr, 0);
    	Move comparedMove= new Move(3,0,4);
    	assertEquals(msg, comparedMove, move);
    }
    
    @Test
    public void testFindNextMoveNoNumbers()
    {
    	String msg="The next move should be a null when index is 0 on a {0, 0, 0, 0, 0, 0}";
    	int[] testArr ={0, 0, 0, 0, 0, 0};
    	Move move= GameUtil.findNextMove(testArr, 0);
    	assertEquals(msg, null, move);
    }
    
    @Test
    public void testFindNextMoveNoNumbersAfter()
    {
    	String msg="The next move should be a null when index is 0 on a {4, 0, 0, 0, 0, 0}";
    	int[] testArr ={4, 0, 0, 0, 0, 0};
    	Move move= GameUtil.findNextMove(testArr, 0);
    	assertEquals(msg, null, move);
    }
    
    @Test
    public void testFindNextMoveZeroMove()
    {
    	String msg="The next move should be a move 4 when index is 1 on a {2, 0, 0, 4, 0, 2}";
    	int[] testArr ={2, 0, 0, 4, 0, 2};
    	Move testMove= GameUtil.findNextMove(testArr, 1);
    	Move compareMove= new Move(3,1,4);
    	assertEquals(msg, compareMove, testMove);
    }
    
    @Test
    public void testFindNextMoveCombineMoveFromZero()
    {
    	String msg="The next move should be a move 4 when index is 1 one a {2, 0, 2, 2, 0, 2}";
    	int[] testArr ={2, 0, 2, 2, 0, 2};
    	Move testMove= GameUtil.findNextMove(testArr, 1);
    	Move compareMove= new Move(2,3,1,2);
    	assertEquals(msg, compareMove, testMove);
    }
    
    @Test
    public void testFindNextMoveCombineMove()
    {
    	String msg="The next move should be a move 4 when index is 1 one a {4, 0, 0, 4, 0, 2}";
    	int[] testArr ={4, 0, 0, 4, 0, 2};
    	Move testMove= GameUtil.findNextMove(testArr, 0);
    	Move compareMove= new Move(0,3,0,4);
    	assertEquals(msg, compareMove, testMove);
    }
    
    
//someone else's tests
	@Test
	public void testFindNextNonEmptyCell(){
		//findNextNonemptyCell returns non-empty cell ON or AFTER given index.
		int[] array = {2,0,0,2,4,0};
		assertEquals(0,GameUtil.findNextNonemptyCell(array, 0));
		assertEquals(3,GameUtil.findNextNonemptyCell(array, 1));
		assertEquals(-1,GameUtil.findNextNonemptyCell(array, 5));
		assertEquals(-1,GameUtil.findNextNonemptyCell(array, 39));
	}
	
	@Test
	public void testFindNextMove(){
		int[] array = {2,0,0,2,4,0};
		int oldIndex=0,oldIndex2=3,newIndex=0,value=2;
		Move m = new Move(oldIndex,oldIndex2,newIndex,value);
		Move nextMove = GameUtil.findNextMove(array, 0);
		assertEquals(oldIndex,nextMove.getOldIndex());
		assertEquals(oldIndex2,nextMove.getOldIndex2());
		assertEquals(newIndex,nextMove.getNewIndex());
		assertEquals(value,nextMove.getValue());
	}
	
	@Test
	public void testFindNextMove2(){
		int[] array = {0,0,2,2,4,0};
		int oldIndex=2,oldIndex2=3,newIndex=0,value=2;
		Move m = new Move(oldIndex,oldIndex2,newIndex,value);
		Move nextMove = GameUtil.findNextMove(array, 0);
		assertEquals(oldIndex,nextMove.getOldIndex());
		assertEquals(oldIndex2,nextMove.getOldIndex2());
		assertEquals(newIndex,nextMove.getNewIndex());
		assertEquals(value,nextMove.getValue());
	}
	
	@Test
	public void testFindNextMove3(){
		int[] array = {0,0,2,4,8,0};
		int oldIndex=2,newIndex=0,value=2;
		Move m = new Move(oldIndex,newIndex,value);
		Move nextMove = GameUtil.findNextMove(array, 0);
		assertEquals(oldIndex,nextMove.getOldIndex());
		assertEquals(newIndex,nextMove.getNewIndex());
		assertEquals(value,nextMove.getValue());
	}
	
	@Test
	public void testFindNextMove4(){
		int[] array = {2,0,4,0,8,0};
		Move nextMove = GameUtil.findNextMove(array, 0);
		//null because there isn't any move.
		assertEquals(null,nextMove);
	}
	
	@Test
	public void testApplyOneMove(){
		int[] array = {2,0,2,2,0,0};
		int[] after = {4,0,0,2,0,0};
		Move nextMove = GameUtil.findNextMove(array, 0);
		GameUtil.applyOneMove(array, nextMove);
		for(int i=0; i<array.length; i++)
			assertEquals(after[i],array[i]);
	}
	
	@Test
	public void testApplyOneMove2(){
		int[] array = {0,0,4,4,0,2};
		int[] after1 = {8,0,0,0,0,2};
		Move nextMove = GameUtil.findNextMove(array, 0);
		GameUtil.applyOneMove(array, nextMove);
		for(int i=0; i<array.length; i++)
			assertEquals(after1[i],array[i]);
		
		int[] after2 = {8,2,0,0,0,0};
		nextMove = GameUtil.findNextMove(array, 1);
		GameUtil.applyOneMove(array, nextMove);
		for(int i=0; i<array.length; i++)
			assertEquals(after2[i],array[i]);
	}
	
	@Test
	public void testCollapseArray0(){
		int[] array = {2,2,4};
		int[] after = {4,4,0};
		GameUtil.collapseArray(array);
		for(int i=0; i<array.length; i++)
			assertEquals(after[i],array[i]);
	}
	
	@Test
	public void testCollapseArray(){
		int[] array = {0,0,4,4,0,2};
		int[] after = {8,2,0,0,0,0};
		GameUtil.collapseArray(array);
		for(int i=0; i<array.length; i++)
			assertEquals(after[i],array[i]);
	}
	
	@Test
	public void testCollapseArray2(){
		int[] array = {0,0,2,4,4,16};
		int[] after = {2,8,16,0,0,0};
		GameUtil.collapseArray(array);
		for(int i=0; i<array.length; i++)
			assertEquals(after[i],array[i]);
	}
	
	@Test
	public void testCollapseArray3(){
		int[] array = {0,0,2,4,8,16};
		int[] after = {2,4,8,16,0,0};
		GameUtil.collapseArray(array);
		for(int i=0; i<array.length; i++)
			assertEquals(after[i],array[i]);
	}
    
    
    
    
    
    
    
    
    
    
    
    
//Testing the collapseArray function    
    @Test
    public void testCollapseArrayNoCombine()
    {
    	int[] testArr ={2, 0, 0, 4, 0, 2};
    	int[] compareArr={2, 4, 2, 0, 0, 0};
    	GameUtil.collapseArray(testArr);
    	for(int i=0; i<testArr.length; i++)
			assertEquals(testArr[i],compareArr[i]);
    }
    
    @Test
    public void testCollapseArrayCombine()
    {
    	int[] testArr ={2, 0, 2, 4, 0, 4};
    	int[] compareArr={4, 8, 0, 0, 0, 0};
    	GameUtil.collapseArray(testArr);
    	for(int i=0; i<testArr.length; i++)
			assertEquals(testArr[i],compareArr[i]); 	
    }

    @Test
    public void testCollapseArrayCombineOrder()
    {
    	int[] testArr ={0, 2, 2, 2, 0, 0};
    	int[] compareArr={4, 2, 0, 0, 0, 0};
    	GameUtil.collapseArray(testArr);
    	for(int i=0; i<testArr.length; i++)
			assertEquals(testArr[i],compareArr[i]);
    }
    
    @Test
    public void testCollapseArrayFull()
    {
    	int[] testArr ={2, 2, 2, 2, 2, 0};
    	int[] compareArr={4, 4, 2, 0, 0, 0};
    	GameUtil.collapseArray(testArr);
    	for(int i=0; i<testArr.length; i++)
			assertEquals(testArr[i],compareArr[i]);
    }
    
}
