package view.gui;

import javax.swing.JFrame;
import controller.Controller;
import view.gui.CardPanel;

public class CardFrame extends JFrame{
	private Controller baseController;
	private CardPanel basePanel;
	private String title;
	private int frameSizex, frameSizey;
	
	public CardFrame(Controller baseController){
		this.baseController = baseController;
		basePanel = new CardPanel(baseController);
		title = "Card Counter 1.0";
		frameSizex = 600;
		frameSizey = 500;
		
		setupFrame();
	}
	
	public Controller getBaseController(){
		return this.baseController;
	}
	
	private void setupFrame(){
		this.setTitle(title);
		this.setContentPane(basePanel);
		this.setSize(frameSizex,frameSizey);
		this.setResizable(false);
		this.setVisible(true); //actualy show the window
		
	}
}
