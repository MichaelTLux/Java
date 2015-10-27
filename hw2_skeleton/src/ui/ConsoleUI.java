package ui;
import java.util.Scanner;

import api.Direction;
import hw2.Game;

/**
 * Ultra-simple UI for the 2048 game.
 * This version does not use the Result object returned
 * from the collapse method.
 */
public class ConsoleUI
{

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    Game g = new Game(4);
    printGrid(g);
    
    while (true)
    {
      System.out.println("Enter i, j, k, or l: ");
      String s = in.nextLine();
      if (s.startsWith("j"))
      {
        g.collapse(Direction.LEFT);
      }
      else if (s.startsWith("l"))
      {
        g.collapse(Direction.RIGHT);
      }
      else if (s.startsWith("i"))
      {
        g.collapse(Direction.UP);
      }
      else if (s.startsWith("k"))
      {
        g.collapse(Direction.DOWN);
      }
      
      printGrid(g);
    }

  }

  public static void printGrid(Game game)
  {
    System.out.println("---------------");
    for (int row = 0; row < game.getSize(); row += 1)
    {
      for (int col = 0; col < game.getSize(); col += 1)
      {
        System.out.printf("%4d", game.getCell(row, col));
      }
      System.out.println();
    }
    System.out.println("---------------");
  }
  
}
