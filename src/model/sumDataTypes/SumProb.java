package model.sumDataTypes;

public class SumProb {
	
	int sum;
	float prob;
	
	public SumProb(int sum) {
		
		this.sum = sum;
		this.prob = 0;
		
	}
	
	public int getSum() {
		
		return sum;
	
	}

	public float getProb() {
		
		return prob;
		
	}
	
	public void setProb(float prob) {
		
		this.prob = prob;
		
	}

	public String toString() {
		
		return Integer.toString(sum) + ": " + Float.toString(prob);
		
	}
	
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		SumProb other = (SumProb) obj;
		
		if (sum != other.sum)
			return false;
		
		return true;
	}
	
	
	
}
