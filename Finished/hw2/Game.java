package hw2;
import java.util.ArrayList;
import java.util.Random;

import api.Direction;
import api.Move;
import api.Result;
import api.TilePosition;

/**
 * The Game class contains the state and logic for an implementation of the
 * game 2048.  The basic underlying state is an n by n grid of tiles, 
 * represented by integer values.  A zero in a cell is considered to be
 * "empty", and all other cells contain some power of two.  The game is played
 * by calling the method <code>collapse()</code>, selecting one of the four
 * directions (LEFT, RIGHT, UP, DOWN). Each row or column is then collapsed
 * according to the algorithm described in the methods of <code>GameUtil</code>.
 * <p>
 * Whenever two cells are <em>merged</em>, the score is increased by the 
 * combined value of the two cells.
 * @author Michael Lux
 */
public class Game
{
	/**
	 * This is the random generator object to choose the location of the next tile
	 */
	private Random rand;
	
	/**
	 * this is the grid in which all of the actions take place
	 */
	private int[][] gameGrid;
	
	/**
	 * this is the score of the current game
	 */
	private int score;
  
  /**
   * Constructs a game with a grid of the given size, using a default
   * random number generator.  Initially there should be two
   * nonempty cells in the grid selected by the method <code>generate()</code>.
   * @param givenSize
   *   size of the grid for this game
   */
  public Game(int givenSize)
  {
	rand= new Random();
	gameGrid= new int[givenSize][givenSize];
	score=0;
	TilePosition a=generate();
	setCell(a.getRow(), a.getCol(), a.getValue());
	TilePosition b=generate();
	setCell(b.getRow(), b.getCol(), b.getValue());	
  }
  
  /**
   * Constructs a game with a grid of the given size, using the given
   * instance of <code>Random</code> for the random number generator.
   * Initially there should be two nonempty cells in the grid selected 
   * by the method <code>generate()</code>.
   * @param givenSize
   *   size of the grid for this game
   * @param givenRandom
   *   given instance of Random
   */
  public Game(int givenSize, Random givenRandom)
  {
	  rand=givenRandom;
	  gameGrid= new int[givenSize][givenSize];
	  score=0;
	TilePosition a=generate();
	setCell(a.getRow(), a.getCol(), a.getValue());
	TilePosition b=generate();
	setCell(b.getRow(), b.getCol(), b.getValue());		
  }
  
   /**
   * Returns the value in the cell at the given row and column.
   * @param row
   *   given row
   * @param col
   *   given column
   * @return
   *   value in the cell at the given row and column
   */
  public int getCell(int row, int col)
  {
        return gameGrid[row][col];
  }
  
  /**
   * Returns the size of this game's grid.
   * @return
   *   size of the grid
   */
  public int getSize()
  {
    return gameGrid.length;
  }
  
  /**
   * Returns the current score.
   * @return
   *   score for this game
   */
  public int getScore()
  {
    return score;
  }

  /**
   * Copy a row or column from the grid into a new one-dimensional array.  
   * There are four possible actions depending on the given direction:
   * <ul>
   *   <li>LEFT - the row indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array from left to right
   *   <li>RIGHT - the row indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array in reverse (from right to left)
   *   <li>UP - the column indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array from top to bottom
   *   <li>DOWN - the column indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array in reverse (from bottom to top)
   * </ul>
   * @param rowOrColumn
   *   index of the row or column
   * @param dir
   *   direction from which to begin copying
   * @return
   *   array containing the row or column
   */
  public int[] copyRowOrColumn(int rowOrColumn, Direction dir)
  {
    //TODO
	  int jndex=0;
	  int [] returnArr= new int[getSize()];
	  
	  if (dir==api.Direction.LEFT)
	  {
		  for (int index=0; index<getSize(); index=index+1)
		  {
			  returnArr[index]=getCell(rowOrColumn, index);
		  }
	  }
	  if (dir==api.Direction.RIGHT)
	  {
		  for (int index=getSize()-1; index>=0; index=index-1)
		  {
			  returnArr[jndex]=getCell(rowOrColumn, index);
			  jndex=jndex+1;
		  }  
	  }
	  if (dir==api.Direction.UP)
	  {
		  for (int index=0; index<getSize(); index=index+1)
		  {
			  returnArr[index]=getCell(index, rowOrColumn);
		  } 
	  }
	  if (dir==api.Direction.DOWN)
	  {
		  for (int index=getSize()-1; index>=0; index=index-1)
		  {
			  returnArr[jndex]=getCell(index, rowOrColumn);
			  jndex=jndex+1;
		  }
	  }
    return returnArr;
  }
  
  
  // copy from given 1d array into the grid in the given direction at the given row or column index
  /**
   * Updates the grid by copying the given one-dimensional array into
   * a row or column of the grid.
   * There are four possible actions depending on the given direction:
   * <ul>
   *   <li>LEFT - the given array is copied into the the row indicated by the 
   *   index <code>rowOrColumn</code> from left to right
   *   <li>RIGHT - the given array is copied into the the row indicated by the 
   *   index <code>rowOrColumn</code> in reverse (from right to left)
   *   <li>UP - the given array is copied into the column indicated by the 
   *   index <code>rowOrColumn</code> from top to bottom
   *   <li>DOWN - the given array is copied into the column indicated by the 
   *   index <code>rowOrColumn</code> in reverse (from bottom to top)
   * </ul>
   * @param arr
   *   the array from which to copy
   * @param rowOrColumn
   *   index of the row or column
   * @param dir
   *   direction from which to begin copying
   */
  public void updateRowOrColumn(int[] arr, int rowOrColumn, Direction dir)
  {
    // TODO
	  int jndex=0;
	  if (dir==api.Direction.LEFT)
	  {
		  for (int index=0; index<getSize(); index=index+1)
		  {
			  setCell(rowOrColumn, index, arr[index]);
		  }
	  }
	  if (dir==api.Direction.RIGHT)
	  {
		  for (int index=getSize()-1; index>=0; index=index-1)
		  {
			  setCell(rowOrColumn, jndex, arr[index]);
			  jndex=jndex+1;
		  }  
	  }
	  if (dir==api.Direction.UP)
	  {
		  for (int index=0; index<getSize(); index=index+1)
		  {
			  setCell(index, rowOrColumn, arr[index]);
		  } 
	  }
	  if (dir==api.Direction.DOWN)
	  {
		  for (int index=getSize()-1; index>=0; index=index-1)
		  {
			  setCell(jndex, rowOrColumn, arr[index]);
			  jndex=jndex+1;
		  }
	  }
  }

