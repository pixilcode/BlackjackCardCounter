package view;

import java.util.Scanner;

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
	
}
