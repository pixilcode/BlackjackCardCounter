package view.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import view.gui.CardFrame;
import controller.Controller;

@SuppressWarnings("serial")
public class BlackJackPanel extends GamePanel{
	Controller baseController;
	
	private JButton[]addCardButtons;
	private JButton addAce;
	private JButton addTwo;
	private JButton addThree;
	private JButton addFour;
	private JButton addFive;
	private JButton addSix;
	private JButton addSeven;
	private JButton addEight;
	private JButton addNine;
	private JButton addTen;
	private JButton addJack;
	private JButton addQueen;
	private JButton addKing;
	
	private JLabel winningPercentLabel;
	private JLabel lessThanPercentLabel;
	private JLabel greaterThanPercentLabel;
	
	private JLabel[] amountLabels;
	private JLabel amountOfAces;
	private JLabel amountOfTwos;
	private JLabel amountOfThrees;
	private JLabel amountOfFours;
	private JLabel amountOfFives;
	private JLabel amountOfSixes;
	private JLabel amountOfSevens;
	private JLabel amountOfEights;
	private JLabel amountOfNines;
	private JLabel amountOfTens;
	private JLabel amountOfJacks;
	private JLabel amountOfQueens;
	private JLabel amountOfKings;
	
	private SpringLayout baseLayout;
	
