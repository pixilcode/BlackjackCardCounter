package model.sumDataTypes;

public class SumCount {
	
	private int sum;
	private int count;
	
	public SumCount(int sum) {
		
		this.sum = sum;
		this.count = 0;
		
	}
	
	public int getSum() {
		
		return sum;
	
	}

	public int getCount() {
		
		return count;
		
	}
	
	public String toString() {
		
		return "( Sum: " + Integer.toString(sum) + " :: Count: " + Integer.toString(count) + " )";
		
	}

	public void increment() {
		
		count++;
		
	}
	
	public void reset() {
		
		count = 0;
		
	}
	
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		SumCount other = (SumCount) obj;
		
		if (sum != other.sum)
			return false;
		
		return true;
	}
	
	
	
}
