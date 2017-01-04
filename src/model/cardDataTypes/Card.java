package model.cardDataTypes;

public class Card{
	
	//Declare variables
	private Suit suit;
	private CardSymbols symbol;
	private int value;
	
	//default constructor
	public Card(){
		value = 0;
	}
	
	//Constructor assigns suit, symbol, and value to the card
	public Card(Suit suit, CardSymbols symbol, int value) {
		
		this.suit = suit;
		this.symbol = symbol;
		this.value = value;
	}
	
	public Card(Suit suit, int value){
		this.suit = suit;
		this.value = value;
		this.symbol = CardSymbols.getCard(value);
	}
	
	public Card(CardSymbols symbol){
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
	public CardSymbols getSymbol() {
		
		return this.symbol;
		
	}
	
	//Get the value
	public int getValue() {
		
		return value;
		
	}
	
}
