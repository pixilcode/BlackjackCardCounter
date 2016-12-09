package model.cardDataTypes;

import java.util.ArrayList;

public class Deck {
	
	//Declare variables
	private ArrayList<Card> unseenDeck = new ArrayList<Card>();
	private ArrayList<Card> seenDeck = new ArrayList<Card>();
	
	//Create an array with standard strings in it
	private static final String[] standardCardSymbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
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
			
			unseenDeck.add(new Card(suit, standardCardSymbols[i], i + 1));
			
		}
		
		
		unseenDeck.sort(null);
		
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
	
	public void addToDeck(Card card) {
		
		unseenDeck.add(card);
		unseenDeck.sort(null);
		
	}
	
	public void addToDeck(String suit, String symbol, int value) {
		
		addToDeck(new Card(suit, symbol, value));
		
	}
	
	public void addDeck(Deck deck) {
		
		Card[] deckArray = deck.to1DArray();
		
		for(int i = 0; i < deckArray.length; i++) {
			
			unseenDeck.add(deckArray[i]);
			
		}
		
		unseenDeck.sort(null);
		
	}
	
	public void removeFromDeck(Card card) {
		
		if(unseenDeck.contains(card)) {
			
			unseenDeck.remove(card);
			
		} else if(seenDeck.contains(card)) {
			
			seenDeck.remove(card);
			
		}
		
		unseenDeck.sort(null);
		
	}
	
	public void removeFromDeck(String suit, String symbol, int value) {
		
		removeFromDeck(new Card(suit, symbol, value));
		
	}
	
	public void add(Card card) {
		
		if(seenDeck.contains(card)) {
			
			seenDeck.remove(card);
			unseenDeck.add(card);
			
		}
		
		unseenDeck.sort(null);
		
	}
	
	public void add(String suit, String symbol, int value) {
		
		add(new Card(suit, symbol, value));
		
	}
	
	public void reset() {
		
		for(int i = 0; i < seenDeck.size(); i++) {
			
			unseenDeck.add(seenDeck.get(i));
			
		}
		
		unseenDeck.sort(null);
		seenDeck.clear();
		
	}
	
	public void remove(Card card) {
		
		if(unseenDeck.contains(card)) {
			
			unseenDeck.remove(card);
			seenDeck.add(card);
			
		}
		
		unseenDeck.sort(null);
		
	}
	
	public void undo() {
		
		Card undoneCard = seenDeck.remove(seenDeck.size() - 1);
		unseenDeck.add(undoneCard);
		unseenDeck.sort(null);
		
	}
	
}
