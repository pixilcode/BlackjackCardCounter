package view.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import controller.Controller;

@SuppressWarnings({ "unused", "serial" })
public class CardPanel extends JPanel {
	private Controller baseController;
	//buttons and other things go here
	private BlackJackPanel blackJackPanel;
	private TexasHoldemPanel texasHoldemPanel;
	private GamePanel gamePanel;//339x315
	
	private JButton resetButton;
	
	private JComboBox gameListBox;
	private SpringLayout baseLayout;
	
	private String[] gameList;
	private JLayeredPane layeredPane;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CardPanel(Controller baseController){
		this.baseController = baseController;
		blackJackPanel = new BlackJackPanel(baseController);
		texasHoldemPanel = new TexasHoldemPanel(baseController);
		
		gamePanel = new GamePanel();
		
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
		baseLayout.putConstraint(SpringLayout.NORTH, gamePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, gamePanel, 6, SpringLayout.EAST, gameListBox);
		baseLayout.putConstraint(SpringLayout.EAST, blackJackPanel, -6, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, blackJackPanel, 325, SpringLayout.NORTH, this);
	}
	
	private void setupListeners(){
		resetButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent click) {
				resetGamePanel();
			}
			public void resetGamePanel(){
				gamePanel.reset();
				setGamePanel(blackJackPanel);
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
		baseLayout.putConstraint(SpringLayout.NORTH, gamePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, gamePanel, 6, SpringLayout.EAST, gameListBox);
		baseLayout.putConstraint(SpringLayout.EAST, blackJackPanel, -6, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, blackJackPanel, 325, SpringLayout.NORTH, this);
		this.gamePanel.setVisible(true);
	}
}
