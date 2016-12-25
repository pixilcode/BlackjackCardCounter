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
	
	public Cards getCard(int value){
		Cards returnType = null;
		switch(value){
		case 1: returnType = ACE;
		case 2: returnType = TWO;
		case 3: returnType = THREE;
		case 4: returnType = FOUR;
		case 5: returnType = FIVE;
		case 6: returnType = SIX;
		case 7: returnType = SEVEN;
		case 8: returnType = EIGHT;
		case 9: returnType = NINE;
		case 10: returnType = TEN;
		case 11: returnType = JACK;
		case 12: returnType = QUEEN;
		case 13: returnType = KING;
		case 0: returnType = JOKER;
		default: break;
		}
		return returnType;
	}
}
