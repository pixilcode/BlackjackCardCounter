package model.cardDataTypes;

import java.util.ArrayList;

public class Deck {
	
	//Declare variables
	private ArrayList<Card> unseenDeck = new ArrayList<Card>();
	private ArrayList<Card> seenDeck = new ArrayList<Card>();
	private Card lastRemovedCard = new Card("", "", 0);
	private boolean undo = false;
	
	//Create an array with standard strings in it
	private String[] standardCardSymbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	//A constructor that gives the deck the four suits
	public Deck() {
		
		for(int i = 0; i < 52; i++) {
			
			String suit = "";
			
			//Set the suit according to 'i'
			switch((i % 13)) {
			
			case 0:
				suit = "SPADES";
				break;
			
			case 1:
				suit = "CLUBS";
				break;
			
			case 2:
				suit = "DIAMONDS";
				break;
			
			case 3:
				suit = "HEARTS";
				break;
			
			}
			
			unseenDeck.add(new Card(suit, standardCardSymbols[i], i));
			
		}
		
		
		
	}
	
	public int length() {
		
		return unseenDeck.size();
		
	}

	public String toString() {
		
		return unseenDeck.toString();
		
	}
	
	public Card[] to1DArray() {
		
		Card[] deck1DArray = new Card[unseenDeck.size()];
		unseenDeck.toArray(deck1DArray);
		
		return deck1DArray;
		
	}
	
	public void reset() {
		
		for(int i = 0; i < seenDeck.size(); i++) {
			
			unseenDeck.add(seenDeck.get(i));
			
		}
		
		seenDeck.clear();
		
	}
	
	public void remove(Card card) {
		
		if(unseenDeck.contains(card)) {
			
			unseenDeck.remove(card);
			seenDeck.add(card);
			lastRemovedCard = card;
			undo = true;
			
		}
		
	}
	
	public void remove(String suit, String symbolIn) {
		
		String symbol = symbolIn;
		int value = 0;
		
		if(symbol.equals("K") || symbol.equals("Q") || symbol.equals("J")) {
			
			value = 10;
			
		} else {
			
			value = Integer.parseInt(symbol);
			
		}
		
		remove(new Card(suit, symbol, value));
		
	}
	
	public void undo() {
		
		if(undo) {
			
			unseenDeck.add(lastRemovedCard);
			seenDeck.add(lastRemovedCard);
			undo = false;
			
		}
		
	}
	
}
