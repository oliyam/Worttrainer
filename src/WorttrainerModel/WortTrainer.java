package WorttrainerModel;

import java.util.Random;
/**
 * WortTrainer Klasse
 * 
 * @author oli
 *
 */

public class WortTrainer {

	private WortListe liste;
	private WortEintrag currentWord;
	
	/**
	 * Konstruktor
	 * 
	 * @param liste
	 */
	public WortTrainer(WortListe liste) {
		this.liste=liste;
		this.currentWord=liste.getEintrag(1);
	}
	
	/**
	 * Gibt einen zuf�lligen WortEintrag aus der Liste aus
	 * 
	 * @return
	 */
	public WortEintrag randomWord() {
		Random rand=new Random();
		int index=rand.nextInt(this.liste.getListe().length);
		return this.liste.getListe()[index];
	}
	
	/**
	 * Gibt den aktuellen WortEintrag aus
	 * 
	 * @return
	 */
	public WortEintrag getAktuellesWort() {
		return this.currentWord;
	}
	
	/**
	 * Setter f�r den aktuellen WortEintrag
	 * 
	 * @param currentWord
	 */
	public void setAktuellesWort(WortEintrag currentWord) {
		this.currentWord=currentWord;
	}
	
	/**
	 *�berpr�ft ob dar aktuelle WortEintrag den Parameter entspricht
	 * 
	 * @param wort
	 * @return
	 */
	public boolean check(WortEintrag wort) {
		return wort.toString().equals(this.currentWord.toString());
	}
	
	/**
	 *�berpr�ft ob dar aktuelle WortEintrag den Parameter entspricht, ungeachtet der Gro�- und Kleinschreibung
	 * 
	 * @param wort
	 * @return
	 */
	public boolean checkIgnoreCase(WortEintrag wort) {
		return (wort.getWort().toUpperCase()).equals(currentWord.getWort().toUpperCase());
	}
}
