package model;

import model.sumDataTypes.SumProb;

public class Data {
	
	//Declare variables
	private float lessThan21;
	private SumProb[] sumProbs;
	private CardProb[] cardProbs;
	
	//Assign the variables
	public Data(float lessThan21, SumProb[] sumProbability, CardProb[] cardProbs) {
		
		this.lessThan21 = lessThan21;
		this.sumProbs = sumProbability;
		this.cardProbs = cardProbs;
		
	}
	
	//Get the probability that the sum will be less than 21
	public float getLessThan21() {
		
		return lessThan21;
		
	}
	
	//Get sum probabilities
	public SumProb[] getSumProbs() {
		
		return sumProbs;
		
	}
	
	//Get card probabilities
	public CardProb[] getCardProbs() {
		
		return cardProbs;
		
	}
	
	
}
