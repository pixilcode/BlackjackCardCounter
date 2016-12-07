package view.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import view.gui.CardFrame;
import controller.Controller;

public class CardPanel extends JPanel {
	private Controller baseController;
	//buttons and other things go here
	Choice choice;
	private SpringLayout baseLayout;
	
	
	public CardPanel(Controller baseController){
		this.baseController = baseController;
		
		choice = new Choice();
		//buttons and other things go here:
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel(){
		this.setLayout(baseLayout);
		this.add(choice);
	}
	
	private void setupLayout(){
		//place to put pregenerated garbage
		
	}
	
	private void setupListeners(){
		
	}
}
