package controller;

import model.*;
import model.cardDataTypes.*;

public class Controller {
	double startTime;
	BlackjackGame bjGame;
	
	public Controller(){
		startTime = (double) System.nanoTime();
		bjGame = new BlackjackGame();
	}
	
	public void start(){
		
	}
	
	//Blackjack commands
	
	
	public Object blackjackGame(String command, Object[] args) {
		
		switch(command) {
		
		//Get the length
		case "getLength":
			return bjGame.length();
		
		//Create a way to get a 'Suit' enum
		case "getSuit":
			switch(((String) args[0]).toUpperCase()) {
			
			case "SPADES":
				return Suit.SPADES;
			
			case "CLUBS":
				return Suit.CLUBS;
			
			case "DIAMONDS":
				return Suit.DIAMONDS;
			
			case "HEARTS":
				return Suit.HEARTS;
			
			default:
				return null;
			
			}
		
		//Add a card to the deck
		case "addToDeck":
			bjGame.addToDeck(new Card((Suit) args[1], (String) args[2], (int) args[3] ));
			return null;
		
		
		}
		
		return "INVALID";
		
	}
	
	public void remove() {
		
		
		
	}
	
	public void testRun(){
		
	}
}
