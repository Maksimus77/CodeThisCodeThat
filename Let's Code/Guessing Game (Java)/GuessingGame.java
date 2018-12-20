import java.util.Scanner;

public class GuessingGame {

	static int range[];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		range = new int[2];
		range[0] = 1;
		range[1] = 100;
		int tries = 0;
		
		boolean isGuessed = false;
		while(!isGuessed) {
			
			int currentGuess = (range[1] + range[0])/2; // Pick the middle element
			print(" Is your guess " + currentGuess + "?");
			isGuessed = isWellGuessed(in);
			
			// If not guessed we pick another number
			if(!isGuessed) {
				if(range[0] == range[1]) {
					System.out.println("You must have lied!");
					return;
				}
				String answer = getAnswer(in);
				updateRange(answer,currentGuess);
			}
			tries++;
		}
		print("Yes! I guessed your number in " + tries +"!");
		
	}
	
	// Helper Functions
	
	// Wrapper for printing
	public static void print(String message) {
		System.out.println(">>" + message );
	}
	
	// Get a String that is either higher or lower
	public static String getAnswer(Scanner in) {
		boolean isAnswerCorrect = false;
		String answer = "";
		while(!isAnswerCorrect) {
			print(" Is your number higher or lower?");
			System.out.print(">> ");
			answer = in.next().toLowerCase();
			if(answer.equals("higher") || answer.equals("lower")) {
				isAnswerCorrect = true;
			}
		}
		return answer;
	}
	
	// get a boolean that says if the number was wel guessed or not
	public static boolean isWellGuessed(Scanner in) {
		System.out.print(">> ");
		return in.nextBoolean();
	}
	
	
	// Update the range global variable depending on the answer
	public static void updateRange(String answer,int currentGuess) {
		if(answer.equals("higher")) {
			if(range[1] - range[0] == 1) {
				range[0] = range[1];
			}else {
				range[0] = currentGuess + 1;
			}
		}else if(answer.equals("lower")) {
			if(range[1] - range[0] == 1) {
				range[1] = range[0];
			}else {
				range[1] = currentGuess - 1;				
			}
		}
	}
}
