package WorttrainerModel;
/**
 * WortListe Klasse
 * 
 * @author oli
 *
 */

public class WortListe {
	
	private WortEintrag[] liste=new WortEintrag[0];
	
	/**
	 * Getter für die Liste
	 * 
	 * @return
	 */
	public WortEintrag[] getListe() {
		return this.liste;
	}
	
	/**
	 * Setter für die Liste
	 * 
	 * @param liste
	 */
	public void setListe(WortEintrag[] liste) {
		this.liste=liste;
	}
	
	/**
	 * Methode um einen WortEintrag zur Liste hinzuzufügen
	 * 
	 * @param eintrag
	 */
	public void hinzu(WortEintrag eintrag) {
		WortEintrag[] temp=new WortEintrag[getListe().length+1];
		for(int i=0;i<temp.length;i++)
			if(i<temp.length-1)
				temp[i]=getListe()[i];
			else
				temp[i]=eintrag;
		setListe(temp);				
	}
	
	/**
	 * Getter um einen WortEintrag an der Stelle index zu bekommen
	 * 
	 * @param index
	 * @return
	 */
	public WortEintrag getEintrag(int index) {
		if(index>0&&index-1<getListe().length)
			return getListe()[index-1];
		return null;
	}
	
	/**
	 * Methode um einen WortEintrag aus der Liste mit dem Namen word zu löschen
	 * 
	 * @param word
	 * @return
	 * @throws WorttrainerException
	 */
	public boolean löscheWort(String word) throws WorttrainerException {
		boolean o=false;
		
		WortEintrag[] temp=new WortEintrag[getListe().length];
		
		for(int i=0;i<getListe().length;i++)
			temp[i]=getEintrag(i+1);
		
		setListe(new WortEintrag[0]);
		
		for(int i=0;i<temp.length;i++)
			if(!temp[i].getWort().contentEquals(word)) 
				hinzu(temp[i]);
			else
				o=true;
	
		if(!o)
			setListe(temp);
		
		return o;
	}
	
	@Override
	public String toString() {
		String text="";
		if(getListe().length!=0)
			for(int i=0;i<getListe().length;i++)
				text+=">"+getListe()[i].toString()+"\n";
		else
			return "Die Liste ist leer!";
		return text;
	}
}
