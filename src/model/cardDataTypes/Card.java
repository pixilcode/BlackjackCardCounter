package model.cardDataTypes;

public class Card implements Comparable<Card> {
	
	//Declare variables
	private String suit;
	private char symbol;
	private int value;
	
	//Constructor assigns suit, symbol, and value to the card
	public Card(String suit, char symbol, int value) {
		
		this.suit = suit;
		this.symbol = symbol;
		this.value = value;
		
	}
	
	//Turn the card into a string
	public String toString() {
		return "[ " + value + ", " + symbol + " of " + suit + " ]";
	}
	
	//Get the suit
	public String getSuit() {
		
		return suit;
		
	}
	
	//Get the symbol
	public char getSymbol() {
		
		return symbol;
		
	}
	
	//Get the value
	public int getValue() {
		
		return value;
		
	}
	
	//Test to see if the card is equal to another given object
	public boolean equals(Object obj) {
		
		//If the object reference is exact same, return true
		if (this == obj) return true;
		
		//If the object is null, return false
		if (obj == null) return false;
		
		//If the classes are different, return false
		if (getClass() != obj.getClass()) return false;
		
		//Create a Card representing the given object
		Card other = (Card) obj;
		
		//If the comparing card suit is null, and the input card is not, return false
		if (suit == null) {
			
			if (other.suit != null) return false;
		
		//Else if the suits are not equal, return false
		} else if (!suit.equals(other.suit)) return false;
		
		//If the symbols are not the same, return false
		if (symbol != other.symbol) return false;
		
		//If the value is not the same, return false
		if (value != other.value) return false;
		
		//If all the conditions were met, return true
		return true;
		
	}
	
	//Compare this card to the given card
	public int compareTo(Card c) {
		
		//If the value is the same, compare the symbols
		if(this.getValue() == c.getValue()) {
			
			//If the symbols are the same, return 0
			if(this.getSymbol() == c.getSymbol()) {
				
				return 0;
				
			//If this card symbol is 'K', return 1
			} else if(this.getSymbol() == 'K') {
				
				return 1;
				
			//If this card symbol is 'J', return -1
			} else if(this.getSymbol() == 'J') {
				
				return -1;
			//If the given card symbol is 'K', return -1	
			} else if(c.getSymbol() == 'K') {
				
				return -1;
				
			//If the given card symbol is 'J', return 1
			} else if(c.getSymbol() == 'J') {
				
				return 1;
				
			}
			
		//Else if this card's value is greater than the given card's value, return 1
		} else if(this.getValue() > c.getValue()) {
			
			return 1;
			
		//Else return -1
		} else {
			
			return -1;
			
		}
		
		//Return 0 in case all of the above situations don't work
		return 0;
		
	}
	
}
