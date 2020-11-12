package WorttrainerController;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import WorttrainerModel.WortEintrag;
import WorttrainerModel.WortListe;
import WorttrainerModel.WortTrainer;
import WorttrainerModel.WorttrainerException;
import WorttrainerView.*;

/**
 * Testklasse für das WortTrainer-Model
 * 
 * @author oli
 *
 */

public class Controller {
	
	/**
	 * testet die WortEintrag Klasse
	 * 
	 * @return
	 * @throws WorttrainerException
	 */
	public static WortEintrag testWortEintrag() throws WorttrainerException{
		WortEintrag wort=new WortEintrag("Sanic", "https://vignette.wikia.nocookie.net/meme/images/4/42/1385136139955.png/revision/latest?cb=20150207013804");
		System.out.println("Wort: "+wort.getWort());
		System.out.println("URL: "+wort.getUrl());
		wort.setWort("DaQueen");
		wort.setUrl("https://vignette.wikia.nocookie.net/gameideas/images/a/a6/Kanna_Kamui.png/revision/latest?cb=20171205153548");
		System.out.println("toString des Eintrags: "+wort.toString());
		return wort;
	}
	
	/**
	 * testet die WortListe Klasse
	 * 
	 * @param eintrag	WortEintrag der in die Liste eingefügt wird
	 * @return
	 * @throws WorttrainerException
	 */
	public static WortListe testWortListe(WortEintrag eintrag) throws WorttrainerException{
		WortListe liste=new WortListe();
		System.out.println(liste.toString());
		liste.hinzu(eintrag);
		liste.hinzu(new WortEintrag("Sanic", "https://vignette.wikia.nocookie.net/meme/images/4/42/1385136139955.png/revision/latest?cb=20150207013804"));
		liste.hinzu(new WortEintrag("Knuckles", "https://i.imgflip.com/26l32r.jpg"));
		System.out.println(liste.toString());
		System.out.println(liste.getEintrag(1));
		System.out.println(liste.löscheWort("Knuckles"));
		System.out.println(liste.toString());		
		return liste;
	}
	
	
	/**
	 * testet WortTrainer Klasse
	 * 
	 * @param liste		Liste die im WortTrainer benutzt wird
	 * @throws WorttrainerException
	 */
	public static void testWortTrainer(WortListe liste) throws WorttrainerException {
		WortTrainer trainer=new WortTrainer(liste);
		
		System.out.println(trainer.randomWord());
		System.out.println(trainer.getAktuellesWort());
		System.out.println(trainer.check(new WortEintrag("daqueen","https://a.wattpad.com/cover/141257335-288-k517735.jpg")));
		System.out.println(trainer.checkIgnoreCase(new WortEintrag("daqueen","https://a.wattpad.com/cover/141257335-288-k517735.jpg")));
		trainer.setAktuellesWort(new WortEintrag("daqueen","https://a.wattpad.com/cover/141257335-288-k517735.jpg"));
		System.out.println(trainer.getAktuellesWort());
	}
	
	/**
	 * main-Methode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	    new Controller();
	}
	
	private AbstractAction action = new AbstractAction(){
	    private static final long serialVersionUID = 1L;

	    @Override
	     public void actionPerformed(ActionEvent e)
	     {
	         System.out.println(e);
	   
	     }
	};
	 
	public Controller() {
	    new Frame(action);
	    WortEintrag eintrag;
	    WortListe liste;
	    String url="https://de.y8.com/games/slope";
	    try {
		System.out.println("*Test der Methoden der Klasse \"WortEintrag\": ");
		eintrag=testWortEintrag();
		System.out.print("\n");
		
		System.out.println("*Test der Methoden der Klasse \"WortListe\": ");
		liste=testWortListe(eintrag);
		System.out.print("\n");
		
		System.out.println("*Test der Methoden der Klasse \"WortTrainer\": ");
		testWortTrainer(liste);
		
		System.out.println(new WortEintrag("yeet", "https://a.w").checkURL(url));
	    }catch(WorttrainerException e) {e.printStackTrace();}
	}
	
}
