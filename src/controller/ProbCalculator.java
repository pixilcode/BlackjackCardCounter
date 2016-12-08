package controller;

import java.util.ArrayList;

import model.CardProb;
import model.Data;
import model.cardDataTypes.*;
import model.sumDataTypes.*;
import view.User;

public class ProbCalculator {
	
	private static int possibleSums = 0;
	
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
	
	private static int sumsLessThan21(Deck deck, int knownSum) {
		
		int lessThan = 21 - knownSum;
		Card[] sumOf21;
		sumOf21 = deck.to1DArray();
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
	
	private static float possibilityLessThan21(Deck deck, int knownSum) {
		sums(deck, knownSum);
		return toPercent((float) (sumsLessThan21(deck, knownSum)) / possibleSums);
		
	}
	
	private static SumCount[] sums(Deck deck, int knownSum) {
		
		Card[] sumOf21;
		sumOf21 = deck.to1DArray();
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
	
	private static SumProb[] sumProbabilities(Deck deck, int knownSum) {
		
		SumCount[] sumsArray;
		sumsArray = sums(deck,knownSum);
		SumProb[] sumProbs = new SumProb[sumsArray.length];
		
		for(int i = 0; i < sumsArray.length; i++) {
			
			sumProbs[i] = new SumProb(sumsArray[i].getSum());
			sumProbs[i].setProb(toPercent((float) (sumsArray[i].getCount()) / possibleSums));
			
		}
		
		return sumProbs;
		
		
	}
	
	private static float cardProbability(Deck deck, String symbol) {
		
		Card[][] deckArray = deck.to2DArray();
		float numberOfCards = 0;
		
		for(int i = 0; i < deckArray.length; i++) {
			
			for(int j = 0; j < deckArray[i].length; j++) {
				
				if(deckArray[i][j].getSymbol() == symbol) {
					
					numberOfCards++;
					
					
				}
				
			}
			
		}
		
		return toPercent(numberOfCards / deck.length());
		
	}
	
	private static CardProb[] cardProbs(Deck deck) {
		
		CardProb[] cardProbsArray = new CardProb[13];
		
		cardProbsArray[0] = new CardProb("A", cardProbability(deck, "A"));
		
		for(int i = 2; i <= 10; i++) {
			
			if(i < 10) {
				
				cardProbsArray[i - 1] = new CardProb(Integer.toString(i), cardProbability(deck, Integer.toString(i)));
				
			} else {
				
				cardProbsArray[i - 1] = new CardProb(Integer.toString(i), cardProbability(deck, Integer.toString(i)));
				
			}
			
		}
		
		cardProbsArray[10] = new CardProb("J", cardProbability(deck, "J"));
		cardProbsArray[11] = new CardProb("Q", cardProbability(deck, "Q"));
		cardProbsArray[12] = new CardProb("K", cardProbability(deck, "K"));
		
		return cardProbsArray;
		
	}
	
	public static Data calculate(Deck deck, int knownSum) {
		
		Data data = new Data(possibilityLessThan21(deck, knownSum), sumProbabilities(deck, knownSum), cardProbs(deck));
		
		return data;
		
	}
	
}
