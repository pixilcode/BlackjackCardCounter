package model.cardDataTypes;

import java.util.ArrayList;

import model.Suit;

public class Deck {
	
	//Declare variables
	protected ArrayList<Card> unseenDeck = new ArrayList<Card>();
	protected ArrayList<Card> seenDeck = new ArrayList<Card>();
	
	//Create an array with standard strings in it
	protected static final String[] standardCardSymbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	//Create variables that store King, Queen, Jack, and Ace Values
	final int ACE = 1;
	final int JACK = 11;
	final int QUEEN = 12;
	final int KING = 13;
	final int JOKER = 14;
	
	//A constructor that gives the deck the four suits
	public Deck(boolean addJokers) {
		
		for(int i = 0; i < 52; i++) {
			
			Suit suit = Suit.SPADES;
			
			//Set the suit according to 'i'
			switch((i % 13)) {
			
			case 0:
				suit = Suit.SPADES;
				break;
			
			case 1:
				suit = Suit.CLUBS;
				break;
			
			case 2:
				suit = Suit.DIAMONDS;
				break;
			
			case 3:
				suit = Suit.HEARTS;
				break;
			
			}
			
			unseenDeck.add(new Card(suit, standardCardSymbols[i], i + 1));
			
		}
		
		//If they want Jokers, add Jokers
		if(addJokers) {
			
			unseenDeck.add(new Card(Suit.JOKER, "JK", 0));
			unseenDeck.add(new Card(Suit.JOKER, "JK", 0));
			
		}
		
		unseenDeck.sort(null);
		
	}
	
	public int length() {
		
		return unseenDeck.size();
		
	}

	public String toString() {
		
		return unseenDeck.toString();
		
	}
	
	public Card[] toArray() {
		
		Card[] deckArray = new Card[unseenDeck.size()];
		unseenDeck.toArray(deckArray);
		
		return deckArray;
		
	}
	
	public int getSymbolValue(String symbol) {
		
		if(symbol.equals("A")) {
			
			return this.ACE;
		
		} else if(symbol.equals("J")) {
			
			return this.JACK;
			
		} else if(symbol.equals("Q")) {
			
			return this.QUEEN;
			
		} else if(symbol.equals("K")) {
			
			return this.KING;
			
		} else if(symbol.equals("JK")) {
			
			return this.JOKER;
			
		}
		
		return Integer.parseInt(symbol);
		
	}
	
	public void addToDeck(Card card) {
		
		unseenDeck.add(card);
		unseenDeck.sort(null);
		
	}
	
	public void addToDeck(String suit, String symbol, int value) {
		
		addToDeck(new Card(Suit.valueOf(suit), symbol, value));
		
	}
	
	public void addDeck(Deck deck) {
		
		Card[] deckArray = deck.toArray();
		
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
		
		removeFromDeck(new Card(Suit.valueOf(suit), symbol, value));
		
	}
	
	public void add(Card card) {
		
		if(seenDeck.contains(card)) {
			
			seenDeck.remove(card);
			unseenDeck.add(card);
			
		}
		
		unseenDeck.sort(null);
		
	}
	
	public void add(String suit, String symbol, int value) {
		
		add(new Card(Suit.valueOf(suit), symbol, value));
		
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
	
	public void remove(String suit, String symbol, int value) {
		
		remove(new Card(Suit.valueOf(suit), symbol, value));
		
	}
	
	public void remove(String symbol) {
		
		if(unseenDeck.contains(new Card(Suit.SPADES, symbol, getSymbolValue(symbol)))) {
			
			remove(Suit.SPADES.toString(), symbol, getSymbolValue(symbol));
			
		} else if(unseenDeck.contains(new Card(Suit.CLUBS, symbol, getSymbolValue(symbol)))) {
			
			remove(Suit.CLUBS.toString(), symbol, getSymbolValue(symbol));
			
		} else if(unseenDeck.contains(new Card(Suit.DIAMONDS, symbol, getSymbolValue(symbol)))) {
			
			remove(Suit.DIAMONDS.toString(), symbol, getSymbolValue(symbol));
			
		} else if(unseenDeck.contains(new Card(Suit.HEARTS, symbol, getSymbolValue(symbol)))) {
			
			remove(Suit.HEARTS.toString(), symbol, getSymbolValue(symbol));
			
		}
		
	}
	
	public void undo() {
		
		Card undoneCard = seenDeck.remove(seenDeck.size() - 1);
		unseenDeck.add(undoneCard);
		unseenDeck.sort(null);
		
	}
	
}
