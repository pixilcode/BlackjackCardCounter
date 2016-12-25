package model.cardDataTypes;

import model.Suit;

public class Card{
	
	//Declare variables
	private Suit suit;
	private Cards symbol;
	private int value;
	
	//default constructor
	public Card(){
		value = 0;
	}
	
	//Constructor assigns suit, symbol, and value to the card
	public Card(Suit suit, Cards symbol, int value) {
		
		this.suit = suit;
		this.symbol = symbol;
		this.value = value;
	}
	
	public Card(Suit suit, int value){
		this.suit = suit;
		this.value = value;
		this.symbol = Cards.getCard(value);
	}
	
	public Card(Cards symbol){
		this.suit = null;
		this.symbol = symbol;
		this.value = symbol.getValue();
	}
	
	//Turn the card into a string
	public String toString() {
		return "[ " + symbol + " of " + suit + ", Value: " + value + " ]";
	}
	
	//Get the suit
	public Suit getSuit() {
		
		return suit;
		
	}
	
	//Get the symbol
	public Cards getSymbol() {
		
		return symbol;
		
	}
	
	//Get the value
	public int getValue() {
		
		return value;
		
	}
	
}
