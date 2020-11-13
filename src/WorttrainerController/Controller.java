package WorttrainerController;

/**
 * Worttrainer Kontrollklasse
 * 
 * @author oli
 */

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import WorttrainerModel.WortEintrag;
import WorttrainerModel.WortListe;
import WorttrainerModel.WortTrainer;
import WorttrainerModel.WorttrainerException;
import WorttrainerView.*;

@SuppressWarnings("serial")
public class Controller {
	
	
	/**
	 * Action Listener
	 */
	private AbstractAction action = new AbstractAction() {
	    @Override
	     public void actionPerformed(ActionEvent e) {
	            if(e.getActionCommand().contentEquals(""))
	        	 panel.setTotalWords(420);
	     }
	};	
	private Frame frame;
	private Panel panel;
	 
	/**
	 * Konstruktor
	 */
	public Controller() {
	    frame = new Frame(action);
	    panel = frame.getPanel();
	    
	   
	}
	
	/**
	 * Main Methode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	    new Controller();
	}
}
