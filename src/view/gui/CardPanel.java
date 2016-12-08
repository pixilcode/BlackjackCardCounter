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
	private JComboBox gameListBox;
	private SpringLayout baseLayout;
	
	private String[] gameList;
	
	public CardPanel(Controller baseController){
		this.baseController = baseController;
		blackJackPanel = new BlackJackPanel(baseController);
		gameList = new String[] {"BlackJack"};
		
		 gameListBox = new JComboBox(gameList);
		
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, gameListBox, 10, SpringLayout.NORTH, this);


		//buttons and other things go here:
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel(){
		setLayout(baseLayout);
		this.add(gameListBox);
	}
	
	private void setupLayout(){
		baseLayout.putConstraint(SpringLayout.WEST, gameListBox, 10, SpringLayout.WEST, this);
	}
	
	private void setupListeners(){
		gameListBox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(gameList[0].equals((String)gameListBox.getSelectedItem())){ //blackJack selected remove other game views and load blackjack view
					
				}
				
			}
			 
		});
	}
}
