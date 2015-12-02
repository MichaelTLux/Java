package mini3;

import java.util.Random;

public class TicTacToeTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    //playInteractive();
    playIterations(10000);
  }
  
//  /**
//   * Play interactively with a random player.
//   */
//  private static void playInteractive()
//  {
//    int seed = (int) System.currentTimeMillis() % 1000;
//    System.out.println("Using seed " + seed);
//    Random rand = new Random(seed);
//    Player[] players = {new RandomPlayer(rand), new InteractivePlayer()};
//    TicTacToeGame game = new TicTacToeGame(players);
//    game.run();
//    game.printCurrentStatus();
//  }
//  
  /**
   * Play two automated players against each other for multiple iterations.
   */
  private static void playIterations(int numIters)
  {
    int[] counts = new int[3];
    for (int i = 0; i < numIters; ++i)
    {
    	Random random=new Random();
      Player[] players = {new RandomPlayer(), new MyPlayer(random)};
      TicTacToeGame game = new TicTacToeGame(players, false);
      game.run();
      int index = game.getWinner() + 1; // returns -1, 0, or 1
      counts[index] += 1;
    }
    System.out.println("Wins:   " + counts[2]);
    System.out.println("Losses: " + counts[1]);
    System.out.println("Ties:   " + counts[0]);
  }
}
