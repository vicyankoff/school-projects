/**
 * Class that will create a TicTacToe table
 * and store the moves by the players.
 * @author Viktor Jankov
 */

public class TicTacToe {

	private static final int  n = 4;

	String[][] board = new String[n][n];

	/**
	 * Constructor that will create and initialize the board with empty values.
	 */
	public TicTacToe()
	{
		for(int i = 1; i < n; i++)
			for(int j = 1; j < n; j++)
				board[i][j] = " ";
	}
	
	/**
	 * Display the board.
	 * @return the state of the Board
	 */
	public String displayBoard()
	{
		String r = "";
		for(int i = 1; i < n; i++)
		{ 
			for(int j = 1; j < n; j++)
			{
				r = r + "[ "  + board[i][j] + " ]";
			}
			r = r + "\n";
		}
		return r;
	}
	
	/**
	 * Check if a move is valid or not.
	 * @param i the row number 
	 * @param j the column number
	 * @param type the player (X,O) that is making the move
	 * @return true if it's valid and false otherwise
	 */
	public boolean validMove(int i, int j, String type)
	{
		if(board[i][j].equalsIgnoreCase(" "))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Record the move in the board.
	 * @param i the row number
	 * @param j the column number
	 */
	
	public void makeMove(int i, int j, String type)
	{
		board[i][j] = type;
	}
	
	/**
	 * Checks if the player that calls this method is a winner or not.
	 * @param player the X or O player
	 * @return true if the player is a winner and false otherwise
	 */
	public boolean checkWinner(String player)
	{
		if(checkRows(player))
			return true;
		else if (checkCols(player))
			return true;
		else if(checkDiag1(player))
			return true;
		else if(checkDiag2(player))
			return true;
		else return false;
	}
	
	/**
	 * Method to be used to see if any of the rows have the same character (X,O).
	 * @param player the player X or O
	 * @return true if there are rows where the player has all three characters aligned, 
	 * and false otherwise
	 */
	private boolean checkRows(String player)
	{
		for(int i = 1; i < n; i++)
		{
		if(board[i][1].equalsIgnoreCase(player) && 
			board[i][2].equalsIgnoreCase(player) &&
			board[i][3].equalsIgnoreCase(player)) 
			{	
			return true;
			}
	}
		return false;
	}
	
	/**
	 * Method to be used to see if any of the columns have the same character (X,O).
	 * @param player the player X or O
	 * @return true if there are columns where the player has all three characters aligned, 
	 * and false otherwise
	 */
		private boolean checkCols(String player)
	{
		for(int i = 1; i < n; i++)
		{
			if(		board[1][i].equalsIgnoreCase(player) && 
					board[2][i].equalsIgnoreCase(player) &&
					board[3][i].equalsIgnoreCase(player) )
					{	
					return true;
					}
		}
		return false;
	}

	/**
	 * Method to be used to see if the first diagonal has the same character (X,O).
	 * @param player the player X or O
	 * @return true if the diagonal has the three same characters and false otherwise
	 */
	private boolean checkDiag1(String player)
	{
	if(	board[1][1].equalsIgnoreCase(player) && 
		board[2][2].equalsIgnoreCase(player) &&
		board[3][3].equalsIgnoreCase(player) )
		{	
		return true;
		}
		return false;
	}
	
	/**
	 * Method to be used to see if the second diagonal has the same character (X,O).
	 * @param player the player X or O
	 * @return true if the diagonal has the three same characters and false otherwise
	 */	
	private boolean checkDiag2(String player)
	{
			if(	board[1][3].equalsIgnoreCase(player) && 
				board[2][2].equalsIgnoreCase(player) &&
				board[3][1].equalsIgnoreCase(player) )
					{	
					return true;
					}
		return false;
	}		
	/**
	 * Method that checks for open spots on the board
	 * and will be used to see if there's a draw or not.
	 * @return return true if there are open spots and false otherwise
	 */
	public boolean openSpots()
	{
		for(int i = 1; i < n; i++){
			for(int j = 1; j < n; j++){
				if(board[i][j].equals(" "))
					return true;
			}
		}
		return false;
	}
}
