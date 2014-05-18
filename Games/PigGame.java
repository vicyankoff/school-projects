import java.util.*;

/**
 * Variation of the game of Pig where the player competes 
 * against the computer and whoever gets to 20 points wins
 * @author Viktor Jankov
 */

public class PigGame {
	public static void main (String[] args){
		int yourTurnPts = 0; 	//points for the player's current term
		int yourScore = 0;		//points for the player's total score
		int myTurnPts = 0;		//points for the computer's current term
		int myScore = 0;		//points for the computer's total score
		int rolls = 0;			//points for the player's current term
		
		boolean player1 = false;	//initialize the player to go first
		Random generator = new Random();
		
		//Introduction to the game
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the game of Pig!");
		System.out.println("The goal is to get to 20 points by rolling a dice");
		System.out.println("You can choose to Roll or Hold,");
		System.out.print("but remember that if you roll a 1 all your points for the current term are erased");
		System.out.println("Otherwise your points are added");
		System.out.println("The computer will randomly generate numbers and play on its own.");
		System.out.println("Let's see if you can beat the Man");
		System.out.println();
		System.out.println("You go first.");
		
		mainLoop:
		while(yourScore < 20 && myScore < 20)
		{
			while(!player1)
			{			
				System.out.println("You have " + yourTurnPts + " for this turn" +
						", and your score is " + yourScore + ", my score is " + myScore);
				System.out.print("Do you want to roll or hold? Enter R or H. ");
				String move = in.next();
				if(move.equalsIgnoreCase("R")) 
				{
					int num = 1 + generator.nextInt(6);
					System.out.println("You rolled " + num);
					if(yourScore + num >= 20)	//check total score is above 20
					{	
						player1 = true;
						break mainLoop;
					}
					if(num == 1)		//reset the points for the turn if 1 is rolled
					{
					yourTurnPts = 0;
					myTurnPts = 0;
					player1 = true;		//switch players
					}
					yourTurnPts += num;
				} else					// report the scores until done
				{
					yourScore += yourTurnPts;
					System.out.println("You got " + yourTurnPts + " on this turn " +
								" and your score is " + yourScore);
					yourTurnPts = 0;
					myTurnPts = 0;
					player1 = true;
				}
			}
			System.out.println("-----------");
			System.out.println("It's my turn now.");
			System.out.println("-----------");

			while(player1)
			{
				System.out.println("I have " + myTurnPts + " for this turn" +
						", and my score is " + myScore + ", your score is " + yourScore);
				System.out.println("I'm going to roll.");
				int num2 = 1 + generator.nextInt(6);
				rolls++;	// the computer won't roll more than 4 times to make it fair
				System.out.println("I rolled " + num2);
				
					if(num2 == 1)
				{
					System.out.println("I rolled 1 so now it's your turn"); //the computer rolled 1 so switch players
					myTurnPts = 0;
					yourTurnPts = 0;
					rolls = 0;
					player1 = false;
				}
				myTurnPts += num2;
				if(myTurnPts + myScore >= 20)
				{
					player1 = false;
					break mainLoop;
				}
				
				if(rolls > 3)
				{	
					System.out.println("I have 4 rolls so I think I'll hold");
					myScore += myTurnPts;
					myTurnPts = 0;
					yourTurnPts = 0;
					rolls = 0;
					player1 = false;
				}
				if(myTurnPts > 12)	// if the computer has more than 12 points in one turn it will hold
				{
					System.out.println("I have more than 12 pts this turn so I'm goin to hold");
					myScore += myTurnPts;
					myTurnPts = 0;
					rolls = 0;
					player1 = false;
				}
			}
			System.out.println("---------------");
		}
		if(yourScore >= 20){
			int result = yourScore + yourTurnPts;
			System.out.println("You have " + result + " so you WON!");}
		else {
			int result = myScore + myTurnPts;
			System.out.println("I have " + result + " so I WON!");
		}
	}
}

