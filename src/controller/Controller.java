package controller;

import model.cardDataTypes.Deck;
import view.User;
import view.UserInterface;

public class Controller {
	double startTime;
	Deck myDeck;
	
	public Controller(){
		startTime = (double)System.nanoTime();
		myDeck = new Deck();
	}
	
	public void start(){
		this.testRun();
	}
	
	public void testRun(){
		User.println(myDeck.toString());
		User.printData(ProbCalculator.calculate(myDeck, 10));
		User.println(myDeck.toString());
		myDeck.reset();
		User.println(myDeck.toString());
		long endTime = System.nanoTime();
		User.println(((float) (endTime - startTime)) / 1000000000 + " seconds");
		UserInterface ui = new UserInterface();
		ui.run();
	}
}
