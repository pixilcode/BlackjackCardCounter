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
	private GamePanel gamePanel;//339x315
	
	private JButton resetButton;
	
	private JComboBox gameListBox;
	private SpringLayout baseLayout;
	
	private String[] gameList;
	
	public CardPanel(Controller baseController){
		this.baseController = baseController;
		blackJackPanel = new BlackJackPanel(baseController);
		gamePanel = blackJackPanel;
		gameList = new String[] {"BlackJack","TexasHoldem"};
		
		resetButton = new JButton();
		resetButton.setText("RESET");
		
		gameListBox = new JComboBox(gameList);
		
		baseLayout = new SpringLayout();

		//buttons and other things go here:
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel(){
		setLayout(baseLayout);
		this.add(gameListBox);
		this.add(gamePanel);
		this.add(resetButton);
		
	}
	
	private void setupLayout(){//place to put generated garbage
		baseLayout.putConstraint(SpringLayout.NORTH, resetButton, 30, SpringLayout.SOUTH, gameListBox);
		baseLayout.putConstraint(SpringLayout.EAST, resetButton, 0, SpringLayout.EAST, gameListBox);
		baseLayout.putConstraint(SpringLayout.WEST, gameListBox, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, gameListBox, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, gamePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, gamePanel, 6, SpringLayout.EAST, gameListBox);
		baseLayout.putConstraint(SpringLayout.EAST, blackJackPanel, -6, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, blackJackPanel, 325, SpringLayout.NORTH, this);

	}
	
	private void setupListeners(){
		gameListBox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(gameList[0].equals((String)gameListBox.getSelectedItem())){ //blackJack selected remove other game views and load blackjack view
					setGamePanel(blackJackPanel);
				}
				
			}
			public void setGamePanel(GamePanel panel){
				gamePanel = panel;
			}
			 
		});// listener that listens for game changes
		
		resetButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent click) {
				resetGamePanel();
			}
			public void resetGamePanel(){
				gamePanel.reset();
			}
			
		});
		
	}
}
