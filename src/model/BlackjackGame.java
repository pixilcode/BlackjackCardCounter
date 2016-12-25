package model;

import model.*;
import model.cardDataTypes.*;
import view.*;

public class BlackjackGame{
	//hi-lo card counting values
	enum HILO{// values to keep track of the likleyness of winning https://www.blackjackapprenticeship.com/resources/how-to-count-cards/
		TEN(-1),
		ACE(-1),
		JACK(-1),
		QUEEN(-1),
		KING(-1),
		TWO(+1),
		THREE(+1),
		FOUR(+1),
		FIVE(+1),
		SIX(+1),
		SEVEN(0),
		EIGHT(0),
		NINE(0);
		private final int value;
		HILO(int value){
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	private static final int ACE = 1;
	private static final int JACK = 10;
	private static final int QUEEN = 10;
	private static final int KING = 10;
	
	private int decks;
	private int currentSum;
	private int likleySum;
	private int runningCount;//extreemist posible running count in one deck is 20 & -20
	private double likleySumPercent;
	private double losingChancePercent;
	private double winningChancePercent;
	private double trueCount;// higher the true count more likley to win
	
	private CardDeck seenDeck;
	private CardDeck unseenDeck;
	private CardDeck cardsInHand;
	private Cards cards;
	private Suit suit;
	
	public BlackjackGame(){
		decks = 1;
		currentSum = 0;
		likleySum =0;
		runningCount = 0;
		likleySumPercent = 0;
		losingChancePercent = 0;
		winningChancePercent = 0;
		trueCount = 0;
		
		seenDeck = new CardDeck();
		unseenDeck = new CardDeck(decks);
		cardsInHand = new CardDeck();
		unseenDeck.addDeck();
	}
	
	private static double toPercent(double num) {
		double percent = 0;	
		try {
			percent = ((double) ((int) (num * 10000))) / 100;
		} catch(NumberFormatException nfe) {
		
		}
		return percent;
	}
	
	public void addCardToHand(Cards card){
		calculate();
		Card newCard = unseenDeck.removeCard(card);
		cardsInHand.addCard(newCard);
		seenDeck.addCard(newCard);
	}
	
	public void addSeenCard(Cards card){
		calculate();
		seenDeck.addCard(unseenDeck.removeCard(card));
	}
	
	public int getSeenCards(Cards card){
		int seenCards = 0;
		seenCards = seenDeck.hasCards(card);
		return seenCards;
	}
	
	public int getCurrentSum(){
		return this.currentSum;
	}
	
	public double getWinningChancePercent(){
		return this.winningChancePercent;
	}
	
	public double getLosingChancePercent(){
		return this.losingChancePercent;
	}
	
	public double getNextLikleySumPercent(){
		return this.likleySumPercent;
	}
	
	public int getNextLikleySum(){
		return this.likleySum;
	}
	
	private void calculate(){
		//subtract all the tens
		for(int i = 10; i < 14; i++)
			runningCount -= seenDeck.hasCards(cards.getCard(i));
		//subtract add all the 2-6's
		for(int i = 2; i < 7; i ++)
			runningCount += seenDeck.hasCards(cards.getCard(i));
		trueCount = ((double)runningCount/(double)decks);
		this.winningChancePercent = trueCount/20;
		this.losingChancePercent = 1 -winningChancePercent;
	}
	
}


//public class BlackjackGame extends Deck {
//	
//	static final int ACE = 1;
//	static final int JACK = 10;
//	static final int QUEEN = 10;
//	static final int KING = 10;
//	private static int possibleSums = 0;
//	private Card[] cards;
//	
//	public BlackjackGame() {
//		
//		super(false);
//		
//		cards = (Card[]) unseenDeck.toArray();
//		
//		for(int i = 0; i < cards.length; i++) {
//			
//			if(cards[i].getSymbol().equals("J") || cards[i].getSymbol().equals("Q") || cards[i].getSymbol().equals("K")) {
//				
//				unseenDeck.remove(cards[i]);
//				unseenDeck.add(new Card(Suit.valueOf(cards[i].getSuit()), cards[i].getSymbol(), 10));
//				
//			}
//			
//		}
//		
//		unseenDeck.sort(null);
//		
//	}
//	
//	//Add BlackjackProbCalculator methods here
//	//Also, add a 'getNextCard' method to unseenDeck
//	private static float toPercent(float num) {
//		
//		float percent = 0;
//		
//		try {
//			
//			percent = ((float) ((int) (num * 10000))) / 100;
//			
//		} catch(NumberFormatException nfe) {
//			
//		}
//		
//		return percent;
//		
//	}
//	
//	public static Suit getSuit(String suit) {
//		
//		switch(suit.toUpperCase()) {
//		
//		case "SPADES":
//			return Suit.SPADES;
//		
//		case "CLUBS":
//			return Suit.CLUBS;
//		
//		case "DIAMONDS":
//			return Suit.DIAMONDS;
//		
//		case "HEARTS":
//			return Suit.HEARTS;
//		
//		default:
//			return null;
//		
//		}
//		
//	}
//	
//	private int sumsLessThan21(int knownSum) {
//		
//		int lessThan = 21 - knownSum;
//		Card[] sumOf21;
//		sumOf21 = toArray();
//		int lessThan21 = 0;
//		
//		for(int i = 0; i < sumOf21.length; i++) {
//			
//			for(int j = 0; j < sumOf21.length; j++) {
//				
//				if(i != j && sumOf21[i].getValue() + sumOf21[j].getValue() < lessThan) {
//					
//					lessThan21++;
//					
//				}
//			
//			}
//			
//		}
//		
//		sums(knownSum);
//		
//		return lessThan21;
//		
//	}
//	
//	private int sumsEqualTo21(int knownSum) {
//		
//		int equalTo = 21 - knownSum;
//		Card[] sumOf21;
//		sumOf21 = toArray();
//		int equalTo21 = 0;
//		
//		for(int i = 0; i < sumOf21.length; i++) {
//			
//			for(int j = 0; j < sumOf21.length; j++) {
//				
//				if(i != j && sumOf21[i].getValue() + sumOf21[j].getValue() == equalTo) {
//					
//					equalTo21++;
//					
//				}
//			
//			}
//			
//		}
//		
//		sums(knownSum);
//		
//		return equalTo21;
//		
//	}
//	
//	private int sumsGreaterThan21(int knownSum) {
//		
//		int greaterThan = 21 - knownSum;
//		Card[] sumOf21;
//		sumOf21 = toArray();
//		int greaterThan21 = 0;
//		
//		for(int i = 0; i < sumOf21.length; i++) {
//			
//			for(int j = 0; j < sumOf21.length; j++) {
//				
//				if(i != j && sumOf21[i].getValue() + sumOf21[j].getValue() < greaterThan) {
//					
//					greaterThan21++;
//					
//				}
//			
//			}
//			
//		}
//		
//		sums(knownSum);
//		
//		return greaterThan21;
//		
//	}
//	
//	public float possibilityLessThan21(int knownSum) {
//		
//		return toPercent((float) (sumsLessThan21(knownSum)) / possibleSums);
//		
//	}
//	
//	public float possibilityEqualTo21(int knownSum) {
//		
//		return toPercent((float) (sumsEqualTo21(knownSum)) / possibleSums);
//		
//	}
//	
//	public float possibilityGreaterThan21(int knownSum) {
//		
//		return toPercent((float) (sumsGreaterThan21(knownSum)) / possibleSums);
//		
//	}
//	
//	private void sums(int knownSum) {
//		
//		Card[] sumOf21;
//		sumOf21 = toArray();
//		possibleSums = 0;
//		
//		for(int i = 0; i < sumOf21.length; i++) {
//			
//			for(int j = 0; j < sumOf21.length; j++) {
//				
//				if(i != j) {
//					
//					possibleSums++;
//					
//				}
//			
//			}
//			
//		}
//		
//	}
//	
//	public float cardProbability(String symbol) {
//		
//		Card[] unseenDeckArray = toArray();
//		float numberOfCards = 0;
//		
//		for(int i = 0; i < unseenDeckArray.length; i++) {
//			
//			if(unseenDeckArray[i].getSymbol() == symbol) {
//				
//				numberOfCards++;
//				
//				
//			}
//			
//		}
//		
//		return toPercent(numberOfCards / length());
//		
//	}
//	
//}
