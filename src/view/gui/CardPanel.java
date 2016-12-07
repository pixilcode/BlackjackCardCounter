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
	private List gameList;
	private SpringLayout baseLayout;
	
	
	public CardPanel(Controller baseController){
		this.baseController = baseController;
		blackJackPanel = new BlackJackPanel(baseController);
		gameList = new List();
		baseLayout = new SpringLayout();
		//buttons and other things go here:
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel(){
		setLayout(baseLayout);
		add(gameList);
	}
	
	private void setupLayout(){
	}
	
	private void setupListeners(){
		
	}
}
