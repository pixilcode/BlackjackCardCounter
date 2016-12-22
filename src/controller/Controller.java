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
	
	
	public Suit spades() {
		
		return Suit.SPADES;
		
	}
	
	public Suit clubs() {
		
		return Suit.CLUBS;
		
	}
	
	public Suit diamonds() {
		
		return Suit.DIAMONDS;
		
	}
	
	public Suit hearts() {
		
		return Suit.HEARTS;
	}
	
	public void remove() {
		
		
		
	}
	
	public void testRun(){
		
	}
}
