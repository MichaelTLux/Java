package mini3;

import java.util.*;

public class MyPlayer implements Player{
	private boolean wentFirst;
	private Random random;
	
	public MyPlayer()
	{
		wentFirst=false;
	}
	public MyPlayer(Random givenRand)
	{
		this();
		random=givenRand;
	}
	
	public String getName()
	{
		return "Michael";
	}
	
	public void gameOver(TicTacToeGame g)
	{
		//didn't find a use for this... yet
	}
	
	public Move play(TicTacToeGame game)
	{
		//TODO
		//determine my pieces and their pieces 
		int me=game.getTurn();
		int opponent;
		if (me==0)
		{
			opponent=1;
		}
		else
		{
			opponent=0;
		}
		//determine if i went first (use forced wins)
		if (game.getAllLegalMoves().size()==9)
		{
			wentFirst=true;
		}
		
		//if i can win i should do so
		if (canWin(game, me))
		{
			//do the winning move
			return winningMove(game, me);
		}
		
		//if they can win i should block
		if (canWin(game, opponent))
		{
			//do the blocking move
			return winningMove(game, opponent);
		}
		//otherwise i check if i went first
		if (wentFirst)
		{
			//bonus for later because i dont go first
			//if i did then i can use the forces at 
			//https://www.quora.com/Is-there-a-way-to-never-lose-at-Tic-Tac-Toe
			return game.getAllLegalMoves().get(0);
		}

		//if not then use random because there doesn't seems to be a best alternative?
		else
		{
			int max=game.getAllLegalMoves().size();
			return game.getAllLegalMoves().get(random.nextInt(max));
			//return game.getAllLegalMoves().get(0);
		}
	}
	
	//check to see if the selected player can win or has won
	private boolean canWin(TicTacToeGame g, int playerInt)
	{
		if (winningMove(g, playerInt)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	private Move winningMove(TicTacToeGame game, int player)
	{
		char who=TicTacToeGame.MARKER[player];
		char[][] board= game.getBoard();
		
		ArrayList<Move> possible= game.getAllLegalMoves();
		
		for (int i=0; i<possible.size();i=i+1)
		{
			Move m= possible.get(i);
			board[m.getRow()][m.getCol()]=who;	
		//just copied the game winning algorithm from the code given
		  // check the row that the last marker m is on
		  if(board[m.getRow()][0]==board[m.getRow()][1] && board[m.getRow()][0]==board[m.getRow()][2])
			  	return possible.get(i);
		  // check the column
		  if(board[0][m.getCol()]==board[1][m.getCol()] && board[0][m.getCol()]==board[2][m.getCol()])
			  return possible.get(i);
		  // check first diagonal
		  if(m.getRow()==m.getCol() && board[0][0]==board[1][1] && board[0][0]==board[2][2])
		      return possible.get(i);
		  // check second diagonal
		  if(m.getRow()+m.getCol()==2 && board[0][2]==board[1][1] && board[0][2]==board[2][0])
			  return possible.get(i);
		  board[m.getRow()][m.getCol()]='-';
		}
		//returns null if a winning move isn't found
		return null;
	}

}