  /**
   * Plays one step of the game by collapsing the grid in the given direction.
   * Returns a <code>Result</code> object containing a list of Move objects describing
   * all moves performed, and a <code>TilePosition</code> object describing
   * the position and value of a newly added tile, if any.  All Move objects must
   * include a valid value for <code>getRowOrColumn()</code> and <code>getDirection()</code>.
   * If no move actually occurs, the returned <code>Result</code> object contains an 
   * empty list and has a null value for the new <code>TilePosition</code>.
   * <p>
   * If any tiles are moved or merged, a new tile is selected according to the 
   * <code>generate()</code> method and is added to the grid.
   * <p>
   * The collapse of an individual row or column must be performed by the 
   * method <code>collapseArray</code> of <code>GameUtil</code>.  
   * 
   * @param dir
   *   direction in which to collapse the grid
   * @return
   *   Result object containing moves and new tile position
   */
  public Result collapse(Direction dir)
  {
    // TODO
	  ArrayList<Move> currentMoveSet= new ArrayList<>();
	  Result result=new Result();
	  for (int index=0; index<getSize();index=index+1)
	  {
		  int[] copied= copyRowOrColumn(index, dir);
		  currentMoveSet= GameUtil.collapseArray(copied);
		  //finish out the arrayList
		  for(int jndex=0; jndex<currentMoveSet.size(); jndex=jndex+1)
		  {
			  currentMoveSet.get(jndex).setDirection(index, dir);
		  }
		  //get a score from the array list
		  for (int jndex=0; jndex<currentMoveSet.size(); jndex=jndex+1)
		  {
			  if (currentMoveSet.get(jndex).isMerged())
			  {
				  score=score+(currentMoveSet.get(jndex).getValue()*2);
			  }
		  }
		  result.addMoves(currentMoveSet);
		  updateRowOrColumn(copied, index, dir);	  
	  }
	  //check if game end
	  if (!(result.getMoves().size()>0))
	  {
			  Result nullResult= new Result();
			  return nullResult;
	  }
	  
	  
	  TilePosition tile=generate();
	  setCell(tile.getRow(), tile.getCol(), tile.getValue());
	  result.setNewTile(tile);
	  
    return result;
  }

  /**
   * Use this game's instance of <code>Random</code> to generate
   * a new tile.  The tile's row and column must be an empty cell
   * of the grid, and the tile's value is either 2 or 4. 
   * The tile is selected in such a way that
   * <ul>
   *   <li>All empty cells of the grid are equally likely
   *   <li>The tile's value is a 2 with 90% probability and a 4 with 10% probability
   * </ul>
   * This method does not modify the grid.  If the grid has no
   * empty cells, returns null.
   * @return
   *   a new TilePosition containing the row, column, and value of the
   *   selected new tile, or null if the grid has no empty cells
   */
  public TilePosition generate()
  {
	boolean flag=false;
	int col=0;
	int row=0;
	int whatNumber=0;
	
	//loop through till flag changes
	while (!flag)
	{	
		col=rand.nextInt(getSize());
		row=rand.nextInt(getSize());
		
		
		//if the location on the grid that was selected is empty, change the flag
		if (getCell(row, col)==0)
		{
			flag=true;
		}
	}
	
	whatNumber=rand.nextInt(10);
	
	//for 90% probability all numbers (0-9 are generated) only 0 is turned into a 4
	if (whatNumber<1)
	{
		whatNumber=4;
	}
	else
	{
		whatNumber=2;
	}
	
	TilePosition returning= new api.TilePosition(row, col, whatNumber);
    return returning;
  }
  
  /**
   * This method set the cell at the row and column given to the value given
   * @param row
   * 	the row of the cell that should be edited
   * @param col
   * 	the column of the cell that should be edited
   * @param value
   * 	the value that it needs to change to
   */
  public void setCell(int row, int col, int value)
  {
	  gameGrid[row][col]=value;
  }
}
  