	BlackJackPanel(Controller baseController){
		this.baseController = baseController;
		
		this.initButtons();
		this.initLabels();
		
		this.baseLayout = new SpringLayout();


		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void initButtons(){
		this.addCardButtons = new JButton[]{addAce = new JButton()
				,addTwo = new JButton()
				,addThree = new JButton()
				,addFour = new JButton()
				,addFive = new JButton()
				,addSix = new JButton()
				,addSeven = new JButton()
				,addEight = new JButton()
				,addNine = new JButton()
				,addTen = new JButton()
				,addJack = new JButton()
				,addQueen = new JButton()
				,addKing = new JButton()};
	}
	
	private void initLabels(){
		this.winningPercentLabel = 		new JLabel();
		this.lessThanPercentLabel = 	new JLabel();
		this.greaterThanPercentLabel = 	new JLabel();
		this.amountLabels = new JLabel[]{
				this.amountOfAces = 			new JLabel(),
				this.amountOfTwos = 			new JLabel(),
				this.amountOfThrees = 			new JLabel(),
				this.amountOfFours = 			new JLabel(),
				this.amountOfFives = 			new JLabel(),
				this.amountOfSixes = 			new JLabel(),
				this.amountOfSevens = 			new JLabel(),
				this.amountOfEights = 			new JLabel(),
				this.amountOfNines = 			new JLabel(),
				this.amountOfTens = 			new JLabel(),
				this.amountOfJacks = 			new JLabel(),
				this.amountOfQueens = 			new JLabel(),
				this.amountOfKings = 			new JLabel(),};
		for(int i = 0; i < amountLabels.length; i++){
			amountLabels[i].setText("0");
		}
	}
	
	private void setupPanel(){
		this.setLayout(baseLayout);
		for(int i =0; i < this.addCardButtons.length; i++){
			this.add(addCardButtons[i]);
		}
		for(int i = 0; i < this.amountLabels.length; i ++){
			this.add(amountLabels[i]);
		}
		this.add(winningPercentLabel);
		this.add(lessThanPercentLabel);
		this.add(greaterThanPercentLabel);
	}
	
	private void setupLayout(){
		setBackground(Color.LIGHT_GRAY);
		addKing.setBackground(Color.LIGHT_GRAY);
		addQueen.setBackground(Color.LIGHT_GRAY);
		addJack.setBackground(Color.LIGHT_GRAY);
		addTen.setBackground(Color.LIGHT_GRAY);
		addNine.setBackground(Color.LIGHT_GRAY);
		addEight.setBackground(Color.LIGHT_GRAY);
		addSeven.setBackground(Color.LIGHT_GRAY);
		addSix.setBackground(Color.LIGHT_GRAY);
		addFive.setBackground(Color.LIGHT_GRAY);
		addFour.setBackground(Color.LIGHT_GRAY);
		addThree.setBackground(Color.LIGHT_GRAY);
		addTwo.setBackground(Color.LIGHT_GRAY);
		addAce.setBackground(Color.LIGHT_GRAY);
		
		addKing.setText("King");
		addQueen.setText("Queen");
		addJack.setText("Jack");
		addTen.setText("Ten");
		addNine.setText("Nine");
		addEight.setText("Eight");
		addSeven.setText("Seven");
		addSix.setText("Six");
		addFive.setText("Five");
		addFour.setText("Four");
		addThree.setText("Three");
		addTwo.setText("Two");
		addAce.setText("Ace");
		
		baseLayout.putConstraint(SpringLayout.SOUTH, addTen, -6, SpringLayout.NORTH, addJack);
		baseLayout.putConstraint(SpringLayout.WEST, addTwo, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, addJack, 164, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addFour, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addKing, 6, SpringLayout.SOUTH, addQueen);
		baseLayout.putConstraint(SpringLayout.EAST, addKing, 164, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addKing, 99, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addJack, 99, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addJack, 58, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, addNine, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addSeven, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addThree, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addTwo, 58, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, addAce, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addNine, 6, SpringLayout.SOUTH, addEight);
		baseLayout.putConstraint(SpringLayout.EAST, addNine, 75, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, addEight, -264, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addTen, 24, SpringLayout.EAST, addAce);
		baseLayout.putConstraint(SpringLayout.EAST, addTen, -175, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addEight, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addSix, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, addSix, -264, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addFive, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, addFive, -264, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, addAce, 75, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addThree, 6, SpringLayout.SOUTH, addTwo);
		baseLayout.putConstraint(SpringLayout.SOUTH, addAce, -6, SpringLayout.NORTH, addTwo);
		baseLayout.putConstraint(SpringLayout.EAST, addTwo, -24, SpringLayout.WEST, addJack);
		baseLayout.putConstraint(SpringLayout.NORTH, addQueen, 6, SpringLayout.SOUTH, addJack);
		baseLayout.putConstraint(SpringLayout.WEST, addQueen, 24, SpringLayout.EAST, addThree);
		baseLayout.putConstraint(SpringLayout.EAST, addQueen, -175, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addFour, 6, SpringLayout.SOUTH, addThree);
		baseLayout.putConstraint(SpringLayout.EAST, addThree, 75, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addFive, 6, SpringLayout.SOUTH, addFour);
		baseLayout.putConstraint(SpringLayout.EAST, addFour, -24, SpringLayout.WEST, addKing);
		baseLayout.putConstraint(SpringLayout.NORTH, addSix, 6, SpringLayout.SOUTH, addFive);
		baseLayout.putConstraint(SpringLayout.NORTH, addSeven, 6, SpringLayout.SOUTH, addSix);
		baseLayout.putConstraint(SpringLayout.NORTH, addEight, 6, SpringLayout.SOUTH, addSeven);
		baseLayout.putConstraint(SpringLayout.EAST, addSeven, 75, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfAces, 4, SpringLayout.NORTH, addAce);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfAces, 6, SpringLayout.EAST, addAce);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfTwos, 4, SpringLayout.NORTH, addTwo);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfTwos, 6, SpringLayout.EAST, addTwo);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfThrees, 4, SpringLayout.NORTH, addThree);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfThrees, 6, SpringLayout.EAST, addThree);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfFours, 4, SpringLayout.NORTH, addFour);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfFours, 6, SpringLayout.EAST, addFour);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfFives, 4, SpringLayout.NORTH, addFive);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfFives, 6, SpringLayout.EAST, addFive);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfSixes, 4, SpringLayout.NORTH, addSix);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfSixes, 6, SpringLayout.EAST, addSix);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfSevens, 4, SpringLayout.NORTH, addSeven);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfSevens, 6, SpringLayout.EAST, addSeven);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfEights, 4, SpringLayout.NORTH, addEight);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfEights, 6, SpringLayout.EAST, addEight);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfNines, 4, SpringLayout.NORTH, addNine);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfNines, 6, SpringLayout.EAST, addNine);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfTens, 4, SpringLayout.NORTH, addTen);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfTens, 6, SpringLayout.EAST, addTen);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfJacks, 4, SpringLayout.NORTH, addJack);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfJacks, 6, SpringLayout.EAST, addJack);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfQueens, 4, SpringLayout.NORTH, addQueen);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfQueens, 6, SpringLayout.EAST, addQueen);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfKings, 4, SpringLayout.NORTH, addKing);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfKings, 6, SpringLayout.EAST, addKing);
	}
	
	private void setupListeners(){
		for(int i = 0; i < addCardButtons.length; i++){
			this.addCardButtons[i].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent clicked) {
					//this listener is meant to get the amount of seen cards of each type and add cards to the seen deck of the blackjack game.
					//Update the percentages of things happening
				}
		
			});
		}
		
	}
	
	@Override
	public void reset(){
		
	}
}
