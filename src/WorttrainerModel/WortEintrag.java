package WorttrainerModel;
/**
 * Klasse WortEintrag speichert wort und url 
 * 
 * @author oli
 *
 */

public class WortEintrag {

	private String wort;
	private String url;
	
	/**
	 * Konstruktor 
	 * 
	 * @param wort
	 * @param url
	 * @throws WorttrainerException
	 */
	public WortEintrag(String wort, String url) throws WorttrainerException {
		this.setWort(wort);
		this.setUrl(url);
	}
	
	/**
	 * Getter für die URL
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Setter für die URL
	 * 
	 * @param url
	 * @throws WorttrainerException
	 */
	public void setUrl(String url) throws WorttrainerException {
		if(checkURL(url))
			this.url = url;
	}
	
	/**
	 * Getter für das Wort
	 * 
	 * @return
	 */
	public String getWort() {
		return wort;
	}
	
	/**
	 * Setter für das Wort
	 * 
	 * @param wort
	 * @throws WorttrainerException
	 */
	public void setWort(String wort) throws WorttrainerException {
		if(checkWort(wort))
			this.wort = wort;
	}

	
	/**
	 * URL Checker
	 * überprüft Validität der URL
	 * 
	 * @param url
	 * @return
	 * @throws WorttrainerException
	 */
	public boolean checkURL(String url) throws WorttrainerException {
		
		//http:// und https:// wird sofern es in der url vorhanden ist herausgeschnitten
		String http="http://";
		String https="https://";
		if(url.length()>http.length()&&(url.substring(0, http.length())).equals("http://"))
			url=url.substring(http.length(), url.length());
		else if(url.length()>https.length()&&(url.substring(0, https.length())).equals(https))
			url=url.substring(https.length(), url.length());
		
		int index=0;
		int last_index=0;
		int arr_length=1;
		int arr_index=0;
		
		//anzahl der elemente und damit array länge wird bestimmt
		for(int o=0;o<url.length();o++) 
			if(url.charAt(o)=='.') 
				arr_length++;
			else if(url.charAt(o)=='/') {
				arr_length++;
				break;
			}	
		
		//gibt es weniger als 2 elemente gibt die methode false zuzück
		if(arr_length<2)
			throw new WorttrainerException("ungültige URL!");	
		
		String[] arr=new String[arr_length];
		
		//aufteilung der elemente in ein array
		for(int i=0;i<url.length();i++) {
			if(url.charAt(i)=='.') {	
				index=i;
				arr[arr_index]=url.substring(last_index, index);	
				last_index=index+1;
				arr_index++;
			}
			else if(url.charAt(i)=='/') {
				index=url.length();
				arr[arr_index]=url.substring(last_index, i);	
				arr_index++;
				arr[arr_index]=url.substring(i, url.length());					
				break;
			}
			if(i+1==url.length()) {
				index=url.length();
				arr[arr_index]=url.substring(last_index, index);	
				last_index=index;
				arr_index++;
			}
		}		
		
		//erstes bis vorletztes element
		String char2="-_";
		for(int z=0;z<arr.length-1;z++)
			for(int q=0;q<arr[z].length();q++) 
				if((arr[z].charAt(q)>'Z'||arr[z].charAt(q)<'A')&&(arr[z].charAt(q)>'z'||arr[z].charAt(q)<'a')&&(arr[z].charAt(q)>'9'||arr[z].charAt(q)<'0')) 
					if(char2.indexOf(arr[z].charAt(q))==-1)	
						throw new WorttrainerException("ungültige URL!");	
		
	
		
		//letztes element
		String char1="_~:/?#[]@!$&'()*+,;=.-";
		for(int w=0;w<arr[arr.length-1].length();w++) 
			if((arr[arr.length-1].charAt(w)>'Z'||arr[arr.length-1].charAt(w)<'A')&&(arr[arr.length-1].charAt(w)>'z'||arr[arr.length-1].charAt(w)<'a')&&(arr[arr.length-1].charAt(w)>'9'||arr[arr.length-1].charAt(w)<'0')) 
				if(char1.indexOf(arr[arr.length-1].charAt(w))==-1) 
					throw new WorttrainerException("ungültige URL!");	
				
		//ausgabe der elemente
		/*for(int p=0;p<arr.length;p++)
			System.out.println(arr[p]);
		*/
		return true;
	}

	/**
	 * Wort Checker 
	 * überprüft ob das Wort nur aus alphanumerischen Zeichen besteht und größer al 2 zeichen ist
	 * 
	 * @param wort
	 * @return
	 * @throws WorttrainerException
	 */
	public boolean checkWort(String wort) throws WorttrainerException {
		if(wort.length()>=2)
			for(int i=0;i<wort.length();i++)
				if((wort.charAt(i)>'Z'||wort.charAt(i)<'A')&&(wort.charAt(i)>'z'||wort.charAt(i)<'a')) 
					throw new WorttrainerException("ungültiges Wort!");	
		return true;
	}

	@Override
	public String toString() {
		return wort+"; "+url;	
	}	
}
