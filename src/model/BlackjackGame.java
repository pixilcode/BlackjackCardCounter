package model;

import java.util.ArrayList;

import model.cardDataTypes.Card;
import model.cardDataTypes.Deck;
import model.sumDataTypes.SumCount;
import model.sumDataTypes.SumProb;
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
				
				if(i != j && sumOf21[i].getValue() + sumOf21[j].getValue() <= lessThan) {
					
					lessThan21++;
					
				}
			
			}
			
		}
		
		return lessThan21;
		
	}
	
	private float possibilityLessThan21(int knownSum) {
		sums(knownSum);
		return toPercent((float) (sumsLessThan21(knownSum)) / possibleSums);
		
	}
	
	private SumCount[] sums(int knownSum) {
		
		Card[] sumOf21;
		sumOf21 = toArray();
		ArrayList<SumCount> sumsList = new ArrayList<SumCount>();
		possibleSums = 0;
		
		for(int i = 0; i < sumOf21.length; i++) {
			
			for(int j = 0; j < sumOf21.length; j++) {
				
				SumCount sum = new SumCount(sumOf21[i].getValue() + sumOf21[j].getValue() + knownSum);
					
				if(!sumsList.contains(sum)) {
					
					sumsList.add(sum);
					
				}
				
				if(i != j) {
					
					sum = sumsList.get(sumsList.indexOf(sum));
					sum.increment();
					possibleSums++;
					
				}
			
			}
			
		}
		
		SumCount[] sumsArray = new SumCount[sumsList.size()];
		sumsList.toArray(sumsArray);
		
		return sumsArray;
		
	}
	
	private SumProb[] sumProbabilities(int knownSum) {
		
		SumCount[] sumsArray;
		sumsArray = sums(knownSum);
		SumProb[] sumProbs = new SumProb[sumsArray.length];
		
		for(int i = 0; i < sumsArray.length; i++) {
			
			sumProbs[i] = new SumProb(sumsArray[i].getSum());
			sumProbs[i].setProb(toPercent((float) (sumsArray[i].getCount()) / possibleSums));
			
		}
		
		return sumProbs;
		
		
	}
	
	private float cardProbability(String symbol) {
		
		Card[] unseenDeckArray = toArray();
		float numberOfCards = 0;
		
		for(int i = 0; i < unseenDeckArray.length; i++) {
			
			if(unseenDeckArray[i].getSymbol() == symbol) {
				
				numberOfCards++;
				
				
			}
			
		}
		
		return toPercent(numberOfCards / length());
		
	}
	
	private CardProb[] cardProbs(Deck unseenDeck) {
		
		CardProb[] cardProbsArray = new CardProb[13];
		
		cardProbsArray[0] = new CardProb("A", cardProbability("A"));
		
		for(int i = 2; i <= 10; i++) {
			
			cardProbsArray[i - 1] = new CardProb(Integer.toString(i), cardProbability(Integer.toString(i)));
			
		}
		
		cardProbsArray[10] = new CardProb("J", cardProbability("J"));
		cardProbsArray[11] = new CardProb("Q", cardProbability("Q"));
		cardProbsArray[12] = new CardProb("K", cardProbability("K"));
		
		return cardProbsArray;
		
	}
	
	public Data calculate(int knownSum) {
		
		Data data = new Data(possibilityLessThan21(knownSum), sumProbabilities(knownSum), cardProbs(this));
		
		return data;
		
	}
	
}
