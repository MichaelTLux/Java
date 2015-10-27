package hw2;

import java.util.ArrayList;

import api.Move;

/**
 * Utility class containing the basic logic for performing moves in a
 * game of 2048.  All methods operate on a one-dimensional array
 * of integers representing the tiles.  A cell with zero is referred to
 * as "empty" and a nonzero cell is "nonempty".  Tiles are only collapsed
 * to the left; that is, tiles that are moved or merged can only move to the 
 * left.  The Game class can use these methods to collapse a row or column
 * in any direction by copying that row or column, forward or backward,
 * into a temporary one-dimensional array.
 */
public class GameUtil
{
  /**
   * Returns the index of the first nonempty cell that is on or after the 
   * given index <code>start</code>, or -1 if there is none.
   * @param arr
   *   given array
   * @param start
   *   index at which to start looking 
   * @return
   *   index of the first nonempty cell, or -1 if none is found
   */
  public static int findNextNonemptyCell(int[] arr, int start)
  {
	  //this makes sure the programs stays in bounds
	  if (start>=arr.length)
	  {
		  return -1;
	  }
	  
	  //starting one past the start find something that isn't zero
	  for (int currentIndex=start; currentIndex<arr.length; currentIndex=currentIndex+1)
	  {
		  if (arr[currentIndex]!=0)
		  {
			  return currentIndex;
		  }
	  }
	  
	//for error checking and it gets mad without it
    return -1;
  }
  
  /**
   *  Given an array and a starting index, finds a move that
   *  would merge or move a tile to that index, if such a move 
   *  exists. This method does not modify the array.  The returned Move object
   *  will have unspecified row/column and direction.  If there is no move
   *  to the given index, returns null.  This method is not required to 
   *  examine cells to the left of <code>index</code>.  
   *  
   *  The logic of this method can be described as follows:
   *  <pre>
   *  if cell at index is occupied (nonzero)
   *      find next occupied cell c to the right of 'index'
   *      if there is one and it is the same value
   *            create a move to merge c with cell at 'index'
   *  else
   *      find next occupied cell c to the right of 'index'
   *      if there is one
   *           find next occupied cell c2 to the right of c
   *           if there is one, and if they are the same value
   *                create a move to merge c and c2 into cell at index
   *           else
   *                create a move that just moves c to 'index'
   *  return the move
   *  
   *  </pre>
   * @param arr
   *   array in which to search for move
   * @param index
   *   index for destination of move
   * @return  
   *   Move object describing the move, or null if there is no move
   */
  public static Move findNextMove(int[] arr, int index)
  {
	  
	  //if the number is zero, check the next two numbers
	  if (arr[index]==0)
	  {
		  int nextNumber=findNextNonemptyCell(arr, index+1);
		  int followingNumber=findNextNonemptyCell(arr, nextNumber+1);
		  //if those next two number are the same return a move with there indexes and the zero's index and an increased value and check for "-1" errors
		  if (!(nextNumber==-1) && !(followingNumber==-1) && arr[nextNumber]==arr[followingNumber])
		  {
			  int value=arr[followingNumber];
			  Move move= new Move(nextNumber, followingNumber, index, value);
			  return move;
		  }
		  //if those two numbers are different only return the index of the first number after zero and its value checking for error "-1"
		  else if (!(nextNumber==-1))
		  {
			  int value=arr[nextNumber];
			  Move move=new Move(nextNumber, index, value);
			  return move;
		  }
	  }
	  
	  //if the number is not zero
	  {
		  int nextNumber=findNextNonemptyCell(arr, index+1);
		  
		  //if the next two number are the same return a move with there indexes and an increased value checking for error "-1"
		  if (!(nextNumber==-1) && arr[index]==arr[nextNumber])
		  {
			  int value=arr[index];
			  Move move= new Move(index, nextNumber, index, value);
			  return move;
		  }
	  }
	  
	  //only should run if not a zero or if a nonzero doesn't have a match following
	  return null;
  }

  
  /**
   * Updates the array according to the given Move.  This
   * method is not required to check whether the given Move describes
   * a move or merge that is correct in the given array.
   * @param arr
   *   given array to be modified
   * @param move
   *   the move to be applied to the array
   */
  public static void applyOneMove(int[] arr, Move move)
  {
    if (move.isMerged())
    {
    	int value=move.getValue()*2;
    	arr[move.getOldIndex()]=0;
    	arr[move.getOldIndex2()]=0;
    	arr[move.getNewIndex()]=value;
    }
    else
    {
    	arr[move.getNewIndex()]=move.getValue();
    	arr[move.getOldIndex()]=0;
    }
  }
  

  /**
   * Collapses the array to the left by performing a sequence of moves, 
   * and returns a list of moves that were performed.  All of the 
   * returned Move objects will have unspecified row/column and direction.
   * <p>
   * The idea is to iterate over the array indices from left to right, 
   * finding a move to that index and (if one exists) applying it to the array.
   * Note that according to this logic, moves do not "cascade": once a cell is merged 
   * with another cell, the resulting cell is not merged again during this operation.  
   * For example, when this method is applied to the array [2, 2, 4], the end result 
   * is [4, 4, 0], not [8, 0, 0].
   * @param arr
   *   array to be collapsed
   * @return
   *   list of all moves performed in the collapse
   */
  public static ArrayList<Move> collapseArray(int[] arr)
  {
    //Iterate over the whole array
	ArrayList<Move> returning= new ArrayList<Move>();
	for (int index=0; index<arr.length; index=index+1)
    {
    	Move move= findNextMove(arr, index);
    	if (move!=null)
    	{
    		returning.add(move);
    		applyOneMove(arr, move);
    	}
    	
    }
    return returning;
  }
  
  

  
  
}
