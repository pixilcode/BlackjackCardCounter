package view.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import view.gui.CardFrame;
import controller.Controller;

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
	
	private SpringLayout baseLayout;
	
	BlackJackPanel(Controller baseController){
		this.baseController = baseController;
		
		addCardButtons = new JButton[]{addAce = new JButton()
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
		
		this.baseLayout = new SpringLayout();


		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel(){
		this.setLayout(baseLayout);
		this.add(addCardButtons[0]);
		this.add(addCardButtons[1]);
		this.add(addCardButtons[2]);
		this.add(addCardButtons[3]);
		this.add(addCardButtons[4]);
		this.add(addCardButtons[5]);
		this.add(addCardButtons[6]);
		this.add(addCardButtons[7]);
		this.add(addCardButtons[8]);
		this.add(addCardButtons[9]);
		this.add(addCardButtons[10]);
		this.add(addCardButtons[11]);
		this.add(addCardButtons[12]);
	}
	
	private void setupLayout(){
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
	}
	
	private void setupListeners(){
		
	}
	
	@Override
	public void reset(){
		
	}
}
