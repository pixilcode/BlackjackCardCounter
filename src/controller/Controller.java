package controller;

import model.cardDataTypes.Deck;
import view.User;
import view.UserInterface;
import view.gui.CardFrame;

public class Controller {
	CardFrame baseFrame;
	double startTime;
	Deck myDeck;
	UserInterface ui ;

	
	public Controller(){
		baseFrame = new CardFrame(this);
		startTime = (double)System.nanoTime();
		myDeck = new Deck();
		ui = new UserInterface();
	}
	
	public void start(){
		this.testRun();
	}
	
	public void testRun(){
		User.println(myDeck.toString());
		myDeck.remove("Hearts", '9');
		myDeck.remove("Spades", 'K');
		myDeck.remove("Diamonds", '3');
		myDeck.remove("Clubs", '7');
		myDeck.remove("Diamonds", 'K');
		User.printData(ProbCalculator.calculate(myDeck, 10));
		User.println(myDeck.toString());
		myDeck.reset();
		User.println(myDeck.toString());
		long endTime = System.nanoTime();
		User.println(((float) (endTime - startTime)) / 1000000000 + " seconds");
		ui.run();
	}
	
}
