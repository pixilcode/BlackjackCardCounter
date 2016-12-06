package view;

import java.util.Scanner;
import model.CardProb;
import model.Data;
import model.sumDataTypes.SumProb;

public class User {
	
	//A scanner 'input' that can take input from the user
	static private Scanner input = new Scanner(System.in);
	
	//No initialization tasks
	User() {
		
	}
	
	//A method that gets input from the user
	public static String read() {
		
		return input.next();
		
	}
	
	
	
	//Methods that sends output to the user
	public static void print(Object in) {
		
		System.out.print(in);
		
	}
	
	public static void println(Object in) {
		
		System.out.println(in);
		
	}
	
	//Prompt an answer from the user
	public static String prompt(Object in) {
		
		User.print(in + " >>> ");
		return User.read();
		
	}
	
	//A method that prints out the data returned by ProbCalculator.calculate()
	public static void printData(Data data) {
		
		//Print out the title
		User.println("Statistics\n");
		
		//Print out the possibility that the sum of all cards will be less than 21
		User.println("The sum of all of the cards will be less than 21: " + data.getLessThan21() + "%\n");
		
		//Print out the sum probabilities
		User.println("Sum Probabilities\n"
				+ "(Sums not listed are 0.0%)");
		for(int i = 0; i < data.getSumProbs().length; i++) {
			
			SumProb sum = data.getSumProbs()[i];
			User.println("Sum of " + sum.getSum() + ": " + sum.getProb() + "%");
			
		}
		
		//Print out the card possibilities
		User.println("\nCard Probabilities");
		for(int i = 0; i < data.getCardProbs().length; i++) {
			
			CardProb card = data.getCardProbs()[i];
			User.println(card.getSymbol() + ": " + card.getProb() + "%");
			
		}
		
		User.println("");
		
	}
	
}
