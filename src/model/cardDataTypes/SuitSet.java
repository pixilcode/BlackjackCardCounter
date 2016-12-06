package model.cardDataTypes;

import java.util.ArrayList;

public class SuitSet {
	
	//Declare the values of a "Ace", "Jack", "Queen", and "King"
	static final int ACE = 1;
	static final int JACK = 10;
	static final int QUEEN = 10;
	static final int KING = 10;
	
	//Initialize a variable for the suit name, as well as an array of 13 to store the card values and the last integer to be removed
	String suitName;
	char symbol;
	Card lastRemovedCard = new Card(null, 'A', 0);
	boolean undo = true;
	ArrayList<Card> cardSet = new ArrayList<Card>();
	
	//An initializer that takes a String 'suit' as an argument
	public SuitSet(String suit) {
		
		//Give the suit a name and reset the card set to have 13 cards
		suitName = suit;
		symbol = (suit.toUpperCase()).charAt(0);
		reset();
		
	}
	
	//A method that returns a string that displays the card set in the format of [ num1, num2, ..., numX ]
	public String toString() {
		
		String cardSetString = suitName + " [ ";
		
		for(int i = 0; i < cardSet.size() - 1; i++) {
			
			cardSetString += cardSet.get(i).toString() + ", ";
			
		}
		
		cardSetString += cardSet.get(cardSet.size() - 1).toString() + " ]";
		
		return cardSetString;
		
	}
	
	//A method that gets the suit
	public String getSuit() {
		
		return suitName;
		
	}
	
	//A method that gets the suit symbol
	public char getSymbol() {
		
		return symbol;
		
	}
	
	//A method that returns a 'Card' array with the contents of the array list
	public Card[] toArray() {
		
	Card[] cardSetArray = new Card[cardSet.size()];
		
		for(int i = 0; i < cardSet.size(); i++) {
			
			cardSetArray[i] = cardSet.get(i);
			
		}
		
		return cardSetArray;
		
	}
	
	//A method that resets the suit set
	public void reset() {
		
		cardSet.clear();
		
		cardSet.add(new Card(suitName, 'A', ACE));
		
		for(int i = 2; i <= 10; i++) {
			
			if(i < 10) {
				
				cardSet.add(new Card(suitName, Integer.toString(i).charAt(0), i));
				
			} else {
				
				cardSet.add(new Card(suitName, Integer.toString(i).charAt(1), i));
				
			}
			
		}
		
		cardSet.add(new Card(suitName, 'J', JACK));
		cardSet.add(new Card(suitName, 'Q', QUEEN));
		cardSet.add(new Card(suitName, 'K', KING));
		
	}
	
	//A method that removes a card
	public void remove(Card card) {
		
		lastRemovedCard = card;
		
		cardSet.remove(lastRemovedCard);
		
		undo = false;
		
	}
	
	//A method that undoes the previous move
	public void undo() {
		
		if(!undo) {
			
			cardSet.add(lastRemovedCard);
			cardSet.sort(null);
			undo = true;
			
		}
		
	}
	
}
