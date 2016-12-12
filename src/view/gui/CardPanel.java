package view.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import controller.Controller;

@SuppressWarnings({ "unused", "serial" })
public class CardPanel extends JPanel {
	private Controller baseController;
	//buttons and other things go here
	private GamePanel gamePanel;//339x315
	
	private JButton resetButton;
	
	private JComboBox gameListBox;
	private SpringLayout baseLayout;
	
	private String[] gameList;
	private JLayeredPane layeredPane;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CardPanel(Controller baseController){
		this.baseController = baseController;
		
		gamePanel = new BlackJackPanel(baseController);
		
		gameList = new String[] {"BlackJack","TexasHoldem"};
		resetButton = new JButton();		
		gameListBox = new JComboBox(gameList);
		
		baseLayout = new SpringLayout();
		layeredPane = new JLayeredPane();

		//buttons and other things go here:
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel(){
		setLayout(baseLayout);
		this.add(gameListBox);
		this.gameListBox.setEnabled(true);
		this.add(gamePanel);
		this.add(resetButton);		
		this.resetButton.setEnabled(true);
		this.add(layeredPane);
	}
	
	private void setupLayout(){//place to put generated garbage
		resetButton.setText("RESET");
		resetButton.setBackground(Color.LIGHT_GRAY);
		baseLayout.putConstraint(SpringLayout.NORTH, resetButton, 30, SpringLayout.SOUTH, gameListBox);
		baseLayout.putConstraint(SpringLayout.EAST, resetButton, 0, SpringLayout.EAST, gameListBox);
		baseLayout.putConstraint(SpringLayout.WEST, gameListBox, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, gameListBox, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, gamePanel, 0, SpringLayout.NORTH, gameListBox);
		baseLayout.putConstraint(SpringLayout.WEST, gamePanel, 6, SpringLayout.EAST, gameListBox);
		baseLayout.putConstraint(SpringLayout.SOUTH, gamePanel, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, gamePanel, -10, SpringLayout.EAST, this);
	}
	
	private void setupListeners(){
		gameListBox.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED){
					if(gameListBox.getSelectedItem().equals(gameList[0])){
						BlackJackPanel blackJackPanel = new BlackJackPanel(baseController);
						setGamePanel(blackJackPanel);
					}else if(gameListBox.getSelectedItem().equals(gameList[1])){
						TexasHoldemPanel texasHoldemPanel = new TexasHoldemPanel(baseController);
						setGamePanel(texasHoldemPanel);
					}
				}
			}
		});
		
		
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
	private void setGamePanel(GamePanel panel){
		this.gamePanel.setVisible(false);
		this.remove(gamePanel);
		gamePanel = panel;
		this.add(gamePanel);
		this.gamePanel.invalidate();
		this.gamePanel.validate();
		baseLayout.putConstraint(SpringLayout.NORTH, gamePanel, 0, SpringLayout.NORTH, gameListBox);
		baseLayout.putConstraint(SpringLayout.WEST, gamePanel, 6, SpringLayout.EAST, gameListBox);
		baseLayout.putConstraint(SpringLayout.SOUTH, gamePanel, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, gamePanel, -10, SpringLayout.EAST, this);
		this.gamePanel.setVisible(true);
	}
}
