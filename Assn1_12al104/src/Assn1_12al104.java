// Andrei Lyskov, 12al104, 10101635

// left to implement ~ computer Strategy
// implementing scanner class to query the user
// 
import java.util.Random;

public class Assn1_12al104 {
	final static int winningScore = 20;
	private static final String[] numNames = {
		    "",
		    " one",
		    " two",
		    " three",
		    " four",
		    " five",
		    " six",
		    };
	
	public static int rollDice() {
		Random r = new Random();
		int Low = 1;
		// 7 for all inclusive
		int High = 7;
		int roll = r.nextInt(High-Low) + Low;
		return roll;
	}
	
	public static int playTurn(int totalScore, boolean humansTurn) {
		int turnScore = 0;
		boolean turnOver = false;
		while (!turnOver){
			if ((totalScore + turnScore) > winningScore){
				return (totalScore + turnScore);
			}
			// turn into an array
			int firstRoll = rollDice();
			int secondRoll = rollDice();
			String turnResponse = interpretDiceRoll(firstRoll, secondRoll, (turnScore + totalScore), humansTurn);
			if (turnResponse == "Double Ones"){
				totalScore = 0;
				turnOver = true;
			}
			else if (turnResponse == "Single One") {
				turnScore = 0;
				turnOver = true;
			}
			else if (turnResponse == "Doubles") {
				turnScore += firstRoll + secondRoll;
			}
			else {
				turnScore += firstRoll + secondRoll;
			}
		}
		return (totalScore + turnScore);
	}
	
	public static String interpretDiceRoll(int diceRollOne, int diceRollTwo, int totalScore, boolean humansTurn){
		String currentPlayer = whoIsPlaying(humansTurn);
		
		System.out.println(currentPlayer+" rolled:" + numToWord(diceRollOne) + " +" + numToWord(diceRollTwo));
		int turnSum = diceRollOne + diceRollTwo;
		// first dice option
		if (diceRollOne == 1 && diceRollTwo == 1){
			System.out.println("TURN OVER!");
			return "Double Ones";
		} 
		else if (diceRollOne == 1 || diceRollTwo == 1){
			System.out.println("TURN OVER! Turn sum is zero!");
			return "Single One";
		}
		else if (diceRollOne == diceRollTwo){
			System.out.println(currentPlayer + " has a current turn sum of: " + turnSum + " and a game sum of: " + (turnSum + totalScore));
			return "Doubles";
		}
		else {
			System.out.println(currentPlayer + " has a current turn sum of: " + turnSum + " and a game sum of: " + (turnSum + totalScore));
			return "Regular";
		}
	}
	
	public static String numToWord(int diceRoll){
		return numNames[diceRoll];
	}
	
	public static boolean checkWinCondition(String currentPlayer, int score)
	{
		if (score >= winningScore){
			System.out.println(currentPlayer + " wins!");
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String whoIsPlaying(boolean humansTurn) {
		String currentPlayer = "Player";
		if (!humansTurn){
			currentPlayer = "Computer";
		}
		return currentPlayer;
	}
	
	public static void startGame(boolean humansTurn, boolean gameOver) {
		int humanScore = 0;
		int computerScore = 0;
		int round = 0;
//		System.out.println("This is the human score " + humanScore);
		while (!gameOver) {
			String currentPlayer = whoIsPlaying(humansTurn);
			System.out.println(currentPlayer +"'s turn is starting.");
			if (humansTurn){
				humanScore = playTurn(humanScore, humansTurn);
				gameOver = checkWinCondition(currentPlayer, humanScore);
				humansTurn = false;
			}
			else{			
				computerScore = playTurn(computerScore, humansTurn);
				gameOver = checkWinCondition(currentPlayer, computerScore);
				humansTurn = true;
			}
			round ++;
			if (round % 2 == 0){
				System.out.println("Player's sum is: " + humanScore + ", Computer's sum is: " + computerScore + ". Press <enter> to start round " + round / 2);
			}
		}
	}
	

	public static void main(String[] args) {
		// the game starts with the human going first
		boolean humansTurn = true;
		boolean gameOver = false;
		startGame(humansTurn, gameOver);
	}

}
