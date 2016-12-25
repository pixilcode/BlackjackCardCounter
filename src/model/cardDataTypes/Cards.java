package model.cardDataTypes;

public enum Cards {
	ACE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(11),
	QUEEN(12),
	KING(13),
	JOKER(14);
	
	private final int value;
	private Cards(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
	
	public static Cards getCard(int cardValue){
		Cards returnCard = null;
		for(Cards card: values()){
			if(card.value == cardValue){
				returnCard = card;
			}
		}
		return returnCard;
	}
}
