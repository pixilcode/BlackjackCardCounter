package model.cardDataTypes;

import java.util.ArrayList;

import model.Suit;

public class CardDeck {
	//place to name variables
	private ArrayList<Card> baseDeck;
	private boolean hasJokers;
	private short decksInDeck;
	
	//default constructor
	public CardDeck(){
		this.hasJokers = false;
		this.decksInDeck = 1;
		initDeck();
	}
	//if the deck has jokers
	public CardDeck(boolean hasJokers){
		this();
		this.hasJokers = hasJokers;
		initDeck();
	}
	//if there is more than one deck
	public CardDeck(int decks){
		this();
		this.decksInDeck = (short) decks;
		for(int i =0; i<this.decksInDeck; i++){
			initDeck();
		}
	}
	//if there is more than one deck and it also has jokers
	public CardDeck(int decks, boolean hasJokers){
		this(decks);
		this.hasJokers = hasJokers;
		for(int i =0; i<this.decksInDeck; i++){
			initDeck();
		}
	}
	//init the deck
	private void initDeck(){
		for(int suit = 0; suit <4; suit ++){
				switch (suit){
				case 0:
					for(int card =0; card < 13; card++){
						baseDeck.add(new Card(Suit.SPADES,card));
					};
				case 1:						
					for(int card =0; card < 13; card++){
						baseDeck.add(new Card(Suit.DIAMONDS,card));
				};
				case 2:
					for(int card =0; card < 13; card++){
						baseDeck.add(new Card(Suit.CLUBS,card));
					};
				case 3:
					for(int card =0; card < 13; card++){
						baseDeck.add(new Card(Suit.HEARTS, card));
					};
				default :break;
			}
		}
		if(hasJokers){
			baseDeck.add(new Card(Suit.JOKER,Cards.JOKER,0));
			baseDeck.add(new Card(Suit.JOKER,Cards.JOKER,0));
		}
	}
	
	public void addDeck(){
		initDeck();
	}
	
	public void addDeck(boolean hasJokers){
		this.hasJokers = hasJokers;
		initDeck();
	}
	
	public void addCard(Card card){
		baseDeck.add(card);
	}
	
	public void removeCard(Card card){
		baseDeck.remove(card);
	}
	
	public boolean hasCard(Card card){
		boolean cardIsInDeck = false;
		baseDeck.contains(card);
		return cardIsInDeck;
	}
	
	public int hasCards(Suit suit){
		int cardsInDeck = 0;
		for(Card cardInDeck: baseDeck){
			if(cardInDeck.getSuit().equals(suit)) 
				cardsInDeck ++;
		}
		return cardsInDeck;
	}
	
	public int hasCards(Cards card){
		int cardsInDeck = 0;
		for(Card cardInDeck: baseDeck){
			if(cardInDeck.getSymbol().equals(card));
		}
		return cardsInDeck;
	}
	
	public int hasCards(Suit suit, Cards card){
		int cardsInDeck = 0;
		for(Card cardInDeck: baseDeck){
			if(cardInDeck.getSuit().equals(suit) && cardInDeck.getSymbol().equals(card))
				cardsInDeck ++;
		}
		return cardsInDeck;
	}
	
	public int hasCards(Card card){
		int cardsInDeck = 0;
		for(Card cardInDeck: baseDeck){
			if(cardInDeck.equals(card))cardsInDeck ++;
		}
		return cardsInDeck;
	}
}
