package model;

import model.cardDataTypes.Card;
import model.cardDataTypes.Deck;
import view.User;

public class BlackjackGame extends Deck {
	
	static final int ACE = 1;
	static final int JACK = 10;
	static final int QUEEN = 10;
	static final int KING = 10;
	private static int possibleSums = 0;
	
	public BlackjackGame() {
		
		super(false);
		
		Card[] cards = (Card[]) unseenDeck.toArray();
		
		for(int i = 0; i < cards.length; i++) {
			
			if(cards[i].getSymbol().equals("J") || cards[i].getSymbol().equals("Q") || cards[i].getSymbol().equals("K")) {
				
				unseenDeck.remove(cards[i]);
				unseenDeck.add(new Card(Suit.valueOf(cards[i].getSuit()), cards[i].getSymbol(), 10));
				
			}
			
		}
		
		unseenDeck.sort(null);
		
	}
	
	//Add BlackjackProbCalculator methods here
	//Also, add a 'getNextCard' method to unseenDeck
	private static float toPercent(float num) {
		
		float percent = 0;
		
		try {
			
			percent = ((float) ((int) (num * 10000))) / 100;
			
		} catch(NumberFormatException nfe) {
			
			User.println(nfe.getMessage());
			nfe.printStackTrace();
			
		}
		
		return percent;
		
	}
	
	public static Suit getSuit(String suit) {
		
		switch(suit.toUpperCase()) {
		
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
		
	}
	
	private int sumsLessThan21(int knownSum) {
		
		int lessThan = 21 - knownSum;
		Card[] sumOf21;
		sumOf21 = toArray();
		int lessThan21 = 0;
		
		for(int i = 0; i < sumOf21.length; i++) {
			
			for(int j = 0; j < sumOf21.length; j++) {
				
				if(i != j && sumOf21[i].getValue() + sumOf21[j].getValue() < lessThan) {
					
					lessThan21++;
					
				}
			
			}
			
		}
		
		sums(knownSum);
		
		return lessThan21;
		
	}
	
	private int sumsEqualTo21(int knownSum) {
		
		int equalTo = 21 - knownSum;
		Card[] sumOf21;
		sumOf21 = toArray();
		int equalTo21 = 0;
		
		for(int i = 0; i < sumOf21.length; i++) {
			
			for(int j = 0; j < sumOf21.length; j++) {
				
				if(i != j && sumOf21[i].getValue() + sumOf21[j].getValue() == equalTo) {
					
					equalTo21++;
					
				}
			
			}
			
		}
		
		sums(knownSum);
		
		return equalTo21;
		
	}
	
	private int sumsGreaterThan21(int knownSum) {
		
		int greaterThan = 21 - knownSum;
		Card[] sumOf21;
		sumOf21 = toArray();
		int greaterThan21 = 0;
		
		for(int i = 0; i < sumOf21.length; i++) {
			
			for(int j = 0; j < sumOf21.length; j++) {
				
				if(i != j && sumOf21[i].getValue() + sumOf21[j].getValue() < greaterThan) {
					
					greaterThan21++;
					
				}
			
			}
			
		}
		
		sums(knownSum);
		
		return greaterThan21;
		
	}
	
	public float possibilityLessThan21(int knownSum) {
		
		return toPercent((float) (sumsLessThan21(knownSum)) / possibleSums);
		
	}
	
	public float possibilityEqualTo21(int knownSum) {
		
		return toPercent((float) (sumsEqualTo21(knownSum)) / possibleSums);
		
	}
	
	public float possibilityGreaterThan21(int knownSum) {
		
		return toPercent((float) (sumsGreaterThan21(knownSum)) / possibleSums);
		
	}
	
	private void sums(int knownSum) {
		
		Card[] sumOf21;
		sumOf21 = toArray();
		possibleSums = 0;
		
		for(int i = 0; i < sumOf21.length; i++) {
			
			for(int j = 0; j < sumOf21.length; j++) {
				
				if(i != j) {
					
					possibleSums++;
					
				}
			
			}
			
		}
		
	}
	
	public float cardProbability(String symbol) {
		
		Card[] unseenDeckArray = toArray();
		float numberOfCards = 0;
		
		for(int i = 0; i < unseenDeckArray.length; i++) {
			
			if(unseenDeckArray[i].getSymbol() == symbol) {
				
				numberOfCards++;
				
				
			}
			
		}
		
		return toPercent(numberOfCards / length());
		
	}
	
}
