package WorttrainerView;

/**
 * @author oli
 * @version 29.05.2019
 * 
 * Frame-Klasse für VieleLayouts mit main-Methode
 */

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame{

	private Panel panel;
	
	public Frame(AbstractAction action) {
		super("Worttrainer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450,450);
		setResizable(true);
		setMinimumSize(new Dimension(450,450));
		panel = new Panel(action);
		setContentPane(panel);
		getContentPane().setBackground(new Color(255,255,255));
		setVisible(true);
	}
	
	public Panel getPanel() {
	    return panel;
	}
}