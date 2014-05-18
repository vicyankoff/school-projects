import java.util.*;

/**
 * Class that creates the board object and interacts with the players
 * @author Viktor Jankov
 */

public class TTTGame {
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		TicTacToe board = new TicTacToe(); //create the board
		int row = 0;
		int col = 0;
		
		System.out.println("Welcome to the game of Tic Tac Toe.");
		System.out.println("The rows and columns start at (1,1) and end at (3,3).");
		System.out.println("Type in the coordinates separated by space.");
		System.out.println("Good luck to both of you!\n");
		
		String player = "X"; 	//player X goes first
		
		//Play the game while there are open spots or while there is a winner
		while(board.openSpots())
		{
		System.out.print(board.displayBoard());
		System.out.print("Player " + player + " please enter your move: ");
		row = in.nextInt();
		col = in.nextInt();
			if(!board.validMove(row,col,player))
			{
				System.out.print("This is not a valid move");
				System.out.println();
				continue;
			}
		board.makeMove(row,col,player);
		
			if(board.checkWinner(player)){
				System.out.println();
				System.out.println("Player " + player + " wins!"); // winner found so display board and exit
				System.out.println(board.displayBoard());
				break;
			} else if (!board.openSpots()) {
				System.out.println();
				System.out.println("Nobody wins, it's a tied game!");
			}
		if(player.equalsIgnoreCase("X")){
			player = "O"; } else { player = "X"; }
	}
}
}

