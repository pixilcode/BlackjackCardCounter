package controller;

import model.*;

public class Controller {
	double startTime;
	BlackjackGame bjGame;
	
	public Controller(){
		startTime = (double) System.nanoTime();
		bjGame = new BlackjackGame();
	}
	
	public void start(){
		
	}
	
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
	
	//Blackjack commands
	public void bjRemoveAce() {
		
		bjGame.remove("A");
		
	}
	
	public void bjRemoveTwo() {
		
		bjGame.remove("2");
		
	}
	
	public void bjRemoveThree() {
		
		bjGame.remove("3");
		
	}
	
	public void bjRemoveFour() {
		
		bjGame.remove("4");
		
	}
	
	public void bjRemoveFive() {
		
		bjGame.remove("5");
		
	}
	
	public void bjRemoveSix() {
		
		bjGame.remove("6");
		
	}
	
	public void bjRemoveSeven() {
		
		bjGame.remove("7");
		
	}
	
	public void bjRemoveEight() {
		
		bjGame.remove("8");
		
	}
	
	public void bjRemoveNine() {
		
		bjGame.remove("9");
		
	}
	
	public void bjRemoveTen() {
		
		bjGame.remove("10");
		
	}
	
	public void bjRemoveJack() {
		
		bjGame.remove("J");
		
	}
	
	public void bjRemoveQueen() {
		
		bjGame.remove("Q");
		
	}
	
	public void bjRemoveKing() {
		
		bjGame.remove("K");
		
	}
	
	public double bjAceChance() {
		
		return bjGame.cardProbability("A");
		
	}
	
	public double bjTwoChance() {
		
		return bjGame.cardProbability("2");
		
	}
	
	public double bjThreeChance() {
		
		return bjGame.cardProbability("3");
		
	}
	
	public double bjFourChance() {
		
		return bjGame.cardProbability("4");
		
	}
	
	public double bjFiveChance() {
		
		return bjGame.cardProbability("5");
		
	}
	
	public double bjSixChance() {
		
		return bjGame.cardProbability("6");
		
	}
	
	public double bjSevenChance() {
		
		return bjGame.cardProbability("7");
		
	}
	
	public double bjEightChance() {
		
		return bjGame.cardProbability("8");
		
	}
	
	public double bjNineChance() {
		
		return bjGame.cardProbability("9");
		
	}
	
	public double bjTenChance() {
		
		return bjGame.cardProbability("10");
		
	}
	
	public double bjJackChance() {
		
		return bjGame.cardProbability("J");
		
	}
	
	public double bjQueenChance() {
		
		return bjGame.cardProbability("Q");
		
	}
	
	public double bjKingChance() {
		
		return bjGame.cardProbability("K");
		
	}
	
	public double lessThan21(int knownSum) {
		
		return bjGame.possibilityLessThan21(knownSum);
		
	}
	
	public double equalTo21(int knownSum) {
		
		return bjGame.possibilityEqualTo21(knownSum);
		
	}
	
	public double greaterThan21(int knownSum) {
		
		return bjGame.possibilityGreaterThan21(knownSum);
		
	}
	
	public void bjReset() {
		
		bjGame.reset();
		
	}
	
	public void testRun(){
		
	}
}
