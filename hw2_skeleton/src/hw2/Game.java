package hw2;
import java.util.ArrayList;
import java.util.Arrays;
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
 */
public class Game
{
  
  /**
   * Constructs a game with a grid of the given size, using a default
   * random number generator.  Initially there should be two
   * nonempty cells in the grid selected by the method <code>generate()</code>.
   * @param givenSize
   *   size of the grid for this game
   */
  public Game(int givenSize)
  {
    // TODO
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
    // TODO
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
    // TODO
    return 0;
  }
  
  /**
   * Returns the size of this game's grid.
   * @return
   *   size of the grid
   */
  public int getSize()
  {
    // TODO
    return 0;
  }
  
  /**
   * Returns the current score.
   * @return
   *   score for this game
   */
  public int getScore()
  {
    // TODO
    return 0;
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
   *   <li>DOWN - the row indicated by the index <code>rowOrColumn</code> is
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
    // TODO
    return null;
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
    return null;
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
    // TODO
    return null;
  }

}
  










