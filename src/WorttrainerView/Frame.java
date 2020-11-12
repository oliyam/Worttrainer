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

public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public Frame(AbstractAction ctrl){
		super("Worttrainer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450,450);
		setResizable(true);
		setMinimumSize(new Dimension(0,450));
		MainLayoutPanel pp = new MainLayoutPanel(ctrl);
		setContentPane(pp);
		getContentPane().setBackground(new Color(255,255,255));
		setVisible(true);
	}
}