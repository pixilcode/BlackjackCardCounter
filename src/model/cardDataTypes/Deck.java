package model.cardDataTypes;

import java.util.ArrayList;

public class Deck {
	
	//Declare variables
	SuitSet[] deck;
	int length = 0;
	
	//A constructor that gives the deck the four suits
	public Deck() {
		
		deck = new SuitSet[4];
		deck[0] = new SuitSet("Spades");
		deck[1] = new SuitSet("Clubs");
		deck[2] = new SuitSet("Diamonds");
		deck[3] = new SuitSet("Hearts");
		
		updateLength();
		
	}
	
	public int length() {
		
		updateLength();
		
		return length;
		
	}
	
	private void updateLength() {
		
		Card[][] deckArray = to2DArray();
		length = 0;
		
		for(int i = 0; i < deckArray.length; i++) {
			
			for(int j = 0; j < deckArray[i].length; j++) {
				
				length++;
				
			}
			
		}
		
	}

	public String toString() {
		
		String deckString = "";
		
		for(int i = 0; i < deck.length; i++) {
			
			deckString += (deck[i].toString() + "\n");
			
		}
		
		return deckString;
		
	}
	
	public Card[] to1DArray() {
		
		Card[][] deck2DArray = to2DArray();
		ArrayList<Card> deck1DList = new ArrayList<Card>();
		
		for(int i = 0; i < deck2DArray.length; i++) {
			
			for(int j = 0; j < deck2DArray[i].length; j++) {
				
				deck1DList.add(deck2DArray[i][j]);
				
			}
			
		}
		
		Card[] deck1DArray = deck1DList.toArray(new Card[0]);
		
		return deck1DArray;
		
	}
	
	public Card[][] to2DArray() {
		
		Card[][] deckArray = new Card[deck.length][13];
		
		for(int i = 0; i < deck.length; i++) {
			
			deckArray[i] = deck[i].toArray();
			
		}
		
		return deckArray;
	}
	
	public void reset() {
		
		for(int i = 0; i < deck.length; i++) {
			
			deck[i].reset();
			
		}
		
		updateLength();
		
	}
	
	public void remove(Card card) {
		
		for(int i = 0; i < deck.length; i++) {
			
			if((card.getSuit().toUpperCase()).charAt(0) == deck[i].getSymbol()) {
				
				deck[i].remove(card);
				
			}
			
		}
		
		if(to1DArray().length < 1) {
			
			reset();
			
		}
		
		updateLength();
		
	}
	
	public void remove(String suit, char symbolIn) {
		
		String symbol = Character.toString(symbolIn);
		int value = 0;
		
		if(symbol.equals("K") || symbol.equals("Q") || symbol.equals("J")) {
			
			value = 10;
			
		} else {
			
			value = Integer.parseInt(symbol);
			
		}
		
		remove(new Card(suit, symbolIn, value));
		
	}
	
	public void undo() {
		
		for(int i = 0; i < deck.length; i++) {
			
			deck[i].undo();
			
		}
		
		updateLength();
		
	}
	
}
