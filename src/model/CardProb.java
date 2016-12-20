package model;

public class CardProb {
	
	String symbol;
	float prob;
	
	public CardProb(String symbol, float prob) {
		
		this.symbol = symbol;
		this.prob = prob;
		
	}

	public String getSymbol() {
		
		return symbol;
		
	}
	
	public float getProb() {
		
		return prob;
		
	}
	
}
