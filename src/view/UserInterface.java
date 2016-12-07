package view;

import model.cardDataTypes.Deck;
import model.cardDataTypes.Card;
import controller.ProbCalculator;

public class UserInterface {
	
	Deck deck = new Deck();
	
	//No initialization
	public UserInterface() {
		
	}
	
	public void pause(long millis) {
		
		try {
			
			Thread.sleep(millis);
			
		} catch (InterruptedException ie) {
			//Do nothing
		}
		
	}
	
	public void playGame() {
		
		boolean finished = false;
		
		while(!finished) {
			
			String choice = User.prompt("Input a card symbol, 'calculate', or 'quit'");
			
			if(choice.toUpperCase().equals("QUIT")) {
				
				finished = true;
				break;
				
			} else if(choice.toUpperCase().equals("CALCULATE")) {
				
				continue;
				
			}
			
		}
		
		
	}
	
	//When the user interface is run,...
	public void run() {
		
		//Print out the "Loading..." string
		User.print("Loading");
		
		//Wait 1 second
		pause(1000);
		
		User.print(".");
		
		//Wait 1 second
		pause(1000);
		
		User.print(".");
		
		pause(1000);
		
		User.println(".\n");
		
		pause(2000);
		
		//Print out welcome and instructions
		User.println("Welcome to [Insert Software Name Here]\n");
		pause(1500);
		User.println("[Insert instructions here]");
		User.prompt("Type 'Y' to continue");
		
		playGame();
		
	}
}
