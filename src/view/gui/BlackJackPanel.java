package view.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import view.gui.CardFrame;
import controller.Controller;

public class BlackJackPanel extends JPanel{
	Controller baseController;
	
	BlackJackPanel(Controller baseController){
		this.baseController = baseController;
	}
}
