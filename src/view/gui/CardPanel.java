package view.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import view.gui.*;
import controller.Controller;

public class CardPanel extends JPanel {
	private Controller baseController;
	//buttons and other things go here
	private BlackJackPanel blackJackPanel;
	private JList gameList;
	private JButton modeBlackJack;
	private SpringLayout baseLayout;
	
	
	public CardPanel(Controller baseController){
		this.baseController = baseController;
		blackJackPanel = new BlackJackPanel(baseController);
		gameList = new JList();
		modeBlackJack = new JButton();
		modeBlackJack.setText("BlackJack");
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, gameList, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, gameList, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, gameList, 55, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, gameList, 104, SpringLayout.WEST, this);
		//buttons and other things go here:
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel(){
		setLayout(baseLayout);
		add(gameList);
		gameList.add(modeBlackJack);
	}
	
	private void setupLayout(){
	}
	
	private void setupListeners(){
		
	}
}
