package model;

public class CardProb {
	
	char symbol;
	float prob;
	
	public CardProb(char symbol, float prob) {
		
		this.symbol = symbol;
		this.prob = prob;
		
	}

	public char getSymbol() {
		
		return symbol;
		
	}
	
	public float getProb() {
		
		return prob;
		
	}
	
}
