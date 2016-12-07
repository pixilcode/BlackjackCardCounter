package view.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import view.gui.CardFrame;
import controller.Controller;

public class CardPanel extends JPanel {
	private Controller baseController;
	//buttons and other things go here
	
	private SpringLayout baseLayout;
	
	
	public CardPanel(Controller baseController){
		this.baseController = baseController;
		//buttons and other things go here:
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel(){
		
	}
	
	private void setupLayout(){
		//place to put pregenerated garbage
		
	}
	
	private void setupListeners(){
		
	}
}
