// Andrei Lyskov, 12al104, 10101635


import java.util.Random;

public class Assn1_12al104 {
	final static int winningScore = 8;
	
	public static int rollDice() {
		Random r = new Random();
		int Low = 1;
		// 7 for all inclusive
		int High = 7;
		int roll = r.nextInt(High-Low) + Low;
		return roll;
	}
	
	public static int playersTurn(int humanScore) {
//		System.out.println("Player's Turn: ");
		humanScore += rollDice();
		return humanScore;
	}
	
	public static int computersTurn(int computerScore) {
//		System.out.println("Computer's Turn: ");
		computerScore += rollDice();
		return computerScore;
	}
	
	public static void startGame(boolean humansTurn, int humanScore, int computerScore) {
//		System.out.println("This is the human score " + humanScore);
		while (humanScore < winningScore && computerScore < winningScore) {
			if (humansTurn){
				humanScore += playersTurn(humanScore);
				humansTurn = false;
				System.out.println(humanScore);
				startGame(humansTurn, humanScore, computerScore);
				System.out.println("works");
			}
			else{
				computerScore += computersTurn(computerScore);
				humansTurn = true;
				startGame(humansTurn, humanScore, computerScore);
			}
		}
	}
	
	public static void main(String[] args) {
		int humanScore = 0;
		int computerScore = 0;
		boolean humansTurn = true;
		startGame(humansTurn, humanScore, computerScore);
	}

}
